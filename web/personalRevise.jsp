<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-10-14
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息修改</title>
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
            $("#home").click(function () {
                location.href = "/index.jsp";
            });
            $("#exchange").click(function () {
                location.href = "/exchange.jsp";
            })
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
<div class="ui centered grid sty" style="margin-top:80px;">
    <div class="twelve wide column" style="background-color:  #FFFFFF;height: 150px;border-radius:5px 5px 0 0;position: relative" >
        <div class="ui special cards raised" style="left: 15px;top: -20px;position:absolute;z-index: 999;width: 160px;height: 160px;">
            <div class="card">
                <div class="blurring dimmable image"  id="img">
                    <div class="ui dimmer">
                        <div class="content">
                            <div class="center">
                                <div class="ui inverted button" id ="uploadImg">上传我的头像</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <strong  style="left: 190px;top: 20px;position:absolute;z-index: 999;font-size: x-large;" id="username"/>
        <div class="ui centered grid sty">
            <div class="eight wide column" >
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
    var path = getCookie("SRC");
    var html = "<img src=" + path.toString() + " class=\"image avatar ui\"/>";
    var html2 = "<img src=" + path.toString() + " style=\"width:160px;height:160px\"/>";
    $('#right').append(html);
    $('#username').append(getCookie("USERNAME"));
    $('#img').append(html2);
</script>
</body>
</html>
