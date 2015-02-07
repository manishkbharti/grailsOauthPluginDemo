package com.mkb.gopd

import com.mkb.gopd.exception.CustomException
import org.scribe.model.Token

class LinkedinController {

    def oauthService
    def linkedinService

    def index() {
        render view: '/index'
    }

    def me() {
        Token linkedinAccessToken = (Token) session[oauthService.findSessionKeyForAccessToken('linkedin')]
        try {
            def (data, linkedinParsedResponse) = linkedinService.getCurrentUserDetails(linkedinAccessToken)
            render view: '/oauthCallBack/index', model: [provider: 'LinkedIn Response', data: data, fullResponse: linkedinParsedResponse]
        } catch (CustomException ce) {
            log.error ce.errorMessage
            flash.error = ce.errorMessage
            render view: '/index'
        }
    }
}
