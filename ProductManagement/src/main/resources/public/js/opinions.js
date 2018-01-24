var host = "http://uam.grzegorz2047.pl";
if (location.hostname === "localhost" || location.hostname === "127.0.0.1")
{
    host = "http://localhost";
}

$(document).ready(function()
{
    $.ajax({
        url: host + ":8080/opinions/all"
    }).then(function(data) {
        var jsonObj = data.opinions;
        var tableRow = $("#tableRow");

        for (i = 0; i < jsonObj.length; i++)
        {
            var newRowId = "newRow" + i;
            tableRow.append("<div id=\"" + newRowId + "\" class=\"col-lg-12 newRow\" style=\"border-top: 1px solid white; height: 40px;\">");
            var newRow = $("#" + newRowId);
            var jsOutput = jsonObj[i];
            newRow.append("<div class=\"col-lg-1\">" + jsOutput.id +  "</div>");
            newRow.append("<div class=\"col-lg-2\">" + jsOutput.productId.name + "</div>");
            newRow.append("<div class=\"col-lg-2\">" + jsOutput.pros + "</div>");
            newRow.append("<div class=\"col-lg-2\">" + jsOutput.cons + "</div>");
            newRow.append("<div class=\"col-lg-4\">" + jsOutput.generalOpinion + "</div>");
            newRow.append("<div class=\"col-lg-1\">" + jsOutput.score + "/5</div>");
            tableRow.append("</div>");
        }
    });
});
