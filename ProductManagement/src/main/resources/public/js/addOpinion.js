$(document).ready(function()
{
    var host = "http://uam.grzegorz2047.pl";
    if (location.hostname === "localhost" || location.hostname === "127.0.0.1")
    {
        host = "http://localhost";
    }

    $.ajax({
        url: host + ":8080/products/all"
    }).then(function(data) {
        var jsonObj = data.products;
        var selectProduct = $("#selectProduct");

        for (i = 0; i < jsonObj.length; i++)
        {
            var jsOutput = jsonObj[i];
            selectProduct.append("<option value=\"" + jsOutput.id + "\">" + jsOutput.name + "</option>");
        }
    });


    $("#addOpinion").click(function()
    {
        var productId = $("#selectProduct").val();
        var opinion = $("#opinion").val();
        var pros = $("#pros").val();
        var cons = $("#cons").val();
        var rate = $("#rate").val();

        var addOpinion = $.ajax({
            url: host + ":8080/opinions/add?userId=1&productId=" + productId + "&opinionText=" + opinion + "&pros=" + pros + "&cons=" + cons + "&score=" + rate
        });
        addOpinion.then(function() {
            var url = host + ":8080/opinions.html";
            $(location).attr("href", url);
        });


    });
});
