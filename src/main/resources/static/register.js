const regbtn = document.getElementById("register");

console.log(regbtn)

// Привязываем к элементу обработчик события "click"
regbtn.addEventListener("click", function (e) {
    /* Инструкция preventDefault позволяет переопределить стандартное поведение браузера,
    если ее убрать, то браузер по-умолчанию обновит страницу после отправки данных формы */
    e.preventDefault();
    let username = document.getElementsByName("username")[0].value;
    let password = document.getElementsByName("password")[0].value;

    // Преобразуем полученные данные в JSON
    const formdata = JSON.stringify({username: username, password: password});

    // Отправляем запрос через fetch (необходимо выставить соответствующий заголовок (headers)!)
    fetch("/api/register",
        {
            method: "POST",
            body: formdata,
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            response.text().then(text => {
                if (text.includes("already exists")) {
                    alert("Такой аккаунт уже существует");
                } else {
                    alert("Успешная регистрация!");
                    window.location.href = "/booking";
                }
            })
        })
        .catch(error => {
            alert(error);
            console.error('error:', error);
        });

});