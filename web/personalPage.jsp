<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-10-13
  Time: 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*" %>
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
<link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/modal.css">
<script src="./pages/semantic/dist/components/visibility.js"></script>
<script src="./pages/semantic/dist/components/sidebar.js"></script>
<script src="./pages/semantic/dist/components/dimmer.js"></script>
<script src="./pages/semantic/dist/components/dropdown.js"></script>
<script src="./pages/semantic/dist/components/transition.js"></script>
<script src="./pages/semantic/dist/components/modal.js"></script>
<script>
    $(document)
        .ready(function () {
            $("#exchange").click(function () {
                location.href = "/showExchange.action?page=1";
            });
            $("#bookComment").click(function () {
                location.href = "/showBookComment.action?page=1";
            });
            $("#discuss").click(function () {
                location.href = "/showDiscuss.action?page=1";
            });
            $('.special.cards .image').dimmer({
                on: 'hover'
            });
            $('.ui.menu a.item')
                .on('click', function () {
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
                $('.ui.small.modal')
                    .modal('show')
                ;
            });
            $("#home").click(function () {
                location.href = "/index.jsp";
            });
            // fix menu when passed
            $('.masthead')
                .visibility({
                    once: false,
                    onBottomPassed: function() {
                        $('.fixed.menu').transition('fade in');
                    },
                    onBottomPassedReverse: function() {
                        $('.fixed.menu').transition('fade out');
                    }
                });
            // create sidebar and attach to menu open
            $('.ui.sidebar')
                .sidebar('attach events', '.toc.item');

        })
    ;
</script>
<style>
    body {
        background-color: #F3F3F3;
        width: 100%;
        height: 100%;
        margin: 0px;
        padding: 0px;
    }
</style>
<body>
<div class="ui segment" style="width: 100%;height: 100%;margin: 0px;padding: 0px;display: none" id="loader">
    <div class="ui active dimmer">
        <div class="ui text loader">Loading</div>
    </div>
    <p></p>
</div>
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
<div class="ui small modal transition">
    <i class="close icon"></i>
    <div class="header">
        编辑个人信息
    </div>
        <div class="content">
            <p style="font-size: x-large;margin-left: 15px"><s:property value="username"></s:property></p>
            <div class="ui grid vertically divided">
                <div class="row" style="margin-left: 30px;padding-top: 30px;padding-bottom: 30px" onmouseenter="show(1)"
                     onmouseleave="hide(1)">
                    <div style="margin-top: 8px">手机号码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                    <div style="margin-top: 8px;" id="phoneSign" class="ui transition">
                        <div id="phoneEle" style="display: inline"><s:property value="beuserEntity.getPhone()"/>
                        </div>&nbsp;&nbsp;&nbsp;<a href="#" class="ui transition hidden" id="phone"
                                                   onclick="showInput(1)"><i class="icon pencil "></i>修改</a></div>
                    <div id="phoneInput" class="transition hidden">
                        <div class="ui input">
                            <input type="text" placeholder="请输入手机号码" id="phoneIn" name="phone">
                        </div>
                        <button class="ui primary button" id="phoneSave" onclick="save(1)">
                            保存
                        </button>
                        <button class="ui button" id="phoneCancel" onclick="showInput(1)">
                            取消
                        </button>
                    </div>
                </div>
                <div class="row" style="margin-left: 30px;padding-top: 30px;padding-bottom: 30px" onmouseenter="show(2)"
                     onmouseleave="hide(2)">
                    <div style="margin-top: 8px">电子邮箱:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                    <div style="margin-top: 8px;" id="emailSign" class="ui transition">
                        <div id="emailEle" style="display: inline"><s:property value="beuserEntity.getEmail()"/>
                        </div>&nbsp;&nbsp;&nbsp;<a href="#" class="transition hidden" id="email" onclick="showInput(2)"><i
                            class="icon pencil"></i>修改</a></div>
                    <div id="emailInput" class="transition hidden">
                        <div class="ui input">
                            <input type="text" placeholder="请输入电子邮箱" id="emailIn" name="email">
                        </div>
                        <button class="ui primary button" id="emailSave" onclick="save(2)">
                            保存
                        </button>
                        <button class="ui button" id="emailCancel" onclick="showInput(2)">
                            取消
                        </button>
                    </div>
                </div>
                <div class="row" style="margin-left: 30px;padding-top: 30px;padding-bottom: 30px" onmouseenter="show(3)"
                     onmouseleave="hide(3)">
                    <div style="margin-top: 8px">个性签名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                    <div style="margin-top: 8px;" id="signSign" class="ui transition">
                        <div id="signEle" style="display: inline"><s:property value="beuserEntity.getSignatrue()"/>
                        </div>&nbsp;&nbsp;&nbsp;<a href="#" class="transition hidden" id="sign"
                                                   onclick="showInput(3)"><i class="icon pencil"></i>修改</a></div>
                    <div id="signInput" class="transition hidden">
                        <div class="ui input">
                            <input type="text" placeholder="请输入个性签名" id="signIn" name="sign">
                        </div>
                        <button class="ui primary button" id="signSave" onclick="save(3)">
                            保存
                        </button>
                        <button class="ui button" id="signCancel" onclick="showInput(3)">
                            取消
                        </button>
                    </div>
                </div>
            </div>
        </div>
    <div class="actions">
        <div class="ui red basic cancel inverted button">
            <i class="remove icon"></i>
            取消
        </div>
        <div class="ui green ok inverted button" onclick="personSubmit()">
            <i class="checkmark icon"></i>
            保存
        </div>
    </div>
