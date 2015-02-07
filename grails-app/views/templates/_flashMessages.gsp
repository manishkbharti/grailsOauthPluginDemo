<g:if test="${flash.error}">
    <div class="alert alert-dismissable alert-danger">
        <button type="button" class="close" data-dismiss="alert">×</button>
        ${flash.error}
    </div>
</g:if>

<g:if test="${flash.info}">
    <div class="alert alert-dismissable alert-info">
        <button type="button" class="close" data-dismiss="alert">×</button>
        ${flash.info}
    </div>
</g:if>

<g:if test="${flash.message}">
    <div class="alert alert-dismissable alert-success">
        <button type="button" class="close" data-dismiss="alert">×</button>
        ${flash.message}
    </div>
</g:if>