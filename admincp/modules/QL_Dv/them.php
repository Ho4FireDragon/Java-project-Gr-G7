<p>Thêm Dịch Vụ</p>
<table border="1px" width="50%" style="border-collapse: collapse;">
  <form method="POST" action="modules/QL_Dv/xuly.php" enctype="multipart/form-data">
    <tr>
        <td>Tên Dịch Vụ</td>
        <td><input type="text" name="tendichvu" rows="5"></td>
    </tr>

    <tr>
        <td>Hình Ảnh Dịch Vụ</td>
        <td><input type="file" name="hinhanh" id="image" ></td>
        <div id="preview"></div>
        
    </tr>

    <tr>
        <td>Giá Dịch Vụ</td>
        <td><input type="text" name="giadichvu"></td>
    </tr>

    <tr>
        <td>Tóm tắt</td>
        <td><input type="text" name="tomtat"></td>
    </tr>

    <tr>
        <td>Nội Dung</td>
        <td><textarea rows="5" cols="120" name="noidung" style="resize: none;"></textarea></td>
    </tr>

    <tr>
        <td>Danh mục sản phẩm</td>
        <td>
          <select name="danhmucdichvu">
            <?php 
            $sql_danhmucdichvu= "SELECT * FROM tbl_danhmucdichvu ORDER BY id_danhmucdichvu DESC";
            $query_danhmucdichvu = mysqli_query($mysqli,$sql_danhmucdichvu);
            while($row_danhmucdichvu = mysqli_fetch_array($query_danhmucdichvu)){
            ?>
            <option value="<?php echo $row_danhmucdichvu['id_danhmucdichvu'] ?>">
                <?php echo $row_danhmucdichvu['tendanhmucdichvu'] ?>
            </option>

            <?php
            }
            ?>
          </select>
        </td>
    </tr>

    <tr>
        <td colspan="2"><input type="submit" name="themdichvu" value="Thêm Dịch Vụ"></td>
    </tr>
  </form>
</table>
