<!DOCTYPE html>
<html>
<head>
    <title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
    <meta name="layout" content="main">
    %{--<g:if env="development"><link rel="stylesheet" href="${resource(dir: 'css', file: 'errors.css')}" type="text/css"></g:if>--}%
</head>

<body>
<g:if env="!development">
    <g:renderException exception="${exception}"/>
</g:if>
<g:else>
    <div class="jumbotron">
        <h1>Sorry</h1>

        <p>Something went wrong.</p>
    </div>
</g:else>
</body>
</html>
