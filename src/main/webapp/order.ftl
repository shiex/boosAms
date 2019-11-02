<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单界面</title>

    <style>
        body {
            margin: 0px;
            padding: 0px;
        }
        .WH-1200{
            width: 1200px;
        }
        .index {
            min-width: 1200px;
        }

        .index .cont {
            width: 1200px;
            margin: auto;
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
        .dialog{
            position: fixed;
            top: 50%;
            left: 50%;
            width:90%;
            height: 45%;
            -webkit-transform: translateX(-50%) translateY(-50%);
            -moz-transform: translateX(-50%) translateY(-50%);
            -ms-transform: translateX(-50%) translateY(-50%);
            transform: translateX(-50%) translateY(-50%);
            text-align: center;
            display: none;
        }
        .dialog .dig{
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
        .index-con .index-con-left{
            float: left;
            color: #98bf21;
        }
        .index-con-left button{
            border: 0px;
            background-color: #eeeeee;
            color: #98bf21;
            font-size: 18px;
        }
        .index-con-left button:hover{
            background-color: #eeeeee;
            color: red;
            cursor: pointer;
        }
        .index-con .index-con-right{
            float: right;
            text-align: right;
        }
        .index-con-right .price-s{
            width: 270px;
            border-bottom: 1px solid #eeeeee;
            padding: 5px 0px;
        }
        .index-con-right .price-s label{
            color: red;
            font-size: 20px;
        }
        .index-con-right button{
            margin-top: 15px;
            width: 190px;
            background-color: #de9751;
            padding: 4px;
            border-radius: 8px;
            color: #fff;
            font-size: 20px;
        }
        .index-con-right button:hover{
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
                    <th class="c2"></th>
                    <th class="c3">图书名称</th>
                    <th class="c4">单价</th>
                    <th class="c5">数量</th>
                    <th class="c6">小计</th>
                </tr>
                <#if cartItemList ??>
                    <#list cartItemList as cartItem>
                        <tr>
                            <td style="padding-left: 35px">
                                <img src="cc.jpg">
                            </td>
                            <td class="book-name">
                                ${cartItem.book.bName}
                            </td>
                            <td>
                                ￥ ${cartItem.book.currPrice}
                            </td>
                            <td>
                                ${cartItem.quantity}
                            </td>
                            <td class="subtotal">
                                ￥ ${cartItem.book.currPrice * cartItem.quantity}
                            </td>
                        </tr>
                    </#list>
                </#if>
            </table>
        </div>
        <div class="index-con" style="border: 0px;margin-top: 10px; padding: 0px;">
            <div class="index-con-right WH-1200">
                <div class="price-s" style="border: 0px; float: right">
                    总计：<label class="price-All" style="margin-right: 30px">￥${priceAll}</label>
                </div>
            </div>
            <div class="index-con-left WH-1200" style="background-color: #eeeeee; margin-top: 20px">
                <h3 style="margin: 10px">收货地址</h3>
            </div>
            <div class="index-con-left WH-1200" style="margin-top: 20px">
                <input class="address" placeholder="请输入收货地址" style="width: 600px;padding: 8px">
            </div>
            <div class="index-con-right WH-1200" >
                <div class="price-s" style="border: 0px; float: right; margin-top: 5px">
                    <button style="margin-right: 25px" onclick="commitOrder()">提交订单</button>
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
    function commitOrder() {
        var address = $('.address').val().trim();
        if (address == '' || address == null) {
            alert('请先填写收货地址!');
            return;
        }
        location.href = "/orderok.html?address=" + address;
    }
</script>
</html>