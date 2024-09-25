<p>Thêm cá</p>
<table border="1px" width="50%" style="border-collapse: collapse;">
  <form method="POST" action="modules/quanlysp/xuly.php" enctype="multipart/form-data">
    <tr>
        <td>Tên cá</td>
        <td><input type="text" name="tensanpham" rows="5"></td>
    </tr>

    <tr>
        <td>Bảo Hành</td>
        <td><input type="text" name="masp"></td>
    </tr>

    <tr>
        <td>Hình Ảnh Sản Phẩm</td>
        <td><input type="file" name="hinhanh" id="image" ></td>
        <div id="preview"></div>
        
    </tr>

    <tr>
        <td>Giá Sản Phẩm</td>
        <td><input type="text" name="giasp"></td>
    </tr>

    <tr>
        <td>Số Lượng Sản Phẩm</td>
        <td><input type="text" name="soluong"></td>
    </tr>

    <tr>
        <td>Nội Dung</td>
        <td><textarea rows="5" cols="120" name="noidung" style="resize: none;"></textarea></td>
    </tr>

    <tr>
        <td>Thông số kĩ thuật</td>
        <td><textarea rows="5" cols="120" name="tomtat" style="resize: none;"></textarea></td>
    </tr>

    <tr>
        <td>Danh mục sản phẩm</td>
        <td>
          <select name="danhmuc">
            <?php 
            $sql_danhmuc= "SELECT * FROM tbl_danhmuc ORDER BY id_danhmuc DESC";
            $query_danhmuc = mysqli_query($mysqli,$sql_danhmuc);
            while($row_danhmuc = mysqli_fetch_array($query_danhmuc)){
            ?>
            <option value="<?php echo $row_danhmuc['id_danhmuc'] ?>"><?php echo $row_danhmuc['tendanhmuc'] ?></option>
            <?php
            }
            ?>
          </select>
        </td>
    </tr>

    <tr>
        <td>Tình Trạng</td>
        <td>
          <select name="tinhtrang">
            <option value=1>Kích Hoạt</option>
            <option value=0>Ẩn</option>
          </select>
        </td>
    </tr>

    <tr>
        <td colspan="2"><input type="submit" name="themsanpham" value="Thêm sản phẩm"></td>
    </tr>
  </form>
</table>
