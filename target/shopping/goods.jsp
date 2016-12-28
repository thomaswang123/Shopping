<%--
  Created by IntelliJ IDEA.
  User: thomas.wang
  Date: 2016/12/27
  Time: 9:01
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
            <c:forEach items="${sessionScope.goodsdata}" var="gddata">
                <tr style="background-color: #c67605;color: #f3f3f3">
                    <td><img  style="width: 300px;height: 200px" src="images/${gddata.picture}"></td>
                    <td style="width:1000px;text-align: left">
                        <span>id:${gddata.id}</span>
                        <br>
                        <span>单价:${gddata.price}</span><br>
                        <span>名字:${gddata.name}</span>
                        <span style="margin-left: 800px"><input style="color: #FFFFFF;background-color: red" type="button" value="删除"></span> <br>
                        <span>库存:${gddata.repertory.number}</span><br>
                        <span>描述:${gddata.describe}</span> <br>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
