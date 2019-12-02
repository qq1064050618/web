<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改Emp</title>
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
            <form action="updateServ" type="post">
                <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">NAME</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputEmail3" placeholder="姓名" name="name" value="${emp.name}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">AGE</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="inputPassword3" placeholder="年龄" name="age" value="${emp.age}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPassword5" class="col-sm-2 col-form-label">SALARY</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="inputPassword5" placeholder="薪资" name="salary" value="${emp.salary}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">DEPT</label>
                    <div class="col-sm-10">
                        <select class="custom-select" name="deptId">
                            <c:forEach items="${depts}" var="dept">
                                <option value="${dept.deptId}" <c:if test="${dept.deptId == emp.deptId}">selected</c:if> >${dept.dname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <fieldset class="form-group">
                    <div class="row">
                        <legend class="col-form-label col-sm-2 pt-0">SEX</legend>
                        <div class="col-sm-10">
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="sex" id="gridRadios1" value="男" <c:if test="${emp.sex == '男'}">checked</c:if> >

                                <label class="form-check-label" for="gridRadios1">
                                    男
                                </label>
                            </div>
                            <div class="form-check">
                                    <input class="form-check-input" type="radio" name="sex" id="gridRadios2" value="女" <c:if test="${emp.sex == '女'}">checked</c:if> >
                                <label class="form-check-label" for="gridRadios2">
                                    女
                                </label>
                            </div>
                        </div>
                    </div>
                </fieldset>
                <input type="hidden" id="hid" name="empId" value="${emp.empId}">
                <div class="form-group row">
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary">UPDATE</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"/>
</body>
</html>