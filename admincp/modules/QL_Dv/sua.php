
<?php 
    $sql_sua_sp = "SELECT * FROM tbl_sanpham WHERE id_sanpham='$_GET[idsanpham]' LIMIT 1";
    $query_sua_sp = mysqli_query($mysqli,$sql_sua_sp);
?>
<p>Sửa sản phẩm</p>
<table border="1px" width="50%" style="border-collapse: collapse;">
<?php
while($row = mysqli_fetch_array($query_sua_sp)){
?>
  <form method="POST" action="modules/quanlysp/xuly.php?idsanpham=<?php echo $row['id_sanpham'] ?>" enctype="multipart/form-data"> <!-- phương thức để gửi dữ liểu(tránh mất dữ liệu-không thấy trên đg dẫn) -->
    <tr>
        <td>Tên Sản Phẩm</td>
        <td><input type="text" value="<?php echo $row['tensanpham'] ?>" name="tensanpham"></td>
    </tr>

    <tr>
        <td>Bảo Hành</td>
        <td><input type="text" value="<?php echo $row['masp'] ?>" name="masp"></td>
    </tr>

    <tr>
        <td>Hình Ảnh Sản Phẩm</td>
        <td>
            <input type="file" name="hinhanh" id="image">
            <img src="modules/quanlysp/uploads/<?php echo $row['hinhanh']?>" width="100px">
            <div id="preview"></div>
        </td>

    </tr>

    <tr>
        <td>Giá Sản Phẩm</td>
        <td><input type="text" value="<?php echo $row['giasp'] ?>" name="giasp"></td>
    </tr>

    <tr>
        <td>Số Lượng Sản Phẩm</td>
        <td><input type="text" value="<?php echo $row['soluong'] ?>" name="soluong"></td>
    </tr>

    <tr>
        <td>Nội Dung</td>
        <td><textarea rows="5" cols="120" name="noidung" style="resize: none;"><?php echo $row['noidung'] ?>></textarea></td>
    </tr>

    <tr>
        <td>Thông số kĩ thuật</td>
        <td><textarea rows="5" cols="120" name="tomtat" style="resize: none;"><?php echo $row['tomtat'] ?></textarea></td>
    </tr>

    <tr>
        <td>Danh mục sản phẩm</td>
        <td>
          <select name="danhmuc">
            <?php 
            $sql_danhmuc= "SELECT * FROM tbl_danhmuc ORDER BY id_danhmuc DESC";
            $query_danhmuc = mysqli_query($mysqli,$sql_danhmuc);
            while($row_danhmuc = mysqli_fetch_array($query_danhmuc)){
                if($row_danhmuc['id_danhmuc']==$row['id_danhmuc']){
            ?>
            <option selected value="<?php echo $row_danhmuc['id_danhmuc'] ?>"><?php echo $row_danhmuc['tendanhmuc'] ?></option>
            <?php
                }else{
            ?>
            <option value="<?php echo $row_danhmuc['id_danhmuc'] ?>"><?php echo $row_danhmuc['tendanhmuc'] ?></option>
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
            if($row['tinhtrang']==1) {
            ?>
            <option value=1 selected>Kích Hoạt</option>
            <option value=0>Ẩn</option>
            <?php
            }else{
            ?>
            <option value=1>Kích Hoạt</option>
            <option value=0 selected>Ẩn</option>
            <?php
            }
            ?>
          </select>
        </td>
    </tr>

    <tr>
        <td colspan="2"><input type="submit" name="suasanpham" value="Sửa sản phẩm"></td>
    </tr>
  </form>
<?php
}
?>
</table>