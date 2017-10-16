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
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/container.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/grid.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/header.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/image.css">
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/menu.css">

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
<script src="./pages/semantic/dist/components/dimmer.js"></script>
<script src="./pages/semantic/dist/components/dropdown.js"></script>
<script src="./pages/semantic/dist/components/transition.js"></script>
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
            $('.ui.dropdown')
                .dropdown({
                    on: 'click'
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
        <div class="ui special cards raised" style="left: 15px;top: 60px;position:absolute;z-index: 2;width: 160px;height: 160px;">
            <div class="card">
                <div class="blurring dimmable image"  id="img">
                    <div class="ui dimmer">
                        <div class="content">
                            <div class="center">
                                <input type="file" id="btn_file" style="display:none" onchange="fileSelected2()">
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
        <button class="ui inverted pink button" style="right: 15px;top: 190px;position:absolute;z-index: 999" id="revise">编辑个人信息</button>
    </div>
    <div class="row" style="padding-top: 0">
        <div class="twelve wide column" style="height: 120px;background-color: #FFFFFF;border-radius:0 0 5px 5px ;" ></div>
    </div>
    <div class="row">
        <div class="twelve wide column" style="background-color: #FFFFFF;border-radius:0 0 5px 5px ;" >
            <div class="ui secondary pointing blue menu">
                <a class="item active" onclick="changeType(1)">
                    个人主页
                </a>
                <a class="item" onclick="changeType(2)">
                    已上传书籍
                </a>
                <a class="item" onclick="changeType(3)">
                    上传书籍
                </a>
                <a class="item" onclick="changeType(4)">
                    交换信息
                </a>
                <a class="item" onclick="changeType(5)">
                    通知消息
                </a>
            </div>
            <form action="index.jsp">
            <div class="ui centered grid">
                <div class="three wide column">
            <div class="ui special cards raised" style="width:160px;height:200px;margin-bottom: 100px">
                <div class="card">
                    <div class="blurring dimmable image" id="imgAdd">
                        <div class="ui dimmer">
                            <div class="content">
                                <div class="center">
                                    <input type="file" id = "bookImgSrc" style="display: none"  onchange="fileSelected()" name="bookSRC">
                                    <div class="ui inverted button" onclick="F_Open_dia2()">点击上传书籍图片</div>
                                </div>
                            </div>
                        </div>
                        <img src="../assets/book.jpg" style="width: 160px;height: 200px" id="bookImg">
                    </div>
                </div>
            </div>
                </div>
                <div class="seven wide column">
                    <div class="ui labeled input">
                        <a class="ui blue label">
                            书名
                        </a>
                        <input type="text" placeholder="请输入书籍的名称" name="bookName">
                    </div>
                    <br>
                    <br>
                    <div class="ui right labeled left icon input">
                        <i class="tags icon"></i>
                        <input placeholder="请添加书籍类型" type="text" id="labelInput">
                        <a class="ui tag blue label" onclick="addLabel()">
                            添加书籍类型
                        </a>
                    </div>
                    <br>
                    <br>
                    <div id="labelC" >
                    </div>
                    <div id = "line" style="display: none">
                        <br>
                    </div>
                    <div class="ui right labeled left icon input">
                        <i class="tags icon"></i>
                        <input placeholder="请添加想要书籍类型" type="text" id="labelInput2">
                        <a class="ui tag blue label" onclick="addLabel2()">
                            添加想要书籍类型
                        </a>
                    </div>
                    <br>
                    <br>
                    <div id="labelB">
                    </div>
                    <div id = "line2" style="display: none">
                        <br>
                    </div>
                    <div class="ui labeled input">
                        <a class="ui blue label">
                            购买日期
                        </a>
                        <input type="text" name="buyDate" placeholder="请输入书籍的购买日期"/><p style="font-size:medium;color: #8a8a8a;margin-top: 5px">日期格式年-月-日</p>
                    </div>
                    <br>
                    <br>
                    <div class="ui labeled input">
                        <a class="ui blue label">
                            书籍简介
                        </a>
                        <input type="text" name="introduction" placeholder="几句话描述这本书吧"/>
                    </div>
                </div>
                <div class="row">
                    <input type="submit" class="ui primary button" value="点击上传"></input>
                </div>
            </div>
                <input type="text" name="wantKind"style="display: none"/>
                <input type="text" name="kind" style="display: none"/>
            </form>
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
        </div>
    </div>
</div>
<script>
    var count = 1;
    var count2 = 1;
    var array = new Array();
    var array2 = new Array();//用来储存书籍类型的Tag的数组
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
    function F_Open_dia2() {
        $('#bookImgSrc').click();
    }
    function fileSelected2() {
        var $file = $('#btn_file');
        var fileObj = $file[0];
        var windowURL = window.URL || window.webkitURL;
        var dataURL;
        var $img = $("#personSRC");

        if (fileObj && fileObj.files && fileObj.files[0]) {
            dataURL = windowURL.createObjectURL(fileObj.files[0]);
            $img.attr('src', dataURL);
        } else {
            dataURL = $file.val();
            var imgObj = document.getElementById("personSRC");
// 两个坑:
// 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
// 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
            imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
        }
    }
    function fileSelected() {
        var $file = $('#bookImgSrc');
        var fileObj = $file[0];
        var windowURL = window.URL || window.webkitURL;
        var dataURL;
        var $img = $("#bookImg");

        if (fileObj && fileObj.files && fileObj.files[0]) {
            dataURL = windowURL.createObjectURL(fileObj.files[0]);
            $img.attr('src', dataURL);
        } else {
            dataURL = $file.val();
            var imgObj = document.getElementById("bookImg");
// 两个坑:
// 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
// 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
            imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
        }
    }
    function changeType(num){
        self.location ="showPersonalPage.action?type="+num;
    }
    function addLabel() {
        var colors=new Array("red","orange","yellow","olive" ,"blue","brown","pink","black");
        var content = $('#labelInput').val();
        if(content!=""){
            $('#line').css('display','block');
            var index = Math.ceil((Math.random()*8))-1;
            var html ="<a id='labelOfSelf"+count+"' onclick='removeLabel("+count+")' class=\"ui "+ colors[index]
                    +" transition tag icon label\" style='margin-left: 20px;margin-top: 5px'>"+content+"<i class=\"delete icon\"></i></a>";
            array[count-1] = content;
            count++;
            $('#labelC').append(html);
            $('#labelInput').val("");
            getResult(array);
        }
    }
    function removeLabel(c) {
        $('#labelOfSelf'+c).transition("fade");
        array[c-1] = "NULL";
        window.alert(getResult(array));
    }
    function removeLabelB(c) {
        $('#labelOfSelfB'+c).transition("fade");
        array2[c-1] = "NULL";
        window.alert(getResult(array2));
    }
    function getResult2(array2) {
        var result="";
        for(var i=0;i<array2.length;i++){
            if(array2[i]!="NULL"&&i!=(array2.length-1))
                result+=array2[i]+";";
            if(array2[i]!="NULL"&&i==(array2.length-1)){
                result+=array2[i];
            }
        }
        if(result==""){
            $('#line2').css('display','none');
        }
        $("input[name='wantKind']").val(result);
        return result;

    }
    function getResult(array) {
        var result="";
        for(var i=0;i<array.length;i++){
            if(array[i]!="NULL"&&i!=(array.length-1))
                result+=array[i]+";";
            if(array[i]!="NULL"&&i==(array.length-1)){
                result+=array[i];
            }
        }
        if(result==""){
            $('#line').css('display','none');
        }
        $("input[name='kind']").val(result);
        return result;
    }
    function addLabel2() {
        var colors=new Array("red","orange","yellow","olive" ,"blue","brown","pink","black");
        var content = $('#labelInput2').val();
        if(content!=""){
            $('#line2').css('display','block');
            var index = Math.ceil((Math.random()*8))-1;
            var html ="<a id='labelOfSelfB"+count2+"' onclick='removeLabelB("+count2+")' class=\"ui "+ colors[index]
                +" transition tag icon label\" style='margin-left: 20px;margin-top: 5px'>"+content+"<i class=\"delete icon\"></i></a>";
            array2[count2-1] = content;
            count2++;
            $('#labelB').append(html);
            $('#labelInput2').val("");
            getResult2(array2);
        }
    }
    var path = getCookie("SRC");
    var html = "<img src=" + path.toString() + " class=\"image avatar ui\"/>";
    var html2 = "<img src=" + path.toString() + " style=\"width:160px;height:160px\"id='personSRC'/>";
    $('#right').append(html);
    $('#username').append(getCookie("USERNAME"));
    $('#img').append(html2);
</script>
</body>
</html>
