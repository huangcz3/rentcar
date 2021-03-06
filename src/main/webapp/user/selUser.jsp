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
    <base href="<%=basePath%>"></base>

    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../lib/html5shiv.js"></script>
    <script type="text/javascript" src="../lib/respond.min.js"></script>
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
    <script type="text/javascript" src="../lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>用户列表</title>
    <script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $.getJSON( // 获取角色对象
                'showRole', function (data) {
                    var result = null;
                    for (var i = 0; i < data.length; i++) {
                        result += "<option value=" + data[i].roleid + ">"
                            + data[i].rolename + "</option>";
                    }
                    $("#rolesel").html(result);
                });


        });


    </script>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
    用户管理 <span class="c-gray en">&gt;</span> 用户查询 <a
        class="btn btn-success radius r"
        style="line-height: 1.6em; margin-top: 3px"
        href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <form action="selUser" method="post">
        <div class="text-c">

            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：<input
                type="text" name="username" id="" placeholder=" 用户名"
                style="width: 200px" class="input-text"> 姓&nbsp;&nbsp;名：<input
                type="text" name="fullname" id="" placeholder=" 姓名"
                style="width: 200px" class="input-text">
        </div>
        <div class="text-c">
            身份证：<input type="text" name="identity" id="" placeholder=" 身份证"
                       style="width: 200px" class="input-text"> 性&nbsp;&nbsp;别：
            <div class="radio-box">
                <input name="sex" type="radio" id="sex-1" checked value="男">
                <label for="sex-1">男</label>
            </div>
            <div class="radio-box">
                <input type="radio" id="sex-2" name="sex" value="女"> <label
                    for="sex-2">女</label>
            </div>

        </div>
        <div class="text-c">

            &nbsp;&nbsp;&nbsp;&nbsp;联系电话：<input type="text" name="phone" id=""
                                                placeholder=" 联系电话" style="width: 200px" class="input-text">
            地&nbsp; 址：<input type="text" name="address" id="" placeholder=" 地址"
                             style="width: 200px" class="input-text">

        </div>
        <div class="text-c">
            &nbsp;&nbsp;角色： <span class="select-box inline"> <select
                name="roleid" class="select" id="rolesel">

			</select>
			</span> 职位： <input type="text" name="position" id="" placeholder=" 职位"
                               style="width: 200px" class="input-text">
            &nbsp;&nbsp;&nbsp;&nbsp;
            <!-- <input type="submit"  class="btn btn-success" value="查询"/>  -->
            <button name="" id="subbu" class="btn btn-success" type="submit">
                <i class="Hui-iconfont">&#xe665;</i> 查询
            </button>
        </div>
    </form>

    <div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l">
				<%--<a onclick="batchdel()" href="javascript:;" class="btn btn-danger radius">--%>
					<%--<i class="Hui-iconfont">&#xe6e2;</i>--%>
					<%--批量删除--%>
				<%--</a>--%>
				<a class="btn btn-primary radius" data-title="添加用户" data-href="user/addUser.jsp"
                   onclick="Hui_admin_tab(this)"
                   href="javascript:;"> <i class="Hui-iconfont">&#xe600;</i> 添加用户
                </a>

                <%--<a class="btn btn-primary radius" data-title="数据下载" data-href=""--%>
                   <%--onclick="Hui_admin_tab(this)"--%>
                   <%--href="javascript:;"> <i class="Hui-iconfont">&#xe600;</i> 数据下载--%>
                <%--</a>--%>

			</span>

        <%--<span class="r">共有数据：<strong>${pagebean.totalCount }</strong> 条 </span>--%>
    </div>
    <div class="mt-20">
        <table
                class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="" value=""></th>
                <th width="80">序号</th>
                <th width="80">登录名</th>
                <th width="80">身份证</th>
                <th width="80">姓名</th>
                <th width="30">性别</th>
                <th width="75">职位</th>
                <th width="75">用户类型</th>
                <th width="120">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pagebean.list }" var="lea" varStatus="vs">
                <tr class="text-c">
                    <td><input type="checkbox" value="${lea.username }" name="userid"></td>
                    <td>${vs.count }</td>
                    <td>${lea.username }</td>
                    <td>${lea.identity }</td>
                    <td>${lea.fullname }</td>
                    <td>${lea.sex }</td>
                    <td>${lea.position }</td>
                    <td>${lea.role.rolename }</td>
                    <td class="f-14 td-manage">
                        <a style="text-decoration: none" class="ml-5"
                           onClick="article_edit('用户编辑','/user/updateUser.jsp?username=${lea.username}')"
                           href="javascript:;" title="编辑">
                            <i class="Hui-iconfont">&#xe6df;</i>
                        </a>
                        <a style="text-decoration: none" class="ml-5"
                           onClick="article_del(this,'${lea.username}')" href="javascript:;"
                           title="删除"><i class="Hui-iconfont">&#xe6e2;</i>
                        </a>
                    </td>
                </tr>

            </c:forEach>
            <!-- <tr class="text-c">
                <td>10001</td>
                <td><input type="checkbox" value="" name=""></td>
                <td class="text-l"><u style="cursor: pointer"
                    class="text-primary"
                    onClick="article_edit('查看','article-zhang.html','10001')"
                    title="查看">用户标题</u></td>
                <td>行业动态</td>
                <td>H-ui</td>
                <td>2014-6-11 11:11:42</td>
                <td>21212</td>
                <td class="td-status"><span
                    class="label label-success radius">已发布</span></td>
                <td class="f-14 td-manage"><a style="text-decoration: none"
                    onClick="article_stop(this,'10001')" href="javascript:;"
                    title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> <a
                    style="text-decoration: none" class="ml-5"
                    onClick="article_edit('用户编辑','article-add.html','10001')"
                    href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
                    <a style="text-decoration: none" class="ml-5"
                    onClick="article_del(this,'10001')" href="javascript:;"
                    title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
            </tr>  -->

            </tbody>
        </table>
    </div>
</div>
<!--_footer 作为公共模版分离出去-->

<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript"
        src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript"
        src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    $('.table-sort').dataTable({
        "aaSorting": [[1, "desc"]],//默认第几个排序
        "bStateSave": true,//状态保存
        "pading": false,
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {
                "orderable": false,
                "aTargets": [0, 8]
            } // 不参与排序的列
        ]
    });

    /*用户-添加*/
    function article_add(title, url, w, h) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*用户-编辑*/
    function article_edit(title, url, id, w, h) {
//        alert(url);
        var index = layer.open({
            type: 2,
            title: title,
            content: url,

        });
        layer.full(index);
    }

    /*用户-删除*/
    function article_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            $.ajax({
                type: 'POST',
                url: 'delUser',
                dataType: 'json',
                data: {"username": id},
                success: function (data) {
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!', {
                        icon: 1,
                        time: 1000
                    });
                },
                error: function (data) {
                    console.log(data.msg);
                },
            });
        });
    }

    function a() {
        $("input:checkbox[name='userid']:checked").each(function () {
            alert($(this).val());
        });
    }

    function b() {
        alert($(this).is(':checked'));
    }

    function batchdel(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            $.ajax({
                type: 'POST',
                url: 'delUser',
                dataType: 'json',
                data: {"username": id},
                success: function (data) {
                    alert(data);
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!', {
                        icon: 1,
                        time: 1000
                    });
                },
                error: function (data) {
                    console.log(data.msg);
                },
            });
        });
    }

</script>


</body>
</html>