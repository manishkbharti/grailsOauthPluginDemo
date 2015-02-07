package com.mkb.gopd

import com.mkb.gopd.exception.CustomException
import grails.converters.JSON
import grails.transaction.Transactional
import org.scribe.model.Token

@Transactional(readOnly = true)
class GoogleService {

    def oauthService

    def getCurrentUserDetails(Token googleAccessToken) {
        if (!googleAccessToken) {
            throw new CustomException('Token not found.')
        }

        String url = "https://www.googleapis.com/oauth2/v1/userinfo"
        def googleResource = oauthService.getGoogleResource(googleAccessToken, url)
        def googleResponse = JSON.parse(googleResource?.getBody())

        return googleResponse
    }
}
