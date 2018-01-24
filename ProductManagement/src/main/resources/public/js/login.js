$(function() {
    $('#login-form-link').click(function(e) {
        $("#error").html("<br>");
        $("#success").html("<br>");
        $("#login-form").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#register-form-link').click(function(e) {
        $("#error").html("<br>");
        $("#success").html("<br>");
        $("#register-form").delay(100).fadeIn(100);
        $("#login-form").fadeOut(100);
        $('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
});

$(document).ready(function()
{
    var host = "http://uam.grzegorz2047.pl";
    if (location.hostname === "localhost" || location.hostname === "127.0.0.1")
    {
        host = "http://localhost";
    }

   $("#register-submit").click(function()
   {
       var username = $("#register-username").val();
       var password = $("#register-password").val();

       $.ajax({
           url: host + ":8080/users/add?name=" + username + "&password=" + password
       }).then(function(data) {
           $("#success").html("Konto utworzono pomyślnie. Możesz się zalogować.");
       });
   });

    $("#login-submit").click(function()
    {
        var username = $("#login-username").val();
        var password = $("#login-password").val();

        $.ajaxSetup({
            headers: {
                'Authorization': "Basic " + btoa(username + ":" + password)
            }
        });

        $.ajax({
            type: "POST",
            url: host + ":8080/users/login?login=" + username + "&password=" + password
        }).then(function(data) {
            var success = data.loginResult.matches;

            if(success)
            {
                $("#error").html("<br>");
                var url = host + ":8080/index.html";
                $(location).attr("href", url);
            }
            else
            {
                $("#error").html("Niepoprawny login lub hasło");
            }
        }).fail(function() {
            $("#error").html("Niepoprawny login lub hasło");
        });
    });
});