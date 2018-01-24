var host = "http://uam.grzegorz2047.pl";
if (location.hostname === "localhost" || location.hostname === "127.0.0.1")
{
    host = "http://localhost";
}

$.ajax({
    type: "POST",
    url: host + ":8080/users/isLogged"
}).fail(function() {
    var url = host + ":8080/unauthorized.html";
    $(location).attr("href", url);
});
