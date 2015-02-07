<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Post</title>
</head>

<body>
<g:form controller="facebook" action="postOnWall" class="form-horizontal">
    <div class="form-group">
        <label for="message" class="col-sm-2 control-label">Message</label>

        <div class="col-sm-10">
            <g:textArea name="message" class="form-control" placeholder="Message" rows="7" value="${params.message}"/>
        </div>
    </div>

    <div class="form-group">
        <label for="link" class="col-sm-2 control-label">Link</label>

        <div class="col-sm-10">
            <g:field type="url" name="link" class="form-control" placeholder="URL" value="${params.link}"/>
        </div>
    </div>

    <div class="form-group">
        <label for="picture" class="col-sm-2 control-label">Picture</label>

        <div class="col-sm-10">
            <g:field type="url" name="picture" class="form-control" placeholder="Picture URL"
                     value="${params.picture}"/>
        </div>
    </div>

    <div class="form-group pull-right">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">Post</button>
        </div>
    </div>
</g:form>

<script type="text/javascript">
    $("[name='message']").focus();
</script>
</body>
</html>