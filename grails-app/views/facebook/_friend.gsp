<g:each in="${friends}" var="friend" status="idx">
    <g:link controller="facebook" action="friendDetails" id="${friend.id}" class="jumbotron col-sm-3 friend" target="_blank">
        ${friend.name}
    </g:link>
    <g:if test="${(idx + 1) % 4 == 0}">
        <span class="clearfix"></span>
    </g:if>
</g:each>
