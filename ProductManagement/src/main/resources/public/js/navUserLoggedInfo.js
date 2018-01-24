$(document).ready(function()
{
    var host = "http://uam.grzegorz2047.pl";
    if (location.hostname === "localhost" || location.hostname === "127.0.0.1")
    {
        host = "http://localhost";
    }

    $.ajax({
        type: "POST",
        url: host + ":8080/users/isLogged"
    }).then(function() {
        $("#to-log").replaceWith("<li><a href=\"logout.html\" style=\"background-color: #8E001C; color:#f0f0f0;\">Wyloguj</a></li>");
    });
});
