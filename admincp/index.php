<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/styleadmincp.css">
    <title>Admin Cpanel</title>
</head>
<body>
    <div class="wrapper">
    <h1 class="title_admin">Welcome to Admin Cpanel</h1>
    <?php   
        include("config/config.php");
        include("modules/header.php");
        include("modules/menu.php");
        include("modules/main.php");
        include("modules/footer.php");
    ?>
    </div>
</body>
</html>