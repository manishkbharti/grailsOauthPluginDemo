package com.mkb.gopd

class HelperTagLib {

    static namespace = "gopd"

    def oauthService

    def ifAnyConnected = { attrs, body ->
        Set<String> providers = grailsApplication.config.oauth.providers.keySet()
        Boolean isAnyConnected = Boolean.FALSE

        providers.each { String provider ->
            if (session[oauthService.findSessionKeyForAccessToken(provider)]) {
                isAnyConnected = Boolean.TRUE
                return
            }
        }

        if (isAnyConnected) {
            out << body()
        }
    }

    def ifAnyDisconnected = { attrs, body ->
        Set<String> providers = grailsApplication.config.oauth.providers.keySet()
        Boolean isAnyDisconnected = Boolean.FALSE

        providers.each { String provider ->
            if (!session[oauthService.findSessionKeyForAccessToken(provider)]) {
                isAnyDisconnected = Boolean.TRUE
                return
            }
        }

        if (isAnyDisconnected) {
            out << body()
        }
    }
}
