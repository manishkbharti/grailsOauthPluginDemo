package com.mkb.gopd

import com.mkb.gopd.exception.CustomException
import grails.converters.JSON
import grails.transaction.Transactional
import org.scribe.model.Token

@Transactional(readOnly = true)
class TwitterService {

    def oauthService

    def getCurrentUserDetails(Token twitterAccessToken) {
        if (!twitterAccessToken) {
            throw new CustomException('Token not found.')
        }

        String url = "https://api.twitter.com/1.1/account/settings.json"
        def twitterResource = oauthService.getTwitterResource(twitterAccessToken, url)
        def twitterResponse = JSON.parse(twitterResource?.getBody())

        String url2 = "https://api.twitter.com/1.1/users/show.json?screen_name=${twitterResponse['screen_name']}"
        def twitterResourceDetailed = oauthService.getTwitterResource(twitterAccessToken, url2)
        def twitterResponseDetailed = JSON.parse(twitterResourceDetailed?.getBody())

        return twitterResponseDetailed
    }
}
