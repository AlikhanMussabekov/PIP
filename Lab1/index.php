<?php session_start(); ?>

<!DOCTYPE html>

<html>

    <head>
        <meta charset="utf-8">
        <script type="text/javascript" src="./main.js"></script>
        <link rel="stylesheet" type="text/css" href="./style.css">
        <title>PHP</title>
    </head>

    <body>

        <div class="title">
            Мусабеков Алихан Нурланович. Группа Р3211. Вариант 28112
            
            <ul>
                <li>
                    <a href="http://vk.com/vm_franky">
                        <img src="./media/vk.png" border="0" width="30" height="30">
                    </a>
                                
                <li>
                    <a href="http://instagram.com/alikhan_msb">
                        <img src="./media/instagram.png" border="0" width="30" height="30">
                     </a>
                
                <li>
                    <a href="http://github.com/alikhanmussabekov">
                        <img src="./media/github.png" border="0" width="30" height="30">
                    </a>
                
            </ul>

        </div>

        <form method="post" action="server.php" target="theFrame">
            
            <table class="mainTable" >
                <tr>
                    <td>
                        <div class="megaBlock">
                            <div class="block">
                                
                                <div class="blockText">
                                    Координата X (диапазон от -3 до 5):
                                </div>

                                <div class="inputBlock" >
                                    <input class="changeValueButton" type="button" value="<" onclick="decreaseX()">
                                    <input class="input" id="xLabel" name="x" type="text" readonly="readonly" value="0">
                                    <input class="changeValueButton" type="button" value=">" onclick="increaseX()">
                                </div>

                            </div>

                            <div class="block" id="yBlock">

                                <div class="blockText">
                                    Координата Y (диапазон от -3 до 3):
                                </div>

                                <div class="inputBlock">
                                    <input class="input" id="yLabel" type="text" name="y" maxlength="10">
                                </div>

                            </div>

                            <div class="block">

                                <div class="blockText">
                                    Параметр R (диапазон от 1 до 3):
                                </div>

                                <div class="inputBlock">
                                    <input class="changeValueButton" type="button" value="<" onclick="decreaseR()">
                                    <input class="input" id="rLabel" name="r" type="text" readonly="readonly" value="1">
                                    <input class="changeValueButton" type="button" value=">" onclick="increaseR()">
                                </div>

                            </div>

                            <div class="buttonBlock">
                                <input type="submit" class="submitButton" value="Проверить" onclick="return validate()">

                                <?php 
                                    if(!isset($_SESSION['arr'])){
                                        $_SESSION['arr'] = array();
                                    }
                                ?>

                            </div>
                            
                        </div>
                    </td>

                    <td>
                        <div class="chartBlock">
                                <!-- <img src="./areas.png" width="350" height="350"> -->
                                <canvas width="350" height="350" id="canvas"></canvas>
                        </div>
                    </td>
                </tr>
            </table>
            
        </form>

        <div align="center">
            <iframe id="theFrame" name="theFrame" onload="iframeLoaded()"></iframe>
        </div>   

    </body> 

</html>