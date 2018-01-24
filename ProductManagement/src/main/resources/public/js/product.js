var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};

var host = "http://uam.grzegorz2047.pl";

if (location.hostname === "localhost" || location.hostname === "127.0.0.1")
{
    host = "http://localhost";
}

var productNameParameter = getUrlParameter("name");

$(document).ready(function()
{
    $("#product-name").append(productNameParameter);

    $.ajax({
        url: host + ":8080/opinions/all"
    }).then(function(data) {
        var jsonObj = data.opinions;
        var tableRow = $("#tableRow");

        for (i = 0; i < jsonObj.length; i++)
        {
            var jsOutput = jsonObj[i];

            if(productNameParameter == jsOutput.productId.name)
            {
                var newRowId = "newRow" + i;
                tableRow.append("<div id=\"" + newRowId + "\" class=\"col-lg-12 newRow\" style=\"border-top: 1px solid white; height: 40px;\">");
                var newRow = $("#" + newRowId);
                newRow.append("<div class=\"col-lg-1\">" + jsOutput.id +  "</div>");
                newRow.append("<div class=\"col-lg-3\">" + jsOutput.pros + "</div>");
                newRow.append("<div class=\"col-lg-3\">" + jsOutput.cons + "</div>");
                newRow.append("<div class=\"col-lg-4\">" + jsOutput.generalOpinion + "</div>");
                newRow.append("<div class=\"col-lg-1\">" + jsOutput.score + "/5</div>");
                tableRow.append("</div>");
            }
        }
    });
});

