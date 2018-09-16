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

        <div class="title">Мусабеков Алихан Нурланович. Группа Р3211. Вариант 28112</div>

        <form method="post" action="server.php" target="theFrame">
            
            <div class="megaBlock">
                <img src="./areas.png">
            </div>

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

            
            
        </form>

        <div align="center">
            <iframe id="theFrame" class="frame" name="theFrame" onload="iframeLoaded()"></iframe>
        </div>   

    </body> 

</html>