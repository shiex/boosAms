<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加分类</title>

    <style>
        .index{
            width: 460px;
            margin: auto;
            margin-top: 200px;
            background-color: #b4deb7;
            padding: 20px;
        }
        div{
            margin-top: 15px;
        }
        input{
            padding: 8px;
        }
    </style>
</head>
<body>
<#if category ??>
    <div class="index">
        <div>
            <h3>一级分类</h3>
        </div>
        <div>
            <label>分类名称：</label>
            <input name="categoryName" value="${category.categoryName}"/>
        </div>
        <div>
            <label>分类描述：</label>
            <textarea name="categoryDesc" style="width: 270px; height: 150px;">${category.categoryDesc}</textarea>
        </div>
        <div>
            <button onclick="saveCategory(${category.categoryId})">保存</button>
        </div>
    </div>
    <#else >
        <div class="index">
            <div>
                <h3>添加一级分类</h3>
            </div>
            <div>
                <label>分类名称：</label>
                <input name="categoryName"/>
            </div>
            <div>
                <label>分类描述：</label>
                <textarea name="categoryDesc" style="width: 270px; height: 150px;"></textarea>
            </div>
            <div>
                <button onclick="saveCategory(0)">保存</button>
            </div>
        </div>
</#if>
</body>

<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/js/afquery.js"></script>
<script type="text/javascript" src="/js/template-web.js"></script>
<script type="text/javascript" src="/js/jquery.sPage.js"></script>
<script>
    function saveCategory(categoryId){
        var form = new AfForm('.index');
        var category = form.get();
        category.categoryId = categoryId;
        if(category.categoryName == '' || category.categoryDesc == ''){
            alert('字段不能为空!')
            return;
        }

        Af.rest('adminCategorySave.api', category, function (data) {
            alert('添加成功');
        })
    }
</script>
</html>