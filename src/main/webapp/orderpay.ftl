<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单详细页面</title>

    <style>
        .index{
            width: 1000px;
            margin: auto;
            margin-top: 100px;
        }
        .index .cont{
            width: 950px;
            background-color: #ffffff;
            margin: auto;
            border: 3px solid #c7c1c1;
            padding: 15px 20px;
            margin-bottom: 50px;
        }
        .cont .index-top{
            height: 65px;
            padding-left: 15px;
            border-bottom: 1px solid #eeeeee;
        }
        .cont .index-con{
            padding-top: 20px;
            min-height: 300px;
        }
        .index-con .index-con-top{
            margin-left: 15px;
            min-height: 150px;
        }
        .index-con-top .customers {
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

        .customers .subtotal {
            color: red;
        }

        .customers .c1 {
            width: 50px
        }

        .customers .c2 {
            width: 90px
        }

        .customers .c3 {
            width: 370px;
            text-align: center;
        }

        .customers .c4 {
            width: 110px
        }

        .customers .c5 {
            width: 80px
        }

        .customers ul{
            padding: 0px;
        }
        .customers li{
            list-style:none;
        }
        .customers button:hover{
            cursor: pointer;
        }
        .cont h4{
            margin: 0px;
        }
        .index-con .index-con-bottom{
            margin-top: 10px;
        }
        .index-con-bottom .btn{
            width: 830px;
            padding-left: 80px;
            text-align: right;
        }
        .btn button{
            width: 110px;
            border-radius: 6px;
            padding: 4px;
            margin-top: 4px;
            color: #fff;
            border: 0px;
        }
        .btn button:hover{
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="index">
    <div class="cont">
        <div style="padding: 15px">
            <label>
                <h4 style="display: inline-block">订单号：</h4>${order.oId?c}
            </label>
            <label style="margin-left: 50px">
                <h4 style="display: inline-block">下单时间：</h4>${order.orderTime?datetime}
            </label>
        </div>
        <div class="index-top">
            <div style="height: 30px"><h4>收货人信息</h4></div>
            <div style="height: 30px; margin-left: 50px">${order.address}</div>
        </div>
        <div class="index-con">
                <div class="index-con-top">
                    <div>
                        <h4>商品清单</h4>
                    </div>
                    <div style="margin-left: 25px">
                        <table class="customers" style="margin-top: 20px">
                            <tr>
                                <th class="c1"></th>
                                <th class="c3">商品名称</th>
                                <th class="c2">单价</th>
                                <th class="c5">数量</th>
                                <th class="c4">小计</th>
                            </tr>

                            <#list order.orderItemList as orderItem>
                                <tr>
                                    <td style="padding-left: 35px">
                                        <img src="cc.jpg">
                                    </td>
                                    <td>
                                        ${orderItem.book.bName}
                                    </td>
                                    <td>
                                        ${orderItem.book.currPrice}
                                    </td>
                                    <td class="subtotal">
                                        ${orderItem.quantity}
                                    </td>
                                    <td>
                                        ￥${orderItem.subtotal}
                                    </td>
                                </tr>
                            </#list>

                        </table>
                    </div>
                </div>
                <div class="index-con-bottom">
                    <div class="btn">
                        <label>您需支付：</label><label style="font-size: 22px; color: red">￥${order.total}</label><br>
                        <button style="background-color: #009688" onclick="promptlyPay(${order.oId})">立即支付</button><br>
                        <button style="background-color: #444444" onclick="callPay(${order.oId})">取消订单</button><br>
                        <button style="background-color: #4172ca" onclick="confirmPay(${order.oId})">确认收货</button><br>
                    </div>
                </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/js/afquery.js"></script>

<script>
    function promptlyPay(orderId) {
        location.href = "/pay.html?orderId=" + orderId;
    }
    function callPay(orderId) {
        var req = {};
        req.orderId = orderId;
        Af.rest('payCall.api', req, function (data) {
            alert('订单已取消');
        })
    }
    function confirmPay(orderId) {
        var req = {};
        req.orderId = orderId;
        Af.rest('payConfirm.api', req, function (data) {
            alert('已确认收货，记得给好评哦');
        })
    }
</script>
</html>