<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <link rel="stylesheet" type="text/css" href="/css/jquery.sPage.css">

    <style>
        body {
            margin: 0px;
            padding: 0px;
        }

        ul, li {
            padding: 0px;
            margin: 0px;
            list-style-type: none;
            color: #fff;
        }

        .index {
            background: #fff;
            min-width: 1200px;
        }

        .index .top {
            background-color: #5bb995;
            height: 70px;
            min-width: 1200px;
        }

        .top .static-top {
            margin: auto;
            width: 1200px;
            height: 100%;
        }

        .static-top h2 {
            text-align: center;
            margin: 0px;
            padding: 0px;
            color: #fff;
        }

        .static-top li {
            display: inline-block;
            padding: 0px 10px;
        }

        .static-top li a {
            color: #ffffff;
        }

        .static-top li a:hover {
            color: #444444;
        }

        .index .content {
            width: 100%;
            padding: 10px 0px;
            min-width: 1170px;
            min-height: 500px;
            margin-bottom: 20px;
        }

        .content .index-content {
            width: 1200px;
            margin: auto;
            min-height: 500px;
        }

        .content .index-content .index-content-left {
            width: 200px;
            border-right: 1px solid #5bb995;
            padding: 0px 10px;
            min-height: 500px;
            display: inline-block;
        }

        .index-content-left .div-item {
            padding: 7px;
            background-color: #5bb995;
            border: 1px solid #c3bcbc;
            padding-left: 20px;
            color: #fff;
        }

        .index-content-left .div-item-top {
            padding: 7px;
            background-color: #5bb995;
            border: 1px solid #c3bcbc;
            padding-left: 20px;
            color: #fff;
            height: 50px;
            line-height: 50px;
        }

        .index-content-left .li-item {
            padding: 7px;
            background-color: #c5e0c7;
            border: 1px solid #eeeeee;
            padding-left: 20px;
            color: #444444;
        }

        .index-content-left .div-item:hover {
            cursor: pointer;
            color: #444;
        }

        .index-content-left .li-item:hover {
            cursor: pointer;
            color: #fff;
            background-color: #b4deb7;
        }

        .index-content-left ul {
            display: none;
        }

        .content .index-content .index-content-right {
            width: 900px;
            margin-left: 10px;
            display: inline-block;
            min-height: 500px;
            margin-top: 0px;
            float: right;
        }

        .index-content-right .btn {
            text-align: center;
        }

        .index-content-right .btn input {
            border: 2px solid #5bb995;
            padding: 5px;
            width: 300px;
        }

        .index-content-right button {
            border: 2px solid #5bb995;
            padding: 2px;
            background-color: #5bb995;
            width: 100px;
            color: #fff;
            font-size: 16px;
        }

        .index-content-right button:hover {
            cursor: pointer;
        }

        .index-content-right h1 {
            text-align: center;
        }

        .index-content-right .book-list {
            margin: 20px 0px;
            width: 100%;
        }

        .index-content-right .book-list .book-item {
            width: 20%;
            background-color: #fff;
            height: 290px;
            display: inline-block;
            padding: 20px;
            position: relative;
            font-size: 15px;
        }

        .book-item .book-it {
            margin-top: 10px;
            position: absolute;
            top: 205px;
            overflow:hidden
        }

        .book-item .book-it .book {
            margin-top: 2px;
        }

        .book .label {
            margin-left: 15px;
        }

        .book-item .img {
            height: 185px;
            width: 80%;
            text-align: center;
            position: absolute;

        }

        .book-item .img img {
            height: 100%;
            width: 90%;
        }

        .index-content-right .book-list .paging {
            width: 100%;
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
        div.or{
            overflow:hidden;
            max-height: 20px;
        }
    </style>
</head>
<body>
<div class="index">
    <div class="top">
        <#include '/index_top.ftl'>
        <div class="content">
            <div class="index-content">
                <div class="index-content-left">
                    <div>
                        <div class="div-item-top">
                            ITCAST网络图书商城
                        </div>
                    </div>
                    <#if categoryList ??>
                        <#list categoryList as category>
                            <div class="categoty">
                                <div class="div-item">
                                    ${category.categoryName}
                                </div>
                                <#if category.classifyList ??>
                                    <ul class="ul-item">
                                        <#list category.classifyList as classify>
                                            <li class="li-item" classifyId="${classify.classifyId?c}">
                                                ${classify.classifyName}
                                            </li>
                                        </#list>
                                    </ul>
                                </#if>
                            </div>
                        </#list>
                    </#if>
                </div>
                <div class="index-content-right">
                    <div class="btn">
                        <input class="find" placeholder="输入需要查找的书籍名称"/>
                        <button onclick="find()">搜索</button>
                        <select style="height: 30px; padding: 5px" id="type">
                            <option value="0">请选择查询条件</option>
                            <option value="1">书名</option>
                            <option value="2">作者</option>
                            <option value="3">出版社</option>
                        </select>
                    </div>
                    <div class="book-list" id="book-list">
                        <h1>
                            欢迎，欢迎！热烈欢迎！
                        </h1>
                    </div>
                    <div class="paging" classifyId="0">
                        <div id="myPage" class="demo"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/js/afquery.js"></script>
<script type="text/javascript" src="/js/template-web.js"></script>
<script type="text/javascript" src="/js/jquery.sPage.js"></script>

<script type="text/html" id="book-tmp">
    {{each bookList as book}}
    {{if book != null}}
    <div class="book-item">
        <div class="img">
            <img src="{{book.imageUri}}"/>
        </div>
        <div class="book-it">
            <div class="book">
                <label style="color: red">￥{{book.currPrice}}</label>
                <label class="label">{{book.price}}</label>
                <label class="label" style="color: red">({{book.discount}})折</label>
            </div>
            <div class="book or">
                <a href="/book.html?bookId={{book.bId}}">{{book.bName}}</a>
            </div>
            <div class="book">
                <label>作者：</label>
                <label style="color: #4172ca">{{book.author}}</label>
            </div>
            <div class="book">
                <label>出版社：</label>
                <label style="color: #4172ca">{{book.press}}</label>
            </div>
            <div class="book">
                <label>出版时间：</label>
                <label>{{book.publishTime}}</label>
            </div>
        </div>
    </div>
    {{/if}}
    {{/each}}
</script>

<script>
    // 结合Ajax使用，仅供参考
    function loadPageData(page, classifyId) {
        var count = {};
        var req = {};
        req.page = page;
        req.classifyId = classifyId;
        Af.rest('/selectByPageBook.api', req, function (data) {
            var p = page || 1;
            $("#myPage").sPage({
                page: p,// 当前页码
                total: data.count,// 数据总条数
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
                    loadPageData(page, data.classifyId);
                }
            });
            var bookData = {
                bookList: data.bookList
            }
            var bookHtml = template('book-tmp', bookData);
            $('#book-list').empty();
            $('#book-list').append(bookHtml);
        });
    }

    $('.div-item').click(function () {
        var f = $(this).parent();
        var isShow = $('.ul-item', f).is(":visible");
        if (isShow == true) {
            $('.ul-item', f).hide();
        } else {
            $('.ul-item', f).show();
        }
    })

    $('.li-item').click(function () {
        var classifyId = $(this).attr('classifyId');
        $('.index-content-right .paging').attr(classifyId);
        $('.paging').show();
        loadPageData(1, classifyId);
    })

    function find() {
        var req = {};
        req.type = $('#type').val();
        req.find = $('.find').val();
        if (req.type == 0){
            alert('请先选择查询类型');
            return;
        }
        if (req.find == '' || req.find == null) {
            alert('请先输入搜索条件!');
            return;
        }
        Af.rest('findBookAll.api', req, function (data) {
            $('.paging').hide();
            var bookData = {
                bookList: data.bookList
            }
            var bookHtml = template('book-tmp', bookData);
            $('#book-list').empty();
            $('#book-list').append(bookHtml);
        })
    }
</script>
</html>