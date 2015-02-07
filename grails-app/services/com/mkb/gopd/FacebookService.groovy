package com.mkb.gopd

import com.mkb.gopd.exception.CustomException
import grails.converters.JSON
import grails.transaction.Transactional
import org.scribe.model.Token

@Transactional(readOnly = true)
class FacebookService {

    def oauthService

    def getProfileImage(Token facebookAccessToken, String userId) {
        if (!facebookAccessToken) {
            throw new CustomException('Token not found.')
        }

        if (!userId) {
            throw new CustomException("UserId not found.")
        }

        String url = "https://graph.facebook.com/${userId}/picture?type=large&redirect=false"
        def facebookResource = oauthService.getFacebookResource(facebookAccessToken, url)
        def facebookResponse = JSON.parse(facebookResource?.getBody())
        String fbProfilePicUrl = facebookResponse.data?.url

        if (!fbProfilePicUrl) {
            log.error "FB Profile Image - ${facebookResource}"
            throw new CustomException("Profile image not found.")
        }

        return [fbProfilePicUrl, facebookResponse]
    }

    def getFriends(Token facebookAccessToken) {
        if (!facebookAccessToken) {
            throw new CustomException('Token not found.')
        }

        String url = "https://graph.facebook.com/me/friends"
        def facebookResource = oauthService.getFacebookResource(facebookAccessToken, url)
        def facebookResponse = JSON.parse(facebookResource?.getBody())
        List friends = facebookResponse.data ?: []

        return [friends, facebookResponse]
    }

    def getFriendDetails(Token facebookAccessToken, String userId) {
        if (!facebookAccessToken) {
            throw new CustomException('Token not found.')
        }

        if (!userId) {
            throw new CustomException("UserId not found.")
        }

        String url = "https://graph.facebook.com/${userId}"
        def facebookResource = oauthService.getFacebookResource(facebookAccessToken, url)
        def facebookResponse = JSON.parse(facebookResource?.getBody())

        if (!facebookResponse) {
            throw new CustomException('Friend detail not found.')
        }

        return facebookResponse
    }

    def postOnWall(Token facebookAccessToken, Map params) {
        if (!facebookAccessToken) {
            throw new CustomException('Token not found.')
        }

        String url = "https://graph.facebook.com/me/feed?message=${params.message?.encodeAsURL()}&link=${params.link}&picture=${params.picture}"
        def facebookResource = oauthService.postFacebookResource(facebookAccessToken, url)
        def facebookResponse = JSON.parse(facebookResource?.getBody())

        return facebookResponse
    }
}
