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
</head>
<body>
<div class="ui two column middle aligned very relaxed stackable grid">
    <div class="column">
        <div class="ui form">
            <div class="field">
                <label>用户名</label>
                <div class="ui left icon input">
                    <input type="text" placeholder="用户名">
                    <i class="user icon"></i>
                </div>
            </div>
            <div class="field">
                <label>性别</label>
                <div class="ui left icon input">
                    <input type="text" placeholder="用户名">
                    <i class="user icon"></i>
                </div>
            </div>
            <div class="field">
                <label>密码</label>
                <div class="ui left icon input">
                    <input type="password" placeholder="请输入你的密码">
                    <i class="lock icon"></i>
                </div>
            </div>
            <div class="field">
                <label>确认密码</label>
                <div class="ui left icon input">
                    <input type="password" placeholder="请确认你的密码">
                    <i class="lock icon"></i>
                </div>
            </div>
            <div class="field">
                <label>电子邮箱</label>
                <div class="ui left icon input">
                    <input type="text" placeholder="请输入你的电子邮箱">
                    <i class="user icon"></i>
                </div>
            </div>
            <div class="field">
                <label>Password</label>
                <div class="ui left icon input">
                    <input type="密码">
                    <i class="lock icon"></i>
                </div>
            </div>
            <div class="ui blue submit button">Login</div>
        </div>
    </div>
    <div class="ui vertical divider">
        Or
    </div>
    <div class="center aligned column">
        <div class="ui big green labeled icon button">
            <i class="signup icon"></i>
            Sign Up
        </div>
    </div>
</div>
</body>
</html>
