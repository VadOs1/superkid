$(document).ready(function () {
    var latlng = new google.maps.LatLng(50.3948321, 30.6201574);
    var settings = {
        zoom: 15,
        center: latlng,
        mapTypeControl: true,
        mapTypeControlOptions: {style: google.maps.MapTypeControlStyle.DROPDOWN_MENU},
        navigationControl: true,
        navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL},
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById("google-map"), settings);
    var companyPos = new google.maps.LatLng(50.3948321, 30.6201574);
    var companyLogo = new google.maps.MarkerImage('/img/superkid_kid.png', new google.maps.Size(200, 200),
        new google.maps.Point(0, 0),
        new google.maps.Point(50, 00)
    );
    var companyMarker = new google.maps.Marker({
        position: companyPos,
        map: map,
        icon: companyLogo,
        title: "SuperKid || Детский магазин модных товаров",
    });
    var width = $('#google-map-block').css('width');
    $('#google-map').css('width', width);
    $('#google-map').css('height', '400px');

    $(window).resize(function () {
        var width = $('#google-map-block').css('width');
        $('#google-map').css('width', width);
    });

});