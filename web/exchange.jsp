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
                $("#personalCenter").click(function () {
                    location.href = "/showPersonalMainPage.action?type=1&more=0";
                });
                $("#bookComment").click(function () {
                    location.href = "/showBookComment.action?page=1";
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
        <a class="active item" id="exchange">书籍交换</a>
        <a class="item" id="bookComment">书评</a>
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

<div class="ui main text container">
    <h1 class="ui header">Semantic UI Fixed Template</h1>

    <div class="ui equal width stackable internally celled grid">
        <div class="center aligned row">
            <div class="center aligned column">
                <div class="ui search">
                    <div class="ui icon input">
                        <input class="prompt" type="text" placeholder="请输入查询关键字">
                        <i class="search icon"></i>
                    </div>
                    <div class="results"></div>
                </div>
            </div>
        </div>
    </div>
    <p></p>
    <p></p>
    <div class="center aligned row">
        <div class="center aligned column">
            <div class="ui divided items">
                <s:iterator value="userBooksWithUserpics" var="obj">
                    <div class="item">
                        <div class="image">
                            <a class="ui left corner label">
                                <i class="heart icon"></i>
                            </a>
                            <img src="<s:property value="src"/>">
                        </div>
                        <div class="content">
                            <a class="header" onclick="showBook(<s:property value="id"/>)"><s:property value="bookname"/></a>
                            <div class="meta">
                                <span class="cinema">
                                    <img class="ui avatar image" src="<s:property value="userSrc"/>">
                                    <a onmouseover="showUser('<s:property value="username"/>')"><s:property value="username"/></a>
                                </span>
                                <span class="cinema">
                                    发布于:<s:property value="date"/>
                                </span>
                            </div>
                            <div class="description">
                                <p><s:property value="introduction"/></p>
                            </div>
                            <div class="extra">
                                <div class="ui right floated primary button">
                                    查看详情
                                    <i class="right chevron icon"></i>
                                </div>
                                <s:generator  val="kind" separator=";">
                                    <s:iterator>
                                        <div class="ui label"><s:property /></div>
                                    </s:iterator>
                                </s:generator>
                            </div>
                        </div>
                    </div>
                </s:iterator>
            </div>
        </div>
    </div>
    <div class="center row">
        <div class="center column" style="text-align: center">
            <div class="ui pagination menu">
                <s:iterator value="pageNum">
                    <a class="item <s:if test="num==page">active</s:if>" onclick="changePage('<s:property value="num"/>')">
                        <s:property value="num"/>
                    </a>
                </s:iterator>
            </div>
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
        self.location ="showExchange.action?page="+num+"&type=<s:property value="type"/>&key=<s:property value="key"/>";
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
    function showBook(id) {
        self.location = "showBook.action?bookID="+id+"&username="+getCookie("USERNAME");
    }
</script>
</body>
</html>
