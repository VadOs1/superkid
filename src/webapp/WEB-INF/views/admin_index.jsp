<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta lang="ru">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="title" content="Superkid || Детский магазин модных товаров">
    <meta name="description"
          content="Удобная и модная обвувь для вашего малыша, большой выбор детских пижам и нижнего белья"/>
    <meta name="keywords"
          content="Детская обувь, детская пижама, детское нижнее белье, купить, пижама супермен, пижама спайдер мен, пижама hello kitty"/>
    <meta name="robots" content="noindex,nofollow">
    <title>Superkid || Детский магазин модных товаров</title>
    <link rel="shortcut icon" href="/resources/img/superkid_favicon.png">
    <script src="/resources/bootstrap/js/jquery-1.11.1.min.js"></script>
    <script src="/resources/bootstrap/js/jquery.appear.js"></script>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/animate.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/style.css">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Arial+Black&effect=emboss">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <script src="/resources/bootstrap/js/main.js"></script>
    <script src="/resources/bootstrap/js/google_maps.js"></script>
    <style>body {background: white}</style>
</head>
<body>

<!-- Logout -->
<div class="container-fluid">
    <section>
        <div class="row login">
            <div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4 col-xs-12 text-center">
                <p> Hello ${userName} !</p>
                <form class="form-signin" action="/logout" method="post">
                    <input type="hidden" id="username" name="username">
                    <button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top: 25px">Выйти
                    </button>
                </form>
            </div>
        </div>
    </section>
</div>
</div>
</body>
</html>
