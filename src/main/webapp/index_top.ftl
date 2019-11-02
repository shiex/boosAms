<div class="static-top">
    <div>
        <h2>ITCAST书店</h2>
    </div>
    <div>
        <#if user ??>
            <ul>
                <li>用户名：${user.loginName}</li>
                <li><a href="/">首页</a></li>
                <li><a href="/shopping.html">我的购物车</a></li>
                <li><a href="/orderlist.html">我的订单</a></li>
                <li><a href="/user_pwd.html">修改密码</a></li>
                <li><a href="/logout">退出</a></li>
            </ul>
        <#else >
            <ul>
                <li>
                    <a href="/login.html">登录</a>
                </li>
                <li>
                    <a href="/register.html">注册</a>
                </li>
                <li>
                    <a href="/admin_login.html">管理员登录</a>
                </li>
            </ul>
        </#if>
    </div>
</div>