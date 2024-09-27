<?php 
    $sql_lietke_dichvu = "SELECT * FROM tbl_dichvu LEFT JOIN tbl_danhmucdichvu ON tbl_dichvu.id_danhmucdichvu = tbl_danhmucdichvu.id_danhmucdichvu ORDER BY tbl_dichvu.id_dichvu DESC";

    $query_lietke_dichvu = mysqli_query($mysqli,$sql_lietke_dichvu);
?>
<p>Liệt kê sản phẩm</p>
<table style="width:100%" border="1" style="border-collapse: collapse;">
  <tr>
    <th>Id</th>
    <th>Tên dịch vụ</th>
    <th>Giá sản phẩm</th>
    <th>Danh mục dịch vụ</th>
    <th>Tóm tắt</th>
    <th>Nội dung</th>
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
    <td><?php echo $row['giadichvu']?></td>
    <td><?php echo $row['tendanhmucdichvu']?></td>
    <td><?php echo $row['tomtat']?></td>
    <td><?php echo $row['noidung']?></td>
    <td><img src="modules/QL_Dv/uploads/<?php echo $row['hinhanh']?>" width="100px"></td>
    <td>
    <a href="modules/QL_Dv/xuly.php?iddichvu=<?php echo $row['id_dichvu'] ?>">Xoá</a> 
    <a href="?action=quanlydichvu&query=sua&iddichvu=<?php echo $row['id_dichvu'] ?>">Sửa</a>

    </td>
  </tr>
  <?php 
  }
  ?>
</table>