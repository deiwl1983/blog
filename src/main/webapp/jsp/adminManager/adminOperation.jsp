<%--
  Created by IntelliJ IDEA.
  User: jaosn
  Date: 2018/7/2
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${request.contextPath }"></c:set>

<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <%--<h2>Plain Page</h2>--%>
                <div>
                    <form id="searchForm" class="form-inline" >
                        <div class="form-group">
                            <label for="name">姓名:</label>
                            <input type="text" name="name" class="form-control" id="name" placeholder="请输入姓名">
                        </div>
                        <div class="form-group">
                            <label for="nickname">真实姓名:</label>
                            <input type="text" name="nickName" class="form-control" id="nickname" placeholder="请选择真实姓名">

                        </div>

                        <button type="submit" class="btn btn-default">查找</button>
                        <button type="button" class="data-add-btn">添加</button>
                     <!--   <a class="btn btn-default"  href="${ctx}/admin/article/add" data-part>发表文章</a>-->
                    </form>

                </div>

                <ul class="nav navbar-right panel_toolbox">
                    <%--<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>--%>
                    <%--</li>--%>

                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">


                <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>姓名</th>
                        <th>真实姓名</th>
                        <th>密码</th>
                        <th>登录日期</th>
                        <th>操作</th>

                    </tr>
                    </thead>

                </table>

            </div>
        </div>
    </div>
</div>
</div>
<script type="application/javascript">
    var table=$('#datatable-responsive').DataTable({
        "paging":true,           //分页
        "processing": true,     //数据加载时显示进度条
        "serverSide": true,    //启用搜索功能
        "ordering": false,      //排序
        "searching": false,     //搜索
        "ajax": {
            "url": "${ctx}/admin/adminOperation/findUserInfo",
            "data":function (paramObj) {
            var arr=$("#searchForm").serializeArray();
            for(var i=0;i<arr.length;i++){
                var param=arr[i];
                paramObj[param.name]=param.value;
            }
        }
    },
    "columns": [
        {
            "width":"2em",
            "render": function ( data, type, row ,meta) {
                return meta.settings._iDisplayStart+meta.row+1;
            },
        },
        { "data": "name",
        },
        { "data": "nickname",
        },
        { "data": "password" },
        { "data": "loginTime" },
        { "render": function ( data, type, row ,meta) {
                var str="<a class='btn btn-default' data-edit-btn='"+row.id+"'> 编辑</a>" +
                    "<a class='btn btn-danger' data-delete-btn='"+row.id+"'>删除</a>"
                //   " <a class='btn btn-danger' data-add-btn='"+row.id+"'>添加</a>"
                return str;
            }
        }
    ],
    });
    $('#datatable-responsive').on("click","a[data-edit-btn]",null,function(){
        var editId = $(this).attr("data-edit-btn");
        __goto("${ctx}/adminOperation/editUserInfo?id="+editId);
        return false;
    });

    $("#datatable-responsive").on("click","a[data-delete-btn]",null,function(data){
        var deleteId = $(this).attr("data-delete-btn");
        __goto("${ctx}/adminOperation/deleteId?id="+deleteId);
        return false;
    })

    $(".data-add-btn").click(function(){
        <%--$.post("${ctx}/admin/adminOperation/addAdmin");--%>
        __goto("${ctx}/admin/adminOperation/addAdmin");
        //整 个页面加载window.location
    // window.location=
    })


</script>