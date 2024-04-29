/*
Реализация AJAX с помощью асинхронного метода fetch. Современный вариант реализации AJAX.
*/

var sendbtn = document.getElementById("sendbtn");    // выбираем DOM-елемент (кнопку)

// Привязываем к элементу обработчик события "click"
sendbtn.addEventListener("click", function (e) {
    /* Инструкция preventDefault позволяет переопределить стандартное поведение браузера,
    если ее убрать, то браузер по-умолчанию обновит страницу после отправки данных формы */
    e.preventDefault();
    let name = document.getElementsByName("name")[0].value;
    let email = document.getElementsByName("email")[0].value;
    let time = document.getElementsByName("time")[0].value;
    let count = document.getElementsByName("count")[0].value;
    let wishes = document.getElementsByName("wishes")[0].value;

    // Преобразуем полученные данные в JSON
    var formdata = JSON.stringify({ fullname: name, email: email, dateTime: time, personsCount: count, wishes: wishes});
    
    // Отправляем запрос через fetch (необходимо выставить соответствующий заголовок (headers)!)
    fetch("/api/form",
    {
        method: "POST",
        body: formdata,
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then( response => {
        // fetch в случае успешной отправки возвращает Promise, содержащий response объект (ответ на запрос)
        // Возвращаем json-объект из response и получаем данные из поля message

        if (response.ok) {
            window.location.href = "/booking";
        } else {
            alert(response.statusText);
        }
    })
    .catch( error => {
        alert(error);
        console.error('error:', error);
    });

});
