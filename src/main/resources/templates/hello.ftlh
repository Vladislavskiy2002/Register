<!DOCTYPE html>
<html>
<head>
    <title>New Recipe</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Обміняти квартиру</h1>
    <form action="/exchange" method="post">
        <div class="form-group">
            <label for="ownerName">Введіть ваше ім'я:</label>
            <input type="text" class="form-control" id="ownerName" name="ownerName" placeholder="Ім'я">
        </div>
        <div class="form-group">
            <label for="ownerSurname">Введіть ваше призвіще:</label>
            <input type="text" class="form-control" id="ownerSurname" name="ownerSurname" placeholder="Призвіще">
        </div>
        <div class="form-group">
            <label for="ownerNumberOfRooms">Введіть кількість кімнат вашої квартири:</label>
            <input type="text" class="form-control" id="ownerNumberOfRooms" name="ownerNumberOfRooms" placeholder="Кількість кімнат">
        </div>
        <div class="form-group">
            <label for="ownerArea">Введіть площу квартири:</label>
            <input type="text" class="form-control" id="ownerArea" name="ownerArea" placeholder="Площа">
        </div>
        <div class="form-group">
            <label for="ownerFloor">Введіть поверх:</label>
            <input type="text" class="form-control" id="ownerFloor" name="ownerFloor" placeholder="Поверх">
        </div>
        <div class="form-group">
            <label for="ownerDistrict">Введіть район:</label>
            <input type="text" class="form-control" id="ownerDistrict" name="ownerDistrict" placeholder="Район">
        </div>
        <div class="form-group">
            <label for="orderNumberOfRooms">Введіть кількість кімнат бажаної квартири:</label>
            <input type="text" class="form-control" id="orderNumberOfRooms" name="orderNumberOfRooms" placeholder="Кількість кімнат">
        </div>
        <div class="form-group">
            <label for="orderArea">Введіть площу бажаної квартири:</label>
            <input type="text" class="form-control" id="orderArea" name="orderArea" placeholder="Площа">
        </div>
        <div class="form-group">
            <label for="orderFloor">Введіть поверх бажаної квартири:</label>
            <input type="text" class="form-control" id="orderFloor" name="orderFloor" placeholder="Поверх">
        </div>
        <div class="form-group">
            <label for="orderDistrict">Введіть район бажаної квартири:</label>
            <input type="text" class="form-control" id="orderDistrict" name="orderDistrict" placeholder="Район">
        </div>
        <button type="submit" class="btn btn-primary">Відправити</button>
    </form>
    <#if errors?has_content>
        <ul class="text-danger">
            <#list errors as error>
                <li>${error.defaultMessage}</li>
            </#list>
        </ul>
    </#if>
</div>
</body>
</html>