<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单管理界面</title>
    <link rel="stylesheet" type="text/css" href="/css/jquery.sPage.css">

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

        .customers ul{
            padding: 0px;
        }
        .customers li{
            list-style:none;
        }
        .customers button:hover{
            cursor: pointer;
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
        .paging {
            float: right;
            width: 900px;
        }

        .paging .num {
            height: 50px;
            line-height: 50px;
            text-align: center;
        }

        .paging .demo {
            margin-bottom: 20px;
            text-align: center;
        }
        .cont .ul-top{
            padding: 0px;
            margin: 0px;
            margin-top: 20px;
        }
        .cont .li-top{
            padding: 0px;
            margin: 0px;
            margin-left: 5px;
            border-left: 1px solid #e0d5d5;
            color: #4172ca;
            display: inline-block;
            padding-left: 8px;
        }
        .cont .li-top:hover{
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="index">
    <div class="cont">
        <div class="index-top">
            <ul class="ul-top">
                <li class="li-top" onclick="loadOrder(0)">全部</li>
                <li class="li-top" onclick="loadOrder(1)">未付款</li>
                <li class="li-top" onclick="loadOrder(2)">已付款</li>
                <li class="li-top" onclick="loadOrder(3)">已发货</li>
                <li class="li-top" onclick="loadOrder(4)">交易成功</li>
                <li class="li-top" onclick="loadOrder(5)">交易取消</li>
            </ul>
            <table class="customers" style="margin-top: 20px">
                <tr>
                    <th class="c1"></th>
                    <th class="c3">订单号</th>
                    <th class="c2">下单时间</th>
                    <th class="c4">金额</th>
                    <th class="c5">订单状态</th>
                    <th class="c6">操作</th>
                </tr>

                <#if orderList ??>
                    <#list orderList as order>
                        <tr>
                            <td style="padding-left: 35px">
                                <img src="cc.jpg">
                            </td>
                            <td>
                                ${order.oId}
                            </td>
                            <td>
                                ${order.orderTime?datetime}
                            </td>
                            <td class="subtotal">
                                <h4 style="margin: 0px">￥ ${order.total}</h4>
                            </td>
                            <td>
                                ${order.statusStr}
                            </td>
                            <td>
                                <ul>
                                    <li style="color: #98bf21;">
                                        <button onclick="payData(${order.oId})">查看</button>
                                    </li>
                                    <li style="color: #98bf21;">
                                        <button onclick="payData(${order.oId})">取消</button>
                                    </li>
                                    <li style="color: #98bf21;">
                                        <button onclick="payData(${order.oId})">发货</button>
                                    </li>
                                </ul>
                            </td>
                        </tr>
                    </#list>

                    <#else>
                    <div style="width: 90%; margin: auto; line-height: 200px;">
                        <h4>暂无订单</h4>
                    </div>
                </#if>
            </table>
        </div>
        <div class="index-con" style="border: 0px;margin-top: 10px; padding: 0px;">
            <div class="paging" classifyId="0">
                <div id="myPage" class="demo"></div>
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
<script type="text/javascript" src="/js/ax-jquery.js"></script>
<script type="text/javascript" src="/js/template-web.js"></script>
<script type="text/javascript" src="/js/jquery.sPage.js"></script>

<script>
    // 结合Ajax使用，仅供参考
    function loadPageData(page, userId) {
        var count = {};
        var req = {};
        req.page = page;
        req.userId = userId;
        Ax.rest('/selectByPageBook.api', req, function (data) {
            var p = page || 1;
            $("#myPage").sPage({
                page: 1,// 当前页码
                total: 111,// 数据总条数
                pageSize: 8,// 每页显示多少条数据
                showTotal: true,// 是否显示总条数，默认关闭：false
                totalTxt: "共{total}条",// 数据总条数文字描述，{total}为占位符，默认"共{total}条"
                noData: false,// 没有数据时是否显示分页，默认false不显示，true显示第一页
                showSkip: true,// 是否显示跳页，默认关闭：false
                showPN: true,// 是否显示上下翻页，默认开启：true
                prevPage: "上一页",// 上翻页文字描述，默认“上一页”
                nextPage: "下一页",// 下翻页文字描述，默认“下一页”
                backFun: function (page) {
                    //点击分页按钮回调函数，返回当前页码
                    $("#pNum").text(page);
                    loadPageData(page, data.userId);
                }
            });
            var orderData = {
                orderList: data.orderList
            }
            var orderHtml = template('order-tmp', orderData);
            $('#order-list').empty();
            $('#order-list').append(bookHtml);
        });
    }
    loadPageData(1, userId);

    function payData(orderId) {
        location.href = "/admin/orderpay.html?orderId=" + orderId;
    }
    function loadOrder(status) {
        if (status == 0) {
            location.href = "/admin/order.html?";
        } else {
            location.href = "/admin/order.html?status="+status;
        }
    }
</script>
</html>