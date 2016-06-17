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
    <meta name="robots" content="index,follow">
    <title>Корзина || Superkid || Детский магазин модных товаров</title>
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
    <script>
        jQuery(function ($) {
            $("#phone").mask("+38 (999) 999-99-99");
        });
    </script>
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
                <a href="/#main"><span class="super-nav">Super</span><span class="kid-nav">Kid</span></a>
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

<!-- CART -->
<div class="container-fluid">
    <section id="cart">
        <div class="row cart">
            <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12">
                <strong>Корзина:</strong>
            </div>
        </div>
        <!-- Empty cart -->
        <c:if test="${fn:length(productsInCart) eq 0}">
            <div class="row cart">
                <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12 empty-cart">
                    <div class="alert alert-info" role="alert">
                        В корзине нет товаров
                    </div>
                </div>
            </div>
        </c:if>
        <!-- Full cart -->
        <c:if test="${fn:length(productsInCart) gt 0}">
            <div class="row cart">
                <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12 full-cart">
                    <table class="table table-striped">
                        <tr>
                            <td class="hidden-xs">Артикул</td>
                            <td>Категория</td>
                            <td>Фото</td>
                            <td class="hidden-xs">Название</td>
                            <td>Размер</td>
                            <td>Стоимость</td>
                        </tr>
                        <c:forEach items="${productsInCart}" var="product">
                            <tr>
                                <td class="hidden-xs">${product.productInfo.article}</td>
                                <td>${product.productCategory.name}</td>
                                <td><img width="50px" height="50px"
                                         src="/resources/${product.productInfo.photoLinkShort}"></td>
                                <td class="hidden-xs">${product.productInfo.name}</td>
                                <td>${product.productSize.size}</td>
                                <td>
                                    <fmt:formatNumber type="number" value="${product.price}"/>
                                    грн
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td class="hidden-xs"></td>
                            <td></td>
                            <td class="hidden-xs"></td>
                            <td></td>
                            <td style="text-align: right;"><strong>Итого:</strong></td>
                            <td><strong>
                                <fmt:formatNumber type="number" value="${productsInCartAmount}"/>
                                грн
                            </strong></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="row cart">
                <form method="post" action="/checkout/">
                    <div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-12 full-cart input-padding text-center">
                        <input class="input" type="text" name="name" placeholder=" Введите имя" maxlength ="50" required autofocus>
                    </div>
                    <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 full-cart input-padding text-center">
                        <input id="phone" class="input" type="text" name="phone" placeholder=" Введите телефон"
                               required>
                    </div>
                    <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 full-cart input-padding text-center">
                        <input class="input" type="email" name="email" placeholder=" Введите Email" maxlength ="50" required>
                    </div>
                    <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 full-cart input-padding text-center">
                        <input type="submit" value="Оформить заказ" class="btn btn-success btn-mg" width="80px">
                    </div>
                </form>
            </div>
            <div class="row cart">
                <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12 full-cart text-center">
                    <p><a href="/#kids" class="btn btn-danger btn-mg">Продолжить покупки</a></p>
                </div>
            </div>
            <div class="row cart">
                <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12 full-cart text-center">
                    <p><a href="/cart/clear/" class="btn btn-info btn-mg">Очистить корзину</a></p>
                </div>
            </div>
        </c:if>
    </section>
</div>

<jsp:include page="/WEB-INF/views/sections/ads.jsp"/>
<jsp:include page="/WEB-INF/views/sections/footer.jsp"/>

</body>
</html>