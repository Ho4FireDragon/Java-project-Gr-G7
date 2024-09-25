<?php 
include('../../config/config.php');
$tenloaica = $_POST['tenloaica'];
$thutu = $_POST['thutu'];
if(isset($_POST['themloaica'])){
    $sql_them = "INSERT INTO tbl_loaica(tenloaica,thutu) VALUE('".$tenloaica."','".$thutu."')";
    mysqli_query($mysqli,$sql_them);
    header('location:../../index.php?action=quanlybaivietcacloaica&query=them');
}elseif(isset($_POST['sualoaica'])){
    $sql_update = "UPDATE tbl_loaica SET tenloaica='".$tenloaica."',thutu='.$thutu.' WHERE id_loaica='$_GET[idloaica]'";
    mysqli_query($mysqli,$sql_update);
    header('location:../../index.php?action=quanlybaivietcacloaica&query=them');
}else{
    $id= $_GET['idloaica'];
    $sql_xoa = "DELETE FROM tbl_loaica WHERE id_loaica= '".$id."'";
    mysqli_query($mysqli,$sql_xoa);
    header('location:../../index.php?action=quanlybaivietcacloaica&query=them');
}
?>