<%@ page import="com.starlight.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: james.jiang
  Date: 2016/12/26
  Time: 11:01
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
    <!-- js -->
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style2.css"/>
    <script type="text/javascript" src="js/jquery-1.2.6.min.js"></script>
    <!-- //js -->
    <!-- cart -->
    <script src="js/simpleCart.min.js"></script>
    <!-- cart -->
    <script type="text/javascript" src="js/jsAddress.js"></script>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="css/css.css" media="all">

    <script type="text/javascript">
        $(document).ready(function () {
            $(".dropdown").mouseenter(function () {
                $(this).children(".dropdown-menu").css("display", "block ");
            });
            $(".dropdown").mouseleave(function () {
                $(this).children(".dropdown-menu").css("display", "none");
            });
        });
        $()
    </script>
    <script type="text/javascript">
        function slideSwitch() {
            var $active = $('#slideshow IMG.active');
            if ($active.length == 0) $active = $('#slideshow IMG:last');
            var $next = $active.next().length ? $active.next()
                : $('#slideshow IMG:first');
            $active.addClass('last-active');
            $next.css({opacity: 0.0})
                .addClass('active')
                .animate({opacity: 1.0}, 1000, function () {
                    $active.removeClass('active last-active');
                });
        }
        $(function () {
            setInterval("slideSwitch()", 2000);
        });
        $(document).ready(function () {
            $("#content3").mouseenter(function () {
                $(this).css("background", "rgba(240,120,24,0.7)");
            });
            $("#content3").mouseleave(function () {
                $(this).css("background", "rgba(51,51,51,0.7)");
            });
        });
    </script>

    <link rel="stylesheet" type="text/css" href="css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
    <style type="text/css">

    </style>
    <!--[if IE]>
    <script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
    <![endif]-->
<%--删除订单--%>
<script type="text/javascript">
    $(document).ready(function () {
        $(".remove").mouseenter(function () {
            $(this).css("background", "rgba(240,120,24,0.7)");
        });
        $(".remove").mouseleave(function () {
            $(this).css("background", "");
        });
        $(".remove").click(function () {
            var id=$(this).attr("name");
            var obj=$(this);
            $.ajax({
                url:'removeOrder.do',
                type:'post',
                async:true,
                dataType: "text",
                data:{id:id},
                timeout:5000,
                success:function (data) {
                    if(data=="true"){
                        obj.parent().remove();
                    }else {
                        alert("删除不成功")
                    }
                },
                error:function () {

                }
            });

        });

    });
</script>

    <script>
        $(document).ready(function() {

            $(".recharge").click(function(){

                $('.theme-popover-mask').fadeIn(100);

                $('.theme-popover').slideDown(200);

            })

            $('.theme-poptit .close').click(function(){

                $('.theme-popover-mask').fadeOut(100);

                $('.theme-popover').slideUp(200);
            })
        })

    </script>

    <%--充值--%>
    <script>
        $(document).ready(function () {
            $("#btn").click(function () {
                var money=$('[name="amount"]').val();
                var password=$('[name="pwd"]').val();
                $.ajax({
                    url:'chargeMoney.do',
                    type:'post',
                    async:true,
                    dataType: "text",
                    data:{money:money,password:password},
                    timeout:5000,
                    success:function (data) {
                        if(data=="true"){

                        }else {
                            alert("充入失败！")
                        }
                    },
                    error:function () {

                    }
                });

            });
        });
    </script>
    
    <%--修改信息--%>
    <script>
        $(document).ready(function () {
            $(".nickName").blur(function () {
                var nickName=$(this).val();
                alert(nickName);
                $.ajax({
                    url:'updateNickName.do',
                    type:'post',
                    async:true,
                    dataType: "text",
                    data:{nickName:nickName},
                    timeout:5000,
                    success:function (data) {
                        if(data=="true"){
                            alert("修改成功！")
                        }else {
                            alert("修改失败！")
                        }
                    },
                    error:function () {

                    }
                });
            });
        });
    </script>
</head>

<body style="background-image:url('images/image2.jpg');">
<!--header-->
<div class="header" style="height: 67px;">
    <div class="container" style="height: 67px;">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <h1 class="navbar-brand" style="margin: 0px auto;"><a href="index.jsp">Yummy</a></h1>
            </div>
            <!--navbar-header-->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="height: 67px;">
                <ul class="nav navbar-nav">
                    <li><a href="index.jsp" class="active">主页</a></li>
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
        <div class="header-info" style="height: 67px;">
            <div class="header-right search-box" style="height: 67px;">
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
            <div class="header-right login" style="height: 67px;">
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
<!--//header-->

