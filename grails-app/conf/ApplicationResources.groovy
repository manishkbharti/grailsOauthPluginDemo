modules = {
    application {
        resource url: 'js/application.js'
    }

    jquery11 {
        resource url: 'js/jquery-1.11.1.min.js', disposition: 'head'
    }

    style {
        dependsOn 'jquery11'
        resource url: 'css/bootstrap.min.css'
        resource url: 'css/styles.css'
        resource url: 'js/bootstrap.min.js'
    }

    fontAwesome {
        resource url: 'css/font-awesome.min.css'
    }
}