<?php 
    $sql_lietke_loaica = "SELECT * FROM tbl_loaica ORDER BY thutu ASC"; 
    $query_lietke_loaica = mysqli_query($mysqli,$sql_lietke_loaica);
?>
<p>Liệt kê các loại cá</p>
<table style="width:100%" border="1" style="border-collapse: collapse;">
  <tr>
    <th>Thứ tự</th>
    <th>ID</th>
    <th>Tên danh mục</th>
    <th>Quản lý</th>
  </tr>
  <?php 
  $i = 0;
  while($row = mysqli_fetch_array($query_lietke_loaica)){
    $i++;
  ?>
  <tr>
    <td><?php echo $i?></td>
    <td><?php echo $row['thutu']?></td>
    <td><?php echo $row['tenloaica']?></td>
    <td>
        <a href="modules/Ql_Cac_loai_ca/xuLy.php?idloaica=<?php 
        echo $row['id_loaica'] ?>">Xoá</a> | <a href="?action=quanlybaivietcacloaica&query=sua&idloaica=<?php 
        echo $row['id_loaica'] ?>">Sửa</a>
    </td>
  </tr>
  <?php 
  }
  ?>
</table>