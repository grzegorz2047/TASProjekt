var getProducts = $(document).ready(function()
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
        var tableRow = $("#tableRow");

        for (i = 0; i < jsonObj.length; i++)
        {
            var newRowId = "newRow" + i;
            tableRow.append("<div id=\"" + newRowId + "\" class=\"col-lg-12 newRow\" style=\"border-top: 1px solid white; height: 40px;\">");
            var newRow = $("#" + newRowId);

            var jsOutput = jsonObj[i];

            newRow.append("<div class=\"col-lg-2\">" + jsOutput.id +  "</div>");
            newRow.append("<div class=\"col-lg-10\"><a href=\"product.html?name=" + jsOutput.name + "\">" + jsOutput.name + "</a></div>");

            tableRow.append("</div>");
        }
    });
});

getProducts();
