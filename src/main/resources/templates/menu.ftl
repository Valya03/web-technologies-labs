<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel='stylesheet' href='/static/style.css'> <!--подключаем файл стилей-->
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


<div class='header-hidden'> <!--шапка сайта-->
    <div class='container'> <!--помогает отодвигать элементы от правой и левой части экрана-->
        <div class='header-line'> <!--меню сайта-->
            <div class='header-logo'> <!--класс для логотипа-->
                <img src="/static/logo.png" alt=""> <!--картинка логотипа, путь картинки-->
            </div>

            <#if navmenu??>
                <div class='nav'>
                    <#list navmenu as item>
                        <!--ссылка куда-то ведет-->
                        <a class='nav-item' href="${item.addr}">${item.name}</a>
                    </#list>
                </div>
            </#if>

            <!--корзина-->
            <div class='cart'>
                <!--ссылка, которая кнопка, на которой картинка корзины-->
                <a href="#">
                    <img class='cart-img' src="/static/cart.png" alt="">
                </a>
                <!--класс картинки корзины-->
            </div>

            <!--телефон-->
            <div class='phone'>
                <!--Значок телефона-->
                <div class='phone-holder'>
                    <div class='phone-img'>
                        <img src="/static/phone.png" alt=""> <!--ссылка на картинку телефона-->
                    </div>

                    <div class='number'><a class='num' href='#'>+999-888-76-54</a>
                    </div>
                    <!--классс для ссылки с номером-->
                </div>

                <!--текст под номером телефоном-->
                <div class='phone-text'>
                    Свяжитесь с нами для <br> бронирования
                </div>
                <!--класс текста телефона-->
                <!--тег br для переноса строки-->
            </div>

            <!--кнопка "Заказ столика"-->
            <div class='btn'>
                <a class='button' href='#'>ЗАКАЗ СТОЛИКА</a>
            </div>
        </div>
    </div>
</div>

