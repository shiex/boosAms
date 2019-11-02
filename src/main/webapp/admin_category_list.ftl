<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>分类管理界面</title>
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
        .customers table{
            padding-left: 30px;
        }
    </style>
</head>
<body>
<div class="index">
    <div class="cont">
        <div class="index-top">
            <div onclick="addCategory()" style="width: 100%; text-align: center; color: #4172ca; margin-top: 30px; cursor: pointer">添加一级分类</div>
            <table class="customers" style="margin-top: 20px">
                <tr>
                    <th class="c3">分类名称</th>
                    <th class="c3">描述</th>
                    <th class="c3">操作</th>
                </tr>

                <#if categoryList ??>
                    <#list categoryList as category>
                        <tr categoryId="${category.categoryId?c}" style="background-color: #eeeeee">
                        <td>
                            ${category.categoryName}
                        </td>
                        <td >
                            ${category.categoryDesc}
                        </td>
                        <td>
                            <button onclick="addClassify(${category.categoryId?c})">添加二级分类</button>
                            <button onclick="editCategory(${category.categoryId?c})">修改</button>
                            <button onclick="deleteCategory(${category.categoryId?c}, this)">删除</button>
                        </td>
                            <#if category.classifyList ??>
                                <#list category.classifyList as classify>
                                    <tr classifyId="${classify.classifyId}">
                                        <td>
                                            ${classify.classifyName}
                                        </td>
                                        <td>
                                            ${classify.classifyDesc}
                                        </td>
                                        <td>
                                            <button onclick="editClassify('${classify.classifyId?c}', '${category.categoryName}')">修改</button>
                                            <button onclick="deleteClassify(${classify.classifyId?c}, this)">删除</button>
                                        </td>
                                    </tr>
                                </#list>
                            </#if>
                        </tr>
                    </#list>
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
<script type="text/javascript" src="/js/template-web.js"></script>
<script type="text/javascript" src="/js/jquery.sPage.js"></script>

<script>
    function addCategory() {
        location.href = "/admin/category/add";
    }
    function editCategory(categoryId) {
        location.href = "/admin/category/add?categoryId=" + categoryId;
    }
    function addClassify(categoryId) {
        location.href = "/admin/classify/add";
    }
    function editClassify(classifyId,categoryName) {
        location.href = "/admin/classify/add?classifyId=" + classifyId + "&categoryName=" + categoryName ;
    }



    function deleteCategory(categoryId, e) {
        var req = {};
        req.categoryId = categoryId;
        Af.rest('adminCategoryDelete.api', req, function () {
            alert('删除成功');
            $(e).parent().parent().empty();
        })
    }
    function deleteClassify(classifyId, e) {
        var req = {};
        req.classifyId = classifyId;
        Af.rest('adminClassifyDelete.api', req, function () {
            alert('删除成功');
            $(e).parent().parent().empty();
        })
    }
</script>
</html>