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
}
