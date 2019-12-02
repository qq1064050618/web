<%--<%@ page import="java.util.List" %>
<%@ page import="com.moli.entity.Emp" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Emp查询</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">

</head>
<body>
<%--在真正的javaweb项目中，是不允许出现<% %>这种基本的jsp使用方式的
<%List<Emp> emps= (List<Emp>) request.getAttribute("emps");%>--%>

<div class="container">
    <div class="row">
        <div class="col">
            <table class="table table-striped table-dark">
                <thead>
                <tr>
                    <th scope="col">姓名</th>
                    <th scope="col">年龄</th>
                    <th scope="col">性别</th>
                    <th scope="col">薪资</th>
                    <th scope="col">部门</th>
                    <th scope="col">删除</th>
                    <th scope="col">更新</th>
                </tr>
                </thead>
                <tbody>
                <%--<% for (Emp emp:emps) { %>--%>
                <c:forEach items="${emps}" var="emp">
                    <tr>
                            <%-- <th scope="row"><%
                                 out.print(emp.getName());
                             %></th>--%>
                        <th scope="row">${emp.name}</th>
                        <td>${emp.age}</td>
                        <td>${emp.sex}</td>
                        <td>${emp.salary}</td>
                        <td>${emp.dept.dname}</td>
                            <%-- <td><%=emp.getDeptId()%></td>--%>
                        <td>
                            <button type="button" class="btn btn-outline-danger delete" data-id="${emp.empId}">delete</button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-secondary update" data-id="${emp.empId}">update</button>
                        </td>
                    </tr>
                </c:forEach>
                <%-- <%}%>--%>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/toAddEmpServ">
                        <button type="button" value="add" class="btn btn-outline-success">add</button>
                    </a></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script>
    $(function () {
        $(".delete").click(function () {

          /*经过jq封装过后，jq会把data-*数据封装成为一个名为data的类似于map的容器
          console.log($(this).data("id"));*/
      var id=this.dataset.id;
      location.href="deleteEmpServ?id=" + id;
        })

        $(".update").click(function () {
            var id=this.dataset.id;
            location.href="toUpdateServ?id=" + id;
        })
    })
</script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"/>
</body>
</html>
