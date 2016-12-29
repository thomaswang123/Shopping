<%--
  Created by IntelliJ IDEA.
  User: thomas.wang
  Date: 2016/12/23
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>修改密码--蛋糕-shopping</title>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    }

    </script>
    <!-- //Custom Theme files -->
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
    <link href="css/style.css" type="text/css" rel="stylesheet" media="all">
    <link href="css/admin.css" type="text/css" rel="stylesheet" media="all">
    <!-- js -->
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    <!-- //js -->
    <!-- cart -->
    <script src="js/simpleCart.min.js"></script>
    <!-- cart -->
    <script type="application/x-javascript">
        $(document).ready(function () {

            /*用户管理点击页码进行刷新数据*/
            $(".connect").click(function () {
                var goods = parseInt($("#goodsnumber").val());
                alert(goods);
                /*进行颜色的变换*/
                var pagination = $(this).attr("id");
                var number = $("#select").val();
                $(".connect").css("color", "blue");
                $(this).css("color", "red");
                $("#thisPaginaTion").val(pagination);
                /*进行查询该页面下的数据发送请求*/
                $.post("pagination.do",
                    {number: "" + number, pagination: "" + pagination, goodsnumber: "" + goods}
                    , function (data) {
                        if (goods != 1 && goods != 2) {
                            /*刷新用户内联页面，展示新的数据*/
                            $('#iframeas').attr('src', $('#iframeas').attr('src'));
                        } else if (goods == 2) {
                            /*刷新管理员*/
                            $('#userRight').attr('src', $('#userRight').attr('src'));
                        } else {
                            /*刷新商品内联页面，展示新的数据*/
                            $('#goods').attr('src', $('#goods').attr('src'));
                        }
                    }, "text"
                );
            });

            /*显示单矿*/
            $("#addGoods").click(function () {
                $("#addGoodsdiv").toggle();
            })

            /*隐藏弹框*/
            $("#abolish").click(function () {
                $("#addGoodsdiv").hide();
            })


            /*选中页面数据数量并刷新页面*/
            /*       $("#select").change(function (){
             var number = $("#select").val();
             /!*进行查询该页面下的数据发送请求*!/
             $.post("intransit.do",
             {number: "" + number, pagination: "" + 1}
             );
             alert("Aaaa");
             });*/

            /*用户管理上一页*/
            $("#previousPage").click(function () {
                var goods = parseInt($("#goodsnumber").val());
                var number = $("#select").val();
                var val = $("#thisPaginaTion").val();
                var pagination = parseInt(val) - 1;
                if (pagination <= 1) {
                    pagination = 1;
                }
                $(".connect").css("color", "blue");
                $("#" + pagination).css("color", "red");
                $("#thisPaginaTion").val("" + pagination);
                /*  进行查询该页面下的数据发送请求*/
                $.post("pagination.do",
                    {number: "" + number, pagination: "" + pagination, goodsnumber: "" + goods}
                    , function (data) {
                        if (goods != 1 && goods != 2) {
                            /*刷新用户内联页面，展示新的数据*/
                            $('#iframeas').attr('src', $('#iframeas').attr('src'));
                        } else if (goods == 2) {
                            $('#userRight').attr('src', $('#userRight').attr('src'));
                        } else {
                            /*刷新商品内联页面，展示新的数据*/
                            $('#goods').attr('src', $('#goods').attr('src'));
                        }
                    }, "text");
            });

            /*用户管理下一页*/
            $("#nextPage").click(function () {
                var goods = parseInt($("#goodsnumber").val());
                var number = $("#select").val();
                var val = $("#thisPaginaTion").val();
                var pagination = parseInt(val) + 1;
                if (pagination > parseInt($("#maxPaginaTion").val())) {
                    pagination = pagination - 1;
                }
                $("#thisPaginaTion").val("" + pagination);
                $(".connect").css("color", "blue");
                $("#" + pagination).css("color", "red");
                /*  进行查询该页面下的数据发送请求*/
                $.post("pagination.do",
                    {number: "" + number, pagination: "" + pagination, goodsnumber: "" + goods}
                    , function (data) {
                        if (goods != 1 && goods != 2) {
                            /*刷新用户内联页面，展示新的数据*/
                            $('#iframeas').attr('src', $('#iframeas').attr('src'));
                        } else if (goods == 2) {
                            $('#userRight').attr('src', $('#userRight').attr('src'));
                        } else {
                            /*刷新商品内联页面，展示新的数据*/
                            $('#goods').attr('src', $('#goods').attr('src'));
                        }
                    }, "text"
                );
            });

            $("#submit").click(function () {
                $.post("addgoodsdata.do",
                    $("#addgoodsdata").serialize(),
                    function (data) {
                    alert(data);
                            /*刷新商品内联页面，展示新的数据*/
                    /*        $('#goods').attr('src', $('#goods').attr('src'));*/
                    }, "text");
            });
        });

        /*用户管理选中页面数据数量并刷新页面*/
        function chage(value) {
            var goodNumber = document.getElementById("goodsnumber").value;
            if (parseInt(goodNumber) == 1) {
                / *利用js发送商品管理请求*/
                window.location.href = "goods.do?number=" + value + "&pagination=1";
            } else if (parseInt(goodNumber) == 2) {
                / *利用js发送管理员请求*/
                window.location.href = "userRight.do?number=" + value + "&pagination=1";
            } else {
                /   *利用js发送用户管理请求*/
                window.location.href = "userControl.do?number=" + value + "&pagination=1";
            }
        }
    </script>
