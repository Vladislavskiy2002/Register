<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Table</title>
    <!-- Add the Bootstrap stylesheet -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .container-xxl {
            max-width: 100%;
            margin: 0;
            padding-top: 20px;
        }
        h1 {
            font-size: 32px;
            margin-bottom: 20px;
            color: #333;
        }
        table {
            margin-bottom: 30px;
        }
        th, td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #000000;
            color: #fff;
        }
        tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .btn-primary {
            background-color: #ecaa13;
            border-color: #ecaa13;
            padding: 8px 20px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .btn-primary:hover {
            background-color: #082567;
            border-color: #082567;
        }
        .btn-danger {
            background-color: #dc3545;
            border-color: #dc3545;
            padding: 8px 20px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .btn-danger:hover {
            background-color: #c82333;
            border-color: #bd2130;
        }
        .menu-button {
            background-color: #000;
            color: #fff;
            padding: 8px 20px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .menu-button:hover {
            background-color: #333;
        }
    </style>
</head>
<body>
<div class="container-xxl">
    <br>
    <h1>Інформація про квартири</h1>
    <div class="row">
        <div class="col">
            <form method="get" action="/findByArea">
                <input class="btn btn-primary" type="submit" value="Знайти за площею"/>
            </form>
        </div>
        <div class="col">
            <form method="get" action="/findByFloor">
                <input class="btn btn-primary" type="submit" value="Знайти за поверхом"/>
            </form>
        </div>
        <div class="col">
            <form method="get" action="/findByRooms">
                <input class="btn btn-primary" type="submit" value="Знайти за кількістю кімнат"/>
            </form>
        </div>
        <div class="col">
            <form method="get" action="/findByDistrict">
                <input class="btn btn-primary" type="submit" value="Знайти за районом"/>
            </form>
        </div>
        <div class="col">
            <form method="post" action="/sortByOwnerNameUp">
                <input class="btn btn-primary" type="submit" value="Сортувати за іменем ↑"/>
            </form>
        </div>
        <div class="col">
            <form method="post" action="/sortByOwnerNameReverse">
                <input class="btn btn-primary" type="submit" value="Сортувати за іменем ↓"/>
            </form>
        </div>
        <br>
        <br>
        <div class="col">
            <form method="post" action="/sortByAreaUp">
                <input class="btn btn-primary" type="submit" value="Сортувати за Площею ↑"/>
            </form>
        </div>
        <div class="col">
            <form method="post" action="/sortByAreaReverse">
                <input class="btn btn-primary" type="submit" value="Сортувати за Площею ↓"/>
            </form>
        </div>
        <div class="col">
            <form method="post" action="/sortByRoomsUp">
                <input class="btn btn-primary" type="submit" value="Сортувати за кімнатами ↑"/>
            </form>
        </div>
        <div class="col">
            <form method="post" action="/sortByRoomsReverse">
                <input class="btn btn-primary" type="submit" value="Сортувати за кімнатами ↓"/>
            </form>
        </div>
        <div class="col">
            <form method="post" action="/sortByFloorUp">
                <input class="btn btn-primary" type="submit" value="Сортувати за поверхом ↑"/>
            </form>
        </div>
        <div class="col">
            <form method="post" action="/sortByFloorReverse">
                <input class="btn btn-primary" type="submit" value="Сортувати за поверхом ↓"/>
            </form>
        </div>
        <br>
        <br>
        <div class="col">
            <form method="get" action="/showAllApartments">
                <input class="btn btn-primary" type="submit" value="Скинути фільтри"/>
            </form>
        </div>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
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
            <th scope="col">Дія</th>
        </tr>
        </thead>
        <tbody>
        <#list apartments as apartment>
            <tr>
                <td>${apartment_index + 1}</td>
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
                <td>
                    <form method="get" action="/deleteOrder">
                        <input type="hidden" name="apartment" value="${apartment.id}"/>
                        <input class="btn btn-danger" type="submit" value="Видалити замовлення"/>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    <!-- Add a previous page button -->
    <form method="get" action="menu">
        <button type="submit" class="menu-button">Меню</button>
    </form>
</div>
</body>
</html>
