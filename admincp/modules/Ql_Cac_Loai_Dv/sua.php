<?php 
    $sql_sua_danhmucdichvu = "SELECT * FROM tbl_danhmucdichvu WHERE id_danhmucdichvu='$_GET[iddanhmucdichvu]' LIMIT 1";
    $query_sua_danhmucdichvu = mysqli_query($mysqli,$sql_sua_danhmucdichvu);
?>
<p>Sửa Tên Danh Mục Dịch Vụ</p>
<table border="1px" width="50%" style="border-collapse: collapse;">
  <form method="POST" action="modules/Ql_Cac_Loai_Dv/xuly.php?iddanhmucdichvu=<?php echo $_GET['iddanhmucdichvu'] ?>"> 
    <?php
    while($dong = mysqli_fetch_array($query_sua_danhmucdichvu)){
    ?>
        <tr>
            <td>Tên Loại Danh Mục Dịch Vụ</td>
            <td><input type="text" value="<?php echo $dong['tendanhmucdichvu'] ?>" name="tendanhmucdichvu"></td>
        </tr>

        <tr>
            <td>ID</td>
            <td><input type="text" value="<?php echo $dong['thutu'] ?>" name="thutu"></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" name="suadanhmucdichvu" value="Sủa Tên Danh Mục Dịch Vụ"></td>
        </tr>
        <?php
        }
        ?>
  </form>
</table>