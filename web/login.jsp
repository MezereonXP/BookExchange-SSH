<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-10-08
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Standard Meta -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <!-- Site Properties -->
    <title>用户登陆</title>
    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/semantic.min.css">
    <script src="pages/semantic/dist/semantic.min.js"></script>
    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/components/reset.css">
    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/components/site.css">

    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/components/container.css">
    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/components/grid.css">
    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/components/header.css">
    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/components/image.css">
    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/components/menu.css">

    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/components/divider.css">
    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/components/segment.css">
    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/components/form.css">
    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/components/input.css">
    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/components/button.css">
    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/components/list.css">
    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/components/message.css">
    <link rel="stylesheet" type="text/css" href="pages/semantic/dist/components/icon.css">

    <script src="https://code.jquery.com/jquery.min.js"></script>
    <script src="pages/semantic/dist/components/form.js"></script>
    <script src="pages/semantic/dist/components/transition.js"></script>

    <style type="text/css">
        body > .grid {
            height: 100%;
        }
        .image {
            margin-top: -100px;
        }
        .column {
            max-width: 450px;
        }
            </style>
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
                            }
                        }
                    })
                ;
            })
        ;
    </script>
</head>
<body>
<div class="ui middle aligned center aligned grid" id="form">
    <div class="column">
        <h2 class="ui teal image header">
            <img src="../assets/logo2.png" class="image">
            <div class="content">
                登陆你的账户
            </div>
        </h2>
        <form class="ui large form" action="login.action" method="post">
            <div class="ui stacked segment">
                <div class="field">
                    <div class="ui left icon input">
                        <i class="user icon"></i>
                        <s:if test="state == 'error'">
                            <input type="text" name="username" value="<s:property value="username"/>" placeholder="用户名"  >
                        </s:if>
                        <s:else>
                            <input type="text" name="username" placeholder="用户名" >
                        </s:else>
                    </div>
                </div>
                <div class="field">
                    <div class="ui left icon input">
                        <i class="lock icon"></i>
                        <s:if test="state == 'error'">
                            <input id="password" type="password" name="password" placeholder="密码" value="<s:property value="password"/>" >
                        </s:if>
                        <s:else>
                            <input id="password" type="password" name="password" placeholder="密码" >
                        </s:else>
                    </div>
                </div>
                <div class="ui fluid large teal submit button" id="submit" onclick="loading()">登陆</div>
            </div>

            <div class="ui error message"></div>
            <s:if test="state == 'error'">
                <div class="ui negative message" id="a">
                    <i id="close" class="close icon" onclick="hideTheWrong()"></i>
                    用户名或密码错误！
                </div>
                <script>
                    $('#form').transition("tada");
                </script>
            </s:if>
            <div class="ui message" >
                没有账户？ <a href="#" >注册</a>
            </div>
        </form>
    </div>

</div>
<script>
    function hideTheWrong() {
        $("#a").transition("fly left");
    }
</script>
</body>

</html>
