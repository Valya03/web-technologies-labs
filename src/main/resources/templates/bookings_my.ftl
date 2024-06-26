<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/static/style.css"> <!--подключаем файл стилей-->
    <!--ссылка на шрифт Open Sans-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;500;600;700;800&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Tinos:wght@400;700&display=swap" rel="stylesheet">
    <script language="JavaScript" type="text/javascript" src="/static/jquery-3.6.0.min.js"></script>
    <title>Ресторан</title>
</head>
<body>

<div class="header-hidden"> <!--шапка сайта-->
    <div class="container"> <!--помогает отодвигать элементы от правой и левой части экрана-->
        <div class="header-line"> <!--меню сайта-->
            <div class="header-logo"> <!--класс для логотипа-->
                <img src="/static/logo.png" alt=""> <!--картинка логотипа, путь картинки-->
            </div>

            <#if navmenu??>
                <div class="nav">
                    <#list navmenu as item>
                        <!--ссылка куда-то ведет-->
                        <a class="nav-item" href="${item.addr}">${item.name}</a>
                    </#list>
                </div>
            </#if>

            <!--корзина-->
            <div class="cart">
                <!--ссылка, которая кнопка, на которой картинка корзины-->
                <a href="#">
                    <img class="cart-img" src="/static/cart.png" alt="">
                </a>
                <!--класс картинки корзины-->
            </div>

            <!--телефон-->
            <div class="phone">
                <!--Значок телефона-->
                <div class="phone-holder">
                    <div class="phone-img">
                        <img src="/static/phone.png" alt=""> <!--ссылка на картинку телефона-->
                    </div>

                    <div class="number"><a class="num" href="#">+999-888-76-54</a>
                    </div>
                    <!--классс для ссылки с номером-->
                </div>

                <!--текст под номером телефоном-->
                <div class="phone-text">
                    Свяжитесь с нами для <br> бронирования
                </div>
                <!--класс текста телефона-->
                <!--тег br для переноса строки-->
            </div>

            <!--кнопка "Заказ столика"-->
            <div class="btn">
                <a class="button" href="#">ЗАКАЗ СТОЛИКА</a>
            </div>
        </div>

    </div>
</div>

<main id="booking" class="booking">
    <!--поле брони-->
    <div class="wrapper">
        <h2>Перечень заявок на бронирование</h2>

        <table id="items" class="table table-striped"></table>

        <div class="hint-text">
            <h3>Хотите отправить новую заявку? <a href="/booking">Отправить</a></h3>
        </div>
    </div>

</main>

<footer>
    <!-- Footer Start -->
    <div class="container-fluid bg-dark text-light footer pt-5 mt-5 wow fadeIn" data-wow-delay="0.1s">

        <div class="container py-5">
            <div class="text-custom-white row g-3">
                <div class="col-lg-3 col-md-3">
                    <h4 class="text-custom-white mb-3">Адрес</h4>
                    <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>Карла Маркса 12, Уфа, Россия</p>
                    <p class="mb-3"><i class="fa fa-phone-alt me-3"></i>8(909) 999 99 99</p>
                    <p class="mb-3"><i class="fa fa-envelope me-3"></i>restoran@mail.ru</p>
                </div>
                <div class="col-lg-3 col-md-3">
                    <h4 class="text-custom-gold mb-3">Время Работы</h4>
                    <h6 class="text-light">Понедельник - Воскресенье:</h6>
                    <p class="mb-3">10:00 - 2:00</p>
                </div>
                <div class="col-lg-3 col-md-3">
                    <h4 class="text-light mb-3">Рассылка</h4>
                    <p>Оставьте свои данные, чтобы знать первым о наших акциях!</p>
                    <div class="position-relative mx-auto" style="max-width: 400px;">
                        <input id="emailInput" class="form-control border-0 w-100 py-3 ps-4 pe-5" type="text"
                               placeholder="Ваша почта">
                        <button id="clearButton" type="button"
                                class="btn btn-custom-orange2 py-2 position-absolute top-0 end-0 mt-2 me-2">Отправить
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>


<script src="/static/app.js"></script>
<script src="/static/myforms.js"></script>

</body>
</html>
