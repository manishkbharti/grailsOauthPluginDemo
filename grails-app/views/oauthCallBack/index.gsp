<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
<div style="float: left;">
    <h1>${provider}</h1>
</div>

<div style="float: right;">
    <h3 id="showFullResponse">
        <a onclick="showResult('full')">Original Response</a>
    </h3>

    <h3 id="showParsedResponse" style="display: none">
        <a onclick="showResult('parsed')">Parsed Response</a>
    </h3>
</div>
<hr style="clear: both;"/>

<div id="parsedResponse">
    <g:render template="/oauthCallBack/responseTable" model="[data: data]"/>
</div>

<div id="fullResponse" style="display: none">
    <g:render template="/oauthCallBack/responseTable" model="[data: fullResponse]"/>
</div>

<script type="text/javascript">
    function showResult(type) {
        if (type == 'full') {
            $("#showFullResponse").css('display', 'none');
            $("#parsedResponse").css('display', 'none');

            $("#showParsedResponse").css('display', 'block');
            $("#fullResponse").css('display', 'block');
        } else {
            $("#showFullResponse").css('display', 'block');
            $("#parsedResponse").css('display', 'block');

            $("#showParsedResponse").css('display', 'none');
            $("#fullResponse").css('display', 'none');
        }
    }
</script>
</body>
</html>
