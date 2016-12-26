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
            $(".user").click(function () {
                $(".yang").hide();
                $(".selectuser").show();
                $(".selectsp").hide();
                $(".iframea").show();
            });
            $(".sp").click(function () {
                $(".yang").hide();
                $(".selectuser").hide();
                $(".selectsp").show();
                $(".iframesp").show();
            });
            $(".jurisdiction").click(function () {
                $(".yang").hide();
                $(".jurisdiction_s").display = "block";
            });
            $(".tongji").click(function () {
                $(".yang").hide();
                $(".tongji_iframe").display = "block";
            });

            /*点击页码进行刷新数据*/
            $(".connect").click(function () {
                /*进行颜色的变换*/
                var pagination = $(this).attr("id");
                var number = $("#select").val();
                $(".connect").css("color", "blue");
                $(this).css("color", "red");
                /*进行查询该页面下的数据发送请求*/
                $.post("pagination.do",
                    {number: "" + number, pagination: "" + pagination}
                    , function (data) {
                      /*刷新用户内联页面，展示新的数据*/
                        $('#iframeas').attr('src', $('#iframeas').attr('src'));
                    }, "text"
                );


            });
        });
    </script>
</head>
<body>
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
                                                href="adminOperation.do?number=10&pagination=1"><img
                                                src="images/admin.png"><span
                                                style="color: red">管理中心</span> </a></span>
                                        <span style="margin-left: 20px;color: red">Lv:</span><span
                                            style="color:red">${sessionScope.admin}</span>
                                    </c:when>
                                    <c:otherwise></c:otherwise>
                                </c:choose>
                                </h4>
                                <h5 style="margin-top: 15px">
                                    <span><a href="switchover.do?url=admin"><img src="images/login.png"><span
                                            style="padding-top: 10px">切换账号</span></a></span>
                                    <span style="color: red;margin-left: 70px;margin-top: 10px"><a
                                            href="switchover.do?url=admin">退出</a></span>
                                </h5>
                            </div>
                            </c:otherwise>
                            </c:choose>
                    </form>
                </div>
            </div>
            <div class="header-right cart">
                <a href="#"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a>
                <div class="cart-box">
                    <h4><a href="Checkout.html">
                        <span class="simpleCart_total" style="color: red"> $0.00 </span> (<span id="simpleCart_quantity"
                                                                                                class="simpleCart_quantity"> 0 </span>)
                    </a></h4>
                    <p><a href="javascript:;" class="simpleCart_empty">清空购物车</a></p>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</div>
</div>
<!--菜单栏-->
<div class="left_menu">
    <div class="left_menuzi">
        <h3>
            <span><a class="user" href="#">用户管理</a></span>
            <span><a class="sp" href="#">商品管理</a></span>
            <span><a class="jurisdiction" href="#">权限管理</a></span>
            <span><a class="tongji" href="#">销售统计</a></span>
        </h3>
    </div>
</div>
<!--具体操作展示数据-->
<div class="certen_menu">
    <div style="margin-top: 20px;margin-left: 150px">
        <span>显示:</span>
        <span>
        <select id="select" ="">
            <option selected value="10">10</option>
            <option>20</option>
            <option>30</option>
            </select>
    </span>
        <span style="margin-left: 20px">数量:<label id="number"><b>${requestScope.numbersum}</b></label></span>
        <span style="margin-left: 190px">
         类型：<select style="width: 90px" class="selectuser">
                <option>id</option>
                <option>账号</option>
                <option>姓名</option>
                <option>性别</option>
                <option>年龄</option>
                <option>电话</option>
                <option>地址</option>
        </select>
            <select class="selectsp">
                <option>id</option>
                <option>商品名称</option>
                <option>商品单价</option>
                <option>商品评分</option>
            </select>
         <input type="text" style="margin-left: 10px;width: 200px;height: 25px" placeholder="请输入相关类型信息">
            <!--   <input type="button" value="查询" style="margin-left: 20px;width: 80px;height:25px ">-->
    </span>
        <span style="margin-left: 300px"><a><img src="images/shuanxin.png">刷新</a></span>
    </div>
    <iframe src="usertable.jsp" id="iframeas" class="iframea yang" frameBorder="0" scrolling="no"></iframe>
    <iframe src="Shopping.html" class="iframesp yang" frameBorder="0" scrolling="no"></iframe>
    <iframe src="UserTable.html" class="jurisdiction_s yang" frameBorder="0" scrolling="no"></iframe>
    <iframe src="UserTable.html" class="tongji_iframe yang" frameBorder="0" scrolling="no"></iframe>
    <div style="margin-left: 1100px">
        <%--用来记录当前的页码--%>
        <input id="thisPaginaTion" value="1" style="display: none">
        <b>
            <c:choose>
                <%-- 只有一页--%>
            <c:when test="${requestScope.number==1&&requestScope==0}">
            </c:when>
            <c:otherwise>
            <span><a href="#">上一页</a></span>
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
                                     href="#" style="font-size: 20px">${i}</a></span>
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
                       <a href="#">${requestScope.number}</a>
                    </span>
                </c:otherwise>
            </c:choose>
            <span>
        <input type="text" style="width: 25px;height: 20;margin-left: 10px">
        <input type="button" value="跳转" id="buttonhref" style="text-align: center;margin-left: 10px">
        </span>
            <span style="margin-left: 10px"><a href="#">下一页</a></span>
        </b>
    </div>
    </c:otherwise>
    </c:choose>
</div>
<!--footer-->
<div class="footer-bottom">
    <div class="container">
        <p>Copyright &copy; 2015.Company name All rights reserved</p>
    </div>
</div>
</body>
</html>
