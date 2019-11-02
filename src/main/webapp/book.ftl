<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图书详情</title>

    <style>
        body{
            margin: 0px;
            padding: 0px;
        }
        .index{
            min-width: 1200px;
        }
        .index .cont{
            min-width: 1200px;
        }
        .cont .index-top{
            width: 1200px;
            margin: auto;
        }
        .cont .index-con{
            width: 1200px;
            margin: auto;
            margin-top: 20px;
            margin-bottom: 50px;
        }
        .cont .index-con .index-con-left{
            float: left;
            margin-top: 15px;
        }
        .index-con-left .left-img{
            height: 420px;
            width: 370px;
            border: 1px solid #eeeeee;
            padding: 15px 25px;
        }
        .index-con-left .left-img img{
            height: 100%;
            width: 100%;
        }
        .cont .index-con .index-con-right{
            float: right;
            width: 680px;
            padding: 30px;
            margin-bottom: 30px;
        }
        .index-con-right .right-top{
           
            border-bottom: 1px solid #444444;
            padding: 10px 0px;
            
        }
        .cont ul{
        	padding-left: 0px;
        	margin: 0px;
        }
        .cont li{
        	list-style:none;
        	margin-top: 10px;
        }
        .right-top h3{
        	margin: 0px; 
        	display: inline-block;
        	color: red;
        }
        .index-con-right .right-zj{
            padding: 10px 0px;
        }
        .right-zj .li-li{
        	display: inline-block; 
        	width: 210px;
        	margin: 0px;
        }
        .index-con-right .right-bottom{
            background-color: #eeeeee;
            padding: 10px 15px;
            height: 120px;
            border: 1px solid #ada8a8;
            margin-top: 15px;
        }
        .right-bottom .btn{
        	margin-top: 10px;
        	position: relative;
    height: 30px;
    background-color: #E0B645;
    padding: 4px;
    border-radius: 20px;
    width: 160px;
  line-height: 30px;
        }
        .right-bottom .btn img{
        	width: 30px; height: 30px; position: absolute;
        	left: 15px;
        }
        .right-bottom .btn button{
        	position: absolute;
        	left: 50px;
        	background-color: #E0B645;
        	border: 0px;
        	color: #fff;
        	font-size: 22px;
        	width: 90px;
        	text-align: center;
        	border-left: 1px solid #ffffff;
        }
        .btn button:hover{
        	cursor: pointer;
        	color: red;
        }
		.right-bottom .input{
			width: 40px; text-align: center;
		}
    </style>
</head>
<body>
<div class="index">
    <div class="cont">
        <div class="index-top">
            <h3 >${book.bName}</h3>
        </div>
        <div class="index-con">
            <div class="index-con-left">
                <div class="left-img">
                    <img src="">
                </div>
            </div>
            <div class="index-con-right">
                <div class="right-top">
					<ul>
						<li>
							<label>商品编号：</label>
							<label>${book.isbn}</label>
						</li>
						<li>
							<label>当前价：</label>
							<label>
								<h3>￥${book.currPrice?c}</h3>
							</label>
						</li>
						<li>
							<label>定价：</label>
							<label>￥${book.price?c}</label>
							<label style="margin-left: 20px;">折扣：</label>
							<label>${book.discount?c}</label>
							<label>折</label>
						</li>
					</ul>
                </div>
                <div class="right-zj">
					<ul>
						<li>
							<label>作者：</label>
							<label>${book.author}</label>
							<label>著</label>
						</li>
						<li>
							<label>出版社：</label>
							<label>${book.press}</label>
						</li>
						<li>
							<label>出版时间：</label>
							<label>${book.publishTime?date}</label>
						</li>
						<li>
							<li class="li-li">
								<label>版次：</label>
								<label>${book.edition?c}</label>
							</li>
							<li class="li-li">
								<label>页数：</label>
								<label>${book.pageNum?c}</label>
							</li>
							<li class="li-li">
								<label>字数：</label>
								<label>${book.wordNum?c}</label>
							</li>
						</li>
						<li>
							<li class="li-li">
								<label>印刷时间：</label>
								<label>${book.printTime?date}</label>
							</li>
							<li class="li-li">
								<label>开本：</label>
								<label>${book.bookSize?c}</label>
							</li>
							<li class="li-li">
								<label>纸张：</label>
								<label>${book.paper}</label>
								
							</li>
						</li>
					</ul>
                </div>
                <div class="right-bottom">
					<ul>
						<li>
							<label>我要买：</label>
							<input class="input" value="1"/>件
						</li>
						<li>
							<div class="btn">
								<img src="ams.png" class="img"/>
								<button onclick="buy(${book.bId?c})">购买</button>
							</div>
						</li>
					</ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/js/afquery.js"></script>

<script>
	function buy(bookId) {
		var req = {};
		req.bId = bookId;
		req.quantity = $('.input').val();
		if (req.quantity == '' || req.quantity == null) {
			alert('请先输入数量!');
			return;
		}
		Af.rest('addCartItem.api', req, function (data) {
			alert('已加入购物车!');
			location.href = "/shopping.html";
		});
	}
</script>
</html>