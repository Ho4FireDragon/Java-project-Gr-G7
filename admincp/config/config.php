<?php
$host = 'localhost'; 
$port = '3306';
$username = 'root';
$password = '';
$database = 'Koi_Healcare';

$mysqli = new mysqli($host, $username, $password, $database, $port);
if ($mysqli->connect_error) {
    die("Connection failed: " . $mysqli->connect_error);
} 

?>