<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加图书</title>

    <style>
        body {
            margin: 0px;
            padding: 0px;
        }

        .index {
            min-width: 1200px;
        }

        .index .cont {
            min-width: 1200px;
            margin-top: 150px;
        }

        .cont .index-top {
            width: 900px;
            margin: auto;
            border-bottom: 3px solid #eeeeee;
            padding-bottom: 20px;
        }

        .cont .div-item {
            display: inline-block;
            width: 100px;
            text-align: right;
        }

        .cont .index-zj {
            width: 900px;
            margin: auto;
        }

        .cont .index-bottom {
            width: 900px;
            margin: auto;
        }

        .cont .div-s {
            margin-top: 15px;
        }

        .div-s .button {
            margin-left: 100px;
            background-color: red;
            width: 150px;
            height: 40px;
            border-radius: 8px;
            color: #fff;
            font-size: 22px;
        }

        .div-s .button:hover {
            cursor: pointer;
        }

        input {
            padding: 6px;
        }
        .imgBtn{
            border: 0px;
            background-color: #b4deb7;
            color: #fff;
            padding: 6px;
            border-radius: 6px;
        }
        .imgBtn:hover{
            cursor: pointer;
            background-color: #51b169;
        }
    </style>
</head>
<body>
<div class="index">
    <#if book ??>
        <div class="cont">
            <div class="index-top">
                <div class="div-s">
                    <h3>图书编辑中</h3>
                </div>
                <div class="div-s">
                    <div class="div-item">书名：</div>
                    <input name="bName" value="${book.bName}" class="input" srt="书名" style="width: 600px">
                </div>
                <div class="div-s">
                    <div class="div-item">当前价格：</div>
                    <input name="currPrice" srt="当前价格" value="${book.currPrice?c}" class="input" style="width: 70px">
                </div>
                <div class="div-s">
                    <div class="div-item">定价：</div>
                    <input name="price" value="${book.price?c}" srt="定价" class="input" style="width: 70px">
                    <div class="div-item" style="margin-left: 10px">折扣：</div>
                    <input name="discount" value="${book.discount?c}" class="input" srt="折扣" style="width: 50px;">折
                </div>
            </div>
            <div class="index-zj">
                <div class="div-s">
                    <div class="div-item">作者：</div>
                    <input name="author" value="${book.author}" class="input" srt="作者" style="width: 120px">
                </div>
                <div class="div-s">
                    <div class="div-item">出版社：</div>
                    <input name="press" value="${book.press}" class="input" srt="出版社" style="width: 200px">
                </div>
                <div class="div-s">
                    <div class="div-item">出版时间：</div>
                    <input name="publishTime" value="${book.publishTime?datetime}" class="input" srt="出版时间"
                           style="width: 90px">
                </div>
                <div class="div-s">
                    <div style="width: 260px; display: inline-block">
                        <div class="div-item">版次：</div>
                        <input name="edition" value="${book.edition?c}" class="input" srt="版次" style="width: 40px">
                    </div>
                    <div style="width: 260px; display: inline-block">
                        <div class="div-item">页数：</div>
                        <input name="pageNum" value="${book.pageNum?c}" class="input" srt="页数" style="width: 50px">
                    </div>
                    <div style="width: 260px; display: inline-block">
                        <div class="div-item">字数：</div>
                        <input name="wordNum" value="${book.wordNum?c}" class="input" srt="字数" style="width: 80px">
                    </div>
                </div>
                <div class="div-s">
                    <div style="width: 260px; display: inline-block">
                        <div class="div-item">印刷时间：</div>
                        <input name="printTime" value="${book.printTime?datetime}" class="input" srt="印刷时间"
                               style="width: 90px">
                    </div>
                    <div style="width: 260px; display: inline-block">
                        <div class="div-item">开本：</div>
                        <input name="bookSize" value="${book.bookSize?c}" class="input" srt="开本" style="width: 30px">
                    </div>
                    <div style="width: 260px; display: inline-block">
                        <div class="div-item">纸张：</div>
                        <input name="paper" value="${book.paper}" class="input" srt="纸张" style="width: 50px">
                    </div>
                </div>
            </div>
            <div class="index-bottom">
                <div class="div-s">
                    <button class="button" onclick="bookSave(${book.bId})">保存</button>
                </div>
            </div>
        </div>
    <#else >
        <div class="cont">
            <div class="index-top">
                <div class="div-s" style="color: red; margin-left: 70px">
                    <#if categoryList ??>
                    <#else >
                        <h3 style="display: inline-block">请先添加一级分类哦</h3>
                    </#if>
                    <#if classifyList ??>
                    <#else >
                        <h3 style="display: inline-block; margin-left: 20px">请先添加二级分类哦</h3>
                    </#if>
                </div>
                <div class="div-s">
                    <div class="div-item">书名：</div>
                    <input name="bName" class="input" srt="书名" style="width: 600px">
                </div>
                <div class="div-s">
                    <div class="div-item">书籍图片：</div>
                    <img class="img" src="ams.png" style="height: 60px; width: 60px">
                    <button class="imgBtn" onclick="M.uploadPhoto()">点击选择图片</button>
                    <input type='file' class='filebutton' style='display:none'/>
                </div>
                <div class="div-s">
                    <div class="div-item">当前价格：</div>
                    <input name="currPrice" srt="当前价格" class="input" style="width: 70px">
                </div>
                <div class="div-s">
                    <div class="div-item">定价：</div>
                    <input name="price" srt="定价" class="input" style="width: 70px">
                    <div class="div-item" style="margin-left: 10px">折扣：</div>
                    <input name="discount" class="input" srt="折扣" style="width: 50px;">折
                </div>
            </div>
            <div class="index-zj">
                <div class="div-s">
                    <div class="div-item">作者：</div>
                    <input name="author" class="input" srt="作者" style="width: 120px">
                </div>
                <div class="div-s">
                    <div class="div-item">出版社：</div>
                    <input name="press" class="input" srt="出版社" style="width: 200px">
                </div>
                <div class="div-s">
                    <div class="div-item">出版时间：</div>
                    <input name="publishTime" class="input" srt="出版时间" style="width: 90px">
                </div>
                <div class="div-s">
                    <div style="width: 260px; display: inline-block">
                        <div class="div-item">版次：</div>
                        <input name="edition" class="input" srt="版次" style="width: 40px">
                    </div>
                    <div style="width: 260px; display: inline-block">
                        <div class="div-item">页数：</div>
                        <input name="pageNum" class="input" srt="页数" style="width: 50px">
                    </div>
                    <div style="width: 260px; display: inline-block">
                        <div class="div-item">字数：</div>
                        <input name="wordNum" class="input" srt="字数" style="width: 80px">
                    </div>
                </div>
                <div class="div-s">
                    <div style="width: 260px; display: inline-block">
                        <div class="div-item">印刷时间：</div>
                        <input name="printTime" class="input" srt="印刷时间" style="width: 90px">
                    </div>
                    <div style="width: 260px; display: inline-block">
                        <div class="div-item">开本：</div>
                        <input name="bookSize" class="input" srt="开本" style="width: 30px">
                    </div>
                    <div style="width: 260px; display: inline-block">
                        <div class="div-item">纸张：</div>
                        <input name="paper" class="input" srt="纸张" style="width: 50px">
                    </div>
                </div>
                <div class="div-s">
                    <div class="div-item">一级分类：</div>
                    <div id="category" style="display: inline-block">
                        <select style="width: 200px;  padding: 6px" id="se">
                            <#if categoryList ??>
                                <#list categoryList as category>
                                    <option value="${category.categoryId}">${category.categoryName}</option>
                                </#list>
                            </#if>
                        </select>
                    </div>
                    <div class="div-item">二级分类：</div>
                    <div id="classify" style="display: inline-block">
                        <select style="width: 200px;  padding: 6px" id="se2">
                            <#if classifyList ??>
                                <#list classifyList as classify>
                                    <option value="${classify.classifyId}">${classify.classifyName}</option>
                                </#list>
                            </#if>
                        </select>
                    </div>
                </div>
            </div>
            <div class="index-bottom">
                <div class="div-s">
                    <button class="button" onclick="bookAdd()">新书上架</button>
                </div>
            </div>
        </div>
    </#if>
