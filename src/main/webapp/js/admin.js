$(document).ready(function () {

    /*用户管理点击页码进行刷新数据*/
    $(".connect").click(function () {
        //用户条件查询
        var userAccount = $("#userText").val();
        var userTemp = $("#userCondition").val();
        //管理员条件查询
        var userRightTemp =  $("#userRightCondition").val();
        var userRightClasses = $("#userRightText").val();

        var text = $("#goodsText").val();
        var goodsCondition = $("#goodsCondition").val();
        var goods = parseInt($("#goodsnumber").val());


        /*进行颜色的变换*/
        var pagination = $(this).attr("id");
        var number = $("#select").val();
        $(".connect").css("color", "blue");
        $(this).css("color", "red");
        $("#thisPaginaTion").val(pagination);
        /*进行查询该页面下的数据发送请求*/
        $.post("pagination.do",
            {
                number: "" + number, pagination: "" + pagination, goodsnumber: "" + goods
                , goodsCondition: "" + goodsCondition, price: "" + text
                , userRightTemp:""+userRightTemp,userRightClasses:""+userRightClasses
                , Account:""+userAccount,userTemp:""+userTemp
            }
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
        $("#addGoodsData").trigger('click');
    });
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
        //用户条件查询
        var userAccount = $("#userText").val();
        var userTemp = $("#userCondition").val();
        //管理员条件查询
        var userRightTemp =  $("#userRightCondition").val();
        var userRightClasses = $("#userRightText").val();

        var text = $("#goodsText").val();
        var goodsCondition = $("#goodsCondition").val();
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
            {
                number: "" + number, pagination: "" + pagination,
                goodsnumber: "" + goods, goodsCondition: "" + goodsCondition, price: "" + text
                , userRightTemp:""+userRightTemp,userRightClasses:""+userRightClasses
                , Account:""+userAccount,userTemp:""+userTemp
            }
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
        //用户条件查询
        var userAccount = $("#userText").val();
        var userTemp = $("#userCondition").val();
        //管理员条件查询
        var userRightTemp =  $("#userRightCondition").val();
        var userRightClasses = $("#userRightText").val();

        var text = $("#goodsText").val();
        var goods = parseInt($("#goodsnumber").val());
        var number = $("#select").val();
        var val = $("#thisPaginaTion").val();
        var goodsCondition = $("#goodsCondition").val();
        var pagination = parseInt(val) + 1;
        if (pagination > parseInt($("#maxPaginaTion").val())) {
            pagination = pagination - 1;
        }
        $("#thisPaginaTion").val("" + pagination);
        $(".connect").css("color", "blue");
        $("#" + pagination).css("color", "red");
        /*  进行查询该页面下的数据发送请求*/
        $.post("pagination.do",
            {
                number: "" + number, pagination: "" + pagination,
                goodsnumber: "" + goods, goodsCondition: "" + goodsCondition, price: "" + text
                , userRightTemp:""+userRightTemp,userRightClasses:""+userRightClasses
                , Account:""+userAccount,userTemp:""+userTemp
            }
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

    /*刷新*/
    $("#refresh").click(function () {
        var goods = parseInt($("#goodsnumber").val());
        if (goods != 1 && goods != 2) {
            /*刷新用户内联页面，展示新的数据*/
            $('#iframeas').attr('src', $('#iframeas').attr('src'));
        } else if (goods == 2) {
            $('#userRight').attr('src', $('#userRight').attr('src'));
        } else {
            /*刷新商品内联页面，展示新的数据*/
            $('#goods').attr('src', $('#goods').attr('src'));
        }
    });

    /*商品的单价条件查询*/
    $("#findGoods").click(function () {
        var number = $("#select").val();
        var text = $("#goodsText").val();
        if ("商品单价" == $(".selectGoods").val()) {
            / *利用js发送商品管理请求*/
            window.location.href = "findByGoodsPrice.do?numbers=" + number + "&pagination=1&" + "price=" + text;
        }
        /*      else if("id"==$(".selectGoods").val()){
         / *利用js发送商品管理请求*!/
         window.location.href = "findByGoodId.do?numbers=" + number + "&pagination=1&"+"price="+text;
         }*/
    });

    /*管理员的级别条件查询*/
    $("#findUserRight").click(function () {
        var number = $("#select").val();
        var text = $("#userRightText").val();
        if ("级别" == $(".userRight").val()) {
            / *利用js发送商品管理请求*/
            window.location.href = "findByAdminClasses.do?numbers=" + number + "&pagination=1&" + "classes=" + text;
        }
    });

    /*用户的账号条件查询*/
    $("#findUser").click(function () {
        var number = $("#select").val();
        var text = $("#userText").val();
        if ("账号" == $(".selectUser").val()) {
            / *利用js发送商品管理请求*/
            window.location.href = "findByLikeName.do?numbers=" + number + "&pagination=1&" + "Account=" + text;
        }
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