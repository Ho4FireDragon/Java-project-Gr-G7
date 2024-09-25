<?php 
    $sql_lietke_sp = "SELECT * FROM tbl_sanpham,tbl_danhmuc WHERE tbl_sanpham.id_danhmuc=tbl_danhmuc.id_danhmuc ORDER BY id_sanpham DESC";
    $query_lietke_sp = mysqli_query($mysqli,$sql_lietke_sp);
?>
<p>Liệt Kê Các Loại Dịch Vụ</p>
<table style="width:100%" border="1" style="border-collapse: collapse;">
  <tr>
    <th>Id</th>
    <th>Tên sản phẩm</th>
    <th>Bảo Hành</th>
    <th>Giá sản phẩm</th>
    <th>Tồn kho</th>
    <th>Số lượng bán</th>
    <th>Danh mục</th>
    <th>Thông số kĩ thuật</th>
    <th>Nội dung</th>
    <th>Trình Trạng</th>
    <th>Hình ảnh</th>
    <th>Quản lý</th>
  </tr>
  <?php 
  $i = 0;
  while($row = mysqli_fetch_array($query_lietke_sp)){
    $i++;
  ?>
  <tr>
    <td><?php echo $i?></td>
    <td><?php echo $row['tensanpham']?></td>
    <td><?php echo $row['masp']?></td>
    <td><?php echo $row['giasp']?></td>
    <td><?php echo $row['soluong']?></td>
    <td><?php echo $row['soluongban']?></td>
    <td><?php echo $row['tendanhmuc']?></td>
    <td><?php echo $row['tomtat']?></td>
    <td><?php echo $row['noidung']?></td>
    <td><img src="modules/quanlysp/uploads/<?php echo $row['hinhanh']?>" width="100px"></td>

    <td>
        <a href="modules/quanlysp/xuly.php?idsanpham=<?php echo $row['id_sanpham'] ?>">Xoá</a> | <a href="?action=quanlysp&query=sua&idsanpham=<?php echo $row['id_sanpham'] ?>">Sửa</a>
    </td>
  </tr>
  <?php 
  }
  ?>
</table>