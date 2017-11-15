$(document).ready(function() {
    var host = "http://uam.grzegorz2047.pl";
    if (location.hostname === "localhost" || location.hostname === "127.0.0.1") {
        host = "http://localhost";
    }

    $.ajax({
        xhrFields: {
            withCredentials: true
        },
        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', 'Basic ' + btoa('admin:admin1')); //pobierac dynamicznie skads tam przy autoryzacji usera
        },
        url: host + ":8080/products/all"
    }).then(function(data) {
        var jsonObj = data.products;
        $('.bloat').append("=================").append("<br>");
        for (i = 0; i < jsonObj.length; i++) {
            let jsOutput = jsonObj[i];
            $('.bloat')
                    .append("product id: ").append(jsOutput.id).append("</br>")
                    .append("product        name: ").append(jsOutput.name).append("<br/>")
                    .append("-----------<br/>");
        }
    });
    $.ajax({
        xhrFields: {
            withCredentials: true
        },
        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', 'Basic ' + btoa('admin:admin1')); //pobierac dynamicznie skads tam przy autoryzacji usera
        },
        url: host + ":8080/users/all"
    }).then(function(data) {
        var jsonObj = data.users;
        $('.bloat').append("=================").append("<br>");
        for (i = 0; i < jsonObj.length; i++) {
            let jsOutput = jsonObj[i];
            $('.bloat')
                    .append("user id: ").append(jsOutput.id).append("</br>")
                    .append("username: ").append(jsOutput.name).append("<br/>")
                    .append("-----------<br/>");
        }
    });
    $.ajax({
        xhrFields: {
            withCredentials: true
        },
        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', 'Basic ' + btoa('admin:admin1')); //pobierac dynamicznie skads tam przy autoryzacji usera
        },
        url: host + ":8080/opinions/all"
    }).then(function(data) {
        var jsonObj = data.opinions;
        $('.bloat').append("=================").append("<br>");
        for (i = 0; i < jsonObj.length; i++) {
            let jsOutput = jsonObj[i];
            $('.bloat')
                    .append("opinion id: ").append(jsOutput.id).append("</br>")
                    .append("productName: ").append(jsOutput.productName).append("</br>")
                    .append("generalOpinion: ").append(jsOutput.generalOpinion).append("</br>")
                    .append("pros: ").append(jsOutput.pros).append("<br/>")
                    .append("cons: ").append(jsOutput.cons).append("<br/>")
                    .append("score: ").append(jsOutput.score).append("<br/>")
                    .append("-----------<br/>");
        }
    });
});