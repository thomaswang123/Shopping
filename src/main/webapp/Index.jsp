<%--
Created by IntelliJ IDEA.
User: thomas.wang
Date: 2016/12/20
Time: 14:45
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>蛋糕——shoopping</title>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- //Custom Theme files -->
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
    <link href="css/style.css" type="text/css" rel="stylesheet" media="all">
    <!-- js -->
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    <!-- //js -->
    <!-- cart -->
    <script src="js/simpleCart.min.js"></script>
    <!-- cart -->
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
                            开始搜索
                        </button>
                    </form>
                </div>
            </div>
            <div class="header-right login">
                <a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
                <div id="loginBox">
                    <form id="loginForm" action="login.do" method="post">
                        <fieldset id="body">
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
                        <p>没有账号吧？<a class="sign" href="Account.html">点击注册</a> <span><a href="Change_Password.jsp">忘记密码?</a></span>
                        </p>
                        </c:when>
                        <c:otherwise>
                            <div>
                                <h4
                                <span>欢迎:</span>
                                <span>
                                    <a href="#" style="color: #0e90d2;">${sessionScope.userinfo.uinfo_nickname}</a>
                                </span>
                                <c:choose>
                                <c:when test="${sessionScope.admin>0}">
                                <span style="margin-left: 20px"><a href="#"><img src="images/admin.png"><span style="color: red">管理中心</span> </a></span>
                                 <span style="margin-left: 20px;color: red">Lv:</span><span style="color:red">${sessionScope.admin}</span>
                                </c:when>
                                <c:otherwise></c:otherwise>
                                </c:choose>
                                </h4>
                                <h5 style="margin-top: 15px">
                                    <span><a href="switchover.do"><img src="images/login.png"><span style="padding-top: 10px">切换账号</span></a></span>
                                    <span style="color: red;margin-left: 70px;margin-top: 10px"><a href="switchover.do">退出</a></span>
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
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!--//header-->
<!--banner-->
<div class="banner">
    <div class="container">
        <h2 class="hdng">Yummy <span>Cakes</span> for u</h2>
        <p>Our best cakes make your day special</p>
        <a href="Products.html">开始 shopping</a>
        <div class="banner-text">
            <img src="images/2.png" alt=""/>
        </div>
    </div>
</div>
<!--//banner-->
<!--gallery-->
<div class="gallery">
    <div class="container">
        <div class="gallery-grids">
            <div class="col-md-8 gallery-grid glry-one">
                <a href="Products.html"><img src="images/g1.jpg" class="img-responsive" alt=""/>
                    <div class="gallery-info">
                        <p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 详情</p>
                        <a class="shop" href="Single.html">添加购物车</a>
                        <div class="clearfix"></div>
                    </div>
                </a>
                <div class="galy-info">
                    <p>Lorem Ipsum is simply</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">$95.00</h5>
                        </div>
                        <div class="rating">
                            <span>☆</span>
                            <span>☆</span>
                            <span>☆</span>
                            <span>☆</span>
                            <span>☆</span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-4 gallery-grid glry-two">
                <a href="Products.html"><img src="images/g2.jpg" class="img-responsive" alt=""/>
                    <div class="gallery-info galrr-info-two">
                        <p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> view</p>
                        <a class="shop" href="Single.html">SHOP NOW</a>
                        <div class="clearfix"></div>
                    </div>
                </a>
                <div class="galy-info">
                    <p>Lorem Ipsum is simply</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">$95.00</h5>
                        </div>
                        <div class="rating">
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 gallery-grid ">
                <a href="Products.html"><img src="images/g3.png" class="img-responsive" alt=""/>
                    <div class="gallery-info">
                        <p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> view</p>
                        <a class="shop" href="Single.html">SHOP NOW</a>
                        <div class="clearfix"></div>
                    </div>
                </a>
                <div class="galy-info">
                    <p>Lorem Ipsum is simply</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">$95.00</h5>
                        </div>
                        <div class="rating">
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 gallery-grid ">
                <a href="products.html"><img src="images/g4.png" class="img-responsive" alt=""/>
                    <div class="gallery-info">
                        <p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> view</p>
                        <a class="shop" href="single.html">SHOP NOW</a>
                        <div class="clearfix"></div>
                    </div>
                </a>
                <div class="galy-info">
                    <p>Lorem Ipsum is simply</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">$95.00</h5>
                        </div>
                        <div class="rating">
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 gallery-grid ">
                <a href="products.html"><img src="images/g5.png" class="img-responsive" alt=""/>
                    <div class="gallery-info">
                        <p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> view</p>
                        <a class="shop" href="single.html">SHOP NOW</a>
                        <div class="clearfix"></div>
                    </div>
                </a>
                <div class="galy-info">
                    <p>Lorem Ipsum is simply</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">$95.00</h5>
                        </div>
                        <div class="rating">
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 gallery-grid ">
                <a href="products.html"><img src="images/g6.png" class="img-responsive" alt=""/>
                    <div class="gallery-info">
                        <p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> view</p>
                        <a class="shop" href="single.html">SHOP NOW</a>
                        <div class="clearfix"></div>
                    </div>
                </a>
                <div class="galy-info">
                    <p>Lorem Ipsum is simply</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">$95.00</h5>
                        </div>
                        <div class="rating">
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 gallery-grid ">
                <a href="products.html"><img src="images/g7.png" class="img-responsive" alt=""/>
                    <div class="gallery-info">
                        <p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 查看</p>
                        <a class="shop" href="single.html">添加购物车</a>
                        <div class="clearfix"></div>
                    </div>
                </a>
                <div class="galy-info">
                    <p>Lorem Ipsum is simply</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">$95.00</h5>
                        </div>
                        <div class="rating">
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 gallery-grid ">
                <a href="products.html"><img src="images/g8.png" class="img-responsive" alt=""/>
                    <div class="gallery-info">
                        <p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> view</p>
                        <a class="shop" href="single.html">SHOP NOW</a>
                        <div class="clearfix"></div>
                    </div>
                </a>
                <div class="galy-info">
                    <p>Lorem Ipsum is simply</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">$95.00</h5>
                        </div>
                        <div class="rating">
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 gallery-grid ">
                <a href="products.html"><img src="images/g9.png" class="img-responsive" alt=""/>
                    <div class="gallery-info">
                        <p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> view</p>
                        <a class="shop" href="single.html">SHOP NOW</a>
                        <div class="clearfix"></div>
                    </div>
                </a>
                <div class="galy-info">
                    <p>Lorem Ipsum is simply</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">$95.00</h5>
                        </div>
                        <div class="rating">
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 gallery-grid ">
                <a href="products.html"><img src="images/g10.png" class="img-responsive" alt=""/>
                    <div class="gallery-info">
                        <p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> view</p>
                        <a class="shop" href="single.html">SHOP NOW</a>
                        <div class="clearfix"></div>
                    </div>
                </a>
                <div class="galy-info">
                    <p>Lorem Ipsum is simply</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">$95.00</h5>
                        </div>
                        <div class="rating">
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
								<span>�?/span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--//gallery-->