<!--account-->
<div style="height: auto;min-height:800px;width: 100%;margin: 50px 80px;">
    <div id="content" style="float:left;margin: 0px 5px;width: 350px;height: 700px;color: whitesmoke;position:fixed;">
        <div style="height: 500px;width: 100%;margin: 5px 5px;">
            <div id="headerpic">
                <img src="images/headpic.jpg" width="100px" height="100px">
            </div>
            <div id="info" style="margin: 20px 20px;">
                账号：<label>${sessionScope.user.account}</label><br><br>
                昵称：<input type="text" class="in rename nickName"  name="rename" value="${sessionScope.userInfo.nickname}" style="color: whitesmoke;"> <br><br>
                性别：<label>${sessionScope.userInfo.sex}</label><br><br>
                年龄：<input type="text" class="in age" name="age" value="${sessionScope.userInfo.age}" style="color: whitesmoke;"><br><br>
                电话：<input type="text" class="in phone" name="phone" value="${sessionScope.userInfo.phone}" style="color: whitesmoke;"> <br><br>
                住址：<input type="text" class="in place" name="place" value="${sessionScope.userInfo.address}" style="color: whitesmoke;"><br><br>
                钱包：<label>${sessionScope.wallet.money}</label>元<br>

            </div>
        </div>
    </div>

    <div id="content2">
        <!--标题-->
        <div class="head-titles1">
            <div class="container">
                <h2 class="hdng">Yummy <span>Cakes</span> for u</h2>
                <p>Our best cakes make your day special</p>
            </div>
        </div>


        <!--订单-->
        <c:forEach items="${orderList}" var="order">

        <div class="head-titles2" style="width: 100%;height: 150px;margin-left: 350px;float: left;">
            <!--单选框-->
            <div class="cbdiv"
                 style="float: left;margin: 40px 20px;padding-top:30px;width: 50px;height:50px;text-align: center;">
                <input type="checkbox" class="cb">
            </div>

            <!--商品图片-->
            <div class="goodpic"
                 style="float: left;margin: 20px 10px;background-color: #F2F6F7;width: 140px;height: 120px;">
                <img src="images/${order.picture}" width="140px" height="120px">
            </div>
            <!--商品价格-->
            <div class="goodprice" style="float: left;margin: 40px 10px;padding-top:30px;width: 130px;height: 60px;">
                名称：${order.goodsName}
            </div>
            <div class="goodprice" style="float: left;margin: 40px 10px;padding-top:30px;width: 130px;height: 60px;">
                价格：100.00元
            </div>
            <div class="goodprice" style="float: left;margin: 40px 10px;padding-top:30px;width: 100px;height: 60px;">
                数量：42
            </div>
            <div class="gooddescribe" style="float: left;margin: 40px 10px;padding-top:30px;width: 160px;height: 60px;">
                购买时间：16.12.10
            </div>
            <div class="goodprice" style="float: left;margin: 40px 10px;padding-top:30px;width: 120px;height: 60px;">
                总计：525元
            </div>
            <div class="gooddescribe remove"
                 style="float: left;margin: 50px 10px;padding-top:20px;width: 60px;height: 60px;text-align: center" name="${order.id}" >
                删除
            </div>
        </div>

        </c:forEach>
    </div>
    <!--充值-->
    <div id="content3" class="recharge">
        充值
    </div>
</div>


<div class="theme-popover">

    <div class="theme-poptit">

        <a href="javascript:;" title="关闭" class="close">×</a>

        <h3>经常充值能快速提高等级哦！</h3>

    </div>

    <div class="theme-popbod dform">

        <form class="theme-signin" name="loginform" action="" method="post" autocomplete="off">
            <ol>
                <li><strong>充入金额：</strong><input class="ipt" type="text" name="amount" placeholder="999.00" size="20"/></li>

                <li><strong>充值密码：</strong><input class="ipt" type="password" name="pwd" placeholder="******" size="20" /></li>

                <li><input id="btn" class="btn btn-primary" type="submit" name="submit" style="width: 180px" value=" 确认充入" /></li>

            </ol>
        </form>

    </div>
</div>





<!--火箭-->
<!-- 右侧小火箭图标返回顶部 -->
<div id="shangxia2" >
				<span id="gotop1">
					<img src="images/huojian.svg" alt="返回顶部小火箭">
                    <!-- <img src="img/rocked.png" alt="返回顶部小火箭"> -->
				</span>
</div>
<script src="http://libs.useso.com/js/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
<script src="http://cdn.bootcss.com/gsap/1.19.0/TweenMax.min.js"></script>
<script src="http://cdn.bootcss.com/gsap/1.19.0/plugins/ScrollToPlugin.min.js"></script>
<script type="text/javascript">
    /* 选择你喜欢的速度类型，复制下面的某段代码即可 */
    $(function () {
        // 默认速度
        $("#gotop6").click(function () {
            TweenMax.to(window, 1, {scrollTo: 0});
        });

        // 弹跳球式滚动底部 .box2是要滚动地方的id或者锚点
        $("#gotop5").click(function () {
            TweenMax.to(window, 2, {scrollTo: ".box2", ease: Bounce.easeOut});
        });

        // 返回顶部，绑定gotop1图标和gotop2文字事件
        $("#gotop1,#gotop2").click(function (e) {
            TweenMax.to(window, 1.5, {scrollTo: 0, ease: Expo.easeInOut});
            var huojian = new TimelineLite();
            huojian.to("#gotop1", 1, {rotationY: 720, scale: 0.6, y: "+=40", ease: Power4.easeOut})
                .to("#gotop1", 1, {y: -1000, opacity: 0, ease: Power4.easeOut}, 0.6)
                .to("#gotop1", 1, {
                    y: 0,
                    rotationY: 0,
                    opacity: 1,
                    scale: 1,
                    ease: Expo.easeOut,
                    clearProps: "all"
                }, "1.4");
        });

        // 以1秒慢快慢的速度滚动顶部
        $("#gotop3").click(function () {
            TweenMax.to(window, 1, {scrollTo: 0, ease: Expo.easeInOut});
        });
        // 以1.5秒快慢快的速度滚动顶部
        $("#gotop4").click(function () {
            TweenMax.to(window, 1.5, {scrollTo: 0, ease: SlowMo.ease.config(0.7, 0.7, false)});
        });

    });
</script>

<!--footer-->
</body>

</html>
