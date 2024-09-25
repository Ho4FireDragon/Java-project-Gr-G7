<?php 
    $sql_sua_loaica = "SELECT * FROM tbl_loaica WHERE id_loaica='$_GET[idloaica]' LIMIT 1";
    $query_sua_loaica = mysqli_query($mysqli,$sql_sua_loaica);
?>
<p>Sửa Tên Cá</p>
<table border="1px" width="50%" style="border-collapse: collapse;">
  <form method="POST" action="modules/Ql_Cac_loai_ca/xuly.php?idloaica=<?php echo $_GET['idloaica'] ?>"> 
    <?php
    while($dong = mysqli_fetch_array($query_sua_loaica)){
    ?>
        <tr>
            <td>Tên Loại Cá</td>
            <td><input type="text" value="<?php echo $dong['tenloaica'] ?>" name="tenloaica"></td>
        </tr>

        <tr>
            <td>ID</td>
            <td><input type="text" value="<?php echo $dong['thutu'] ?>" name="thutu"></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" name="sualoaica" value="Sủa Tên Cá"></td>
        </tr>
        <?php
        }
        ?>
  </form>
</table>