</head>
<body>
<%--标记作用--%>
<c:choose>
    <c:when test="${sessionScope.goodsdata!=null}">
        <input id="goodsnumber" value="1">
    </c:when>
    <c:when test="${sessionScope.userRight!=null}">
        <input id="goodsnumber" value="2">
    </c:when>
    <c:otherwise>
        <input id="goodsnumber" value="0">
    </c:otherwise>
</c:choose>

<%--添加商品的弹框--%>
<div id="addGoodsdiv" style=" position: absolute;width:600px;height: 300;
background-color: #7ab5d3;margin-left: 500px;margin-top:250px
;border-width: 1px; border-style: solid; padding: 1px;display: none;
 ">
    <%--添加的商品信息--%>


    <form id="addgoodsdata"  action="upload.do" method="post" enctype="multipart/form-data">
        <div style="float:left;width: 300;height: 300;border-width: 1px; border-style: solid; padding: 1px;">
            <%--   <span><img src="images/g3.png" style="width: 300;height: 300"></span>--%>
            <input name="file" type="file" value="添加图片">
        </div>
        <div style="float: left">
            <ul style="list-style: none;margin-top: 60px;margin: 20px">
                <c:if test="${sessionScope.goodsdata!=null}">
                    <li><label>商品编号id:<b>${requestScope.maxid}</b></label></li>
                    <input name="goodsid" value="${requestScope.maxid}" style="display: none">
                </c:if>
                <li><label>商品名称: </label><input type="text" name="goodsname"></li>
                <li><label>商品单价: </label><input type="text" name="goodsprivce"></li>
                <li><label>商品数量: </label><input type="text" name="goodsnumber"></li>
                <li><label>商品描述: </label><input type="text" name="gdsdescribe"></li>
            </ul>
        </div>
        <div style="float: left;margin-left: 20px;margin-top: 20px">
            <span> <input id="submit" type="submit" value="提交"></span>
            <span><input style="margin-left: 50px" type="button" id="abolish" value="取消"></span>
        </div>
    </form>