</div>
<div class="ui centered grid sty" style="margin-top: 50px;" id="main">
    <div class="twelve wide column"
         style="background-color:  #96A1A9;height: 150px;border-radius:5px 5px 0 0;position: relative">
        <div class="ui special cards raised"
             style="left: 15px;top: 60px;position:absolute;z-index: 2;width: 160px;height: 160px;">
            <div class="card">
                <div class="blurring dimmable image" id="img">
                    <div class="ui dimmer">
                        <div class="content">
                            <div class="center">
                                <input type="file" id="btn_file" style="display:none" onchange="fileSelected2()">
                                <div class="ui inverted button" onclick="F_Open_dia()" id="userPic">上传我的头像</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <strong style="left: 195px;top: 165px;position:absolute;z-index: 999;font-size: x-large;" id="username">
        </strong>
        <p style="left: 195px;top: 195px;position:absolute;z-index: 999;font-size: small;color: #8a8a8a"><s:property value="beuserEntity.getSignatrue()"/></p>
        <button class="ui inverted pink button" style="right: 15px;top: 190px;position:absolute;z-index: 2" id="revise">
            编辑个人信息
        </button>
    </div>
    <div class="row" style="padding-top: 0">
        <div class="twelve wide column"
             style="height: 120px;background-color: #FFFFFF;border-radius:0 0 5px 5px ;"></div>
    </div>
    <div class="row">
        <div class="twelve wide column" style="background-color: #FFFFFF;border-radius:0 0 5px 5px ;">
            <div class="ui secondary pointing blue menu" id="mMenu">
                <a class="item" onclick="changeType(1)">
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
            <div id="type" style="display: none"><s:property value="type"></s:property>
            </div>
            <s:if test="type ==1">
                <div class="ui grid vertically divided">
                    <div class="row">
                        <div class="ui grid">
                            <div class="sixteen column">
                                <p style="font-size: x-large;margin-left: 20px;width:110px;display: inline">我的书籍</p>
                                <button class="ui white right labeled icon button" style="float: right"
                                        onclick="more()">
                                    <i class="Angle Right icon"></i>
                                    更多
                                </button>
                                <div class="ui items" style="padding-left: 10px">
                                    <s:iterator value="userbookEntityList" var="obj">
                                        <div class="item" style="float:left;width:320px;margin:10px">
                                            <div class="ui fluid image" style="height: 145px;width: 115px">

                                                <s:if test="state==0">
                                                    <div class="ui white ribbon label">
                                                        未交换
                                                    </div>
                                                </s:if>
                                                <s:if test="state==1">
                                                    <div class="ui blue ribbon label">
                                                        交换中
                                                    </div>
                                                </s:if>
                                                <s:if test="state==2">
                                                    已交换
                                                </s:if>
                                                <img src="<s:property value="src"/>" style="height: 145px;width: 115px">
                                            </div>
                                            <div class="content">
                                                <a class="header"
                                                   style="display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 1;overflow: hidden;"><s:property
                                                        value="bookname"/></a>
                                                <div class="meta">
                                                    <span></span>
                                                </div>
                                                <div class="description">
                                                    <p style="display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 5;overflow: hidden;">
                                                        <s:property value="introduction"/></p>
                                                </div>
                                            </div>
                                        </div>
                                    </s:iterator>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="padding-bottom: 30px">
                        <div class="ui grid vertical divided">
                            <div class="row" style="margin-left: 12px">
                                <div class="sixteen column">
                                    <p style="font-size: x-large;margin-left: 20px;display: inline">我的书评</p>
                                    <button class="ui right labeled icon button" style="float: right">
                                        <i class="Angle Right icon"></i>
                                        更多
                                    </button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="ui items">
                                    <s:iterator value="bookarticleEntityList">
                                        <div class="item" style="margin-left: 30px;">
                                            <div class="content">
                                                <div class="meta">
                                                <span class="cinema">
                                                    <img class="ui avatar image" src="<s:property value="authorpic"/>">
                                                    <a><s:property value="username"/></a>
                                                </span>
                                                    <span class="cinema">
                                                    发布于:<s:property value="time"/>
                                                </span>
                                                </div>
                                                <div class="header" style="margin-top: 3px"><s:property
                                                        value="title"/></div>
                                                <div class="description">
                                                    <p style="width:650px;display: -webkit-box;-webkit-box-orient:
                                                vertical;-webkit-line-clamp: 3;overflow: hidden;">
                                                        <s:property value="introduction"/>
                                                    </p>
                                                </div>
                                            </div>
                                            <div class="ui small image">
                                                <img src="<s:property value="src"/>">
                                            </div>
                                        </div>
                                    </s:iterator>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </s:if>
            <s:if test="type == 2"><p>上传书籍界面</p></s:if>
            <s:if test="type == 3">
                <form class="ui form" id="form" action="addBook.action">
                    <div class="ui centered grid">
                        <div class="three wide column">
                            <div class="ui special cards raised" style="width:160px;height:200px;margin-bottom: 100px">
                                <div class="card">
                                    <div class="blurring dimmable image" id="imgAdd">
                                        <div class="ui dimmer">
                                            <div class="content">
                                                <div class="center">
                                                    <input type="file" id="bookImgSrc" style="display: none"
                                                           onchange="fileSelected()">
                                                    <div class="ui inverted button" onclick="F_Open_dia2()">点击上传书籍图片
                                                    </div>
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
                            <div id="labelC">
                            </div>
                            <div id="line" style="display: none">
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
                            <div id="line2" style="display: none">
                                <br>
                            </div>
                            <div class="ui labeled input">
                                <a class="ui blue label">
                                    购买日期
                                </a>
                                <input type="text" name="buyDate" placeholder="请输入书籍的购买日期"/>
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
                    </div>
                    <input type="text" name="wantKind" style="display: none"/>
                    <input type="text" name="kind" style="display: none"/>
                    <input type="text" name="bookSRC" style="display: none"/>
                    <input type="text" name="username" style="display: none"/>
                    <input type="text" name="date" style="display: none"/>
                </form>
                <div style="text-align: center">
                    <button class="ui primary button" onclick="sub()">点击上传</button>
                </div>
            </s:if>
            <s:if test="type == 4">
                <div class="ui grid vertically divided">
                    <div class="row">
                        <div class="ui grid">
                            <div class="sixteen column">
                                <p style="font-size: x-large;margin-left: 32px;width:110px;display: inline">交换请求</p>
                                <div class="row">
                                    <div class="ui items">
                                        <s:iterator value="requestList">
                                            <div class="item" style="margin-left: 30px;margin-top: 5px">
                                                <div class="ui small image">
                                                    <img src="<s:property value="booksrca"/>" style="height: 145px;width: 115px">
                                                </div>
                                                <i class="icon large exchange" style="margin-top: 60px;margin-right: 40px"></i>
                                                <div class="ui small image">
                                                    <img src="<s:property value="booksrcb"/>" style="height: 145px;width: 115px">
                                                </div>
                                                <div class="content">
                                                    <div class="meta">
                                                        <span class="cinema">
                                                            <a><s:property value="usernamea"/></a>
                                                        </span>
                                                        <span class="cinema">
                                                            于<s:property value="date"/>发起申请
                                                        </span>
                                                        <br>
                                                        <br>
                                                        <span class="cinema">
                                                            使用<h4 style="display: inline;"><s:property value="booknamea"/></h4>
                                                            <br>
                                                            交换您的<h4 style="display: inline;"><s:property value="booknameb"/></h4>
                                                        </span>
                                                    </div>
                                                    <button class="ui primary button" onclick="agree(<s:property value="id"/>)">同意</button>
                                                    <button class="ui primary button negative" onclick="refuse(<s:property value="id"/>)">拒绝</button>
                                                </div>
                                            </div>
                                        </s:iterator>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="padding-bottom: 30px">
                        <div class="ui grid vertical divided">
                            <div class="row" style="margin-left: 12px">
                                <div class="sixteen column">
                                    <p style="font-size: x-large;margin-left: 20px;display: inline">已发送申请</p>
                                    <button class="ui right labeled icon button" style="float: right">
                                        <i class="Angle Right icon"></i>
                                        更多
                                    </button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="ui items">
                                    <s:iterator value="waitList">
                                        <div class="item" style="margin-left: 45px;margin-top: 5px">
                                            <div class="ui small image">
                                                <img src="<s:property value="booksrca"/>" style="height: 145px;width: 115px">
                                            </div>
                                            <i class="icon large exchange" style="margin-top: 60px;margin-right: 40px"></i>
                                            <div class="ui small image">
                                                <img src="<s:property value="booksrcb"/>" style="height: 145px;width: 115px">
                                            </div>
                                            <div class="content">
                                                <div class="meta">
                                                    <span class="cinema">
                                                        <a><s:property value="usernamea"/></a>
                                                    </span>
                                                    <span class="cinema">
                                                        您于<s:property value="date"/>发起申请
                                                    </span>
                                                    <br>
                                                    <br>
                                                    <span class="cinema">
                                                        使用您的<h4 style="display: inline;"><s:property value="booknamea"/></h4>
                                                        <br>
                                                        交换<h4 style="display: inline;"><s:property value="booknameb"/></h4>
                                                        <br>
                                                        <br>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </s:iterator>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="padding-bottom: 30px">
                        <div class="ui grid vertical divided">
                            <div class="row" style="margin-left: 12px">
                                <div class="sixteen column">
                                    <p style="font-size: x-large;margin-left: 20px;display: inline">交换中书籍</p>
                                    <button class="ui right labeled icon button" style="float: right">
                                        <i class="Angle Right icon"></i>
                                        更多
                                    </button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="ui items">
                                    <s:iterator value="exchangingList">
                                        <div class="item" style="margin-left: 45px;margin-top: 5px">
                                            <div class="ui small image">
                                                <img src="<s:property value="booksrca"/>" style="height: 145px;width: 115px">
                                            </div>
                                            <i class="icon large exchange" style="margin-top: 60px;margin-right: 40px"></i>
                                            <div class="ui small image">
                                                <img src="<s:property value="booksrcb"/>" style="height: 145px;width: 115px">
                                            </div>
                                            <div class="content">
                                                <div class="meta">
                                                    <span class="cinema">
                                                        <a><s:property value="usernamea"/></a>
                                                    </span>
                                                    <span class="cinema">
                                                        于<s:property value="date"/>开始发起交换
                                                    </span>
                                                    <br>
                                                    <br>
                                                    <span class="cinema">
                                                        正在交换<h4 style="display: inline;"><s:property value="booknamea"/></h4>
                                                        <br>
                                                        与<h4 style="display: inline;"><s:property value="booknameb"/></h4>
                                                        <br>
                                                        <br>
                                                        <button class="ui primary button" onclick="uploadNum(<s:property value="id"/>)">上传物流单号</button>
                                                        <button class="ui primary button grey" onclick="checkState(<s:property value="id"/>)">查看状态</button>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </s:iterator>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="padding-bottom: 30px">
                        <div class="ui grid vertical divided">
                            <div class="row" style="margin-left: 12px">
                                <div class="sixteen column">
                                    <p style="font-size: x-large;margin-left: 20px;display: inline">已交换书籍</p>
                                    <button class="ui right labeled icon button" style="float: right">
                                        <i class="Angle Right icon"></i>
                                        更多
                                    </button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="ui items">
                                    <s:iterator value="exchangedList">
                                        <div class="item" style="margin-left: 45px;margin-top: 5px">
                                            <div class="ui small image">
                                                <img src="<s:property value="booksrca"/>" style="height: 145px;width: 115px">
                                            </div>
                                            <i class="icon large exchange" style="margin-top: 60px;margin-right: 40px"></i>
                                            <div class="ui small image">
                                                <img src="<s:property value="booksrcb"/>" style="height: 145px;width: 115px">
                                            </div>
                                            <div class="content">
                                                <div class="meta">
                                                    <span class="cinema">
                                                        <a><s:property value="usernamea"/></a>
                                                    </span>
                                                    <span class="cinema">
                                                        于<s:property value="date"/>开始发起交换
                                                    </span>
                                                    <br>
                                                    <br>
                                                    <span class="cinema">
                                                        与<h4 style="display: inline;"><s:property value="booknamea"/></h4>
                                                        <br>
                                                        交换结束<h4 style="display: inline;"><s:property value="booknameb"/></h4>
                                                        <br>
                                                        <br>
                                                        <button class="ui primary button" onclick="uploadNum(<s:property value="id"/>)">发布相关书评</button>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </s:iterator>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </s:if>
            <s:if test="type == 5"><p>通知消息界面</p></s:if>
            <%--上传书籍--%>
        </div>
    </div>
