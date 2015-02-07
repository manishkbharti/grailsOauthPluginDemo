package com.mkb.gopd

import com.mkb.gopd.exception.CustomException
import grails.converters.JSON
import grails.transaction.Transactional
import org.scribe.model.Token

@Transactional(readOnly = true)
class LinkedinService {

    def oauthService

    def getCurrentUserDetails(Token linkedinAccessToken) {
        if (!linkedinAccessToken) {
            throw new CustomException('Token not found.')
        }

        String url = "http://api.linkedin.com/v1/people/~:(id,first-name,last-name,email-address,date-of-birth)?format=json"
        def linkedInResponse = oauthService.getLinkedInResource(linkedinAccessToken, url)
        def linkedinParsedResponse = JSON.parse(linkedInResponse?.getBody())

        Map data = [Id         : linkedinParsedResponse.id, 'Email Address': linkedinParsedResponse.emailAddress, 'First Name': linkedinParsedResponse.firstName,
                    'Last Name': linkedinParsedResponse.lastName, 'Date Of Birth': linkedinParsedResponse.dateOfBirth]

        return [data, linkedinParsedResponse]
    }
}
