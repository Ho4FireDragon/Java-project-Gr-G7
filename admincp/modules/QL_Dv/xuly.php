<?php 
include('../../config/config.php');
$tendichvu = $_POST['tendichvu'];
$madichvu = $_POST['madichvu'];
$giadichvu = $_POST['giadichvu'];
$tomtat = $_POST['tomtat'];
$noidung = $_POST['noidung'];
$danhmucdichvu = $_POST['danhmucdichvu'];

$hinhanh = $_FILES['hinhanh']['name'];
$hinhanh_tmp = $_FILES['hinhanh']['tmp_name']; /* tmp_name biến tạm của hình ảnh */

//Thêm sp
if(isset($_POST['themdichvu'])){
    $sql_them = "INSERT INTO tbl_dichvu(tendichvu,madichvu,giadichvu,hinhanh,tomtat,noidung,id_danhmucdichvu) 
    VALUE('".$tendichvu."','".$madichvu."','".$giadichvu."','".$hinhanh."','".$tomtat."','".$noidung."','".$id_danhmucdichvu."')";
    mysqli_query($mysqli,$sql_them);
    move_uploaded_file($hinhanh_tmp,'uploads/'.$hinhanh);
    header('location:../../index.php?action=quanlydichvu&query=them'); /* trỏ địa chỉ */
}//sửa sp
elseif(isset($_POST['suadichvu'])){
    if($hinhanh!=''){
    move_uploaded_file($hinhanh_tmp,'uploads/'.$hinhanh);
    
    $sql_update = "UPDATE tbl_dichvu SET tendichvu='".$tendichvu."','".$madichvu."','".$giadichvu."',
    '".$hinhanh."','".$tomtat."','".$noidung."','".$id_danhmucdichvu."' WHERE id_dichvu='$_GET[iddichvu]'";   
    $sql = "SELECT * FROM tbl_dichvu WHERE id_dichvu = '$_GET[iddichvu]' LIMIT 1";
    $query = mysqli_query($mysqli,$sql);
    while($row = mysqli_fetch_array($query)){
        unlink('uploads/'.$row['hinhanh']);
    }
    }else{
        $sql_update = "UPDATE tbl_dichvu SET tendichvu='".$tendichvu."',
        '".$madichvu."','".$giadichvu."','".$hinhanh."','".$tomtat."',
        '".$noidung."','".$id_danhmucdichvu."' WHERE id_dichvu='$_GET[iddichvu]'";
    }    
    mysqli_query($mysqli,$sql_update);
    header('location:../../index.php?action=quanlydichvu&query=them');
}
//xoá sp
else{
    $id= $_GET['iddichvu'];
    $sql = "SELECT * FROM tbl_dichvu WHERE id_dichvu = '$id' LIMIT 1";
    $query = mysqli_query($mysqli,$sql);
    while($row = mysqli_fetch_array($query)){
        unlink('uploads/'.$row['hinhanh']);
    }
    $sql_xoa = "DELETE FROM tbl_dichvu WHERE id_dichvu= '".$id."'";
    mysqli_query($mysqli,$sql_xoa);
    header('location:../../index.php?action=quanlydichvu&query=them');
}
?>