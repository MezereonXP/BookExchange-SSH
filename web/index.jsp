<%--
  Created by IntelliJ IDEA.
  User: Mezereon
  Date: 2017/8/31
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>BookExchange-Super</title>
  </head>
  <title>Homepage - Semantic</title>
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
  <style type="text/css">
    .hidden.menu {
      display: none;
    }
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

  <script src="./pages/semantic/dist/components/visibility.js"></script>
  <script src="./pages/semantic/dist/components/sidebar.js"></script>
  <script src="./pages/semantic/dist/components/transition.js"></script>
  <script>
    $(document)
            .ready(function() {
                $("#login").click(function(){
                    location.href = "/login.jsp";});
                $("#login1").click(function(){
                    location.href = "/login.jsp";});
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
                      })
              ;

              // create sidebar and attach to menu open
              $('.ui.sidebar')
                      .sidebar('attach events', '.toc.item')
              ;

            })
    ;
  </script>
  <body >
  <!-- Following Menu -->
  <div class="ui large top fixed hidden menu">
    <div class="ui container">
      <a class="active item">主页</a>
      <a class="item">书籍交换</a>
      <a class="item">书评</a>
      <a class="item">讨论区</a>
      <div class="right menu">
        <div class="item">
          <a class="ui button" id="login1">登陆</a>
        </div>
        <div class="item">
          <a class="ui primary button">注册</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Sidebar Menu -->
  <div class="ui vertical inverted sidebar menu">
    <a class="active item">Home</a>
    <a class="item">Work</a>
    <a class="item">Company</a>
    <a class="item">Login</a>
    <a class="item">Signup</a>
  </div>


  <!-- Page Contents -->
  <div class="pusher">
    <div class="ui inverted vertical masthead center aligned segment">

      <div class="ui container">
        <div class="ui large secondary inverted pointing menu">
          <a class="toc item">
            <i class="sidebar icon"></i>
          </a>
          <a class="active item">主页</a>
          <a class="item">书籍交换</a>
          <a class="item">书评</a>
          <a class="item">讨论区</a>
          <div class="right item">
            <a class="ui inverted button" id="login">登陆</a>
            <a class="ui inverted button">注册</a>
          </div>
        </div>
      </div>

      <div class="ui text container">
        <h1 class="ui inverted header">
          还在为房间里堆满的旧书而烦恼吗?
        </h1>
        <h2>这里有你想要的一切</h2>
        <div class="ui huge primary button">开始交换吧 <i class="right arrow icon"></i></div>
      </div>
    </div>

    <div class="ui vertical stripe segment">
      <div class="ui middle aligned stackable grid container">
        <div class="row">
          <div class="eight wide column">
            <h3 class="ui header">在这里不仅仅只是换书！</h3>
            <p>分享书评似乎是件更激动人心的事情！阅读与发布书评让爱好读书的你沉醉于此。</p>
            <h3 class="ui header">另外，这里还是你们讨论的天堂！</h3>
            <p>在讨论区里你可以遇见广大书友，阅读完后就你的感受与他们辩驳一番吧！</p>
          </div>
          <div class="six wide right floated column">
            <img src="assets/images/wireframe/white-image.png" class="ui large bordered rounded image">
          </div>
        </div>
        <div class="row">
          <div class="center aligned column">
            <a class="ui huge button">进入讨论区</a>
          </div>
        </div>
      </div>
    </div>


    <div class="ui vertical stripe quote segment">
      <div class="ui equal width stackable internally celled grid">
        <div class="center aligned row">
          <div class="column">
            <h3>"What a Company"</h3>
            <p>That is what they all say about us</p>
          </div>
          <div class="column">
            <h3>"I shouldn't have gone with their competitor."</h3>
            <p>
              <img src="assets/images/avatar/nan.jpg" class="ui avatar image"> <b>Nan</b> Chief Fun Officer Acme Toys
            </p>
          </div>
        </div>
      </div>
    </div>

    <div class="ui vertical stripe segment">
      <div class="ui text container">
        <h4 class="ui horizontal header divider">
          热门讨论
        </h4>
        <h3 class="ui header" style="text-overflow:ellipsis"> 点滴的记录，那些年我读过的书（文学类居多+不定时更新+读后感）</h3>
        <p style="font-size: 16px">很久很久没有在讨论里发表过只言片语了，长久以来，我只是把所有的思想隐藏在心里....</p>
        <a class="ui large button">开始讨论</a>
        <h4 class="ui horizontal header divider">
          热门书评
        </h4>
        <h3 class="ui header">罗为民之死</h3>
        <p style="font-size: 16px">最近，我看了一本书，书的名字叫《看不清的真相》，看书的简介，是作者百年如歌的新作（在这之前，并未看过她的作品），书又是社会派推理大神，紫金陈（闻其名，不知其人，提其作品，恍然大悟，最近由秦昊，邓家佳主演的悬疑热剧《无证之罪》）、周浩晖（郭京飞主演的《暗黑者：死亡通知单》，这个剧当时也是大燥）推荐，两位专业的推理大神推荐的书，如何，请允许我以第一人称，给大家捋捋。.....</p>
        <a class="ui large button">阅读全文</a>
      </div>
    </div>


    <div class="ui inverted vertical footer segment">
      <div class="ui container">
        <div class="ui stackable inverted divided equal height stackable grid">
          <div class="three wide column">
            <h4 class="ui inverted header">About</h4>
            <div class="ui inverted link list">
              <a href="#" class="item">Sitemap</a>
              <a href="#" class="item">Contact Us</a>
              <a href="#" class="item">Religious Ceremonies</a>
              <a href="#" class="item">Gazebo Plans</a>
            </div>
          </div>
          <div class="three wide column">
            <h4 class="ui inverted header">Services</h4>
            <div class="ui inverted link list">
              <a href="#" class="item">Banana Pre-Order</a>
              <a href="#" class="item">DNA FAQ</a>
              <a href="#" class="item">How To Access</a>
              <a href="#" class="item">Favorite X-Men</a>
            </div>
          </div>
          <div class="seven wide column">
            <h4 class="ui inverted header">Footer Header</h4>
            <p>Extra space for a call to action inside the footer that could help re-engage users.</p>
          </div>
        </div>
      </div>
    </div>
  </div>

  </body>
</html>