<main id="menu">

    <div class='black-block'>
        <div class='container'>
            <div class='block-holder'>
                <!--левый блок-->
                <div class='left'>
                    <div class='left-title'>
                        Отпразднуйте в одном из <br> самых лучших ресторанов.
                    </div>
                    <!--тег br - перенос строки-->
                    <div class='left-text'>
                        Только в этом месяце бизнес-ланч от 250 ₽
                    </div>
                </div>
                <!--правый блок, кнопка справа-->
                <div class='right'>
                    <div class='right-button'>
                        <a href='#' class='button'>ЗАКАЗ СТОЛИКА</a>
                        <!-- #- это кнопка без ссылки-->
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--блюда меню-->
    <div class='dishes'>

        <div class='container'>

            <!--заголовок-->
            <div class='dishes-title'>
                Наши <span>Блюда</span>
            </div>

            <div class='burgers'>
                <div class='burgers-image hoverable-container'> <!--большая картинка бургера-->
                    <img src='/static/pizza.jpg' class='pizza' alt="">
                </div>

                <!--правые маленькие одинаковые бургеры-->
                <div class='burgers-items'>
                    <div class='burger-item hoverable-container'>
                        <img src="/static/burger.jpg" class='burger' alt="">
                        <div class='burger-text'>
                            Гамбургер мини -------------- 220 ₽
                        </div>
                    </div>

                    <div class='burger-item hoverable-container'>
                        <img src="/static/burger.jpg" class='burger' alt="">
                        <div class='burger-text'>
                            Гамбургер мини -------------- 220 ₽
                        </div>
                    </div>

                    <div class='burger-item hoverable-container'>
                        <img src="/static/burger.jpg" class='burger' alt="">
                        <div class='burger-text'>
                            Гамбургер мини -------------- 220 ₽
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

    <div class="container_table">
        <div class="row">
            <div class="col">
                <h2 class="text-center text-custom-orange mb-5" style="text-shadow: 2px 2px 4px rgba(0, 0, 0, 0);">Наше
                    меню</h2>
                <div class="table-responsive">
                    <table class="table table-striped" id="priceTable">
                        <thead>
                        <tr>
                            <th scope="col">Горячие блюда</th>
                            <th scope="col">
                                Цена (в рублях)
                                <button class="btn btn-link btn-sm" onclick="sortTable()">↑↓</button>
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Баклажаны в остром соусе</td>
                            <td>290</td>
                        </tr>
                        <tr>
                            <td>Паста с овощами и креветками</td>
                            <td>440</td>
                        </tr>
                        <tr>
                            <td>Скумбрия обжаренная с брокколи</td>
                            <td>360</td>
                        </tr>
                        <tr>
                            <td>Филе белой рыбки с овощным пюре</td>
                            <td>380</td>
                        </tr>
                        <tr>
                            <td>Омуль с овощами в кисло-сладком соусе</td>
                            <td>450</td>
                        </tr>
                        <tr>
                            <td>Вок с курицей</td>
                            <td>380</td>
                        </tr>
                        <tr>
                            <td>Паста Карбонара</td>
                            <td>370</td>
                        </tr>
                        <tr>
                            <td>Пельмени из конины</td>
                            <td>310</td>
                        </tr>
                        <tr>
                            <td>Куриное филе с овощами и соусом из бекона</td>
                            <td>390</td>
                        </tr>
                        <tr>
                            <td>Вареники с курицей и сыром</td>
                            <td>320</td>
                        </tr>
                        <tr>
                            <td>Бифштекс из конины</td>
                            <td>410</td>
                        </tr>
                        <tr>
                            <td>Стейк из говядины</td>
                            <td>540</td>
                        </tr>
                        <tr>
                            <td>Стейк из конины</td>
                            <td>510</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div class="hidebox">
            <h2 class="clickable" style="text-shadow: 2px 2px 4px rgba(0, 0, 0, 0);">Lorem ipsum</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean non neque ac sem accumsan rhoncus ut ut
                turpis. In hac habitasse platea dictumst. Proin eget nisi erat, et feugiat arcu. Duis semper porttitor
                lectus, ac pharetra erat imperdiet nec. Morbi interdum felis nulla. Aenean eros orci, pellentesque sed
                egestas vitae, auctor aliquam nisi. Nulla nec libero eget sem rutrum iaculis. Quisque in enim velit, at
                dignissim est. Nulla ullamcorper, dolor ac pellentesque placerat, justo tellus gravida erat, vel
                porttitor libero erat condimentum metus. Donec sodales aliquam orci id suscipit. Proin sed risus sit
                amet massa ultrices laoreet quis a erat. Aliquam et metus id erat vulputate egestas. Cum sociis natoque
                penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
            <h2 class="clickable" style="text-shadow: 2px 2px 4px rgba(0, 0, 0, 0);">Donec vel nisl</h2>
            <p>Donec vel nisl nibh. Aenean quam tortor, tempus sit amet mattis dapibus, egestas tempor dui. Duis
                vestibulum imperdiet risus pretium pretium. Nunc vitae porta ligula. Vestibulum sit amet nulla quam.
                Aenean lacinia, ante vitae sodales sagittis, leo felis bibendum neque, mattis sagittis neque urna vel
                magna. Sed at sem vitae lorem blandit feugiat.</p>
            <h2 class="clickable" style="text-shadow: 2px 2px 4px rgba(0, 0, 0, 0);">Работа у нас</h2>
            <p>В нашу дружную команду всегда нужны трудолюбивые и ответственные люди! Хочешь работать в приятном
                коллективе? Скорее звони нам по номеру +7 (917) 805-60-74, обсудим возможные варианты вакансий.</p>
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


<script src='static/app.js'></script>

<script>
    // Use jQuery via jQuery() instead of via $()
    $('.hoverable-container img').on({
        mouseenter: function () {
            $(this).animate({
                borderRadius: "15%"
            }, 200);
        },
        mouseleave: function () {
            $(this).animate({
                borderRadius: "0%"
            }, 200);
        }
    });
</script>


</body>
</html>
