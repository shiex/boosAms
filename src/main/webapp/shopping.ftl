<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>购物车界面</title>

    <style>
        body {
            margin: 0px;
            padding: 0px;
        }

        .WH-1200 {
            width: 1200px;
        }

        .index {
            min-width: 1200px;
        }

        .index .cont {
            min-width: 1200px;
        }

        .cont .index-top {
            width: 1200px;
            margin: auto;
        }

        .index-top .customers {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            width: 100%;
            border-collapse: collapse;
        }

        .customers td, .customers th {
            font-size: 1em;
            border-bottom: 1px solid #98bf21;
            padding: 3px 7px 2px 7px;
        }

        .customers th {
            font-size: 1.1em;
            text-align: left;
            padding-top: 5px;
            padding-bottom: 4px;
            background-color: #A7C942;
            color: #ffffff;
        }

        .customers td {
            padding: 15px 10px;
        }

        .customers input[type=checkbox] {
            width: 15px;
            height: 15px;
        }

        .customers img {
            width: 70px;
            height: 90px;
        }

        .customers button {
            border: 0px;
            background-color: #ffffff;
            color: #98bf21;
        }

        .customers button:hover {
            cursor: pointer;
            color: royalblue;
        }

        .customers .book-name {
            color: #98bf21;
        }

        .customers .subtotal {
            color: red;
        }

        .customers .c1 {
            width: 50px
        }

        .customers .c2 {
            width: 50px
        }

        .customers .c3 {
            width: 270px;
            text-align: center
        }

        .customers .c4 {
            width: 70px
        }

        .customers .c5 {
            width: 110px
        }

        .customers .c6 {
            width: 70px
        }

        .customers .c7 {
            width: 70px
        }

        .inputNum {
            vertical-align: middle;
            height: 22px;
            border: 1px solid #d0d0d0;
            text-align: center;
        }

        .btn {
            display: inline-block;
            vertical-align: middle;
            background: #f0f0f0 no-repeat center;
            border: 1px solid #d0d0d0;
            width: 24px;
            height: 24px;
            border-radius: 2px;
            box-shadow: 0 1px rgba(100, 100, 100, .1);
            color: #666;
            transition: color .2s, background-color .2s;
        }

        .btn:active {
            box-shadow: inset 0 1px rgba(100, 100, 100, .1);
        }

        .btn:hover {
            background-color: #e9e9e9;
            color: #333;
        }

        .btn_plus {
            background-image: linear-gradient(to top, currentColor, currentColor), linear-gradient(to top, currentColor, currentColor);
            background-size: 10px 2px, 2px 10px;
        }

        .btn_minus {
            background-image: linear-gradient(to top, currentColor, currentColor);
            background-size: 10px 2px;
        }

        .dialog {
            position: fixed;
            top: 50%;
            left: 50%;
            width: 90%;
            height: 45%;
            -webkit-transform: translateX(-50%) translateY(-50%);
            -moz-transform: translateX(-50%) translateY(-50%);
            -ms-transform: translateX(-50%) translateY(-50%);
            transform: translateX(-50%) translateY(-50%);
            text-align: center;
            display: none;
        }

        .dialog .dig {
            width: 150px;
            height: 50px;
            background-color: #98bf21;
            margin: auto;
            padding: 30px;
        }

        .cont .index-con {
            width: 1200px;
            margin: auto;
            margin-top: 20px;
            margin-bottom: 50px;
            padding: 15px;
            height: 120px;
            border-top: 3px solid #eeeeee;
        }

        .index-con .index-con-left {
            float: left;
            color: #98bf21;
        }

        .index-con-left button {
            border: 0px;
            background-color: #eeeeee;
            color: #98bf21;
            font-size: 18px;
        }

        .index-con-left button:hover {
            background-color: #eeeeee;
            color: red;
            cursor: pointer;
        }

        .index-con .index-con-right {
            float: right;
            text-align: right;
        }

        .index-con-right .price-s {
            width: 270px;
            border-bottom: 1px solid #eeeeee;
            padding: 5px 0px;
        }

        .index-con-right .price-s label {
            color: red;
            font-size: 20px;
        }

        .index-con-right button {
            margin-top: 15px;
            width: 190px;
            background-color: #de9751;
            padding: 4px;
            border-radius: 8px;
            color: #fff;
            font-size: 20px;
        }

        .index-con-right button:hover {
            cursor: pointer;
            font-size: 20px;
        }
    </style>
</head>
<body>
<div class="index">
    <div class="cont">
        <div class="index-top">
            <table class="customers" style="margin-top: 20px">
                <tr>
                    <th class="c1">
                        <input type="checkbox" onclick="allElection(this)">全选
                    </th>
                    <th class="c2"></th>
                    <th class="c3">商品名称</th>
                    <th class="c4">单价</th>
                    <th class="c5">数量</th>
                    <th class="c6">小计</th>
                    <th class="c7">操作</th>
                </tr>

                <#if cartItemList ??>
                    <#list cartItemList as cartItem>
                        <tr>
                            <td>
                                <input type="checkbox" name="cart" class="check" value="${cartItem.cartItemId}">
                            </td>
                            <td>
                                <img src="/ams.jpg">
                            </td>
                            <td class="book-name">
                                ${cartItem.book.bName}
                            </td>
                            <td>
                                ￥ ${cartItem.book.currPrice?c}
                            </td>
                            <td price="${cartItem.book.currPrice?c}" cartItemId="${cartItem.cartItemId?c}">
                                <button href="javascript:" class="btn btn_plus" role="button" title="增加"></button>
                                <input class="inputNum" value="${cartItem.quantity?c}" size="1" readonly="readonly"
                                       style="cursor:not-allowed;">
                                <button href="javascript:" class="btn btn_minus" role="button" title="减少"></button>
                            </td>
                            <td class="subtotal" subtotal="${cartItem.book.currPrice?c}">
                                ￥ ${cartItem.book.currPrice * cartItem.quantity}
                            </td>
                            <td>
                                <button onclick="deleteById(${cartItem.cartItemId}, this)">删除</button>
                            </td>
                        </tr>
                    </#list>
                </#if>
            </table>
        </div>
        <div class="index-con">
            <div class="index-con-left">
                <button onclick="deleteByIds()">批量删除</button>
            </div>
            <div class="index-con-right">
                <div class="price-s">
                    总计：<label class="price-All">￥0</label>
                </div>
                <div>
                    <button onclick="settleAccounts()">结算</button>
                </div>
            </div>
        </div>
    </div>
