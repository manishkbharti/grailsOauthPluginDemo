package grailsoauthplugindemo

import grails.converters.JSON
import org.scribe.model.Token

class OauthCallBackController {

    def oauthService

    def facebookSuccess() {
        Token facebookAccessToken = (Token) session[oauthService.findSessionKeyForAccessToken('facebook')]
        def facebookResource = oauthService.getFacebookResource(facebookAccessToken, "https://graph.facebook.com/me")
        def facebookResponse = JSON.parse(facebookResource?.getBody())

        Map data = [id: facebookResponse.id, username: facebookResponse.username, name: facebookResponse.name, email: facebookResponse.email,
                first_name: facebookResponse.first_name, last_name: facebookResponse.last_name, birthday: facebookResponse.birthday,
                gender: facebookResponse.gender, link: facebookResponse.link, work: facebookResponse.work, hometown: facebookResponse.hometown,
                education: facebookResponse.education]

        render view: '/index', model: [provider: 'Facebook', data: data]
    }

    def twitterSuccess() {
        Token twitterAccessToken = (Token) session[oauthService.findSessionKeyForAccessToken('twitter')]
        def twitterResource = oauthService.getTwitterResource(twitterAccessToken, "https://api.twitter.com/1.1/account/settings.json")
        def twitterResponse = JSON.parse(twitterResource?.getBody())

        def twitterResourceDetailed = oauthService.getTwitterResource(twitterAccessToken, "https://api.twitter.com/1.1/users/show.json?screen_name=${twitterResponse['screen_name']}")
        def twitterResponseDetailed = JSON.parse(twitterResourceDetailed?.getBody())

        Map data = [id: twitterResponseDetailed.id, screen_name: twitterResponseDetailed.screen_name, name: twitterResponseDetailed.name,
                lang: twitterResponseDetailed.lang, created_at: twitterResponseDetailed.created_at]

        render view: '/index', model: [provider: 'Twitter', data: data]
    }

    def failure() {
        render "Error"
    }

}
