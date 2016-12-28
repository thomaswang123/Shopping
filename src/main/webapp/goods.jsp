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
    <script src="js/jquery.min.js"></script>
    <script type="application/x-javascript">
        $(document).ready(function () {
            /*修改商品操作*/
            $(".alert").click(function () {
                $(".label").text(""+$(this).attr('id'));
                $("#img").attr("src","images/"+$(this).attr('name'));
                $("#alertGoodsdiv").show();
            });

            /*取消操作*/
            $("#abolish").click(function () {
                $("#alertGoodsdiv").hide();
            });
        });

    </script>
</head>
<body>
<div id="alertGoodsdiv" style=" position: absolute;width:600px;height: 300;
background-color: #7ab5d3;margin-left: 450px;margin-top:200px
;border-width: 1px; border-style: solid; padding: 1px;display: none;
 ">
    <div style="float: left">
        <img  id="img" style="width: 300px;height: 300px">
    </div>
    <div style="float: left">
        当前修改的商品id是:<label class="label"></label><br>
        单价: <input  style="margin-top: 10px" type="text"><br>
        名字: <input  style="margin-top: 10px" type="text"><br>
        描述: <input  style="margin-top: 10px;width: 230px" type="text"><br>
        库存: <input  style="margin-top: 10px" type="text"><br>
    </div>
    <div style="margin-top: 20px;float: left">
        <span style="margin-left: 10px"> <input type="button" value="提交"> </span>
        <span><input id="abolish" type="button" value="取消"></span>
    </div>
</div>
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
                        <span style="margin-left: 800px">
                           <span><input class="alert" id="${gddata.id}" name="${gddata.picture}" style="color: #FFFFFF;background-color: #5B9922" type="button" value="修改"></span>
                            <span><input style="color: #FFFFFF;background-color: red" type="button" value="删除"></span>
                        </span> <br>
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
