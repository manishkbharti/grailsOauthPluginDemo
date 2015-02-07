package com.mkb.gopd

import com.mkb.gopd.exception.CustomException
import org.scribe.model.Token

class YahooController {

    def oauthService
    def yahooService

    def index() {
        render view: '/index'
    }

    def me() {
        Token yahooAccessToken = (Token) session[oauthService.findSessionKeyForAccessToken('yahoo')]
        try {
            def yahooProfile = yahooService.getCurrentUserDetails(yahooAccessToken)

            Map data = [Guid      : yahooProfile.guid, Nickname: yahooProfile.nickname, Location: yahooProfile.location, 'Display Age': yahooProfile.displayAge,
                        Gender    : yahooProfile.gender, 'Member Since': yahooProfile.memberSince, Updated: yahooProfile.updated,
                        profileUrl: g.link(url: yahooProfile.profileUrl) { 'Profile Link' },
                        Image     : g.img(uri: yahooProfile.image?.imageUrl)]

            render view: '/oauthCallBack/index', model: [provider: 'Yahoo Response', data: data, fullResponse: yahooProfile]
        } catch (CustomException ce) {
            log.error ce.errorMessage
            flash.error = ce.errorMessage
            render view: '/index'
        }
    }
}
