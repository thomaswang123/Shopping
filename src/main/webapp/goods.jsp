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
                $(".label").text("" + $(this).attr('id'));
                $(".id").val("" + $(this).attr('id'));
                $("#img").attr("src",""+$(this).attr('name'));
                $("#goodsNumber").val("0");
                $("#alertGoodsdiv").show();
            });

            /*删除商品*/
            $(".delete").click(function () {
                $(".delLabel").text("" + $(this).attr('id'));
                $(".id").val("" + $(this).attr('id'));
                $("#delGoodsdiv").show();
            });

            /*后台删除*/
            $("#delSubmit").click(function () {
                $.post("delGoods.do",
                    $("#delGoods").serialize(),
                    function (data) {

                        if(data!=null||data!="") {
                            //刷新admin.jsp
                            window.parent.location.reload();
                            //刷新当前页面
                            window.location.reload();
                        }
                    }, "text");
            });

            /*取消删除*/
            $("#delAbolish").click(function () {
                $("#delGoodsdiv").hide();
            });

            /*取消操作*/
            $("#abolish").click(function () {
                $("#alertGoodsdiv").hide();
            });


            $("#submit").click(function () {
                $.post("alertGoods.do",
                    $("#alertGoods").serialize(),
                    function (data) {
                        var datas = data;
                        if (datas != "no") {

                            $("#price" + $(".id").val()).text($("#price").val());
                            $("#name" + $(".id").val()).text($("#goodsName").val());
                            $("#number" + $(".id").val()).text($("#goodsNumber").val());
                            $("#describe" + $(".id").val()).text($("#describe").val());
                            $(".goodsdata").val("");
                            $("#alertGoodsdiv").hide();
                        } else {
                            $(".goodsdata").val("");
                            alert("金币不能为空，名字不能为空，库存不能为空");
                        }
                    }, "text");
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
        <img id="img" style="width: 300px;height: 300px">
    </div>
    <form id="alertGoods">
        <div style="float: left">
            当前修改的商品id是:<label class="label"></label><br>
            <input name="goodsId" style="display: none" class="id">
            单价: <input class="goodsdata" style="margin-top: 10px" type="text" name="price" id="price"><br>
            名字: <input class="goodsdata" style="margin-top: 10px" type="text" name="goodsName" id="goodsName"><br>
            描述: <input class="goodsdata" style="margin-top: 10px;width: 230px" type="text" name="describe"
                       id="describe"><br>
            库存: <input class="goodsdata" style="margin-top: 10px" type="text" name="goodsNumber" id="goodsNumber"><br>
        </div>
        <div style="margin-top: 20px;float: left">
            <span style="margin-left: 10px"> <input type="button" id="submit" value="提交"> </span>
            <span><input id="abolish" type="button" value="取消"></span>
        </div>
    </form>
</div>

<%--删除--%>
<div id="delGoodsdiv" style=" position: absolute;width:600px;height: 300;
background-color: #7ab5d3;margin-left: 450px;margin-top:200px
;border-width: 1px; border-style: solid; padding: 1px;display: none;
 ">
    <form id="delGoods" method="post">
        当前删除商品id是:<label class="delLabel"></label><br>
        <input name="goodsId" style="display: none" class="id">
        <input id="number" name="number" value="${sessionScope.number}" style="display: none">
        <span style="margin-left: 10px">
                <input type="button" id="delSubmit" value="提交"> </span>
        <span><input id="delAbolish" type="button" value="取消"></span>
    </form>
</div>
<!--展示数据-->
<div style="margin-top: 20px;margin-left: 100px;margin-right: 25px">
    <div style="height:620px;overflow-y:scroll; border:1px solid;">
        <table style="text-align: center " class="usertable">
            <c:forEach items="${sessionScope.goodsdata}" var="gddata">
                <tr style="background-color: #c67605;color: #f3f3f3">
                    <td><img style="width: 300px;height: 200px" src="${gddata.picture}"></td>
                    <td style="width:1000px;text-align: left">
                        <span>id:${gddata.id}</span>
                        <br>
                        <span>单价:</span> <span id="price${gddata.id}">${gddata.price}</span><br>
                        <span>名字:</span>  <span id="name${gddata.id}">${gddata.name}</span>
                        <span style="margin-left: 800px">
                           <span><input class="alert" id="${gddata.id}" name="${gddata.picture}"
                                        style="color: #FFFFFF;background-color: #5B9922" type="button"
                                        value="修改"></span>
                            <span><input style="color: #FFFFFF;background-color: red" type="button" id="${gddata.id}"
                                         class="delete" value="删除"></span>
                        </span> <br>
                        <span>库存:</span> <span id="number${gddata.id}">${gddata.repertory.number}</span><br>
                        <span>描述: </span> <span id="describe${gddata.id}">${gddata.describe}</span> <br>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
