<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-10-09
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" type="text/css" href="./pages/semantic/dist/semantic.min.css">
    <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    <script src="./pages/semantic/dist/semantic.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./pages/semantic/dist/components/reset.css">
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
    <script src="./pages/semantic/dist/components/transition.js"></script>
    <script>
        $(document)
            .ready(function() {
                $('.ui.form')
                    .form({
                        fields: {
                            username: {
                                identifier  : 'username',
                                rules: [
                                    {
                                        type   : 'empty',
                                        prompt : '请输入你的用户名'
                                    },
                                ]
                            },
                            password: {
                                identifier  : 'password',
                                rules: [
                                    {
                                        type   : 'length[6]',
                                        prompt : '密码长度至少为6位'
                                    }
                                ]
                            },
                            email: {
                                identifier  : 'email',
                                rules: [
                                    {
                                        type   : 'empty',
                                        prompt : '邮箱地址不能为空'
                                    },
                                    {
                                        type:'email',
                                        prompt:'邮箱格式有误'
                                    }
                                ]
                            },
                            passwordCheck: {
                                identifier  : 'passwordCheck',
                                rules: [
                                    {
                                        type   : 'match[password]',
                                        prompt : '密码与确认密码必须一致'
                                    }
                                ]
                            },
                            phone:{
                                identifier  : 'phone',
                                rules: [
                                    {
                                        type   : 'regExp[/^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\\d{8}$/]',
                                        prompt : '手机号码格式有误'
                                    }
                                ]
                            }
                        }
                    })
                ;
            })
        ;
    </script>
</head>
<body>
<div class="ui vertically divided stackable grid" >
    <div class="row" style="padding-top: 20px;padding-bottom: 0px">
    <div class="one wide column">
    </div>
    <div class="one wide column" style=";padding-right: 0px">
        <img src="../assets/logo2.png" class="image" style="width: 55px ; height: 55px">
    </div>
    <div class="three wide column" style="padding-left: 0px;padding-top: 5px">
        <p style="font-size: 30px">BookExchange</p>
    </div>
    <div class="three wide column" style="padding-top: 5px">
        <p style="font-size: 30px">欢迎注册</p>
    </div>
    </div>
    <div class = "row">
        <div class="five wide column"></div>
        <div class="four wide column" >
            <form class="ui form" action="register.action">
                <div class="field" style="margin-bottom: 25px">
                    <label>用户名</label>
                    <div class="ui left icon input">
                        <s:if test="exist == 'true'">
                            <input type="text" name="username" value="<s:property value="username"/>" placeholder="用户名"  >
                        </s:if>
                        <s:else>
                            <input type="text" name="username" placeholder="用户名" >
                        </s:else>
                        <i class="user icon"></i>
                    </div>
                </div>
                <div class="inline fields" style="margin-bottom: 25px">
                    <label>性别</label>
                    <div class="field">
                        <div class="ui radio checkbox">
                            <input type="radio" name="sex" checked="checked" value="男">
                            <label>男</label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui radio checkbox">
                            <input type="radio" name="sex" value="女">
                            <label>女</label>
                        </div>
                    </div>
                </div>
                <div class="field" style="margin-bottom: 25px">
                    <label>密码</label>
                    <div class="ui left icon input">
                        <input type="password" placeholder="请输入你的密码" name="password">
                        <i class="lock icon"></i>
                    </div>
                </div>
                <div class="field" style="margin-bottom: 25px">
                    <label>确认密码</label>
                    <div class="ui left icon input">
                        <input type="password" placeholder="请确认你的密码" name="passwordCheck">
                        <i class="lock icon"></i>
                    </div>
                </div>
                <div class="field" style="margin-bottom: 25px">
                    <label>电子邮箱</label>
                    <div class="ui left icon input">
                        <s:if test="exist == 'true'">
                            <input type="text" name="email" value="<s:property value="email"/>" placeholder="请输入你的电子邮箱"  >
                        </s:if>
                        <s:else>
                            <input type="text"placeholder="请输入你的电子邮箱" name="email" >
                        </s:else>
                        <i class="Mail Outline icon"></i>
                    </div>
                </div>
                <div class="field" style="margin-bottom: 25px">
                    <label>手机号码</label>
                    <div class="ui left icon input">
                        <s:if test="exist == 'true'">
                            <input type="text" name="phone" value="<s:property value="phone"/>" placeholder="请输入你的手机号码"  >
                        </s:if>
                        <s:else>
                            <input type="text"placeholder="请输入你的手机号码" name="phone" >
                        </s:else>
                        <i class="Call icon"></i>
                    </div>
                </div>
                <div class="ui error message"></div>
                <s:if test="exist == 'true'">
                    <div class="ui negative message" id="a">
                        <i id="close" class="close icon" onclick="hideTheWrong()"></i>
                        用户名已存在！
                    </div>
                </s:if>
                <div class="field" style="margin-bottom: 25px ;text-align: center" >
                    <div class="ui fluid large teal submit button"style="  margin-left:auto;margin-left:auto;" id="register"  >
                        <i class="signup icon"></i>
                        点击注册
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function hideTheWrong() {
        $("#a").transition("fly left");
    }
</script>
</body>
</html>
