fetch("/api/my_forms",
    {
        method: "GET",
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        response.json().then(json => {
            var headers = Object.keys(json[0]);

            console.log(headers)

            var headerTitles = ["ID", "ID автора", "ФИО", "email", "Дата", "Сколько человек", "Пожелания"]

            //Prepare html header
            var headerRowHTML = '<tr>';
            for (var i = 0; i < headerTitles.length; i++) {
                headerRowHTML += '<th>' + headerTitles[i] + '</th>';
            }
            headerRowHTML += '</tr>';

            //Prepare all the employee records as HTML
            var allRecordsHTML = '';
            for (var i = 0; i < json.length; i++) {

                //Prepare html row
                allRecordsHTML += '<tr>';
                for (var j = 0; j < headers.length; j++) {
                    var header = headers[j];
                    allRecordsHTML += '<td>' + json[i][header] + '</td>';
                }
                allRecordsHTML += '</tr>';

            }

            //Append the table header and all records
            var table = document.getElementById("items");
            table.innerHTML = headerRowHTML + allRecordsHTML;
        })
    })
    .catch(error => {
        alert(error);
        console.error('error:', error);
    });