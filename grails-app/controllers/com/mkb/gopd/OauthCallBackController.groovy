package com.mkb.gopd

class OauthCallBackController {

    def oauthService

    def index() {
        render view: '/index'
    }

    def facebook() {
        if (session[oauthService.findSessionKeyForAccessToken('facebook')]) {
            flash.message = "Facebook authentication successful. Use top navigation menu for more action."
        }
        redirect action: 'index'
    }

    def twitter() {
        if (session[oauthService.findSessionKeyForAccessToken('twitter')]) {
            flash.message = "Twitter authentication successful. Use top navigation menu for more action."
        }
        redirect action: 'index'
    }

    def linkedin() {
        if (session[oauthService.findSessionKeyForAccessToken('linkedin')]) {
            flash.message = "LinkedIn authentication successful. Use top navigation menu for more action."
        }
        redirect action: 'index'
    }

    def google() {
        if (session[oauthService.findSessionKeyForAccessToken('google')]) {
            flash.message = "Google authentication successful. Use top navigation menu for more action."
        }
        redirect action: 'index'
    }

    def yahoo() {
        if (session[oauthService.findSessionKeyForAccessToken('yahoo')]) {
            flash.message = "Yahoo authentication successful. Use top navigation menu for more action."
        }
        redirect action: 'index'
    }

    def failure() {
        flash.error = "Error."
        render view: '/index'
    }

    def revoke() {
        if (params.id && session[oauthService.findSessionKeyForAccessToken(params.id)]) {
            session[oauthService.findSessionKeyForAccessToken(params.id)] = null
            flash.message = "Token revoked successfully."
        }
        redirect action: 'index'
    }

}
