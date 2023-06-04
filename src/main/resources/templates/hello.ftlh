<!DOCTYPE html>
<html>
<head>
    <title>New Recipe</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div>
    <form action="/exchange" method="post">
        Введіть ваше ім'я: <input placeholder="name" name="ownerName">
        <br>
        <br>
        Введіть вашу фамілію: <input placeholder="surname" name="ownerSurname">
        <br>
        <br>
        Введіть кількість кімнат вашої квартири: <input placeholder="number of Rooms" name="ownerNumberOfRooms">
        <br>
        <br>
        Введіть площу квартири: <input placeholder="area" name="ownerArea">
        <br>
        <br>
        Введіть поверх: <input placeholder="floor" name="ownerFloor">
        <br>
        <br>
        Введіть район: <input placeholder="district" name="ownerDistrict">
        <br>
        <br>
        Введіть кількість кімнат бажаної квартири: <input placeholder="number of Rooms" name="orderNumberOfRooms">
        <br>
        <br>
        Введіть площу бажаної квартири: <input placeholder="area" name="orderArea">
        <br>
        <br>
        Введіть поверх бажаної квартири: <input placeholder="floor" name="orderFloor">
        <br>
        <br>
        Введіть район бажаної квартири: <input placeholder="district" name="orderDistrict">
        <br>
        <br>
        <button type="submit">ENTER</button>
    </form>
    <#if errors?has_content>
        <ul>
            <#list errors as error>
                <li class="text-danger">${error.defaultMessage}</li>
            </#list>
        </ul>
    </#if>
    </div>
</body>