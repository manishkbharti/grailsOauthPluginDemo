<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Facebook Friends</title>
    <style type="text/css">
    .friend {
        padding: 12px !important;
        margin: 5px 0 0 0 !important;
    }

    #mainContent a {
        color: #c8c8c8 !important;
        text-decoration: none;
    }
    </style>
</head>

<body>
<h1>Friends (${friends.size()})</h1>

<div role="tabpanel" style="margin-bottom: 10px">
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active">
            <a href="#tabA" role="tab" data-toggle="tab"
               title="${friends.count { it?.name?.startsWith('A') }} Friends">A</a>
        </li>
        <g:each in="${'B'..'Z'}" var="alphabet">
            <li role="presentation">
                <a href="#tab${alphabet}" role="tab" data-toggle="tab"
                   title="${friends.count { it?.name?.startsWith(alphabet) }} Friends">${alphabet}</a>
            </li>
        </g:each>
    </ul>

    <div class="tab-content">
        <div role="tabpanel" class="tab-pane fade in active" id="tabA">
            <g:render template="friend" model="[friends: friends.findAll { it?.name?.startsWith('A') }]"/>
        </div>
        <g:each in="${'B'..'Z'}" var="alphabet">
            <div role="tabpanel" class="tab-pane fade" id="tab${alphabet}">
                <g:render template="friend" model="[friends: friends.findAll { it?.name?.startsWith(alphabet) }]"/>
            </div>
        </g:each>
    </div>
</div>
</body>
</html>