package com.mkb.gopd

import com.mkb.gopd.exception.CustomException
import org.scribe.model.Token

class TwitterController {

    def oauthService
    def twitterService

    def index() {
        render view: '/index'
    }

    def me() {
        Token twitterAccessToken = (Token) session[oauthService.findSessionKeyForAccessToken('twitter')]
        try {
            def twitterResponseDetailed = twitterService.getCurrentUserDetails(twitterAccessToken)

            Map data = [Id             : twitterResponseDetailed.id, 'Screen Name': twitterResponseDetailed.screen_name, Name: twitterResponseDetailed.name,
                        Lang           : twitterResponseDetailed.lang, 'Created At': twitterResponseDetailed.created_at,
                        'Profile Image': g.img(uri: twitterResponseDetailed.profile_image_url)]

            render view: '/oauthCallBack/index', model: [provider: 'Twitter Response', data: data, fullResponse: twitterResponseDetailed]
        } catch (CustomException ce) {
            log.error ce.errorMessage
            flash.error = ce.errorMessage
            render view: '/index'
        }
    }
}
