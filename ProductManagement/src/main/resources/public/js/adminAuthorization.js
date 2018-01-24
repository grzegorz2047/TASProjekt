$(document).ready(function()
{
    var host = "http://uam.grzegorz2047.pl";
    if (location.hostname === "localhost" || location.hostname === "127.0.0.1")
    {
        host = "http://localhost";
    }

    var path = window.location.pathname;

    var adminAuth = $.ajax({
        url: host + ":8080/users/all"
    });

    adminAuth.then(function()
    {
        if(!path.indexOf("addUser.html") >= 0 || !path.indexOf("allUsers.html") >= 0)
        {
            $("#panel-admin").show();
        }
    });

    adminAuth.fail(function()
    {
       if(path.indexOf("addUser.html") >= 0 || path.indexOf("allUsers.html") >= 0)
       {
           var url = host + ":8080/unauthorizedAdmin.html";
           $(location).attr("href", url);
       }
    });
});
