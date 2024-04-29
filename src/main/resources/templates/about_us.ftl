<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel='stylesheet' href='/static/style.css'> <!--подключаем файл стилей-->
    <!--ссылка на шрифт Open Sans-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;500;600;700;800&display=swap" rel="stylesheet"> 
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

<main id="about_us">
<!--класс карточек-->
<div class='cards'>

    <div class='container'> <!--помогает отодвигать элементы от правой и левой части экрана-->

       <div class='cards-holder'>

            <div class='card'>

                <div class='card-image'>
                    <img class='card-img' src='/static/card.png'>
                    <!--путь к картинке карточки-->
                </div>

                <div class='card-title'>
                    Магическая  <span> Атмосфера</span>
                </div>

                <!--описание карточки-->
                <div class='card-desc'>
                    В нашем заведении царит магическая атмосфера наполненная вкусными ароматами
                </div>

            </div>
           
           <!--распологается наша картинка-->
            <div class='card'>

                <div class='card-image'>
                    <img class='card-img' src='/static/card.png'>
                </div>

                <div class='card-title'>
                    Лучшее качество  <span> Еды</span>
                </div>

                <div class='card-desc'>
                    Качество нашей Еды - отменное!

                </div>

            </div>

            <div class='card'>

                <div class='card-image'>
                    <img class='card-img' src='/static/card.png'>
                </div>

                <div class='card-title'>
                   Недорогая  <span> Еда</span>
                </div>

                <div class='card-desc'>
                    Стоимость нашей Еды зависит только от её количества. Качество всегда на высоте!
                </div>

            </div>п
        </div>
    </div>

</div>


<div class='history'>

    <div class='container'> <!--помогает отодвигать элементы от правой и левой части экрана-->

        <div class='history-holder'>
            <div class='history-info'>
                
                <div class='history-title'>
                    Наша <span>История</span>
                </div>

                <div class='history-desc'>
                    Как и у любого другого самобытного места, у нас есть своя, особая история. Идея ресторана пришла основателям неожиданно. Во время прогулки по лесу создатель нашего ресторана застрял в сотнях километров от ближайшего населенного пункта. Вдали от цивилизации и связи им пришлось навремя обустровать себе нехитрый быт, добывать и готовить себе еду.
                </div>


                <div class='history-number'>
                    <div class='number-item'>
                        93 <span>Напитки</span>
                    </div>

                    <div class='number-item'>
                        206 <span>Еда</span>
                    </div>

                    <div class='number-item'>
                        71 <span>Закуски</span>
                    </div>
                </div>
            </div>

            <div class='history-images'>
                <img class='imgages-1' src="/static/1.jpg" alt="">
                <img class='imgages-2' src="/static/2.jpg" alt="">
                <img class='imgages-3' src="/static/3.jpg" alt="">
            </div>
        </div>

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
                    <p class="mb-3">10:00  - 2:00</p>
                </div>
                <div class="col-lg-3 col-md-3">
                    <h4 class="text-light mb-3">Рассылка</h4>
                    <p>Оставьте свои данные, чтобы знать первым о наших акциях!</p>
                    <div class="position-relative mx-auto" style="max-width: 400px;">
						<input id="emailInput" class="form-control border-0 w-100 py-3 ps-4 pe-5" type="text" placeholder="Ваша почта">
						<button id="clearButton" type="button" class="btn btn-custom-orange2 py-2 position-absolute top-0 end-0 mt-2 me-2">Отправить</button>
					</div>
                </div>
            </div>
        </div>
    </div>
</footer>  

    
<script src='static/app.js'>

</script>
</div>

</body>
</html>
