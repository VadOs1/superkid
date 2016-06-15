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
          content="Детская обувь, детская пижама, детское нижнее белье, купить, пижама супермен, пижама спайдер мен, пижама hello kitty"/>
    <meta name="robots" content="index,follow">
    <meta name="google-site-verification" content="BY0AcjFpow27z5lGiGn1B4_wYviwIZ5ZyRbvn6G8hTo">
    <meta name='yandex-verification' content='45f9f13ab0f6cd62'>
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
            <div id="menu">
                <ul class="nav navbar-nav">
                    <li id="nav-main"><a href="#main">Главная</a></li>
                    <li id="nav-kids"><a href="#kids">Кидсы</a></li>
                    <li id="nav-pajamas"><a href="#pajamas">Пижамы</a></li>
                    <li id="nav-panties"><a href="#panties">Трусики</a></li>
                    <li id="nav-payments" class="hidden-sm"><a href="#payments">Оплата</a></li>
                    <li id="nav-delivery" class="hidden-sm"><a href="#delivery">Доставка</a></li>
                    <li id="nav-contacts" class="hidden-sm"><a href="#contacts">Контакты</a></li>
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

<!-- MAIN PHOTO -->
<section id="main">
    <div class="container-fluid hidden-xs">
        <div class="row main">
            <span class="main-text-label-yellow">Детский магазин</span>
            <span class="main-text-label-red">&nbsp;модных товаров</span>
        </div>
    </div>
    <div class="container-fluid hidden-lg hidden-md hidden-sm">
        <div class="row main-text-mob">
            <span class="main-text-label-yellow-mob">Детский магазин</span>
            <span class="main-text-label-red-mob">&nbsp;модных товаров</span>
        </div>
    </div>
</section>

<!-- KIDS -->
<div class="container-fluid">
    <section id="kids">
        <div class="row kids">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <h3 class=" intro-text label-kids">
                    <img src="/resources/img/superkid_kid.png" alt="Superkid || Детский магазин модных товаров"
                         title="Купить кидсы">

                    <p class="super-nav">Супер<span class="kid-nav"> Кидсы</span></p>
                </h3>
            </div>
        </div>
        <div class="row kids">
            <c:forEach items="${products}" var="product">
                <c:if test="${product.productCategory.id eq 1}">
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                        <div class="product">
                            <a href="/products/${product.productInfo.article}" title="${product.productInfo.name}">
                                <img alt="${product.productInfo.name}" title="${product.productInfo.name}"
                                     class="img-thumbnail blink"
                                     src="/resources/${product.productInfo.photoLinkShort}">

                                <div>
                                    <button type="button" class="btn btn-sm btn-default">Выбрать размер</button>
                                </div>
                                <p class="price-top">
                                    <fmt:formatNumber type="number" value="${product.price}"/>
                                    грн
                                </p>
                            </a>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </section>
</div>
<div class="container-fluid">
    <section>
        <div class="row kids-advantages">
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 icon-block">
                <i class="fa fa-hand-peace-o fa-5x icon-white" id="icon1"></i>

                <p class="icon-text-white">Стильные</p>
                <hr class="short">
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 icon-block">
                <i class="fa fa-child fa-5x icon-white" id="icon2"></i>

                <p class="icon-text-white">Удобные</p>
                <hr class="short">
            </div>
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 icon-block">
                <i class="fa fa-gift fa-5x icon-white" id="icon3"></i>

                <p class="icon-text-white">Хороший подарок</p>
                <hr class="short">
            </div>
        </div>
    </section>
</div>

<!-- PAJAMAS -->

<div class="container-fluid">
    <section id="pajamas">
        <div class="row pajamas">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <h3 class=" intro-text label-pajamas">
                    <img src="/resources/img/superkid_kid.png" alt="Superkid || Детский магазин модных товаров"
                         title="Купить детскую пижаму">

                    <p class="super-nav">Супер<span class="kid-nav"> Пижамы</span></p>
                </h3>
            </div>
        </div>
        <div class="row pajamas">
            <c:forEach items="${products}" var="product">
                <c:if test="${product.productCategory.id eq 2}">
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                        <div class="product">
                            <a href="/products/${product.productInfo.article}" title="${product.productInfo.name}">
                                <img alt="${product.productInfo.name}" title="${product.productInfo.name}"
                                     class="img-thumbnail blink"
                                     src="/resources/${product.productInfo.photoLinkShort}">

                                <div>
                                    <button type="button" class="btn btn-sm btn-default">Выбрать размер</button>
                                </div>
                                <p class="price-top">
                                    <fmt:formatNumber type="number" value="${product.price}"/>
                                    грн
                                </p>
                            </a>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </section>
</div>
<div class="container-fluid">
    <section>
        <div class="row pajamas-advantages">
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 icon-block">
                <i class="fa fa-paw fa-5x icon-white" id="icon4"></i>

                <p class="icon-text-white">Красочные</p>
                <hr class="short">
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 icon-block">
                <i class="fa fa-user-secret fa-5x icon-white" id="icon5"></i>

                <p class="icon-text-white">Теплые</p>
                <hr class="short">
            </div>
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 icon-block">
                <i class="fa fa-home fa-5x icon-white" id="icon6"></i>

                <p class="icon-text-white">Идеально для дома и садика</p>
                <hr class="short">
            </div>
        </div>
    </section>
