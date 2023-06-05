<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Table</title>
    <!-- Add the Bootstrap stylesheet -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container-xl">
    <br>
    <h1>Інформація про квартири</h1>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Ім'я замовника</th>
            <th scope="col">Прізвище замовника</th>
            <th scope="col">Площа квартири</th>
            <th scope="col">Номер поверху</th>
            <th scope="col">Кількість кімнат</th>
            <th scope="col">Район</th>
            <th scope="col">Бажана площа квартири</th>
            <th scope="col">Бажаний номер поверху</th>
            <th scope="col">Бажана кількість кімнат</th>
            <th scope="col">Бажаний район</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <#list apartments as apartment>
            <tr>
                <td>${apartment.ownerName}</td>
                <td>${apartment.ownerSurname}</td>
                <td>${apartment.ownerArea}</td>
                <td>${apartment.ownerFloor}</td>
                <td>${apartment.ownerNumberOfRooms}</td>
                <td>${apartment.ownerDistrict}</td>
                <td>${apartment.order.orderArea}</td>
                <td>${apartment.order.orderFloor}</td>
                <td>${apartment.order.orderNumberOfRooms}</td>
                <td>${apartment.order.orderDistrict}</td>
                <br>
                <form method="get" action="/deleteOrder">
                    <input type="hidden" name="apartment" value="${apartment.id}"/>
                    <input class="btn btn-danger" type="submit" value="delete order"/>
                </form>
                <br>
            </tr>
            <tr>
            </tr>
            <tr>
                <td colspan="7"></td>
            </tr>
        </#list>
        </tbody>
    </table>
    <!-- Add a previous page button -->
    <form method="get" action="menu">
        <button type="submit" class="btn btn-primary">Меню</button>
    </form>
</div>
</body>
</html>