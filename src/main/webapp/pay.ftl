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
            width: 650px;
            height: 450px;
            background-color: #ffffff;
            margin: auto;
        }
        .cont .index-top{
            background-color: #eeeeee;
            line-height: 80px;
            padding-left: 25px;
            border-bottom: 5px solid #fff;
        }
        .cont .index-con{
            height: 340px;
            padding-top: 20px;
            border: 3px solid #eeeeee;
        }
        .index-con .index-con-top{
            margin-left: 15px;
            color: red;
        }
        .index-con .index-con-zj{
            margin-left: 15px;
        }
        .index-con .index-con-zj ul{
            padding: 0px;
        }
        .index-con .index-con-zj li{
            list-style:none;
            display: inline-block;
            margin-right: 15px;
            margin-bottom: 15px;
        }
        .index-con-zj .pay-item{
            display: inline-block;
            border: 1px solid #eeeeee;
            box-shadow: 1px 1px 1px 1px #eeeeee;
            padding: 6px;
        }
        .index-con .index-con-bottom{
            margin-left: 15px;
        }
        .index-con-bottom button{
            background-color: #51b169;
            width: 130px;
            padding: 4px;
            border-radius: 8px;
        }
        .index-con-bottom button:hover{
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="index">
    <div class="cont">
        <div class="index-top">
            <label>支付金额：</label><label>￥${order.total}</label>
            <label style="margin-left: 30px">订单编号：${order.oId}</label>
        </div>
        <div class="index-con">
            <div class="index-con-top">
                选择网上银行
            </div>
            <div class="index-con-zj">
                <ul>
                    <li>
                        <input type="checkbox">
                        <div class="pay-item">中国嗯哼银行</div>
                    </li>
                    <li>
                        <input type="checkbox">
                        <div class="pay-item">中国啊哈银行</div>
                    </li>
                    <li>
                        <input type="checkbox">
                        <div class="pay-item">中国哦吼银行</div>
                    </li>
                    <li>
                        <input type="checkbox">
                        <div class="pay-item">中国无敌银行</div>
                    </li>
                    <li>
                        <input type="checkbox">
                        <div class="pay-item">中国演示银行</div>
                    </li>
                    <li>
                        <input type="checkbox">
                        <div class="pay-item">中国数据银行</div>
                    </li>
                    <li>
                        <input type="checkbox">
                        <div class="pay-item">中国工体银行</div>
                    </li>
                    <li>
                        <input type="checkbox">
                        <div class="pay-item">中国建设银行</div>
                    </li>
                    <li>
                        <input type="checkbox">
                        <div class="pay-item">中国广电银行</div>
                    </li>
                    <li>
                        <input type="checkbox">
                        <div class="pay-item">中国工商银行</div>
                    </li>
                    <li>
                        <input type="checkbox">
                        <div class="pay-item">中国农业银行</div>
                    </li>
                    <li>
                        <input type="checkbox">
                        <div class="pay-item">中国广大银行</div>
                    </li>

                </ul>
            </div>
            <div class="index-con-bottom">
                <button onclick="pay(${order.oId})">下一步</button>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/js/afquery.js"></script>

<script>
    $("input[type='checkbox']").click(function () {
        $("input[type='checkbox']").prop("checked", false);
        $(this).prop("checked", true);
    });
    function pay(orderId) {
        var req = {};
        req.orderId = orderId;
        Af.rest('payAdd.api', req, function (data) {
            alert('支付成功!');
            $("input[type='checkbox']").prop("checked", false);
        })
    }
</script>
</html>