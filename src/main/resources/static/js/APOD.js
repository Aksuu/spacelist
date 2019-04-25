var myApiKey = "eouaU2byphnbSBMhS5Wh8CtwEt7QoDrA67CZOYou";

$(document).ready(function () {
  $("#update").click(updateDate);
});

function updateDate(event) {
  var date = $("#image-date").val();
  var url = apodUrlBuild(date);
  $.getJSON(url, function (response) {
    $("#apodImg").attr("src", response.url);
    $("#apodTitle").html(response.title);
    $("#apodDescription").html(response.explanation);
  });
}

function apodUrlBuild(date) {
  var finalUrl = "https://api.nasa.gov/planetary/apod";
  finalUrl += "?date=" + date + "&api_key=" + myApiKey;
  return finalUrl;
}