</div>
</body>

<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/js/afquery.js"></script>
<script type="text/javascript" src="/js/template-web.js"></script>

<script type="text/html" id="classify-tmp">
    <select style="width: 200px; padding: 6px" id="sele2">
        {{each classifyList as classify}}
        {{if classify != null}}
        <option value="{{classify.classifyId}}">{{classify.classifyName}}</option>
        {{/if}}
        {{/each}}
    </select>
</script>

<script>
    function bookAdd() {
        var texts = '';
        $('.input').each(function (i) {//把所有被选中的复选框的值存入数组
            var text = $(this).val().trim();
            if (text == '' || text == null) {
                if (i > 0) {
                    texts += ",";
                }
                var str = $(this).attr('srt');
                texts += str;
            }
        });
        if (texts != '') {
            alert("[" + texts + "] --- 字段，" + "不得为空");
        }
        var bookForm = new AfForm('.cont');
        var book = bookForm.get();

        var date = /^(\d{1,4})(-)(\d{1,2})\2(\d{1,2})$/;
        var r = book.printTime.match(date);
        if (r == null) {
            alert("印刷时间日期格式不符合YYYY-MM-DD格式!");
            return;
        }
        r = book.publishTime.match(date)
        if (r == null) {
            alert("出版时间日期不符合YYYY-MM-DD格式!");
            return;
        }

        book.categoryId = $('#category select').val();
        book.classifyId = $('#classify select').val();
        Af.rest('adminBookAdd.api', book, function (data) {
            alert('添加成功');
        });
    }

    function bookSave(bookId) {
        var texts = '';
        $('.input').each(function (i) {//把所有被选中的复选框的值存入数组
            var text = $(this).val().trim();
            if (text == '' || text == null) {
                if (i > 0) {
                    texts += ",";
                }
                var str = $(this).attr('srt');
                texts += str;
            }
        });
        if (texts != '') {
            alert("[" + texts + "] --- 字段，" + "不得为空");
        }
        var bookForm = new AfForm('.cont');
        var book = bookForm.get();
        book.bId = bookId;

        var date = /^(\d{1,4})(-)(\d{1,2})\2(\d{1,2})$/;
        var r = book.printTime.match(date);
        if (r == null) {
            alert("印刷时间日期格式不符合YYYY-MM-DD格式!");
            return;
        }
        r = book.publishTime.match(date)
        if (r == null) {
            alert("出版时间日期不符合YYYY-MM-DD格式!");
            return;
        }

        Af.rest('adminBookAdd.api', book, function (data) {
            alert('修改成功!');
        });
    }

    $('#category select').change(function () {
        var categoryId = $(this).children('option:selected').val();//这就是selected的值
        loadClassify(categoryId);
    });

    function loadClassify(categoryId) {
        var req = {};
        req.categoryId = categoryId;
        Af.rest('adminLoadClassify.api', req, function (data) {
            var classifyData = {
                classifyList: data.classifyList
            }
            var classifyHtml = template('classify-tmp', classifyData);
            $('#classify').empty();
            $('#classify').append(classifyHtml);
        })
    }

    var M = {};

    M.init = function () {
        M.uploader = new AfFileUploader();
        M.uploader.setButton('.filebutton').setObserver(this);
    }
    M.uploadPhoto = function () {
        M.uploader.setUploadUrl("photoFile.upload");
        M.uploader.openFileDialog();
    }

    M.uploadHandleEvent = function (msg, uploader) {
        if (msg == 'complete') {
            // 取得图片地址
            var url = uploader.response.data.storePath;
            $('.cont .img').attr('src', url);
        }
    }

    M.init();
</script>
</html>