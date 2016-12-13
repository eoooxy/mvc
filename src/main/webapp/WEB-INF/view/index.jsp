<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>login test</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bas/index.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>
</head>
<body>
<form id="form_login" action="">
    <table>
        <tr>
            <td>用户名</td>
            <td><input id="userName" name="userName"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input id="userPassword" name="userPassword"></td>
        </tr>
        <tr>
            <td><input type="button" value="确定" onclick="login()"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