<!--subscribe-->
<div class="subscribe">
    <div class="container">
        <h3>Newsletter</h3>
        <form>
            <input type="text" class="text" value="Email" onfocus="this.value = '';"
                   onblur="if (this.value == '') {this.value = 'Email';}">
            <input type="submit" value="Subscribe">
        </form>
    </div>
</div>
<!--//subscribe-->
<!--footer-->
<div class="footer">
    <div class="container">
        <div class="footer-grids">
            <div class="col-md-2 footer-grid">
                <h4>company</h4>
                <ul>
                    <li><a href="products.html">products</a></li>
                    <li><a href="#">Work Here</a></li>
                    <li><a href="#">Team</a></li>
                    <li><a href="#">Happenings</a></li>
                    <li><a href="#">Dealer Locator</a></li>
                </ul>
            </div>
            <div class="col-md-2 footer-grid">
                <h4>service</h4>
                <ul>
                    <li><a href="#">Support</a></li>
                    <li><a href="#">FAQ</a></li>
                    <li><a href="#">Warranty</a></li>
                    <li><a href="contact.html">Contact Us</a></li>
                </ul>
            </div>
            <div class="col-md-3 footer-grid">
                <h4>order & returns</h4>
                <ul>
                    <li><a href="#">Order Status</a></li>
                    <li><a href="#">Shipping Policy</a></li>
                    <li><a href="#">Return Policy</a></li>
                    <li><a href="#">Digital Gift Card</a></li>
                </ul>
            </div>
            <div class="col-md-2 footer-grid">
                <h4>legal</h4>
                <ul>
                    <li><a href="#">Privacy</a></li>
                    <li><a href="#">Terms and Conditions</a></li>
                    <li><a href="#">Social Responsibility</a></li>
                </ul>
            </div>
            <div class="col-md-3 footer-grid icons">
                <h4>Connect with Us</h4>
                <ul>
                    <li><a href="#"><img src="images/i1.png" alt=""/>Follow us on Facebook</a></li>
                    <li><a href="#"><img src="images/i2.png" alt=""/>Follow us on Twitter</a></li>
                    <li><a href="#"><img src="images/i3.png" alt=""/>Follow us on Google-plus</a></li>
                    <li><a href="#"><img src="images/i4.png" alt=""/>Follow us on Pinterest</a></li>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</div>
<!--//footer-->
<div class="footer-bottom">
    <div class="container">
        <p>Copyright &copy; 2015.Company name All rights reserved></p>
    </div>
</div>
</body>
</html>
