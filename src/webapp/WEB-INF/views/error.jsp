<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
          content="Детская обувь, детская пижама, детское нижнее белье, купить, пижама супермен, пижама спайдер мен"/>
    <meta name="robots" content="noindex,nofollow">
    <title>Ошибка || Superkid || Детский магазин модных товаров</title>
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
    <script src="/resources/bootstrap/js/main.js"></script>
    <script src="/resources/bootstrap/js/jquery.maskedinput.min.js"></script>
</head>
<body>


<!-- NAVBAR -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span><span class="icon-bar"></span>
            </button>
            <div class="navbar-brand">
                <a href="http://www.superkid.com.ua"><span class="super-nav">Super</span><span class="kid-nav">Kid</span></a>
            </div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <div id="menu-product">
                <ul class="nav navbar-nav">
                    <li id="nav-main"><a href="/#main">Главная</a></li>
                    <li id="nav-kids"><a href="/#kids">Кидсы</a></li>
                    <li id="nav-pajamas"><a href="/#pajamas">Пижамы</a></li>
                    <li id="nav-panties"><a href="/#panties">Трусики</a></li>
                    <li id="nav-payments" class="hidden-sm"><a href="/#payments">Оплата</a></li>
                    <li id="nav-delivery" class="hidden-sm"><a href="/#delivery">Доставка</a></li>
                    <li id="nav-contacts" class="hidden-sm"><a href="/#contacts">Контакты</a></li>
                </ul>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/cart/">
                        <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Корзина
                        (${fn:length(productsInCart)})
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- ERROR -->
<div class="container-fluid">
    <section>
        <div class="row cart">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center">
                <h3 style="padding-top: 120px; padding-bottom: 100px">
                    Ошибка в запросе
                </h3>
            </div>
        </div>
    </section>
</div>
<jsp:include page="/WEB-INF/views/sections/ads.jsp"/>
<jsp:include page="/WEB-INF/views/sections/footer.jsp"/>
</body>
</html>