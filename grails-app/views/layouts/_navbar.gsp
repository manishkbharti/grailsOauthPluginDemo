<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-responsive-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <g:link url="${g.createLink(uri: '/')}" class="navbar-brand">Grails Oauth Plugin Demo</g:link>
        </div>

        <div class="navbar-collapse collapse navbar-responsive-collapse">
            <ul class="nav navbar-nav">
                <oauth:connected provider="facebook">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                            <i class="fa fa-facebook-square fa-2x"></i> <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li><g:link controller="facebook" action="friendDetails" id="me">My Details</g:link></li>
                            <li><g:link controller="facebook" action="profileImage">Facebook Profile Image</g:link></li>
                            <li><g:link controller="facebook" action="friends">Facebook Friends</g:link></li>
                            <li class="divider"></li>
                            <li><g:link controller="facebook" action="post">Post On My Wall</g:link></li>
                        </ul>
                    </li>
                </oauth:connected>

                <oauth:connected provider="google">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                            <i class="fa fa-google-plus-square fa-2x"></i> <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li><g:link controller="google" action="me">My Details</g:link></li>
                        </ul>
                    </li>
                </oauth:connected>

                <oauth:connected provider="linkedin">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                            <i class="fa fa-linkedin-square fa-2x"></i> <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li><g:link controller="linkedin" action="me">My Details</g:link></li>
                        </ul>
                    </li>
                </oauth:connected>

                <oauth:connected provider="twitter">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                            <i class="fa fa-twitter-square fa-2x"></i> <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li><g:link controller="twitter" action="me">My Details</g:link></li>
                        </ul>
                    </li>
                </oauth:connected>

                <oauth:connected provider="yahoo">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                            <i class="fa fa-yahoo fa-2x"></i> <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li><g:link controller="yahoo" action="me">My Details</g:link></li>
                        </ul>
                    </li>
                </oauth:connected>
            </ul>
        </div>
    </div>
</div>