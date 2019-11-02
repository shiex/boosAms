<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理界面</title>
    <link rel="stylesheet" type="text/css" href="/css/jquery.sPage.css">

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

        .customers .status {
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

        .customers ul {
            padding: 0px;
        }

        .customers li {
            list-style: none;
        }

        .customers button:hover {
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

        .cont .ul-top {
            padding: 0px;
            margin: 0px;
            margin-top: 20px;
        }

        .cont .li-top {
            padding: 0px;
            margin: 0px;
            margin-left: 5px;
            border-left: 1px solid #e0d5d5;
            color: #4172ca;
            display: inline-block;
            padding-left: 8px;
        }

        .cont .li-top:hover {
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="index">
    <div class="cont">
        <div class="index-top">
            <table class="customers" style="margin-top: 20px">
                <tr>
                    <th class="c1">用户ID</th>
                    <th class="c3">用户名</th>
                    <th class="c2">禁止状态</th>
                    <th class="c4">邮箱</th>
                    <th class="c6">操作</th>
                </tr>

                <#if userList ??>
                    <#list userList as user>
                        <tr>
                            <td style="padding-left: 35px">
                                ${user.uId}
                            </td>
                            <td>
                                ${user.loginName}
                            </td>
                            <td class="status">
                                <#if user.status == true>
                                    已禁止
                                <#else >
                                    未禁止
                                </#if>
                            </td>
                            <td>
                                ${user.emali}
                            </td>
                            <td>
                                <button onclick="addStatus(${user.uId}, this)">禁止</button>
                                <button onclick="deleteStatus(${user.uId}, this)">解除禁止</button>
                            </td>
                        </tr>
                    </#list>

                <#else>
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
<script type="text/javascript" src="/js/afquery.js"></script>

<script>
    function addStatus(userId, e) {
        var req = {};
        req.uId = userId;
        req.status = 1;
        Af.rest('adminStatusAdd.api', req, function (data) {
            alert('已禁止!');
            var tr = $(e).parent().parent();
            $('.status', tr).text('已禁止');
        })
    }

    function deleteStatus(userId, e) {
        var req = {};
        req.uId = userId;
        req.status = 0;
        Af.rest('adminStatusDelete.api', req, function (data) {
            alert('已解除禁止!');
            var tr = $(e).parent().parent();
            $('.status', tr).text('未禁止');
        })
    }
</script>
</html>