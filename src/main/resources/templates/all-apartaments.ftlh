<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My Table</title>
    <!-- Add the Bootstrap stylesheet -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<div class="container-xl">
            <#list apartments as apartment>
                <br>
                    ЗАМОВНИК:
                <br>
                Ім'я замовника: <td>${apartment.ownerName}</td>
                <br>
                Призвіще замовника: <td>${apartment.ownerSurname}</td>
                <br>
                Площа квартири: <td>${apartment.ownerArea}</td>
                <br>
                Номер поверху: <td>${apartment.ownerFloor}</td>
                <br>
                Кількість кімнат: <td>${apartment.ownerNumberOfRooms}</td>
                <br>
                Район: <td>${apartment.ownerDistrict}</td>
                <br>
                    ЗАМОВЛЕННЯ:
                <br>
                Бажана площа квартири: <td>${apartment.order.orderArea}</td>
                <br>
                Бажаний поверх: <td>${apartment.order.orderFloor}</td>
                <br>
                Бажана кількість кімнат: <td>${apartment.order.orderNumberOfRooms}</td>
                <br>
                Бажана вулиця: <td>${apartment.order.orderDistrict}</td>
                <br>
                <br>
            </#list>
        <!-- Add a previous page button -->
        <form method="get" action="menu">
            <button type="submit" class="btn btn-primary">Меню</button>
        </form>
    </div>
</div>