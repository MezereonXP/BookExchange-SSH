<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Mezereon
  Date: 2017/10/8
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookExchange-Super</title>
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
<script src="./pages/semantic/dist/components/transition.js"></script>
<script src='https://cloud.tinymce.com/stable/tinymce.min.js'></script>
<script>
    tinymce.init({
        selector: '#mytextarea'
    });
</script>
<style type="text/css">
    .masthead.segment {
        min-height: 700px;
        padding: 1em 0em;
    }
    .masthead .logo.item img {
        margin-right: 1em;
    }
    .masthead .ui.menu .ui.button {
        margin-left: 0.5em;
    }
    .masthead h1.ui.header {
        margin-top: 3em;
        margin-bottom: 0em;
        font-size: 4em;
        font-weight: normal;
    }
    .masthead h2 {
        font-size: 1.7em;
        font-weight: normal;
    }

    .ui.vertical.stripe {
        padding: 8em 0em;
    }
    .ui.vertical.stripe h3 {
        font-size: 2em;
    }
    .ui.vertical.stripe .button + h3,
    .ui.vertical.stripe p + h3 {
        margin-top: 3em;
    }
    .ui.vertical.stripe .floated.image {
        clear: both;
    }
    .ui.vertical.stripe p {
        font-size: 1.33em;
    }
    .ui.vertical.stripe .horizontal.divider {
        margin: 3em 0em;
    }

    .quote.stripe.segment {
        padding: 0em;
    }
    .quote.stripe.segment .grid .column {
        padding-top: 5em;
        padding-bottom: 5em;
    }

    .footer.segment {
        padding: 5em 0em;
    }

    .secondary.pointing.menu .toc.item {
        display: none;
    }

    @media only screen and (max-width: 700px) {
        .ui.fixed.menu {
            display: none !important;
        }
        .secondary.pointing.menu .item,
        .secondary.pointing.menu .menu {
            display: none;
        }
        .secondary.pointing.menu .toc.item {
            display: block;
        }
        .masthead.segment {
            min-height: 350px;
        }
        .masthead h1.ui.header {
            font-size: 2em;
            margin-top: 1.5em;
        }
        .masthead h2 {
            margin-top: 0.5em;
            font-size: 1.5em;
        }
    }

