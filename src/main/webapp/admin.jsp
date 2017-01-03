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

    <%--添加商品弹窗样式插件--%>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="cropper/cropper.min.css" rel="stylesheet">
    <link href="sitelogo/sitelogo.css" rel="stylesheet">
    <script src="cropper/cropper.min.js"></script>
    <script src="sitelogo/sitelogo.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!-- cart -->
    <%--页面的所有操作jquery--%>
    <script type="application/x-javascript" src="js/admin.js">
    </script>
</head>
<body>
<%--标记作用--%>
<c:choose>
    <c:when test="${sessionScope.goodsdata!=null}">
        <input id="goodsnumber" value="1" style="display: none">
    </c:when>
    <c:when test="${sessionScope.userRight!=null}">
        <input id="goodsnumber" value="2" style="display: none">
    </c:when>
    <c:otherwise>
        <input id="goodsnumber" value="0" style="display: none">
    </c:otherwise>
</c:choose>

<%--商品的弹框--%>
<div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <%--表单--%>
            <form class="avatar-form" action="upload.do" enctype="multipart/form-data" method="post">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal" type="button">&times;</button>
                    <h4 class="modal-title" id="avatar-modal-label">添加商品信息</h4>
                </div>
                <div class="modal-body">
                    <div class="avatar-body">
                        <div class="avatar-upload">
                            <input class="avatar-src" name="avatar_src" type="hidden">
                            <input class="avatar-data" name="avatar_data" type="hidden">
                            <label for="avatarInput" >图片上传</label>
                            <input class="avatar-input" id="avatarInput" name="avatar_file" type="file"></div>
                        <div class="row">
                            <div class="col-md-9" style="width: 50%">
                                <div class="avatar-wrapper"></div>
                            </div>
                            <div class="col-md-9" style="width: 50%;float: left;">
                                <div class="avatar-wrapper2" >
                                    <div class="messages">
                                        <div class="message">
                                            <label>商品编号:&nbsp;<b>${requestScope.maxid}</b></label>
                                            <input name="goodsid" value="${requestScope.maxid}" style="display: none">
                                        </div>
                                        <div class="message">
                                            <label>商品名称: &nbsp;</label><input type="text" name="goodsname">
                                        </div>
                                        <div class="message">
                                            <label>商品单价:&nbsp; </label><input type="text" name="goodsprivce">
                                        </div>
                                        <div class="message">
                                            <label>商品数量:&nbsp; </label><input type="text" name="goodsnumber">
                                        </div>
                                        <div class="message" style="height: 80px;">
                                            <div style="float: left;margin-top: 0px">
                                                <label >商品描述: &nbsp;</label>
                                            </div>
                                            <textarea name="gdsdescribe" style="height: 80px;width:174px"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row avatar-btns">
                            <div class="col-md-9">
                                <div class="btn-group">
                                    <button class="btn" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees"><i class="fa fa-undo"></i> 向左旋转</button>
                                </div>
                                <div class="btn-group">
                                    <button class="btn" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees"><i class="fa fa-repeat"></i> 向右旋转</button>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <button class="btn btn-success btn-block avatar-save" type="submit"><i class="fa fa-save"></i>提交信息</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%--导航栏--%>
    <div class="header" style="height: 67px">
        <div class="container">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header" style="margin-top: 0px">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <h1 class="navbar-brand" style="margin-top: 0px;"><a href="index.jsp" style="margin-top: 0px;">Yummy</a></h1>
                </div>
                <!--navbar-header-->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
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
                        <form id="loginForm" action="login.do?url=index" method="post">
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
                            <p>没有账号吧？<a class="sign" href="register.html">点击注册</a> <span><a
                                    href="changePassword.jsp">忘记密码?</a></span>
                            </p>
                            </c:when>
                            <c:otherwise>
                                <div>
                                    <h4>
                                        <span>欢迎:</span>
                                        <span>
                                    <a href="personal.do" style="color: #0e90d2;">
                                            ${sessionScope.userinfo.nickname}
                                    </a>
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
              <div id="crop-avatar" class="col-md-6"style="width:200px;height: 100%;display: none;float: left; margin-left: 20px;">
                <input type="button" class="avatar-view" style="width:100px;height: 25px;float: left;" id="addGoodsData"  value="上传图片">
            </div>
            <span style="margin-left: 60px">
            <input type="button" style="width:100px;height: 25px" id="addGoods" value="+添加商品">
        </span>
        </c:if>
        <span style="margin-left: 100px">
         类型：
            <c:choose>
                <c:when test="${sessionScope.goodsdata!=null}">
                    <select class="selectGoods" style="width: 120px">
                        <option selected>${requestScope.type}</option>
                      <%--   <option>id</option>
                         <option>商品单价</option>--%>
                   </select>
                </c:when>
                <c:when test="${sessionScope.userRight!=null}">
                     <select class="userRight" style="width:120px">
                       <option selected>${requestScope.type}</option>
                       <%--  <option>id</option>
                         <option>账号</option>--%>
                <%--         <option>级别</option>--%>
                      </select>
                </c:when>
                <c:otherwise>
                        <select style="width: 120px" class="selectUser">
                            <option selected>${requestScope.type}</option>
                  <%--       <option>id</option>
                         <option>账号</option>--%>
                       <%--  <option>姓名</option>
                         <option>性别</option>
                         <option>年龄</option>--%>
                  </select>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${sessionScope.goodsdata!=null}">
                    <label><b style="font-size: 20px"><</b></label>
                    <input type="text" id="goodsText"
                           style="margin-left: 10px;width: 200px;height: 25px"
                           placeholder="请输入相关类型信息" value="${requestScope.price}">
                    <input type="button" id="findGoods" value="◎查询">
                    <%--用来分页--%>
                    <input type="text" id="goodsCondition" style="display: none" value="${requestScope.temp}">
                    <%--用来分页--%>
                    <input type="text" id="userCondition" style="display: none" value="${requestScope.userTemp}">
                    <%--用来分页--%>
                    <input type="text" id="userRightCondition" style="display: none"
                           value="${requestScope.userRightTemp}">
                </c:when>
                <c:when test="${sessionScope.userRight!=null}">
                    <input type="text" id="userRightText" value="${requestScope.classes}"
                           style="margin-left: 10px;width: 200px;height: 25px" placeholder="请输入相关类型信息">
                    <input type="button" id="findUserRight" value="◎查询">
                    <%--用来分页--%>
                    <input type="text" id="userRightCondition" style="display: none"
                           value="${requestScope.userRightTemp}">
                    <%--用来分页--%>
                    <input type="text" id="userCondition" style="display: none" value="${requestScope.userTemp}">
                    <%--用来分页--%>
                    <input type="text" id="goodsCondition" style="display: none" value="${requestScope.temp}">
                </c:when>
                <c:otherwise>
                    <input type="text" id="userText" value="${requestScope.Account}" style="margin-left: 10px;width: 200px;height: 25px"
                           placeholder="请输入相关类型信息">
                    <input type="button" id="findUser" value="◎查询">
                    <%--用来分页--%>
                    <input type="text" id="userCondition" style="display: none" value="${requestScope.userTemp}">
                    <%--用来分页--%>
                    <input type="text" id="userRightCondition" style="display: none"
                           value="${requestScope.userRightTemp}">
                    <%--用来分页--%>
                    <input type="text" id="goodsCondition" style="display: none" value="${requestScope.temp}">
                </c:otherwise>
            </c:choose>
            <!--   <input type="button" value="查询" style="margin-left: 20px;width: 80px;height:25px ">-->
    </span>
        <span style="margin-left: 200px"><a href="#" id="refresh"><img src="images/shuanxin.png">刷新</a></span>
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
                    <span>...</span>
                    <span style="margin-left: 10px">
                       <a href="#" id="${requestScope.number}">${requestScope.number}</a>
                    </span>
                </c:when>
                <c:otherwise>
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



<div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
</body>
</html>

