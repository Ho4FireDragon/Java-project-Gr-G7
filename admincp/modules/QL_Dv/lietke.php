<?php 
    $sql_lietke_dichvu = "SELECT * FROM tbl_dichvu LEFT JOIN tbl_danhmucdichvu ON tbl_dichvu.id_danhmucdichvu = tbl_danhmucdichvu.id_danhmucdichvu ORDER BY tbl_dichvu.id_dichvu DESC";

    $query_lietke_dichvu = mysqli_query($mysqli,$sql_lietke_dichvu);
?>
<p>Liệt kê sản phẩm</p>
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
  while($row = mysqli_fetch_array($query_lietke_dichvu)){
    $i++;
  ?>
  <tr>
    <td><?php echo $i?></td>
    <td><?php echo $row['tendichvu']?></td>
    <td><?php echo $row['madichvu']?></td>
    <td><?php echo $row['giadichvu']?></td>
    <td><?php echo $row['soluong']?></td>
    <td><?php echo $row['soluongban']?></td>
    <td><?php echo $row['tendanhmuc']?></td>
    <td><?php echo $row['tomtat']?></td>
    <td><?php echo $row['noidung']?></td>
    <td><img src="modules/QL_Dv/uploads/<?php echo $row['hinhanh']?>" width="100px"></td>

    <td>
        <a href="modules/QL_Dv/xuly.php?idsanpham=<?php echo $row['id_sanpham'] ?>">Xoá</a> | <a href="?action=quanlysp&query=sua&idsanpham=<?php echo $row['id_sanpham'] ?>">Sửa</a>
    </td>
  </tr>
  <?php 
  }
  ?>
</table>