</style>
<script>
    $(document)
            .ready(function() {
                $("#login").click(function(){
                    location.href = "/login.jsp";});
                $("#login1").click(function(){
                    location.href = "/login.jsp";});
                $("#register1").click(function(){
                    location.href = "/register.jsp";});
                $("#register").click(function(){
                    location.href = "/register.jsp";});
                $("#home").click(function () {
                    location.href = "/index.jsp";
                });
                $("#exchange").click(function () {
                    location.href = "/showExchange.action?page=1";
                });
                $("#personalCenter").click(function () {
                    location.href = "/personalPage.jsp?type=1";
                });
                $("#discuss").click(function () {
                    location.href = "/showDiscuss.action?page=1";
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
<body>
<div class="ui fixed inverted menu">
    <div class="ui container">
        <a href="#" class="header item">
            <img class="logo" src="../assets/logo2.png">
            BookExchange
        </a>

        <a class="item" id="home">主页</a>
        <a class="item" id="exchange">书籍交换</a>
        <a class="active item" id="bookComment">书评</a>
        <a class="item" id="discuss">讨论区</a>
        <div class="right item" id="right">
            <a class="ui inverted button" id="login">登陆</a>
            <a class="ui inverted button" id ="register">注册</a>
            <div style="position: absolute; top: 50px;left: -95px; width: 260px;height: 300px;z-index: 9;padding-top: 0px">
                <div onmouseleave="hideUserPic()" id="userCard" class="ui card hidden transition" style="width: 260px;height: 100px;z-index: 10">
                    <div class="row" style="padding-top: 10px;text-align: center">
                        <div id="userNameInCard" class="column center" >

                        </div>
                        <div id="userSignInCard" class="column center">

                        </div>
                        <div class="column center" style="margin: 10px">
                            <div id="personalCenter" class="ui medium primary button"><i class="user icon"></i>个人中心 </div>
                            <div class="ui medium negative button"><i class="power icon"></i>注销 </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<div class="ui main text container" style="margin-top: 70px">
    <h1 class="ui header">发布书评</h1>
    <div class="ui labeled input">
        <a class="ui blue label">
            书名
        </a>
        <input type="text" placeholder="请输入书名" name="bookName">
    </div>
    <p>
    <div class="ui labeled input">
        <a class="ui blue label">
            标题
        </a>
        <input type="text" placeholder="请输入标题" name="title">
    </div>
    <p>
    <div style="text-align: center">
        <form method="post">
            <textarea id="mytextarea" name="content" style="height: 400px;width: 800px"></textarea>
        </form>
    </div>
    <div class="ui equal width stackable internally celled grid">

        <div class="row center aligned">
            <a style="display: inline" class="ui blue large button" onclick="sendBookComment()">发布书评</a>
        </div>
    </div>
    <p></p>
    <p></p>
</div>

<div class="ui inverted vertical footer segment">
    <div class="ui center aligned container">
        <div class="ui stackable inverted divided grid">
            <div class="three wide column">
                <h4 class="ui inverted header">Group 1</h4>
                <div class="ui inverted link list">
                    <a href="#" class="item">Link One</a>
                    <a href="#" class="item">Link Two</a>
                    <a href="#" class="item">Link Three</a>
                    <a href="#" class="item">Link Four</a>
                </div>
            </div>
            <div class="three wide column">
                <h4 class="ui inverted header">Group 2</h4>
                <div class="ui inverted link list">
                    <a href="#" class="item">Link One</a>
                    <a href="#" class="item">Link Two</a>
                    <a href="#" class="item">Link Three</a>
                    <a href="#" class="item">Link Four</a>
                </div>
            </div>
            <div class="three wide column">
                <h4 class="ui inverted header">Group 3</h4>
                <div class="ui inverted link list">
                    <a href="#" class="item">Link One</a>
                    <a href="#" class="item">Link Two</a>
                    <a href="#" class="item">Link Three</a>
                    <a href="#" class="item">Link Four</a>
                </div>
            </div>
            <div class="seven wide column">
                <h4 class="ui inverted header">Footer Header</h4>
                <p>Extra space for a call to action inside the footer that could help re-engage users.</p>
            </div>
        </div>
        <div class="ui inverted section divider"></div>
        <img src="assets/images/logo.png" class="ui centered mini image">
        <div class="ui horizontal inverted small divided link list">
            <a class="item" href="#">Site Map</a>
            <a class="item" href="#">Contact Us</a>
            <a class="item" href="#">Terms and Conditions</a>
            <a class="item" href="#">Privacy Policy</a>
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
    function showUser(user) {
        //window.alert(user);
    }
    function changePage(num) {
        //window.alert(""+num);
        self.location ="showBookComment.action?page="+num;
    }
    var path = getCookie("SRC");
    if(path!="null") {
        var html = "<img onmouseover='showUserPic()' src=" + path.toString() + " class=\"image avatar ui\" "+" id=\"personal\"/>";
        $('#right').append(html);
    }
    if(getCookie("USERNAME")=='null'){
    }else {
        document.getElementById("login").style.display="none";
        document.getElementById("register").style.display="none";
    }
    function showUserPic() {
        $('#userCard').transition("browse");
        var userNameInCard = document.getElementById("userNameInCard");
        userNameInCard.innerHTML = "<a class=\"ui teal image label\"> " +
                "<img src="+getCookie("SRC")+">"+ getCookie("USERNAME")
                +"<div class=\"detail\">普通用户</div></a>";
    }
    function hideUserPic() {
        $('#userCard').transition("fly up");
    }
    function showArticle(id) {
        self.location = "showArticle.action?articleID="+id;
    }
    function sendBookComment() {
        window.alert(tinymce.get('mytextarea').getContent());
    }
</script>
</body>
</html>