</div>

<!-- PANTIES -->

<div class="container-fluid">
    <section id="panties">
        <div class="row panties">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <h3 class=" intro-text label-panties">
                    <img src="/resources/img/superkid_kid.png" alt="Superkid || Детский магазин модных товаров"
                         title="Купить детские трусики">

                    <p class="super-nav">Супер<span class="kid-nav"> Трусики</span></p>
                </h3>
            </div>
        </div>
        <div class="row panties">
            <c:forEach items="${products}" var="product">
                <c:if test="${product.productCategory.id eq 3}">
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                        <div class="product">
                            <a href="/products/${product.productInfo.article}" title="${product.productInfo.name}">
                                <img alt="${product.productInfo.name}" title="${product.productInfo.name}"
                                     class="img-thumbnail blink"
                                     src="/resources/${product.productInfo.photoLinkShort}">

                                <div>
                                    <button type="button" class="btn btn-sm btn-default">Выбрать размер</button>
                                </div>
                                <p class="price-top">
                                    <fmt:formatNumber type="number" value="${product.price}"/>
                                    грн
                                </p>
                            </a>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </section>
</div>
<div class="container-fluid">
    <section>
        <div class="row panties-advantages">
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 icon-block">
                <i class="fa fa-photo fa-5x icon-white" id="icon7"></i>

                <p class="icon-text-white">Яркие</p>
                <hr class="short">
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 icon-block">
                <i class="fa fa-leaf fa-5x icon-white" id="icon8"></i>

                <p class="icon-text-white">Комфортные</p>
                <hr class="short">
            </div>
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 icon-block">
                <i class="fa fa-child fa-5x icon-white" id="icon9"></i>

                <p class="icon-text-white">Модный ребенок</p>
                <hr class="short">
            </div>
        </div>
    </section>
</div>

<!-- PAYMENTS -->
<div class="container-fluid">
    <section id="payments">
        <div class="row payments">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <h3 class=" intro-text label-payments">
                    <img src="/resources/img/superkid_kid.png" alt="Superkid || Детский магазин модных товаров"
                         title="Superkid || Детский магазин модных товаров">

                    <p class="super-nav">Оплата</p>
                </h3>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 icon-block-payment-delivery">
                <i class="fa fa-money fa-5x icon-yellow" id="icon10"></i>

                <p class="icon-text-yellow">Оплата курьеру</p>
                <hr class="short">
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 icon-block-payment-delivery">
                <i class="fa fa-cc-visa fa-5x icon-yellow" id="icon11"></i>

                <p class="icon-text-yellow">Карта Приватбанка</p>
                <hr class="short">
            </div>
            <div class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12">
                <h4 class="text-payments">
                    Возврат приобретенных товаров осуществляется в случаях и согласно условиям, регламентированным
                    «Законом Украины о защите прав потребителей»
                </h4>
            </div>
        </div>
    </section>
</div>

<!-- DELIVERY-->
<div class="container-fluid">
    <section id="delivery">
        <div class="row delivery">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <h3 class=" intro-text label-delivery">
                    <img src="/resources/img/superkid_kid.png" alt="Superkid || Детский магазин модных товаров"
                         title="Superkid || Детский магазин модных товаров">

                    <p class="super-nav"><span class="kid-nav">Доставка</span></p>
                </h3>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 icon-block-payment-delivery">
                <i class="fa fa-motorcycle fa-5x icon-red" id="icon12"></i>

                <p class="icon-text-red">Курьер по адресу <br>Киев</p>
                <hr class="short">
            </div>
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 icon-block-payment-delivery">
                <i class="fa fa-truck fa-5x icon-red" id="icon13"></i>
                <p class="icon-text-red">Новая Почта<br>Украина</p>
                <hr class="short">
            </div>
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 icon-block-payment-delivery">
                <i class="fa fa-shopping-cart fa-5x icon-red" id="icon14"></i>

                <p class="icon-text-red">Самовывоз <br>Киев</p>
                <hr class="short">
            </div>
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <h4 class="text-delivery">
                    Стоимость курьевской доставки по Киеву и отправка Новой Почтой - 30 грн<br>
                    Мы находимся по адресу г.Киев, пр. Бажана 10
                </h4>
            </div>
        </div>
    </section>
</div>

<!-- GOOGLE EARTH -->
<div class="container-fluid">
    <section id="contacts">
        <div class="row google-map">
            <div id="google-map-block" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <h3 class=" intro-text label-contacts">
                    <img src="/resources/img/superkid_kid.png" alt="Superkid || Детский магазин модных товаров"
                         title="Superkid || Детский магазин модных товаров">

                    <p class="super-nav">Контакты</p>
                </h3>
                <div id="google-map"></div>
            </div>
        </div>
    </section>
</div>

<jsp:include page="/WEB-INF/views/sections/ads.jsp"/>
<jsp:include page="/WEB-INF/views/sections/footer.jsp"/>
</body>
</html>