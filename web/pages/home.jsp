<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Mezereon
  Date: 2017/8/31
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>

<body>

    Username is <s:property value="username"/>
    <br>
    Password is <s:property value="password"/>
    <br>
    <%--<ul class="list-group" style="text-align: center;width: 300px">--%>
        <%--<s:generator separator="," val="%{'Archer,Saber,Berserker,Caster,Assasin,Lancer'}">--%>
            <%--<s:iterator>--%>
                <%--<li class="list-group-item">--%>
                    <%--<s:property></s:property>--%>
                <%--</li>--%>
            <%--</s:iterator>--%>
        <%--</s:generator>--%>
    <%--</ul>--%>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>密码</th>
            <th>邮箱</th>
        </tr>
        <s:iterator value="users" var="obj">
            <tr>
                <td><s:property value="id"/></td>
                <td><s:property value="username"/></td>
                <td><s:property value="password"/></td>
                <td><s:property value="email"/></td>
            </tr>
        </s:iterator>
    </table>
</body>
</html>
