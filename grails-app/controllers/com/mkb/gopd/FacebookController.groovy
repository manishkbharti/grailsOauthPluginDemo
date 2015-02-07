package com.mkb.gopd

import com.mkb.gopd.exception.CustomException
import org.scribe.model.Token

class FacebookController {

    def oauthService
    def facebookService

    def index() {
        render view: '/index'
    }

    def profileImage() {
        Token facebookAccessToken = (Token) session[oauthService.findSessionKeyForAccessToken('facebook')]
        try {
            def (profilePicUrl, facebookResponse) = facebookService.getProfileImage(facebookAccessToken, 'me')
            Map data = ['Profile Image': g.img(uri: profilePicUrl)]
            render view: '/oauthCallBack/index', model: [provider: 'Facebook Profile Image', data: data, fullResponse: facebookResponse]
        } catch (CustomException ce) {
            log.error ce.errorMessage
            flash.error = ce.errorMessage
            render view: '/index'
        }
    }

    def friends() {
        Token facebookAccessToken = (Token) session[oauthService.findSessionKeyForAccessToken('facebook')]
        try {
            def (List friends, facebookResponse) = facebookService.getFriends(facebookAccessToken)
            render view: 'friends', model: [friends: friends?.sort { it.name }]
        } catch (CustomException ce) {
            log.error ce.errorMessage
            flash.error = ce.errorMessage
            render view: '/index'
        }
    }

    def friendDetails() {
        Token facebookAccessToken = (Token) session[oauthService.findSessionKeyForAccessToken('facebook')]
        try {
            def facebookResponse = facebookService.getFriendDetails(facebookAccessToken, params.id)
            Map data = [Id          : facebookResponse.id, Username: facebookResponse.username, Name: facebookResponse.name, Email: facebookResponse.email,
                        'First Name': facebookResponse.first_name, 'Last Name': facebookResponse.last_name, Birthday: facebookResponse.birthday, Gender: facebookResponse.gender,
                        Link        : g.link(url: facebookResponse.link) { 'Profile Link' }]

            def (profilePicUrl) = facebookService.getProfileImage(facebookAccessToken, params.id)
            data += ['Profile Image': g.img(uri: profilePicUrl)]

            render view: '/oauthCallBack/index', model: [provider: "${data.Name ?: 'Friend'} Details", data: data, fullResponse: facebookResponse]
        } catch (CustomException ce) {
            log.error ce.errorMessage
            flash.error = ce.errorMessage
            render view: '/index'
        }
    }

    def post() {

    }

    def postOnWall() {
        Token facebookAccessToken = (Token) session[oauthService.findSessionKeyForAccessToken('facebook')]
        try {
            def facebookResponse = facebookService.postOnWall(facebookAccessToken, params)
            if (facebookResponse?.error) {
                flash.error = facebookResponse?.error
                redirect action: 'post'
            } else if (facebookResponse?.id) {
                flash.message = 'Message posted in your wall successfully'
                redirect action: 'index'
            } else {
                flash.error = "Something went wrong..,. ${facebookResponse}"
                redirect action: 'index'
            }
        } catch (CustomException ce) {
            log.error ce.errorMessage
            flash.error = ce.errorMessage
            render view: '/index'
        }

        render view: '/index'
    }
}
