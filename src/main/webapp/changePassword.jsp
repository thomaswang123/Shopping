<%--
  Created by IntelliJ IDEA.
  User: thomas.wang
  Date: 2016/12/20
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
    <!-- js -->
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    <!-- //js -->
    <!-- cart -->
    <script src="js/simpleCart.min.js"></script>
    <!-- cart -->
    <script type="application/x-javascript">
        $(document).ready(function () {
            /*展示修改密保以及支付密码的输入框*/
            $("#zhifu").click(function () {
                $("#Payment_codepswd").toggle();
            });
            $("#mibao").click(function () {
                $("#Secret_question").toggle();
            });

            /*进行后台的答案数据验证*/
            $("#butto2").click(function () {
                alert("Aaa");
                $.post("answer.do",
                    $("#answer").serialize(),
                    function (data) {
                        if (data != "") {
                            alert(data);
                            $("#security_settings").show();
                            $("#apply_for").hide();
                        }
                    }, "text");
            });

            /*档账号输入框！失去焦点时，便发送ajax请求，请求成功，隐藏账号输入框*/
            $('#butto1').click(
                function () {
                    $.post("user_checkexist.do",
                        {username: $("#username").val()}, function (data) {
                            if (data != null) {
                                $("#tishi").hide();
                                $("#userid").hide();
                                var arr = data.split(",");
                                for (var i = 0; i < arr.length; i++) {
                                    if ((i+1)%2==0) {
                                        $("#Security_question" + (i + 1)).text(arr[i] + "?");
                                        $("#Security_question" + (i + 7)).text(arr[i] + "?");
                                    }else{
                                        $("#ppid" + (i+1)).val(arr[i]);
                                        $("#ppid" + (i+1)).name="ppid";
                                    }
                                }
                                $("#Security_question").show();
                            } else {
                                $("#tishi").show();
                            }
                        }, "text"
                    );
                }
            );
            /*进行后台的答案数据验证*/
      /*      $("#butto3").click(function () {
                $.post("alertAll.do",
                    $("#alertPpAll").serialize(),
                    function (data) {
                        if (data != null) {
                            alert(data);
                        }
                    }, "text");
            });*/

            $("#butto3").click(function () {
                alert("aaa");
                $.post("alertPpAll.do",
                    $("#alertPpAll").serialize(),
                    function (data) {
                        if (data != null) {
                            alert(data);
                        }
                    }, "text");
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
<!--account-->
<div class="account">
    <div class="container">
        <div class="register">
            <%--    <form>--%>
            <div class="register-bottom-grid">
                <div style="display: block" id="apply_for">
                    <h3>Application Information</h3><h4 style="color: #d58512">填写申请修改信息 :</h4>
                    <div class="input" id="userid">
                        <span>account number (填写账号 ：) <label style="color: red"> *</label></span>
                        <span style="float: left;margin-top: 5px">账号：</span>
                        <input type="text" id="username" style="width: 300px;float: left;margin-left: 23px">
                        <span style="margin-left: 20px;color=red;display: none" id="tishi">账号不正确正确</span><br>
                        <div class="clearfix"></div>
                        <div class="register-but">
                            <input type="button" id="butto1" value="确认提交">
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <%--这里是账号正确后，然后进行三个密保的展示操作--%>
                    <div id="Security_question" style="display: none">
                        <form id="answer">
                            <span>Secret question (密保问题：) <label style="color: red"> *请正确填写相关信息</label></span>
                            <div>
                                <span style="float: left;margin-top: 5px">密保问题一：</span>
                                <span style="margin-top: 5px"><label id="Security_question2"></label></span>
                            </div>

                            <div class="input">
                                <div>
                                    <span style="float: left;margin-top: 15px">答案：</span>
                                    <input style="margin-top: 10px;float: left;margin-left: 23px;width: 300px;height: 30px"
                                           type="text" name="result">
                                </div>
                                <br><br>
                            </div>
                            <div>
                                <span style="float: left;margin-top: 5px">密保问题二：</span>
                                <span style="margin-top: 5px"><label id="Security_question4"></label></span>
                            </div>

                            <div class="input">
                                <div>
                                    <span style="float: left;margin-top: 15px">答案：</span>
                                    <input style="margin-top: 10px;float: left;margin-left: 23px;width: 300px;height: 30px"
                                           type="text" name="result">
                                </div>
                                <br><br>
                            </div>
                            <div>
                                <span style="float: left;margin-top: 5px">密保问题三：</span>
                                <span style="margin-top: 5px"><label id="Security_question6"></label></span>
                            </div>
                            <div class="input">
                                <div>
                                    <span style="float: left;margin-top: 15px">答案：</span>
                                    <input style="margin-top: 10px;float: left;margin-left: 23px;width: 300px;height: 30px"
                                           type="text" name="result">
                                </div>
                                <br><br>
                            </div>
                        </form>
                        <div class="clearfix"></div>
                        <div class="register-but">
                            <input type="button" id="butto2" value="确认提交">
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
                <div id="security_settings" style="display: none">
                    <form id="alertPpAll">
                        <h3>security settings</h3>
                        <h4 style="color: #d58512;">设置密码等 :</h4>
                        <div>
                    <span style="color: #d58512;float: left">
                             重置密保 :<input type="checkbox" id="mibao">
                             </span>
                            <span style="color: #d58512;float: left;margin-left: 15px">
                             重置支付密码 :<input type="checkbox" id="zhifu">
                             </span><br>
                        </div>
                        <br>

                        <div class="input">
                            <span>Password (密码 :) <label style="color: red"> *请填写新的密码</label></span>
                            <input type="password" name="password" style="width: 300px">
                        </div>

                        <div class="input">
                            <span>Confirm Password (确认密码 :) <label style="color: red"> *</label></span>
                            <input type="password" name="Confirmpssoword" style="width: 300px">
                        </div>
                        <!--支付密码-->
                        <div id="Payment_codepswd" style="display: none">
                            <div class="input">
                                <span> payment code (支付密码 :) <label style="color: red;"> *请填写新的支付密码</label></span>
                                <input type="password" name="payment_code" style="width: 300px">
                            </div>

                            <div class="input">
                                <span> affirm payment code (确认支付密码 :) <label style="color: red"> *</label></span>
                                <input type="password" name="affirm_payment_code" style="width: 300px">
                            </div>
                        </div>
                        <!--重置密码-->
                        <div id="Secret_question" style="display: none">
                            <div>
                                <span style="float: left;margin-top: 5px">密保问题一：</span>
                                <span style="margin-top: 5px"><label id="Security_question8"></label></span>
                            </div>

                            <div class="input">
                                <div>
                                    <span  style="float: left;margin-top: 15px">答案：</span>
                                    <input style="margin-top: 10px;float: left;margin-left: 23px;width: 300px;height: 30px"
                                           type="text" name="result" >
                                    <input id="ppid1"  name="ppid" style="display: block">
                                </div>
                                <br><br>
                            </div>
                            <div>
                                <span style="float: left;margin-top: 5px">密保问题二：</span>
                                <span style="margin-top: 5px"><label  id="Security_question10"></label></span>
                            </div>

                            <div class="input" >
                                <div >
                                    <span style="float: left;margin-top: 15px">答案：</span>
                                    <input style="margin-top: 10px;float: left;margin-left: 23px;width: 300px;height: 30px"
                                           type="text" name="result">
                                    <input id="ppid3"  name="ppid" style="display: none">
                                </div>
                                <br><br>
                            </div>
                            <div>
                                <span style="float: left;margin-top: 5px">密保问题三：</span>
                                <span style="margin-top: 5px"><label id="Security_question12"></label></span>
                            </div>
                            <div class="input">
                                <div >
                                    <span style="float: left;margin-top: 15px">答案：</span>
                                    <input style="margin-top: 10px;float: left;margin-left: 23px;width: 300px;height: 30px"
                                           type="text" name="result">
                                <%--    <label id="ppid5"  ></label>--%>
                                    <input id="ppid5"  name="ppid" style="display: none">
                                </div>
                                <br><br>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="register-but">
                            <input type="button" id="butto3" value="确认提交" >
                            <div class="clearfix"></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%--  </from>--%>
    </div>
</div>
</div>


<!--//account-->
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
<!--footer-->
<div class="footer-bottom">
    <div class="container">
        <p>Copyright &copy; 2015.Company name All rights reserved</p>
    </div>
</div>
</body>
</html>
