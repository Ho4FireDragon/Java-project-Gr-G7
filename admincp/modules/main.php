<div class="clear"></div>
<div class="main">
<?php
    if(isset($_GET['action']) && $_GET['query']){
        $tam = $_GET['action'];
        $query = $_GET['query'];
    }else{
        $tam = '';
        $query = '';
    }
    if($tam=="quanlybaivietcacloaica" && $query=='them'){
        include("modules/Ql_Cac_loai_ca/them.php");
        include("modules/Ql_Cac_loai_ca/lietke.php");

    }elseif ($tam=="quanlybaivietcacloaica" && $query=='sua'){
        include("modules/Ql_Cac_loai_ca/sua.php");

    }
    
    elseif ($tam=="quanlycacbaivietchamsocca" && $query=='them'){
        include("modules/QL_Cham_soc_ca/them.php");
        include("modules/QL_Cham_soc_ca/lietke.php");

    }elseif ($tam=="quanlycacbaivietchamsocca" && $query=='sua'){
        include("modules/QL_Cham_soc_ca/sua.php");

    }
    
    elseif ($tam=="quanlycacbaivietcacvandesuckhoecuaca" && $query=='them'){
        include("modules/quanlycacbaivietcacvandesuckhoecuaca/them.php");
        include("modules/quanlycacbaivietcacvandesuckhoecuaca/lietke.php");

    }elseif($tam=="quanlycacbaivietvecacvandelienquan" && $query=='lietke'){
        include("modules/quanlycacbaivietvecacvandelienquan/them.php");
        include("modules/quanlycacbaivietvecacvandelienquan/lietke.php");

    }else{
        include("modules/dashboard.php");
    }
?>