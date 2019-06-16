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
    <title>Checkout || Superkid || Детский магазин модных товаров</title>
    <link rel="shortcut icon" href="/img/superkid_favicon.png">
    <script src="/bootstrap/js/jquery-1.11.1.min.js"></script>
    <script src="/bootstrap/js/jquery.appear.js"></script>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap/css/animate.css">
    <link rel="stylesheet" href="/bootstrap/css/style.css">
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Arial+Black&effect=emboss">
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script src="/bootstrap/js/main.js"></script>
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
                        (0)
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- CHECKOUT -->
<div class="container-fluid">
    <section id="checkout">
        <div class="row checkout">
            <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12">
                <div class="alert alert-info" role="alert">
                    <strong>${order.client.name}</strong>, cпасибо за заказ!<br><br>
                    Менеджер по продажам свяжется с Вами в течение часа!<br><br>
                    Номер заказа: <strong>300101${order.id}</strong><br><br>
                    Будем рады видеть Вас снова!<br><br>
                </div>
            </div>
            <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12">
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
                            <td><img width="50px" height="50px" src="/${product.productInfo.photoLinkShort}">
                            </td>
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
                        <td>
                            <strong>
                                <fmt:formatNumber type="number" value="${productsInCartAmount}"/>
                                грн
                            </strong></td>
                    </tr>
                </table>
            </div>
            <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12 text-center">
                Телефоны для связи с нами: <br><br>
                044-361-51-54<br>
                067-149-54-56<br>
                050-141-73-93<br><br>
                www.superkid.com.ua
            </div>
        </div>
    </section>
</div>

<jsp:include page="/WEB-INF/templates/sections/ads.jsp"/>
<jsp:include page="/WEB-INF/templates/sections/footer.jsp"/>
</body>
</html>