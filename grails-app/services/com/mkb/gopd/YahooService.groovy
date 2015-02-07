package com.mkb.gopd

import com.mkb.gopd.exception.CustomException
import grails.converters.JSON
import grails.transaction.Transactional
import org.scribe.model.Token

@Transactional(readOnly = true)
class YahooService {

    def oauthService

    def getCurrentUserDetails(Token yahooAccessToken) {
        if (!yahooAccessToken) {
            throw new CustomException('Token not found.')
        }

        String url = "https://social.yahooapis.com/v1/me/guid?format=json"
        def yahooResource = oauthService.getYahooResource(yahooAccessToken, url)
        def yahooResponse = JSON.parse(yahooResource?.getBody())

        String url2 = "https://social.yahooapis.com/v1/user/${yahooResponse?.guid?.value}/profile/usercard?format=json"
        yahooResource = oauthService.getYahooResource(yahooAccessToken, url2)
        yahooResponse = JSON.parse(yahooResource?.getBody())

        def yahooProfile = yahooResponse.profile

        return yahooProfile
    }
}
