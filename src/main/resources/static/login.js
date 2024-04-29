const loginbtn = document.getElementById("login");

console.log(loginbtn)

loginbtn.addEventListener("click", function (e) {
    /* Инструкция preventDefault позволяет переопределить стандартное поведение браузера,
    если ее убрать, то браузер по-умолчанию обновит страницу после отправки данных формы */
    e.preventDefault();
    let username = document.getElementsByName("username")[0].value;
    let password = document.getElementsByName("password")[0].value;

    // Преобразуем полученные данные в JSON
    const formdata = JSON.stringify({username: username, password: password});

    // Отправляем запрос через fetch (необходимо выставить соответствующий заголовок (headers)!)
    fetch("/api/login",
        {
            method: "POST",
            body: formdata,
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            // fetch в случае успешной отправки возвращает Promise, содержащий response объект (ответ на запрос)
            // Возвращаем json-объект из response и получаем данные из поля message
            response.text().then(text => {
                if (text.includes("Invalid username")) {
                    alert("Неправильное имя пользователя");
                } else if (text.includes("Invalid password")) {
                    alert("Неправильный пароль");
                } else {
                    alert("Успешная авторизация!");
                    window.location.href = "/booking";
                }
            })
        })
        .catch(error => {
            alert(error);
            console.error('error:', error);
        });

});