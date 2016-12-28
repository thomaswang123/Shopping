<%--
  Created by IntelliJ IDEA.
  User: thomas.wang
  Date: 2016/12/23
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="css/admin.css" type="text/css" rel="stylesheet" media="all">
    <script src="js/jquery.min.js"></script>
    <script type="application/x-javascript">
        $(document).ready(function () {
            /*删除用户操作*/
            $(".deluser").click(function () {
                var id = $(this).attr("id");
                $.post("deluser.do",
                    {uid:""+id},function (data) {
                        alert(data);
                        //刷新当前页面
                        window.location.reload();
                    },"text");
            });


        });

    </script>
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
                <td style="width: 300px">地址</td>
                <td>其他操作</td>
            </tr>
            <c:forEach items="${sessionScope.userdata}" var="ud">
                <c:choose>
                    <c:when test="${ud.color%2!=0}">
                        <tr style="color: #FFFFFF;background-color: #3498DB">
                            <td>${ud.user.id}</td>
                            <td>${ud.user.account}</td>
                            <td>${ud.nickname}</td>
                            <td>${ud.sex}</td>
                            <td>${ud.age}</td>
                            <td>${ud.phone}</td>
                            <td>${ud.address}</td>
                            <td>
                                <input type="button"  class="deluser" id="${ud.user.id}" style="font-size: 20px;
                                color: red;cursor: hand" value="×删除">
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr style=";background-color: #5bb75b">
                            <td>${ud.user.id}</td>
                            <td>${ud.user.account}</td>
                            <td>${ud.nickname}</td>
                            <td>${ud.sex}</td>
                            <td>${ud.age}</td>
                            <td>${ud.phone}</td>
                            <td>${ud.address}</td>
                            <td>
                                <input type="button"  class="deluser"  id="${ud.user.id}"
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
