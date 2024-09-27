<?php 
    $sql_lietke_danhmucdichvu = "SELECT * FROM tbl_danhmucdichvu ORDER BY thutu ASC"; 
    $query_lietke_danhmucdichvu = mysqli_query($mysqli,$sql_lietke_danhmucdichvu);
?>
<p>Liệt Kê Các Loại Danh Mục Dịch Vụ</p>
<table style="width:100%" border="1" style="border-collapse: collapse;">
  <tr>
    <th>Thứ tự</th>
    <th>ID</th>
    <th>Tên Dịch Vụ</th>
    <th>Quản lý</th>
  </tr>
  <?php 
  $i = 0;
  while($row = mysqli_fetch_array($query_lietke_danhmucdichvu)){
    $i++;
  ?>
  <tr>
    <td><?php echo $i?></td>
    <td><?php echo $row['thutu']?></td>
    <td><?php echo $row['tendanhmucdichvu']?></td>
    <td>
        <a href="modules/Ql_Cac_Loai_Dv/xuLy.php?iddanhmucdichvu=<?php 
        echo $row['id_danhmucdichvu'] ?>">Xoá</a> | <a href="?action=quanlydanhmucdichvu&query=sua&iddanhmucdichvu=<?php 
        echo $row['id_danhmucdichvu'] ?>">Sửa</a>
    </td>
  </tr>
  <?php 
  }
  ?>
</table>