</div>
<!--header-->
<div class="header">
    <div class="container">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <h1 class="navbar-brand"><a href="Index.html">Yummy</a></h1>
            </div>
            <!--navbar-header-->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="Index.html" class="active">主页</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Birthday<b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-4">
                            <div class="row">
                                <div class="col-sm-3">
                                    <h4>By Relation</h4>
                                    <ul class="multi-column-dropdown">
                                        <li><a class="list" href="products.html">Friend</a></li>
                                        <li><a class="list" href="products.html">Lover</a></li>
                                        <li><a class="list" href="products.html">Sister</a></li>
                                        <li><a class="list" href="products.html">Brother</a></li>
                                        <li><a class="list" href="products.html">Kids</a></li>
                                        <li><a class="list" href="products.html">Parents</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-3">
                                    <h4>By Flavour</h4>
                                    <ul class="multi-column-dropdown">
                                        <li><a class="list" href="products.html">Chocolate</a></li>
                                        <li><a class="list" href="products.html">Mixed Fruit</a></li>
                                        <li><a class="list" href="products.html">Butterscotch</a></li>
                                        <li><a class="list" href="products.html">Strawberry</a></li>
                                        <li><a class="list" href="products.html">Vanilla</a></li>
                                        <li><a class="list" href="products.html">Eggless Cakes</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-3">
                                    <h4>By Theme</h4>
                                    <ul class="multi-column-dropdown">
                                        <li><a class="list" href="products.html">Heart shaped</a></li>
                                        <li><a class="list" href="products.html">Cartoon Cakes</a></li>
                                        <li><a class="list" href="products.html">2-3 Tier Cakes</a></li>
                                        <li><a class="list" href="products.html">Square shape</a></li>
                                        <li><a class="list" href="products.html">Round shape</a></li>
                                        <li><a class="list" href="products.html">Photo cakes</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-3">
                                    <h4>Weight</h4>
                                    <ul class="multi-column-dropdown">
                                        <li><a class="list" href="products.html">1 kG</a></li>
                                        <li><a class="list" href="products.html">1.5 kG</a></li>
                                        <li><a class="list" href="products.html">2 kG</a></li>
                                        <li><a class="list" href="products.html">3 kG</a></li>
                                        <li><a class="list" href="products.html">4 kG</a></li>
                                        <li><a class="list" href="products.html">Large</a></li>
                                    </ul>
                                </div>
                            </div>
                        </ul>
                    </li>
                    <li class="dropdown grid">
                        <a href="#" class="dropdown-toggle list1" data-toggle="dropdown">Wedding<b
                                class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-4">
                            <div class="row">
                                <div class="col-sm-3">
                                    <h4>By Relation</h4>
                                    <ul class="multi-column-dropdown">
                                        <li><a class="list" href="products.html">Friend</a></li>
                                        <li><a class="list" href="products.html">Lover</a></li>
                                        <li><a class="list" href="products.html">Sister</a></li>
                                        <li><a class="list" href="products.html">Brother</a></li>
                                        <li><a class="list" href="products.html">Kids</a></li>
                                        <li><a class="list" href="products.html">Parents</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-3">
                                    <h4>By Flavour</h4>
                                    <ul class="multi-column-dropdown">
                                        <li><a class="list" href="products.html">Chocolate</a></li>
                                        <li><a class="list" href="products.html">Mixed Fruit</a></li>
                                        <li><a class="list" href="products.html">Butterscotch</a></li>
                                        <li><a class="list" href="products.html">Strawberry</a></li>
                                        <li><a class="list" href="products.html">Vanilla</a></li>
                                        <li><a class="list" href="products.html">Eggless Cakes</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-3">
                                    <h4>By Theme</h4>
                                    <ul class="multi-column-dropdown">
                                        <li><a class="list" href="products.html">Heart shaped</a></li>
                                        <li><a class="list" href="products.html">Cartoon Cakes</a></li>
                                        <li><a class="list" href="products.html">2-3 Tier Cakes</a></li>
                                        <li><a class="list" href="products.html">Square shape</a></li>
                                        <li><a class="list" href="products.html">Round shape</a></li>
                                        <li><a class="list" href="products.html">Photo cakes</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-3">
                                    <h4>Weight</h4>
                                    <ul class="multi-column-dropdown">
                                        <li><a class="list" href="products.html">1 kG</a></li>
                                        <li><a class="list" href="products.html">1.5 kG</a></li>
                                        <li><a class="list" href="products.html">2 kG</a></li>
                                        <li><a class="list" href="products.html">3 kG</a></li>
                                        <li><a class="list" href="products.html">4 kG</a></li>
                                        <li><a class="list" href="products.html">Large</a></li>
                                    </ul>
                                </div>
                            </div>
                        </ul>
                    </li>
                    <li class="dropdown grid">
                        <a href="#" class="dropdown-toggle list1" data-toggle="dropdown">Special Offers <b
                                class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-4">
                            <div class="row">
                                <div class="col-sm-3">
                                    <h4>By Relation</h4>
                                    <ul class="multi-column-dropdown">
                                        <li><a class="list" href="products.html">Friend</a></li>
                                        <li><a class="list" href="products.html">Lover</a></li>
                                        <li><a class="list" href="products.html">Sister</a></li>
                                        <li><a class="list" href="products.html">Brother</a></li>
                                        <li><a class="list" href="products.html">Kids</a></li>
                                        <li><a class="list" href="products.html">Parents</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-3">
                                    <h4>By Flavour</h4>
                                    <ul class="multi-column-dropdown">
                                        <li><a class="list" href="products.html">Chocolate</a></li>
                                        <li><a class="list" href="products.html">Mixed Fruit</a></li>
                                        <li><a class="list" href="products.html">Butterscotch</a></li>
                                        <li><a class="list" href="products.html">Strawberry</a></li>
                                        <li><a class="list" href="products.html">Vanilla</a></li>
                                        <li><a class="list" href="products.html">Eggless Cakes</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-3">
                                    <h4>By Theme</h4>
                                    <ul class="multi-column-dropdown">
                                        <li><a class="list" href="products.html">Heart shaped</a></li>
                                        <li><a class="list" href="products.html">Cartoon Cakes</a></li>
                                        <li><a class="list" href="products.html">2-3 Tier Cakes</a></li>
                                        <li><a class="list" href="products.html">Square shape</a></li>
                                        <li><a class="list" href="products.html">Round shape</a></li>
                                        <li><a class="list" href="products.html">Photo cakes</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-3">
                                    <h4>Weight</h4>
                                    <ul class="multi-column-dropdown">
                                        <li><a class="list" href="products.html">1 kG</a></li>
                                        <li><a class="list" href="products.html">1.5 kG</a></li>
                                        <li><a class="list" href="products.html">2 kG</a></li>
                                        <li><a class="list" href="products.html">3 kG</a></li>
                                        <li><a class="list" href="products.html">4 kG</a></li>
                                        <li><a class="list" href="products.html">Large</a></li>
                                    </ul>
                                </div>
                            </div>
                        </ul>
                    </li>
                    <li class="dropdown grid">
                        <a href="#" class="dropdown-toggle list1" data-toggle="dropdown">Store<b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-3">
                            <div class="row">
                                <div class="col-sm-4">
                                    <h4>By Relation</h4>
                                    <ul class="multi-column-dropdown">
                                        <li><a class="list" href="products.html">Friend</a></li>
                                        <li><a class="list" href="products.html">Lover</a></li>
                                        <li><a class="list" href="products.html">Sister</a></li>
                                        <li><a class="list" href="products.html">Brother</a></li>
                                        <li><a class="list" href="products.html">Kids</a></li>
                                        <li><a class="list" href="products.html">Parents</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-4">
                                    <h4>By Flavour</h4>
                                    <ul class="multi-column-dropdown">
                                        <li><a class="list" href="products.html">Chocolate</a></li>
                                        <li><a class="list" href="products.html">Mixed Fruit</a></li>
                                        <li><a class="list" href="products.html">Butterscotch</a></li>
                                        <li><a class="list" href="products.html">Strawberry</a></li>
                                        <li><a class="list" href="products.html">Vanilla</a></li>
                                        <li><a class="list" href="products.html">Eggless Cakes</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-4">
                                    <h4>Specials</h4>
                                    <ul class="multi-column-dropdown">
                                        <li><a class="list" href="products.html">Ice cream cake</a></li>
                                        <li><a class="list" href="products.html">Swiss roll</a></li>
                                        <li><a class="list" href="products.html">Ruske kape</a></li>
                                        <li><a class="list" href="products.html">Cupcakes</a></li>
                                        <li><a class="list" href="products.html">Muffin</a></li>
                                        <li><a class="list" href="products.html">Merveilleux</a></li>
                                    </ul>
                                </div>
                            </div>
                        </ul>
                    </li>
                </ul>
                <!--/.navbar-collapse-->
            </div>
            <!--//navbar-header-->
        </nav>
        <div class="header-info">
            <div class="header-right search-box">
                <a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>
                <div class="search">
                    <form class="navbar-form">
                        <input type="text" class="form-control">
                        <button type="submit" class="btn btn-default" aria-label="Left Align">
                            搜索
                        </button>
                    </form>
                </div>
            </div>
            <div class="header-right login">
                <a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
                <div id="loginBox">
                    <form id="loginForm" action="login.do?url=admin" method="post">
                        <fieldset id="body">
                            <fieldset>
                                <c:choose>
                                <c:when test="${sessionScope.userinfo==null}">
                                <div style="color: red">请登录！!</div>
                                <fieldset>
                                    <label for="email">账号</label>
                                    <input type="text" name="username" id="email">
                                </fieldset>
                                <fieldset>
                                    <label for="password">密码</label>
                                    <input type="password" name="password" id="password">
                                </fieldset>
                                <input type="submit" id="login" value="登陆">
                                <!--	<label for="checkbox"><input type="checkbox" id="checkbox"> <i>记住账号</i></label>-->
                            </fieldset>
                            <p>没有账号吧？<a class="sign" href="register.html">点击注册</a> <span><a
                                    href="changePassword.jsp">忘记密码?</a></span>
                            </p>
                            </c:when>
                            <c:otherwise>
                            <div>
                                <h4
                                <span>欢迎:</span>
                                <span>
                                    <a href="#" style="color: #0e90d2;">${sessionScope.userinfo.nickname}</a>
                                </span>
                                <c:choose>
                                    <c:when test="${sessionScope.admin>0}">
                                        <span style="margin-left: 20px"><a
                                                href="userControl.do?number=10&pagination=1"><img
                                                src="images/admin.png"><span
                                                style="color: red">管理中心</span> </a></span>
                                        <span style="margin-left: 20px;color: red">Lv:</span><span
                                            style="color:red">${sessionScope.admin}</span>
                                    </c:when>
                                    <c:otherwise></c:otherwise>
                                </c:choose>
                                </h4>
                                <h5 style="margin-top: 15px">
                                    <span><a href="switchover.do?url=index"><img src="images/login.png"><span
                                            style="padding-top: 10px">切换账号</span></a></span>
                                    <span style="color: red;margin-left: 70px;margin-top: 10px"><a
                                            href="switchover.do?url=index">退出</a></span>
                                </h5>
                            </div>
                            </c:otherwise>
                            </c:choose>
                    </form>
                </div>
            </div>
            <c:if test="${sessionScope.userinfo==null}">
                <div class="header-right cart">
                    <a href="#"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a>
                    <div class="cart-box">
                        <h4>
                            <a href="#">
                        <span  style="color: red">
                            请先登录！
                        </span>

                            </a></h4>
                        <p><a href="javascript:;" class="simpleCart_empty">清空购物车</a></p>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </c:if>
            <c:if test="${sessionScope.userinfo!=null}">
                <div class="header-right cart">
                    <a href="#"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a>
                    <div class="cart-box">
                        <h4>
                            <a href="showCheckout.do">
                        <span class="simpleCart_total" style="color: red"> $0.0
                        </span>
                                (<span id="simpleCart_quantity"  class="simpleCart_quantity"> 0 </span>)
                            </a></h4>
                        <p><a href="javascript:;" class="simpleCart_empty">清空购物车</a></p>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </c:if>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</div>
