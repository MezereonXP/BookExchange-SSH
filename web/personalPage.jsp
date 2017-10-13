<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-10-13
  Time: 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/semantic.min.css">
<script
        src="https://code.jquery.com/jquery-3.1.1.min.js"
        integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
        crossorigin="anonymous"></scriptscript src="./pages/semantic/dist/semantic.min.js"></script>
<link rel="stylesheet" type="text/css" href="./pages/se>
  <mantic/dist/components/reset.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/site.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/card.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/container.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/grid.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/header.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/image.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/menu.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/dimmer.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/divider.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/dropdown.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/segment.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/button.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/list.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/icon.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/sidebar.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/transition.css">

<script src="./pages/semantic/dist/components/visibility.js"></script>
<script src="./pages/semantic/dist/components/sidebar.js"></script>
<script src="./pages/semantic/dist/components/transition.js"></script>
<script src="./pages/semantic/dist/components/dimmer.js"></script>
<script src="./pages/semantic/dist/components/"></script>
<script>
    $(document)
        .ready(function() {
            $('.special.cards .image').dimmer({
                on: 'hover'
            });
            $('.ui.menu a.item')
                .on('click', function() {
                    $(this)
                        .addClass('active')
                        .siblings()
                        .removeClass('active')
                    ;
                })
            ;
            $('#revise').click(function () {
                location.href="/personalRevise.jsp"
            });
            $("#home").click(function () {
                location.href = "/index.jsp";
            });
            $("#exchange").click(function () {
                location.href = "/exchange.jsp";
            });
            $("#uploadImage").click(function () {

            });
        })
    ;
</script>
<style>
    body{
        background-color: #F3F3F3;
    }
</style>
<body>
<div class="ui fixed inverted menu">
    <div class="ui container">
        <a href="#" class="header item">
            <img class="logo" src="../assets/logo2.png">
            BookExchange
        </a>

        <a class="item" id="home">主页</a>
        <a class="item" id="exchange">书籍交换</a>
        <a class="item">书评</a>
        <a class="item">讨论区</a>
        <div class="right item" id="right">
        </div>
    </div>
</div>
<br>
<div class="ui centered grid sty" style="margin-top: 50px;">
    <div class="twelve wide column" style="background-color:  #96A1A9;height: 150px;border-radius:5px 5px 0 0;position: relative" >
        <div class="ui special cards raised" style="left: 15px;top: 60px;position:absolute;z-index: 999;width: 160px;height: 160px;">
            <div class="card">
                <div class="blurring dimmable image"  id="img">
                    <div class="ui dimmer">
                        <div class="content">
                            <div class="center">
                                <input type="file" id="btn_file" style="display:none">
                                <div class="ui inverted button" onclick="F_Open_dia()">上传我的头像</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <strong  style="left: 195px;top: 165px;position:absolute;z-index: 999;font-size: x-large;" id="username">
        </strong>
        <p style="left: 195px;top: 195px;position:absolute;z-index: 999;font-size: small;color: #8a8a8a">暂无个性签名</p>
        <button class="ui inverted pink button" style="right: 15px;top: 190px;position:absolute;z-index: 999" id="revise">发布书籍</button>
    </div>
    <div class="row" style="padding-top: 0">
        <div class="twelve wide column" style="height: 120px;background-color: #FFFFFF;border-radius:0 0 5px 5px ;" ></div>
    </div>
    <div class="row">
        <div class="twelve wide column" style="background-color: #FFFFFF;border-radius:0 0 5px 5px ;" >
            <div class="ui secondary pointing blue menu">
                <a class="item active">
                    个人主页
                </a>
                <a class="item">
                    已上传书籍
                </a>
                <a class="item" >
                    交换信息
                </a>
                <a class="item" >
                    通知消息
                </a>
            </div>
            <%--个人页面--%>
            <%--<div class="ui grid vertically divided">--%>
                <%--<div class="row">--%>
                    <%--<p style="font-size: x-large;margin-left: 20px">我的书籍</p>--%>
                <%--</div>--%>
                <%--<div class="row" style="padding-bottom: 30px">--%>
                    <%--<p style="font-size: x-large;margin-left: 20px">我的书评</p>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--上传书籍--%>
            <div class="ui grid vertically divided">

            </div>
        </div>
    </div>
</div>
<script>
    function getCookie(name) {
        var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
        if (arr = document.cookie.match(reg))
            return unescape(arr[2]);
        else
            return 'null';
    }
    function F_Open_dia() {
        $('#btn_file').click();
    }
    var path = getCookie("SRC");
    var html = "<img src=" + path.toString() + " class=\"image avatar ui\"/>";
    var html2 = "<img src=" + path.toString() + " style=\"width:160px;height:160px\"/>";
    $('#right').append(html);
    $('#username').append(getCookie("USERNAME"));
    $('#img').append(html2);
</script>
</body>
</html>
