<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <style>
        .container2 {
            width: 500px;
            margin-top: 100px;
        }
        #tie{
            text-align: center;
            color: red;
            display:none;
        }
    </style>
</head>
<body>
<div class="container container2">
    <div class="row">
        <div class="col">
            <form action="addEmpServ" type="post">
                <div class="form-group row">
                    <label for="inputName" class="col-sm-2 col-form-label">NAME</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputName" placeholder="姓名" name="name">
                    </div>
                </div>
                <div id="tie">此用户已存在！</div>
                <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">AGE</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="inputPassword3" placeholder="年龄" name="age">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPassword5" class="col-sm-2 col-form-label">SALARY</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="inputPassword5" placeholder="薪资" name="salary">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">DEPT</label>
                    <div class="col-sm-10">
                        <select class="custom-select" name="deptId">
                            <option selected>---请选择所在部门---</option>
                            <c:forEach items="${depts}" var="dept">
                                <option value="${dept.deptId}">${dept.dname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <fieldset class="form-group">
                    <div class="row">
                        <legend class="col-form-label col-sm-2 pt-0">SEX</legend>
                        <div class="col-sm-10">
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="sex" id="gridRadios1" value="男"
                                       checked>
                                <label class="form-check-label" for="gridRadios1">
                                    男
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="sex" id="gridRadios2" value="女">
                                <label class="form-check-label" for="gridRadios2">
                                    女
                                </label>
                            </div>
                        </div>
                    </div>
                </fieldset>
                <div class="form-group row">
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary">SUBMIT</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script>
    $("#inputName").blur(function () {
       /* console.log($("#inputName").val());*/
       $.ajax({
            url: 'checkEmp',
            type: 'post',
            data: {name:$("#inputName").val()},
            success: function (data) {
                if (data.status == 10) {
                    $("#tie").css("display","block")
                }else {
                    $("#tie").css("display","none");
                }
            }
        })
    })
</script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"/>
</body>
</html>
