<%--
  Created by IntelliJ IDEA.
  User: thomas.wang
  Date: 2016/12/27
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="css/admin.css" type="text/css" rel="stylesheet" media="all">
</head>
<body>
<!--展示数据-->
<div style="margin-top: 20px;margin-left: 100px;margin-right: 25px">
    <div style="height:620px;overflow-y:scroll; border:1px solid;">
        <table style="text-align: center " class="usertable">
            <tr style="background-color: #c67605;color: #f3f3f3;;">
                <td>id</td>
                <td>账号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>年龄</td>
                <td>电话</td>
                <td>地址</td>
                <td>其他操作</td>
            </tr>
            <c:forEach items="${sessionScope.userRight}" var="ur">
                <c:choose>
                    <c:when test="${ur.color%2!=0}">
                        <tr style="color: #FFFFFF;background-color: #3498DB">
                            <td>${ur.user.id}</td>
                            <td>${ur.user.account}</td>
                            <td>${ur.nickname}</td>
                            <td>${ur.sex}</td>
                            <td>${ur.age}</td>
                            <td>${ur.phone}</td>
                            <td style="color:#FFFFFF;width: 40px"><b>${ur.classes}</b></td>
                            <td>
                              设置级别: <select>
                                    <option selected>当前级别：${ur.classes}</option>
                                    <option>3</option>
                                    <option>2</option>
                                    <option>1</option>
                                    <option>0</option>
                                </select>
                                <input type="button"  class="deluser" id="${ur.user.id}" style="font-size: 20px;
                                color: red;cursor: hand" value="×删除">
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr style=";background-color: #5bb75b">
                            <td>${ur.user.id}</td>
                            <td>${ur.user.account}</td>
                            <td>${ur.nickname}</td>
                            <td>${ur.sex}</td>
                            <td>${ur.age}</td>
                            <td>${ur.phone}</td>
                            <td style="color:  #FFFFFF"><b>${ur.classes}</b></td>
                            <td>
                                设置级别:  <select>
                                    <option selected>当前级别：${ur.classes}</option>
                                    <option>3</option>
                                    <option>2</option>
                                    <option>1</option>
                                    <option>0</option>
                                </select>
                                <input type="button"  class="deluser"  id="${ur.user.id}"
                                       style="font-size: 20px;color: red;cursor: hand" value="×删除">
                            </td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
