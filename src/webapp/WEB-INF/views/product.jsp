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
    <meta name="description" content="${productsByArticle.get(0).productInfo.name}"/>
    <meta name="keywords" content="${productsByArticle.get(0).productInfo.name}"/>
    <meta name="robots" content="index,follow">
    <title>${productsByArticle[0].productInfo.name} || Superkid || Детский магазин модных товаров</title>
    <link rel="shortcut icon" href="/resources/img/superkid_favicon.png">
    <script src="/resources/bootstrap/js/jquery-1.11.1.min.js"></script>
    <script src="/resources/bootstrap/js/jquery.appear.js"></script>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/animate.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/style.css">
    <link rel="stylesheet" type="text/css"
          href="http://fonts.googleapis.com/css?family=Arial+Black&effect=emboss">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="/resources/bootstrap/js/main.js"></script>
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
                <span class="super-nav">Super</span><span class="kid-nav">Kid</span>
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

<!-- PRODUCT -->

<div class="container-fluid">
    <section id="one-product">
        <div class="row one-product">
            <div class="col-lg-7 col-lg-offset-1 col-md-7 col-md-offset-1 col-sm-7 col-sm-offset-1 col-xs-12 col-xs-offset-0">
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-10 col-xs-offset-1">
                    <img src="/resources/${productsByArticle[0].productInfo.photoLinkShort}" alt="${productsByArticle[0].productInfo.name}">
                </div>
                <div class="col-lg-6 col-lg-offset-2 col-md-6 col-md-offset-2 col-sm-6 col-sm-offset-2 col-xs-12 col-xs-offset-0 one-product-top">
                    <h3>${productsByArticle[0].productInfo.name}</h3>
                    <h5>Артикул: ${productsByArticle[0].productInfo.article}</h5>

                    <h3><p class="label label-info">
                        <fmt:formatNumber type="number" value="${productsByArticle[0].price}"/>
                        грн
                    </p></h3>
                    <form action="/cart/new/" method=get>
                        <input type=hidden name="article" value="${productsByArticle[0].productInfo.article}">

                        <h5 class="text-right">Выбрать размер:</h5>

                        <p class="text-right">
                            <select name="size">
                                <c:forEach items="${productsByArticle}" var="productOneElement">
                                    <option value="${productOneElement.productSize.id}">${productOneElement.productSize.size}</option>
                                </c:forEach>
                            </select>
                        </p>
                        <p class="text-right title = "${productsByArticle[0].productInfo.name}">
                        <button class="btn btn-md btn-info" type="submit">Добавить в корзину</button>
                        </p>
                    </form>
                </div>
                <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-10 col-xs-offset-1 one-product-top">
                    <hr class="long">
                    <h4>Описание товара:</h4>

                    <p>${productsByArticle[0].productCategory.description}</p>
                    <img alt="${productsByArticle[0].productInfo.name}" src="/resources/${productsByArticle[0].productInfo.photoLinkLong}"
                         class="hidden-xs hidden-sm">
                </div>
            </div>

            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 featured-products text-center">
                <c:forEach items="${featuredProducts}" var="product">
                    <c:if test="${product.productInfo.article eq 400101 || product.productInfo.article eq 300106 || product.productInfo.article eq 500101 || product.productInfo.article eq 400106 || product.productInfo.article eq 300102 || product.productInfo.article eq 500108}">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="product">
                                <a href="/products/${product.productInfo.article}" title="${product.productInfo.name}">
                                    <img alt="${product.productInfo.name}" title="${product.productInfo.name}"
                                         class="img-thumbnail blink"
                                         src="/resources/${product.productInfo.photoLinkShort}">

                                    <div>
                                        <button type="button" class="btn btn-sm btn-default">Выбрать размер
                                        </button>
                                    </div>
                                    <p class="price-top-featured">
                                        <fmt:formatNumber type="number" value="${product.price}"/>
                                        грн
                                    </p>
                                </a>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </section>
</div>

<jsp:include page="/WEB-INF/views/sections/ads.jsp"/>
<jsp:include page="/WEB-INF/views/sections/footer.jsp"/>
<script>
    $(document).ready(function () {
        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r;
            i[r] = i[r] || function () {
                        (i[r].q = i[r].q || []).push(arguments)
                    }, i[r].l = 1 * new Date();
            a = s.createElement(o),
                    m = s.getElementsByTagName(o)[0];
            a.async = 1;
            a.src = g;
            m.parentNode.insertBefore(a, m)
        })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

        ga('create', 'UA-57663378-3', 'auto');
        ga('send', 'pageview');
    });
</script>
<script>
    (function (d, w, c) {
        (w[c] = w[c] || []).push(function () {
            try {
                w.yaCounter33795579 = new Ya.Metrika({
                    id: 33795579,
                    clickmap: true,
                    trackLinks: true,
                    accurateTrackBounce: true
                });
            } catch (e) {
            }
        });

        var n = d.getElementsByTagName("script")[0],
                s = d.createElement("script"),
                f = function () {
                    n.parentNode.insertBefore(s, n);
                };
        s.type = "text/javascript";
        s.async = true;
        s.src = "https://mc.yandex.ru/metrika/watch.js";

        if (w.opera == "[object Opera]") {
            d.addEventListener("DOMContentLoaded", f, false);
        } else {
            f();
        }
    })(document, window, "yandex_metrika_callbacks");
</script>
</body>
</html>