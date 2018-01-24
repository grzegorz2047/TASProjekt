$(document).ready(function()
{
    var host = "http://uam.grzegorz2047.pl";
    if (location.hostname === "localhost" || location.hostname === "127.0.0.1")
    {
        host = "http://localhost";
    }

    $("#addProduct").click(function()
    {
        var productName = $("#productName").val();
        //credentials
        var addProduct = $.ajax({
            url: host + ":8080/products/add?userId=1&name=" + productName
        });
        addProduct.then(function() {
            var url = host + ":8080/product.html?name=" + productName;
            $(location).attr("href", url);
        });
        addProduct.fail(function() {
            alert("niegit");
        });
    });
});
