<?php 
    $sql_sua_sp = "SELECT * FROM tbl_dichvu WHERE id_dichvu='$_GET[iddichvu]' LIMIT 1"; 
    $query_sua_sp = mysqli_query($mysqli, $sql_sua_sp);
?>
<p>Sửa Dịch Vụ</p>
<table border="1px" width="50%" style="border-collapse: collapse;">
<?php
while($row = mysqli_fetch_array($query_sua_sp)){
?>
  <form method="POST" action="modules/QL_Dv/xuly.php?iddichvu=<?php echo $row['id_dichvu'] ?>" enctype="multipart/form-data">
    <tr>
        <td>Tên Dịch Vụ</td>
        <td><input type="text" value="<?php echo $row['tendichvu'] ?>" name="tendichvu"></td>
    </tr>

    <tr>
        <td>Mã Dịch Vụ</td>
        <td><input type="text" value="<?php echo $row['madichvu'] ?>" name="madichvu"></td>
    </tr>

    <tr>
        <td>Hình Ảnh Dịch Vụ</td>
        <td>
            <input type="file" name="hinhanh" id="image">
            <img src="modules/QL_Dv/uploads/<?php echo $row['hinhanh']?>" width="100px">
            <div id="preview"></div>
        </td>
    </tr>

    <tr>
        <td>Giá Dịch Vụ</td>
        <td><input type="text" value="<?php echo $row['giadichvu'] ?>" name="giadichvu"></td>
    </tr>


    <tr>
        <td>Nội Dung</td>
        <td><textarea rows="5" cols="120" name="noidung" style="resize: none;"><?php echo $row['noidung'] ?></textarea></td>
    </tr>

    <tr>
        <td>Tóm Tắt</td>
        <td><textarea rows="5" cols="120" name="tomtat" style="resize: none;"><?php echo $row['tomtat'] ?></textarea></td>
    </tr>

    <tr>
        <td>Danh mục dịch vụ</td>
        <td>
          <select name="danhmucdichvu">
            <?php 
            $sql_danhmucdichvu= "SELECT * FROM tbl_danhmucdichvu ORDER BY id_danhmucdichvu DESC";
            $query_danhmucdichvu = mysqli_query($mysqli,$sql_danhmucdichvu);
            while($row_danhmucdichvu = mysqli_fetch_array($query_danhmucdichvu)){
                if($row_danhmucdichvu['id_danhmucdichvu'] == $row['id_danhmucdichvu']){
            ?>
            <option selected value="<?php echo $row_danhmucdichvu['id_danhmucdichvu'] ?>"><?php echo $row_danhmucdichvu['tendanhmucdichvu'] ?></option>
            <?php
                }else{
            ?>
            <option value="<?php echo $row_danhmucdichvu['id_danhmucdichvu'] ?>"><?php echo $row_danhmucdichvu['tendanhmucdichvu'] ?></option>
            <?php        
                }
            }
            ?>
          </select>
        </td>
    </tr>

    <tr>
        <td>Tình Trạng</td>
        <td>
          <select name="tinhtrang">
            <?php
            if($row['tinhtrang'] == 1) {
            ?>
            <option value="1" selected>Kích Hoạt</option>
            <option value="0">Ẩn</option>
            <?php
            } else {
            ?>
            <option value="1">Kích Hoạt</option>
            <option value="0" selected>Ẩn</option>
            <?php
            }
            ?>
          </select>
        </td>
    </tr>

    <tr>
        <td colspan="2"><input type="submit" name="suadichvu" value="Sửa Dịch Vụ"></td>
    </tr>
  </form>
<?php
}
?>
</table>
