<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .container {
                 max-width: 500px;
                 margin: 100px auto;
                 text-align: center;
             }
        h1 {
            font-size: 28px;
            margin-bottom: 40px;
            color: #333;
        }

        .btn-custom {
            background-color: #007bff;
            color: #fff;
            border: none;
            margin-bottom: 20px;
            padding: 12px 30px;
            font-size: 18px;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-custom:hover {
            background-color: #0069d9;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Успішно!</h1>
    <table class="table">
        <tr>
            <td>КВАРТИРА УСПІШНО ДОДАНА ДО КАРТОТЕКИ</td>
        </tr>
    </table>
    <form method="get" action="/menu">
        <button class="btn btn-custom" type="submit">OK</button>
    </form>
</div>
</body>
</html>