<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>下单成功页面</title>

    <style>
        .index{
            width: 900px;
            margin: auto;
            margin-top: 200px;
        }
        .index .cont{
            width: 700px;
            height: 300px;
            background-color: #ffffff;
            margin: auto;
            border: 3px solid #eeeeee;
        }
        .cont .index-top{
            background-color: #eeeeee;
            line-height: 40px;
            padding-left: 15px;
        }
        .cont .index-con{
            height: 240px;
            padding-top: 20px;
        }
        .index-con .index-con-left{
            width: 260px;
            text-align: center;
            display: inline-block;
        }
        .index-con .index-con-right{
            width: 410px;
            display: inline-block;
        }
        .index-con-right ul{
            padding: 0px;
        }
        .index-con-right li{
            list-style:none;
        }
        .index-con-right h5{
            margin: 5px 0px;
        }
        .index-con-right button{
            width: 70px;
            padding: 4px;
            background-color: #51b169;
        }
        .index-con-right button:hover{
            cursor: pointer;
            border: 2px solid #444444;
            border-radius: 8px;
        }
        .Mar-40W{
            margin-left: 40px;
        }
    </style>
</head>
<body>
<div class="index">
    <div class="cont">
        <div class="index-top">
            订单已生成
        </div>
        <div class="index-con">
            <div class="index-con-left">
                <div class="img">
                    <img src="ams.png" style="width: 150px; height: 150px">
                </div>
            </div>
            <div class="index-con-right">
                <ul>
                    <li><h5>订单编号</h5></li>
                    <li class="Mar-40W">${order.oId}</li>
                    <li><h5>合计金额</h5></li>
                    <li class="Mar-40W">
                        <h3 style="margin: 0px; color: red">￥${order.total}</h3>
                    </li>
                    <li><h5>收货地址</h5></li>
                    <li class="Mar-40W">${order.address}</li>
                    <li style="margin-top: 10px">
                        ITCAST书城感谢您的支持，祝您购物愉快！<button style="margin-left: 15px" onclick="pay()">支付</button>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>

<script>
    function pay() {
        location.href = "/orderpay.html?orderId=" + ${order.oId};
    }
</script>
</html>