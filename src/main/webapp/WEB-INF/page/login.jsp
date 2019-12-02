<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录user</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <style>
        .container2 {
            width: 500px;
            margin-top: 100px;
        }
    </style>
</head>
<body>
<div class="container container2">
    <div class="row">
        <div class="col">
            <form action="loginServ" method="post" id="loginForm">
                <div class="form-group">
                    <label for="exampleInputEmail1">用户名</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="username"
                           placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name="password"
                           placeholder="Password">
                </div>
                <button type="button" class="btn btn-primary login">Login</button>
            </form>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script>
    $(".login").click(function () {
        $.ajax({
            url: 'loginServ',
            type: 'post',
            data: $("#loginForm").serialize(),
            success: function (data) {
                if (data.status == 0) {
                    location.href = "empServ";
                } else {
                    alert(data.message);
                }
            }
        })
    })
</script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"/>
</body>
</html>
