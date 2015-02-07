<%@ page defaultCodec="none" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <style type="text/css">
    #mainContent a {
        color: #ffffff !important;
        text-decoration: none;
    }
    </style>
</head>

<body>
<gopd:ifAnyDisconnected>
    <h3>Authenticate</h3>

    <div class="provider-list jumbotron">
        <oauth:disconnected provider="facebook">
            <oauth:connect provider="facebook" title="Facebook">
                <i class="fa fa-facebook-square fa-4x"></i>
            </oauth:connect>
        </oauth:disconnected>

        <oauth:disconnected provider="google">
            <oauth:connect provider="google" title="Google">
                <i class="fa fa-google-plus-square fa-4x"></i>
            </oauth:connect>
        </oauth:disconnected>

        <oauth:disconnected provider="linkedin">
            <oauth:connect provider="linkedin" title="LinkedIn">
                <i class="fa fa-linkedin-square fa-4x"></i>
            </oauth:connect>
        </oauth:disconnected>

        <oauth:disconnected provider="twitter">
            <oauth:connect provider="twitter" title="Twitter">
                <i class="fa fa-twitter-square fa-4x"></i>
            </oauth:connect>
        </oauth:disconnected>

        <oauth:disconnected provider="yahoo">
            <oauth:connect provider="yahoo" title="Yahoo">
                <i class="fa fa-yahoo fa-4x"></i>
            </oauth:connect>
        </oauth:disconnected>
    </div>
</gopd:ifAnyDisconnected>

<gopd:ifAnyConnected>
    <h3>Revoke Token</h3>

    <div class="provider-list jumbotron">
        <oauth:connected provider="facebook">
            <g:link controller="oauthCallBack" action="revoke" id="facebook" title="Facebook">
                <i class="fa fa-facebook-square fa-4x"></i>
            </g:link>
        </oauth:connected>

        <oauth:connected provider="google">
            <g:link controller="oauthCallBack" action="revoke" id="google" title="Google">
                <i class="fa fa-google-plus-square fa-4x"></i>
            </g:link>
        </oauth:connected>

        <oauth:connected provider="linkedin">
            <g:link controller="oauthCallBack" action="revoke" id="linkedin" title="LinkedIn">
                <i class="fa fa-linkedin-square fa-4x"></i>
            </g:link>
        </oauth:connected>

        <oauth:connected provider="twitter">
            <g:link controller="oauthCallBack" action="revoke" id="twitter" title="Twitter">
                <i class="fa fa-twitter-square fa-4x"></i>
            </g:link>
        </oauth:connected>

        <oauth:connected provider="yahoo">
            <g:link controller="oauthCallBack" action="revoke" id="yahoo" title="Yahoo">
                <i class="fa fa-yahoo fa-4x"></i>
            </g:link>
        </oauth:connected>
    </div>
</gopd:ifAnyConnected>
</body>
</html>
