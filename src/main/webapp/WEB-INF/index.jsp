<%@ page language="java" pageEncoding="UTF-8"
		 contentType="text/html; charset=UTF-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>"/>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport"
		  content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
	<meta http-equiv="Cache-Control" content="no-siteapp"/>
	<link rel="Bookmark" href="/favicon.ico">
	<link rel="Shortcut Icon" href="/favicon.ico"/>
	<!--[if lt IE 9]>
	<script type="text/javascript" src="/lib/html5shiv.js"></script>
	<script type="text/javascript" src="/lib/respond.min.js"></script>
	<![endif]-->
	<link rel="stylesheet" type="text/css"
		  href="../static/h-ui/css/H-ui.min.css"/>
	<link rel="stylesheet" type="text/css"
		  href="../static/h-ui.admin/css/H-ui.admin.css"/>
	<link rel="stylesheet" type="text/css"
		  href="../lib/Hui-iconfont/1.0.8/iconfont.css"/>
	<link rel="stylesheet" type="text/css"
		  href="../static/h-ui.admin/skin/default/skin.css" id="skin"/>
	<link rel="stylesheet" type="text/css"
		  href="../static/h-ui.admin/css/style.css"/>
	<!--[if IE 6]>
	<script type="text/javascript" src="/lib/DD_belatedPNG_0.0.8a-min.js"></script>
	<script>DD_belatedPNG.fix('*');</script>
	<![endif]-->
	<title>汽车租赁管理系统</title>

</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl">
			<a class="logo navbar-logo f-l mr-10 hidden-xs" href="/menu">汽车租赁管理系统</a>
			<a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">v1.0</a>
			<span class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span>
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
			<nav class="nav navbar-nav"></nav>
			<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
				<ul class="cl">
					<li><span>${sessionScope.user.position} </span></li>
					<li class="dropDown dropDown_hover">
						<a class="dropDown_A">${sessionScope.user.fullname} <i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<%--<li><a href="javascript:;" onClick="myselfinfo()">个人信息</a></li>--%>
							<li><a href="#">切换账户</a></li>
							<li><a href="logout">退出</a></li>
						</ul>
					</li>
					<%--<li id="Hui-msg"><a href="#" title="消息"><span--%>
					<%--class="badge badge-danger">1</span><i class="Hui-iconfont"--%>
					<%--style="font-size: 18px">&#xe68a;</i></a></li>--%>
					<li id="Hui-skin" class="dropDown right dropDown_hover"><a
							href="javascript:;" class="dropDown_A" title="换肤"><i
							class="Hui-iconfont" style="font-size: 18px">&#xe62a;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
							<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
							<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
							<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
							<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
							<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
						</ul>
					</li>
				</ul>
			</nav>
		</div>
	</div>
</header>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">

		<c:forEach items="${menulist}" var="menu">
			<dl id="menu-article">
				<dt>
					<i class="Hui-iconfont">&#xe616;</i> ${menu.menuname }<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<c:forEach items="${menu.childMenu }" var="child"> <!--子菜单 -->
							<li><a data-href="${child.uri}"
								   data-title="${child.menuname}" href="javascript:void(0)">${child.menuname}</a></li>
						</c:forEach> <!--child end  -->
					</ul>
				</dd>
			</dl>
		</c:forEach> <!--father end  -->


	</div>
</aside>
<div class="dislpayArrow hidden-xs">
	<a class="pngfix" href="javascript:void(0);"
	   onClick="displaynavbar(this)"></a>
</div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active"><span title="主页" >主页</span>
					<em></em></li>
			</ul>
		</div>
		<div class="Hui-tabNav-more btn-group">
			<a id="js-tabNav-prev" class="btn radius btn-default size-S"
			   href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a
				id="js-tabNav-next" class="btn radius btn-default size-S"
				href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
		</div>
	</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display: none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="/html/welcome.html?userName=${sessionScope.user.fullname}" ></iframe>
		</div>
	</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前</li>
		<li id="closeall">关闭全部</li>
	</ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript"
		src="../lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
    $(function () {
//        $("#min_title_list li").contextMenu('Huiadminmenu', {
//            bindings: {
//                'closethis': function (t) {
//                    console.log(t);
//                    if (t.find("i")) {
//                        t.find("i").trigger("click");
//                    }
//                },
//                'closeall': function (t) {
//                    alert('Trigger was ' + t.id + '\nAction was Email');
//                },
//            }
//        });
    });

    /*个人信息*/
    function myselfinfo() {
        layer.open({
            type: 1,
            area: ['300px', '200px'],
            fix: false, //不固定
            maxmin: true,
            shade: 0.4,
            title: '查看信息',
            content: '<div>管理员信息</div>'
        });
    }

    /*资讯-添加*/
    function article_add(title, url) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*图片-添加*/
    function picture_add(title, url) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*产品-添加*/
    function product_add(title, url) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*用户-添加*/
    function member_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }
</script>


</body>
</html>