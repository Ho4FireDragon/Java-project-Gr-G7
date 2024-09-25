<?php 
    $sql_lietke_dichvu = "SELECT * FROM tbl_dichvu, tbl_danhmucdichvu WHERE tbl_dichvu.id_danhmucdichvu = tbl_danhmucdichvu.id_danhmucdichvu ORDER BY tbl_danhmucdichvu.id_danhmucdichvu DESC";
    $query_lietke_dichvu = mysqli_query($mysqli, $sql_lietke_dichvu);
?>

<p>Liệt Kê Các Loại Dịch Vụ</p>
<table style="width:100%" border="1" style="border-collapse: collapse;">
  <tr>
    <th>Id</th>
    <th>Tên dịch vụ</th>
    <th>Mã dịch vụ</th>
    <th>Giá dịch vụ</th>
    <th>Danh mục</th>
    <th>Thông số kĩ thuật</th>
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
    <td><?php echo $i ?></td>
    <td><?php echo $row['tendichvu'] ?></td>
    <td><?php echo $row['madichvu'] ?></td>
    <td><?php echo $row['giadichvu'] ?></td> 
    <td><?php echo $row['tendanhmucdichvu'] ?></td>
    <td><?php echo $row['tomtat'] ?></td>
    <td><?php echo $row['noidung'] ?></td>
    <td><img src="modules/QL_Dv/uploads/<?php echo $row['hinhanh'] ?>" width="100px"></td>

    <td>
        <a href="modules/QL_Dv/xuly.php?iddichvu=<?php echo $row['id_dichvu'] ?>">Xoá</a> | 
        <a href="?action=QL_Dv&query=sua&iddichvu=<?php echo $row['id_dichvu'] ?>">Sửa</a>
    </td>
  </tr>
  <?php 
  }
  ?>
</table>
