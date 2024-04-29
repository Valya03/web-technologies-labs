<!DOCTYPE html>
<!-- Coding By CodingNepal - codingnepalweb.com -->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Авторизация</title>
    <script language="JavaScript" type="text/javascript" src="/static/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="/static/style.css">
</head>
<body>
<main class="auth">
    <div class="wrapper">
        <h2>Регистрация</h2>
        <form action="#">
            <div class="input-box">
                <input type="text" name="username" placeholder="Введите никнейм" required>
            </div>
            <div class="input-box">
                <input type="password" name="password" placeholder="Введите пароль" required>
            </div>
            <div class="input-box send-button">
                <input type="Submit" id="register" value="Зарегистрироваться">
            </div>
            <div class="hint-text">
                <h3>Уже есть аккаунт? <a href="/login">Войти</a></h3>
            </div>
        </form>
    </div>
</main>
<script src="/static/register.js"></script>
</body>
</html>