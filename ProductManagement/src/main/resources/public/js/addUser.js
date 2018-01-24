$(document).ready(function()
{
    var host = "http://uam.grzegorz2047.pl";
    if (location.hostname === "localhost" || location.hostname === "127.0.0.1")
    {
        host = "http://localhost";
    }

    $("#addUser").click(function()
    {
        var username = $("#username").val();
        var password = $("#password").val();
        var role = $("#role").val();

        $.ajax({
            url: host + ":8080/users/add?name=" + username + "&password=" + password + "&role=" + role
        }).then(function() {
            var url = host + ":8080/allUsers.html";
            $(location).attr("href", url);
        });
    });
});
