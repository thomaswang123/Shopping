<%--
  Created by IntelliJ IDEA.
  User: james.jiang
  Date: 2016/12/23
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
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
    <link href="css/form.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- js -->
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    <!-- //js -->
    <!-- cart -->
    <script src="js/simpleCart.min.js"></script>
    <!-- cart -->
    <!-- the jScrollPane script -->
    <script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>
    <script type="text/javascript" id="sourcecode">
        $(function () {
            $('.scroll-pane').jScrollPane();
        });
    </script>
    <!-- //the jScrollPane script -->
    <script type="text/javascript" src="js/jquery.mousewheel.js"></script>
    <!-- the mousewheel plugin -->
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
                <h1 class="navbar-brand"><a href="index.jsp">Yummy</a></h1>
            </div>
            <!--navbar-header-->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="index.html" class="active">主页</a></li>
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
                        <p>没有账号吧？<a class="sign" href="register.html">点击注册</a> <span><a href="changePassword.jsp">忘记密码?</a></span>
                        </p>
                        </c:when>
                        <c:otherwise>
                            <div>
                                <h4>
                                    <span>欢迎:</span>
                                    <span>
                                    <a href="personal.do" style="color: #0e90d2;">${sessionScope.userinfo.nickname}</a>
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
                    <h4><a href="checkout.html">
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
<!--products-->
<div class="products">
    <div class="container">
        <h2>Our Products</h2>
        <div class="col-md-9 product-model-sec">


                <!--第一个蛋糕-->
            <c:forEach items="${showAllGoods}" var="cake">
            <div class="product-grid">
                <a href="single.do?id=${cake.id}">
                    <div class="more-product"><span> </span></div>
                    <div class="product-img b-link-stripe b-animate-go  thickbox">
                        <img src="images/${cake.picture}" class="img-responsive" alt="">
                        <div class="b-wrapper">
                            <h4 class="b-animate b-from-left  b-delay03">
                                <button>View</button>
                            </h4>
                        </div>
                    </div>
                </a>

                <div class="product-info simpleCart_shelfItem">
                    <div class="product-info-cust prt_name">
                        <h4>${cake.name}</h4>
                        <span class="item_price">${cake.price}</span>
                        <div class="ofr">
                            <p class="pric1">
                                <del>${cake.price*0.8}</del>
                            </p>
                            <p class="disc">[15% Off]</p>
                        </div>
                        <input type="text" class="item_quantity" value="1"/>
                        <input type="button" class="item_add items" value="Add">
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            </c:forEach>

        </div>
        <div class="col-md-3 rsidebar span_1_of_left" style="float: none;margin-left: 20px;margin-top: 10px;" >
            <section class="sky-form">
                <div class="product_right">
                    <h4 class="m_2"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>Categories</h4>
                    <div class="tab1">
                        <ul class="place">
                            <li class="sort">Regular Cakes</li>
                            <li class="by"><span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
                            </li>
                        </ul>
                        <div class="clearfix" style="height: 70px"></div>
                        <div class="single-bottom">
                            <a href="#"><p>Cassata</p></a>
                            <a href="#"><p>Cheesecake</p></a>
                            <a href="#"><p>Coconut cake</p></a>
                            <a href="#"><p>Cupcake</p></a>
                        </div>
                    </div>
                    <div class="tab2">
                        <ul class="place">
                            <li class="sort">Special Cakes</li>
                            <li class="by"><span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
                            </li>
                        </ul>
                        <div class="clearfix" style="height: 70px"></div>
                        <div class="single-bottom">
                            <a href="#"><p>Delicious Cakes</p></a>
                            <a href="#"><p>Gingerbread</p></a>
                        </div>
                    </div>
                    <div class="tab3">
                        <ul class="place">
                            <li class="sort">Eggless Cake</li>
                            <li class="by"><span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
                            </li>
                        </ul>
                        <div class="clearfix" style="height: 70px"></div>
                        <div class="single-bottom">
                            <a href="#"><p>Milk Cakes</p></a>
                            <a href="#"><p>Fruits Cakes</p></a>
                        </div>
                    </div>
                    <div class="tab4">
                        <ul class="place">
                            <li class="sort">2-3 Tier Cakes</li>
                            <li class="by"><span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
                            </li>
                        </ul>
                        <div class="clearfix" style="height: 70px"></div>
                        <div class="single-bottom">
                            <a href="#"><p>Twist 4 tier</p></a>
                            <a href="#"><p>Floral Tier</p></a>
                            <a href="#"><p>Double Heartshape</p></a>
                        </div>
                    </div>
                    <!--script-->
                    <script>
                        $(document).ready(function () {
                            $(".tab1 .single-bottom").hide();
                            $(".tab2 .single-bottom").hide();
                            $(".tab3 .single-bottom").hide();
                            $(".tab4 .single-bottom").hide();
                            $(".tab5 .single-bottom").hide();

                            $(".tab1 ul").click(function () {
                                $(".tab1 .single-bottom").slideToggle(300);
                                $(".tab2 .single-bottom").hide();
                                $(".tab3 .single-bottom").hide();
                                $(".tab4 .single-bottom").hide();
                                $(".tab5 .single-bottom").hide();
                            })
                            $(".tab2 ul").click(function () {
                                $(".tab2 .single-bottom").slideToggle(300);
                                $(".tab1 .single-bottom").hide();
                                $(".tab3 .single-bottom").hide();
                                $(".tab4 .single-bottom").hide();
                                $(".tab5 .single-bottom").hide();
                            })
                            $(".tab3 ul").click(function () {
                                $(".tab3 .single-bottom").slideToggle(300);
                                $(".tab4 .single-bottom").hide();
                                $(".tab5 .single-bottom").hide();
                                $(".tab2 .single-bottom").hide();
                                $(".tab1 .single-bottom").hide();
                            })
                            $(".tab4 ul").click(function () {
                                $(".tab4 .single-bottom").slideToggle(300);
                                $(".tab5 .single-bottom").hide();
                                $(".tab3 .single-bottom").hide();
                                $(".tab2 .single-bottom").hide();
                                $(".tab1 .single-bottom").hide();
                            })
                            $(".tab5 ul").click(function () {
                                $(".tab5 .single-bottom").slideToggle(300);
                                $(".tab4 .single-bottom").hide();
                                $(".tab3 .single-bottom").hide();
                                $(".tab2 .single-bottom").hide();
                                $(".tab1 .single-bottom").hide();
                            })
                        });
                    </script>
                    <!--//script -->
                </div>
            </section>
            <section class="sky-form">
                <h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>DISCOUNTS</h4>
                <div class="row row1 scroll-pane">
                    <div class="col col-4">
                        <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Upto - 10% (20)</label>
                    </div>
                    <div class="col col-4">
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>70% - 60% (5)</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>50% - 40% (7)</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>30% - 20% (2)</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>10% - 5% (5)</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>30% - 20% (7)</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>10% - 5% (2)</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Other(50)</label>
                    </div>
                </div>
            </section>
            <section class="sky-form">
                <h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>Price</h4>
                <ul class="dropdown-menu1">
                    <li><a href="">
                        <div id="slider-range"></div>
                        <input type="text" id="amount"
                               style="border: 0; font-weight: NORMAL;   font-family: 'Dosis-Regular';"/>
                    </a></li>
                </ul>
            </section>
            <!---->
            <script type="text/javascript" src="js/jquery-ui.min.js"></script>
            <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
            <script type='text/javascript'>//<![CDATA[
            $(window).load(function () {
                $("#slider-range").slider({
                    range: true,
                    min: 0,
                    max: 100000,
                    values: [500, 100000],
                    slide: function (event, ui) {
                        $("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
                    }
                });
                $("#amount").val("$" + $("#slider-range").slider("values", 0) + " - $" + $("#slider-range").slider("values", 1));

            });//]]>
            </script>
            <!---->
            <section class="sky-form">
                <h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>By Flavour</h4>
                <div class="row row1 scroll-pane">
                    <div class="col col-4">
                        <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Vanilla</label>
                    </div>
                    <div class="col col-4">
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Chocolate</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Butterscotch</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Strawberry</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Black Forest</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Mixed Fruit</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Honey</label>
                    </div>
                </div>
            </section>
            <section class="sky-form">
                <h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>Weight</h4>
                <div class="row row1 scroll-pane">
                    <div class="col col-4">
                        <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Half KG</label>
                    </div>
                    <div class="col col-4">
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>One KG</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>TwO KG</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>More</label>
                    </div>
                </div>
            </section>
            <section class="sky-form">
                <h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>Color</h4>
                <div class="row row1 scroll-pane">
                    <div class="col col-4">
                        <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>White</label>
                    </div>
                    <div class="col col-4">
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Pink</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Gold</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Silver</label>
                    </div>
                </div>
            </section>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!--//products-->
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
                </ul>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</div>
<!--//footer-->
<div class="footer-bottom">
    <div class="container">
        <p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">
            &#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
    </div>
</div>
</body>
</html>