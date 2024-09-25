<?php 
include('../../config/config.php');
$tendanhmucdichvu = $_POST['tendanhmucdichvu'];
$thutu = $_POST['thutu'];
if(isset($_POST['themdanhmucdichvu'])){
    $sql_them = "INSERT INTO tbl_danhmucdichvu(tendanhmucdichvu,thutu) VALUE('".$tendanhmucdichvu."','".$thutu."')";
    mysqli_query($mysqli,$sql_them);
    header('location:../../index.php?action=quanlydanhmucdichvu&query=them');
}elseif(isset($_POST['suadanhmucdichvu'])){
    $sql_update = "UPDATE tbl_danhmucdichvu SET tendanhmucdichvu='".$tendanhmucdichvu."',thutu='.$thutu.' WHERE id_danhmucdichvu='$_GET[iddanhmucdichvu]'";
    mysqli_query($mysqli,$sql_update);
    header('location:../../index.php?action=quanlydanhmucdichvu&query=them');
}else{
    $id= $_GET['iddanhmucdichvu'];
    $sql_xoa = "DELETE FROM tbl_danhmucdichvu WHERE id_danhmucdichvu= '".$id."'";
    mysqli_query($mysqli,$sql_xoa);
    header('location:../../index.php?action=quanlydanhmucdichvu&query=them');
}
?>