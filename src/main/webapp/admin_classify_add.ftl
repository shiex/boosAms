<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

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
    <#if classify ??>
        <div class="index">
            <div>
                <h3>二级分类</h3>
            </div>
            <div>
                <label>所属分类：</label>
                <label>${categoryName}</label>
            </div>
            <div>
                <label>分类名称：</label>
                <input name="classifyName" value="${classify.classifyName}"/>
            </div>
            <div>
                <label>分类描述：</label>
                <textarea name="classifyDesc" style="width: 270px; height: 150px;">${classify.classifyDesc}</textarea>
            </div>
            <div>
                <button onclick="editClassify()">保存</button>
            </div>
        </div>
        <#else >
            <div class="index">
                <div>
                    <h3>添加二级分类</h3>
                </div>
                <div>
                    <label>分类名称：</label>
                    <input name="classifyName""/>
                </div>
                <div>
                    <label>分类描述：</label>
                    <textarea name="classifyDesc" style="width: 270px; height: 150px;"></textarea>
                </div>
                <div>
                    <label>选择父类：</label>
                    <select id="cae" style="padding: 10px">
                        <#list categoryList as category>
                            <option value="${category.categoryId?c}">
                                ${category.categoryName}
                            </option>
                        </#list>
                    </select>
                </div>
                <div>
                    <button onclick="addClassify()">保存</button>
                </div>
            </div>
    </#if>
</body>

<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/js/afquery.js"></script>
<script type="text/javascript" src="/js/template-web.js"></script>
<script type="text/javascript" src="/js/jquery.sPage.js"></script>
<script>
    function addClassify(){
        var form = new AfForm('.index');
        var classify = form.get();
        classify.categoryId = $("#cae").find("option:selected").val();
        if(classify.classifyName == '' || classify.classifyDesc == ''){
            alert('字段不能为空!');
            return;
        }

        Af.rest('adminClassifyAdd.api', classify, function (data) {
            alert('保存成功');
        })
    }

    function editClassify(){
        var form = new AfForm('.index');
        var classify = form.get();
        if(classify.classifyName == '' || classify.classifyDesc == ''){
            alert('字段不能为空!');
            return;
        }
        Af.rest('adminClassifyEdit.api', classify, function (data) {
            alert('保存成功');
        })
    }
</script>
</html>