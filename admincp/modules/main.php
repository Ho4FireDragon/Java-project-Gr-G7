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
    if($tam=="quanlydanhmucdichvu" && $query=='them'){
        include("modules/Ql_Cac_Loai_Dv/them.php");
        include("modules/Ql_Cac_Loai_Dv/lietke.php");

    }elseif ($tam=="quanlydanhmucdichvu" && $query=='sua'){
        include("modules/Ql_Cac_Loai_Dv/sua.php");

    }

    if($tam=="quanlydichvu" && $query=='them'){
        include("modules/QL_Dv/them.php");
        include("modules/QL_Dv/lietke.php");

    }elseif ($tam=="quanlydichvu" && $query=='sua'){
        include("modules/QL_Dv/sua.php");

    }
    
    elseif ($tam=="quanlycacbaivietchamsocca" && $query=='them'){
        include("modules/QL_Cham_soc_ca/them.php");
        include("modules/QL_Cham_soc_ca/lietke.php");

    }elseif ($tam=="quanlycacbaivietchamsocca" && $query=='sua'){
        include("modules/QL_Cham_soc_ca/sua.php");

    }
    
    elseif ($tam=="quanlycacbaivietcacvandesuckhoecuaca" && $query=='them'){
        include("modules/QL_Cac_Van_De_SK_ca/them.php");
        include("modules/QL_Cac_Van_De_SK_ca/lietke.php");

    }elseif ($tam=="quanlycacbaivietcacvandesuckhoecuaca" && $query=='sua'){
        include("modules/QL_Cac_Van_De_SK_ca/sua.php");

    }
    
    elseif($tam=="quanlycacbaivietvecacvandelienquan" && $query=='them'){
        include("modules/QL_Cac_Van_De_LQ/them.php");
        include("modules/QL_Cac_Van_De_LQ/lietke.php");

    }elseif ($tam=="quanlycacbaivietvecacvandelienquan" && $query=='sua'){
        include("modules/QL_Cac_Van_De_LQ/sua.php");

    }
    
    else{
        include("modules/dashboard.php");
    }
?>