</div>

<!--<div class="dialog">
    <div class="dig">
        <div>确定删除吗？</div>
        <button onclick="">删除</button>
        <button>取消</button>
    </div>
</div>-->
</body>

<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/js/afquery.js"></script>

<script>
    $('.btn_plus').click(function () {
        var f = $(this).parent();
        btnCount(f, 1);
    });
    $('.btn_minus').click(function () {
        var f = $(this).parent();
        btnCount(f, 0);
    });

    function btnCount(f, isPlus) {
        var count = Number($('.inputNum', f).val());
        var req = {};
        req.isAdd = isPlus;
        req.cartItemId = $(f).attr('cartItemId');
        Af.rest('quantityCartItem.api', req, function (data) {
            if (isPlus == 1) {
                count += 1;
            } else {
                count -= 1;
                if (count < 1) {
                    count = 1;
                }
            }
            $('.inputNum', f).val(count);
            var price = $(f).attr('price');
            var price2 = price * count;
            var tr = $(f).parent();
            price2 = price2.toFixed(2);
            $('.subtotal', tr).text('￥ ' + price2);

            var subtotalAll = $('.index-con-right .price-All').text().substring(1);
            var isSelection = $('.check', tr).is(':checked');
            if (isSelection == true) {
                if (isPlus == 1) {
                    subtotalAll = parseFloat(subtotalAll) + parseFloat(price);
                } else {
                    if (count > 1) {
                        subtotalAll = parseFloat(subtotalAll) - parseFloat(price);
                    }
                }
            }
            subtotalAll = subtotalAll.toFixed(2);
            $('.index-con .price-All').text('￥' + subtotalAll);
        })
    }

    function allElection(e) {
        var isSelection = $(e).is(':checked');
        if (isSelection == true) {
            $("input[type='checkbox']").prop("checked", true);
            var subtotalAll = 0;
            var subtotal = $('.subtotal');
            for (var i = 0; i < subtotal.length; i++) {
                var price = $(subtotal[i]).text().trim();
                price = price.substring(1).trim();
                subtotalAll += parseFloat(price);
            }
            subtotalAll = subtotalAll.toFixed(2);
            $('.index-con .price-All').text('￥' + subtotalAll);
        } else {
            $("input[type='checkbox']").prop("checked", false);
            $('.index-con .price-All').text('￥ 0');
        }
    }

    $('.check').click(function () {
        var tr = $(this).parent().parent();
        var subtotal = $('.subtotal', tr).text().trim();
        subtotal = subtotal.substring(1).trim();
        var subtotalAll = $('.index-con .price-All').text();
        subtotalAll = subtotalAll.substring(1);
        var isSelection = $(this).is(':checked');
        if (isSelection == true) {
            subtotalAll = parseFloat(subtotalAll) + parseFloat(subtotal);
        } else {
            subtotalAll = parseFloat(subtotalAll) - parseFloat(subtotal);
        }
        subtotalAll = subtotalAll.toFixed(2);
        $('.index-con .price-All').text('￥' + subtotalAll);
    });

    function deleteById(cartItemIds, e) {
        var req = {};
        req.cartItemIds = cartItemIds;
        Af.rest('deleteCartItem.api', req, function (data) {
            alert('删除成功!');
            $(e).parent().parent().empty();
        })
    }

    function deleteByIds() {
        var req = {};
        req.cartItemIds = '';
        $("input[name='cart']:checked").each(function (i) {//把所有被选中的复选框的值存入数组
            req.cartItemIds += $(this).val() + ",";
        });
        if (req.cartItemIds == '') {
            alert('请先选中需要删除的条目!');
            return;
        }
        Af.rest('deleteCartItem.api', req, function (data) {
            alert('删除成功!');
            $("input[name='cart']:checked").each(function (i) {//把所有被选中的复选框的值存入数组
                $(this).parent().parent().empty();
            });
        })
    }

    function settleAccounts() {
        var req = {};
        req.cartItemIds = '';
        req.priceAll = $('.price-All').text().trim().substring(1).trim();
        $("input[name='cart']:checked").each(function (i) {//把所有被选中的复选框的值存入数组
            if(i > 0){
                req.cartItemIds += ",";
            }
            req.cartItemIds += $(this).val();
        });
        if (req.cartItemIds == '') {
            alert('请先选中需要购买的条目!');
            return;
        }
        Af.rest('accountsCartItem.api', req, function (data) {
            location.href = "/order.html";
        })
    }
</script>
</html>