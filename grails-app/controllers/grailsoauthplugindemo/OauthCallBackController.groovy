package grailsoauthplugindemo

import grails.converters.JSON
import org.scribe.model.Token

class OauthCallBackController {

    def oauthService

    def index() {}

    def facebookSuccess() {
        Token facebookAccessToken = (Token) session[oauthService.findSessionKeyForAccessToken('facebook')]
        def facebookResource = oauthService.getFacebookResource(facebookAccessToken, "https://graph.facebook.com/me")
        def facebookResponse = JSON.parse(facebookResource?.getBody())

        render "Email = ${facebookResponse.email}"
    }

    def facebookFailure() {
        render "Error"
    }

    def twitterSuccess() {
        Token twitterAccessToken = (Token) session[oauthService.findSessionKeyForAccessToken('twitter')]
        def twitterResource = oauthService.getTwitterResource(twitterAccessToken, "https://api.twitter.com/1.1/account/settings.json")
        def twitterResponse = JSON.parse(twitterResource?.getBody())

        def twitterResourceDetailed = oauthService.getTwitterResource(twitterAccessToken, "https://api.twitter.com/1.1/users/show.json?screen_name=${twitterResponse['screen_name']}")
        def twitterResponseDetailed = JSON.parse(twitterResourceDetailed?.getBody())

        render "twitterId = ${twitterResponseDetailed['id']}"
    }

    def twitterFailure() {
        render "Error"
    }

}