</div>
<script>
    //window.alert($('#type').text());
    $('#mMenu a').eq($('#type').text() - 1).addClass("active");
    var count = 1;
    var count2 = 1;
    var array = new Array();
    var array2 = new Array();//用来储存书籍类型的Tag的数组
    function sub() {
        if ($(" input[ name='kind' ] ").val() == "" || $(" input[ name='wantKind' ] ").val() == "" || $(" input[ name='bookName' ] ").val() == "" || $(" input[ name='introduction' ] ").val() == "" || $(" input[ name='buyDate' ] ").val() == "" || $(" input[ id='bookImgSrc' ] ").val() == "") {
            window.alert("请填完所有内容");
        } else {
            $("#main").css("display", "none");
            $("#loader").show();
            var formData = new FormData();
            formData.append("file", document.getElementById("bookImgSrc").files[0]);
            $.ajax({
                url: "http://mezereon.gotoip2.com/bookEx/addBookPic.php",
                type: "POST",
                data: formData,
                /**
                 *必须false才会自动加上正确的Content-Type
                 */
                contentType: false,
                /**
                 * 必须false才会避开jQuery对 formdata 的默认处理
                 * XMLHttpRequest会对 formdata 进行正确的处理
                 */
                processData: false,
                success: function (data) {
                    console.log(data);
                    alert(data);
                    $(" input[ name='bookSRC' ] ").val(data);
                    $(" input[ name='username' ] ").val(getCookie("USERNAME"));
                    $(" input[ name='date' ] ").val(getNowFormatDate());
                    $("#form").submit();
                },
                error: function () {
                    alert("上传失败！");
                }
            })
        }
    }

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
        var formData = new FormData();
        formData.append("file", document.getElementById("btn_file").files[0]);
        formData.append("username", getCookie("USERNAME"));
        $.ajax({
            url: "http://mezereon.gotoip2.com/bookEx/uploadpic.php",
            type: "POST",
            data: formData,
            /**
             *必须false才会自动加上正确的Content-Type
             */
            contentType: false,
            /**
             * 必须false才会避开jQuery对 formdata 的默认处理
             * XMLHttpRequest会对 formdata 进行正确的处理
             */
            processData: false,
            success: function (data) {
                console.log(data);
                alert(data);
                delCookie("SRC");
                setCookie("SRC", data);
                location.href = "upaloadUserPic.action?src=" + data;
            },
            error: function () {
                alert("上传失败！");
            }
        })
    }

    function setCookie(name, value) {
        var Days = 30;
        var exp = new Date();
        exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
        document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
    }

    function delCookie(name) {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval = getCookie(name);
        if (cval != null)
            document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
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

    function changeType(num) {
        if (num == 1) {
            self.location = "showPersonalMainPage.action?type=" + num + "&more=0";
        } else if (num == 3) {
            self.location = "showPersonalMainPage.action?type=" + num;
        } else if(num == 4){
            self.location = "showPersonalMainPage.action?type="+num;
        }

    }

    function more() {
        self.location = "showPersonalMainPage.action?type=1&username=" + getCookie("USERNAME") + "&more=1";
    }

    function addLabel() {
        var colors = new Array("red", "orange", "yellow", "olive", "blue", "brown", "pink", "black");
        var content = $('#labelInput').val();
        if (content != "") {
            $('#line').css('display', 'block');
            var index = Math.ceil((Math.random() * 8)) - 1;
            var html = "<a id='labelOfSelf" + count + "' onclick='removeLabel(" + count + ")' class=\"ui " + colors[index]
                + " transition tag icon label\" style='margin-left: 20px;margin-top: 5px'>" + content + "<i class=\"delete icon\"></i></a>";
            array[count - 1] = content;
            count++;
            $('#labelC').append(html);
            $('#labelInput').val("");
            getResult(array);
        }
    }

    function removeLabel(c) {
        $('#labelOfSelf' + c).transition("fade");
        array[c - 1] = "NULL";
        getResult(array);
    }

    function removeLabelB(c) {
        $('#labelOfSelfB' + c).transition("fade");
        array2[c - 1] = "NULL";
        getResult2(array2);
    }

    function getResult2(array2) {
        var result = "";
        for (var i = 0; i < array2.length; i++) {
            if (array2[i] != "NULL" && i != (array2.length - 1))
                result += array2[i] + ";";
            if (array2[i] != "NULL" && i == (array2.length - 1)) {
                result += array2[i];
            }
        }
        if (result == "") {
            $('#line2').css('display', 'none');
        }
        $("input[name='wantKind']").val(result);
        return result;

    }

    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
        return currentdate;
    }

    function getResult(array) {
        var result = "";
        for (var i = 0; i < array.length; i++) {
            if (array[i] != "NULL" && i != (array.length - 1))
                result += array[i] + ";";
            if (array[i] != "NULL" && i == (array.length - 1)) {
                result += array[i];
            }
        }
        if (result == "") {
            $('#line').css('display', 'none');
        }
        $("input[name='kind']").val(result);
        return result;
    }

    function addLabel2() {
        var colors = new Array("red", "orange", "yellow", "olive", "blue", "brown", "pink", "black");
        var content = $('#labelInput2').val();
        if (content != "") {
            $('#line2').css('display', 'block');
            var index = Math.ceil((Math.random() * 8)) - 1;
            var html = "<a id='labelOfSelfB" + count2 + "' onclick='removeLabelB(" + count2 + ")' class=\"ui " + colors[index]
                + " transition tag icon label\" style='margin-left: 20px;margin-top: 5px'>" + content + "<i class=\"delete icon\"></i></a>";
            array2[count2 - 1] = content;
            count2++;
            $('#labelB').append(html);
            $('#labelInput2').val("");
            getResult2(array2);
        }
    }

    function show(type) {
        switch (type) {
            case 1:
                $("#phone").transition("fade");
                break;
            case 2:
                $("#email").transition("fade");
                break;
            case 3:
                $("#sign").transition("fade");
                break;
        }
    }

    function hide(type) {
        switch (type) {
            case 1:
                $("#phone").transition("fade");
                break;
            case 2:
                $("#email").transition("fade");
                break;
            case 3:
                $("#sign").transition("fade");
                break;
        }
    }

    function showInput(type) {
        switch (type) {
            case 1:
                $("#phoneInput").transition("fade");
                $("#phoneSign").transition("fade");
                break;
            case 2:
                $("#emailInput").transition("fade");
                $("#emailSign").transition("fade");
                break;
            case 3:
                $("#signInput").transition("fade");
                $("#signSign").transition("fade");
                break;
        }
    }

    function save(type) {
        switch (type) {
            case 1:
                if ($("#phoneIn").val() != "") {
                    $("#phoneEle").html($("#phoneIn").val());
                }
                $("#phoneInput").transition("fade");
                $("#phoneSign").transition("fade");
                break;
            case 2:
                if ($("#emailIn").val() != "") {
                    $("#emailEle").html($("#emailIn").val());
                }
                $("#emailInput").transition("fade");
                $("#emailSign").transition("fade");
                break;
            case 3:
                if ($("#signIn").val() != "") {
                    $("#signEle").html($("#signIn").val());
                }
                $("#signInput").transition("fade");
                $("#signSign").transition("fade");
                break;
        }
    }
    function personSubmit() {
        location.href = "updateUser.action?sign="+$("#signEle").text()+"&phone="+$("#phoneEle").text()+"&email="+$("#emailEle").text();
    }

    function agree(id) {
        var formData = new FormData();
        formData.append("exchangeID", id);
        $.ajax({
            url: "http://localhost:8099/agree.action",
            type: "POST",
            data: formData,
            contentType: false,
            processData: false,
            success: function (data) {
                alert("操作成功!");
                self.location = "showPersonalMainPage.action?type=4";
            },
            error: function () {
                alert("操作失败!");
            }
        })
    }
    function refuse(id) {
        var formData = new FormData();
        formData.append("exchangeID", id);
        $.ajax({
            url: "http://localhost:8099/refuse.action",
            type: "POST",
            data: formData,
            contentType: false,
            processData: false,
            success: function (data) {
                alert("操作成功!");
                self.location = "showPersonalMainPage.action?type=4";
            },
            error: function () {
                alert("操作失败!");
            }
        })
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