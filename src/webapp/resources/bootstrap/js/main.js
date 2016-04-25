$(document).ready(function () {
    $("#menu").on("click", "a", function (event) {
        event.preventDefault();
        var id = $(this).attr('href'),
            top = $(id).offset().top;
        $('body,html').animate({scrollTop: top}, 1500);
    });
    $("#menu_bottom").on("click", "a", function (event) {
        event.preventDefault();
        var id = $(this).attr('href'),
            top = $(id).offset().top;
        $('body,html').animate({scrollTop: top}, 1500);
    });
    $(document.body).on('appear', '.main', function (e, $affected) {
        $('#nav-main').addClass('active');
        $('#nav-kids').removeClass('active');
        $('#nav-pajamas').removeClass('active');
        $('#nav-panties').removeClass('active');
        $('#nav-payments').removeClass('active');
        $('#nav-delivery').removeClass('active');
        $('#nav-contacts').removeClass('active');
    });
    $('.main').appear({force_process: true});
    $(document.body).on('appear', '.kids', function (e, $affected) {
        $('#nav-main').removeClass('active');
        $('#nav-kids').addClass('active');
        $('#nav-pajamas').removeClass('active');
        $('#nav-panties').removeClass('active');
        $('#nav-payments').removeClass('active');
        $('#nav-delivery').removeClass('active');
        $('#nav-contacts').removeClass('active');
        $(".label-kids").addClass('animated zoomIn');
    });
    $('.kids').appear({force_process: true});
    $(document.body).on('appear', '.pajamas', function (e, $affected) {
        $('#nav-main').removeClass('active');
        $('#nav-kids').removeClass('active');
        $('#nav-pajamas').addClass('active');
        $('#nav-panties').removeClass('active');
        $('#nav-payments').removeClass('active');
        $('#nav-delivery').removeClass('active');
        $('#nav-contacts').removeClass('active');
        $(".label-pajamas").addClass('animated zoomIn');
    });
    $('.pajamas').appear({force_process: true});
    $(document.body).on('appear', '.panties', function (e, $affected) {
        $('#nav-main').removeClass('active');
        $('#nav-kids').removeClass('active');
        $('#nav-pajamas').removeClass('active');
        $('#nav-panties').addClass('active');
        $('#nav-payments').removeClass('active');
        $('#nav-delivery').removeClass('active');
        $('#nav-contacts').removeClass('active');
        $(".label-contacts").addClass('animated zoomIn');
        $(".label-panties").addClass('animated zoomIn');
    });
    $('.panties').appear({force_process: true});
    $(document.body).on('appear', '.payments', function (e, $affected) {
        $('#nav-main').removeClass('active');
        $('#nav-kids').removeClass('active');
        $('#nav-pajamas').removeClass('active');
        $('#nav-panties').removeClass('active');
        $('#nav-payments').addClass('active');
        $('#nav-delivery').removeClass('active');
        $('#nav-contacts').removeClass('active');
        $(".label-payments").addClass('animated zoomIn');
    });
    $('.payments').appear({force_process: true});
    $(document.body).on('appear', '.delivery', function (e, $affected) {
        $('#nav-main').removeClass('active');
        $('#nav-kids').removeClass('active');
        $('#nav-pajamas').removeClass('active');
        $('#nav-panties').removeClass('active');
        $('#nav-payments').removeClass('active');
        $('#nav-delivery').addClass('active');
        $('#nav-contacts').removeClass('active');
        $(".label-delivery").addClass('animated zoomIn');
    });
    $('.delivery').appear({force_process: true});
    $(document.body).on('appear', '.google-map', function (e, $affected) {
        $('#nav-main').removeClass('active');
        $('#nav-kids').removeClass('active');
        $('#nav-pajamas').removeClass('active');
        $('#nav-panties').removeClass('active');
        $('#nav-payments').removeClass('active');
        $('#nav-delivery').removeClass('active');
        $('#nav-contacts').addClass('active');
        $(".label-contacts").addClass('animated zoomIn');
    });
    $('.google-map').appear({force_process: true});


    $(document.body).on('appear', '#icon1', function (e, $affected) {
        $('#icon1').addClass('animated bounce');
    });
    $('#icon1').appear({force_process: true});

    $(document.body).on('appear', '#icon2', function (e, $affected) {
        $('#icon2').addClass('animated bounce');
    });
    $('#icon2').appear({force_process: true});

    $(document.body).on('appear', '#icon3', function (e, $affected) {
        $('#icon3').addClass('animated bounce');
    });
    $('#icon3').appear({force_process: true});

    $(document.body).on('appear', '#icon4', function (e, $affected) {
        $('#icon4').addClass('animated bounce');
    });
    $('#icon4').appear({force_process: true});

    $(document.body).on('appear', '#icon5', function (e, $affected) {
        $('#icon5').addClass('animated bounce');
    });
    $('#icon5').appear({force_process: true});

    $(document.body).on('appear', '#icon6', function (e, $affected) {
        $('#icon6').addClass('animated bounce');
    });
    $('#icon6').appear({force_process: true});

    $(document.body).on('appear', '#icon7', function (e, $affected) {
        $('#icon7').addClass('animated bounce');
    });
    $('#icon7').appear({force_process: true});

    $(document.body).on('appear', '#icon8', function (e, $affected) {
        $('#icon8').addClass('animated bounce');
    });
    $('#icon8').appear({force_process: true});

    $(document.body).on('appear', '#icon9', function (e, $affected) {
        $('#icon9').addClass('animated bounce');
    });
    $('#icon9').appear({force_process: true});

    $(document.body).on('appear', '#icon10', function (e, $affected) {
        $('#icon10').addClass('animated bounce');
    });
    $('#icon10').appear({force_process: true});

    $(document.body).on('appear', '#icon11', function (e, $affected) {
        $('#icon11').addClass('animated bounce');
    });
    $('#icon11').appear({force_process: true});

    $(document.body).on('appear', '#icon12', function (e, $affected) {
        $('#icon12').addClass('animated bounce');
    });
    $('#icon12').appear({force_process: true});

    $(document.body).on('appear', '#icon13', function (e, $affected) {
        $('#icon13').addClass('animated bounce');
    });
    $('#icon13').appear({force_process: true});

    $(document.body).on('appear', '#icon14', function (e, $affected) {
        $('#icon14').addClass('animated bounce');
    });
    $('#icon14').appear({force_process: true});

});