<!--菜单栏-->
<div class="left_menu">
    <div class="left_menuzi">
        <h3>
            <span><a class="user" href="userControl.do?number=10&pagination=1">用户管理</a></span>
            <span><a class="sp" href="goods.do?number=10&pagination=1">商品管理</a></span>
            <span><a class="jurisdiction" href="userRight.do?number=10&pagination=1">权限管理</a></span>
            <%--            <span><a class="tongji" href="#">销售统计</a></span>--%>
        </h3>
    </div>
</div>
<!--具体操作展示数据-->
<div class="certen_menu">
    <div style="margin-top: 20px;margin-left: 150px">
        <span>显示:</span>
        <span>
        <select id="select" onchange="chage(this.value)">
                  <option selected>当前值:${requestScope.datanumber}</option>
                   <option>10</option>
                  <option>20</option>
                  <option>30</option>
            </select>
    </span>
        <span style="margin-left: 20px">数量:<label id="number"><b>${requestScope.numbersum}</b></label></span>
        <c:if test="${sessionScope.goodsdata!=null}">
             <span style="margin-left: 60px">
            <input type="button" style="width:100px;height: 25px" id="addGoods" value="+添加商品">
        </span>
        </c:if>
        <span style="margin-left: 100px">
         类型：
            <c:choose>
                <c:when test="${sessionScope.goodsdata!=null}">
                    <select class="selectGoods">
                         <option>id</option>
                         <option>商品名称</option>
                         <option>商品单价</option>
                   </select>
                </c:when>
                <c:when test="${sessionScope.userRight!=null}">
                     <select class="selectGoods">
                         <option>id</option>
                         <option>账号</option>
                         <option>级别</option>
                      </select>
                </c:when>
                <c:otherwise>
                        <select style="width: 90px" class="selectuser">
                         <option>id</option>
                         <option>账号</option>
                         <option>姓名</option>
                         <option>性别</option>
                         <option>年龄</option>
                         <option>电话</option>
                         <option>地址</option>
                  </select>
                </c:otherwise>
            </c:choose>
         <input type="text" style="margin-left: 10px;width: 200px;height: 25px" placeholder="请输入相关类型信息">
            <!--   <input type="button" value="查询" style="margin-left: 20px;width: 80px;height:25px ">-->
    </span>
        <span style="margin-left: 300px"><a><img src="images/shuanxin.png">刷新</a></span>
    </div>

    <%--内联页面--%>
    <c:choose>
        <c:when test="${sessionScope.goodsdata!=null}">
            <iframe src="goods.jsp" id="goods" frameBorder="0" scrolling="no"
                    style="width:90%;height: 660px;"></iframe>
        </c:when>
        <c:when test="${sessionScope.userRight!=null}">
            <iframe src="jurisdiction.jsp" id="userRight" frameBorder="0"
                    scrolling="no" style="width:90%;height: 660px;"></iframe>
        </c:when>
        <c:otherwise>
            <iframe src="usertable.jsp" id="iframeas" class="iframea yang"
                    frameBorder="0" scrolling="no"></iframe>
        </c:otherwise>
    </c:choose>
    <div style="margin-left: 950px">
        <%--用来记录当前的页码--%>
        <input id="thisPaginaTion" value="1" style="display: none">
        <select id="maxPaginaTion" style="display: none">
            <option selected>${requestScope.number}</option>
        </select>
        <b>
            <c:choose>
                <%-- 只有一页--%>
            <c:when test="${requestScope.number==1||requestScope.number==0}">
            </c:when>
            <c:otherwise>
            <span><a href="#" id="previousPage">上一页</a></span>
                <%--页面数--%>
            <c:choose>
                <c:when test="${requestScope.number<10&&requestScope.number>1}">
                    <c:forEach var="i" begin="1" end="${requestScope.number}">
                        <c:choose>
                            <c:when test="${i==1}">
                                <span style="margin-left: 10px"><a class="connect" id="${i}"
                                                                   onclick="conncet(this.id,this.class)" href="#"
                                                                   style="color: red;font-size: 20px">${i}</a></span>
                            </c:when>
                            <c:otherwise>
                                <span style="margin-left: 10px;color:#006dcc"><a class="connect" id="${i}"
                                                                                 onclick="conncet(this.id,this.class)"
                                                                                 href="#"
                                                                                 style="font-size: 20px">${i}</a></span>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:when>
                <c:when test="${requestScope.number>10}">
                    <c:forEach var="i" begin="1" end="${7}">
                        <span style="margin-left: 10px"><a class="connect" id="${i}"
                                                           onclick="conncet(this.id,this.class)" href="#"
                                                           style="font-size: 20px">${i}</a></span>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <span>...</span>
                    <span style="margin-left: 10px">
                       <a href="#" id="${requestScope.number}">${requestScope.number}</a>
                    </span>
                </c:otherwise>
            </c:choose>
            <span>
        <input type="text" style="width: 25px;height: 20;margin-left: 10px">
        <input type="button" value="跳转" id="buttonhref" style="text-align: center;margin-left: 10px">
        </span>
            <span style="margin-left: 10px"><a href="#" id="nextPage">下一页</a></span>
        </b>
    </div>
    </c:otherwise>
    </c:choose>
</div>
<%--<br>
<!--footer-->
<div class="footer-bottom">
    <div class="container">
        <p>Copyright &copy; 2015.Company name All rights reserved</p>
    </div>
</div>--%>
</body>
</html>
