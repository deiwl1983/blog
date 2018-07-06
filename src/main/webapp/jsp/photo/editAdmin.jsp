<%--
  Created by IntelliJ IDEA.
  User: jaosn
  Date: 2018/7/1
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${request.contextPath }"></c:set>
<script type="text/javascript" src="${ctx}/static/admin/vendors/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="${ctx}/static/admin/vendors/ueditor/ueditor.all.js"></script>

    <script type="text/javascript" src="${ctx}/jsp/photo/photoholder/js/hc-sticky.js"></script>
    <script type="text/javascript" src="${ctx}/jsp/photo/photoholder/js/comm.js"></script>
    <script type="text/javascript" src="${ctx}/jsp/photo/photoholder/js/scrollReveal.js"></script>

<div class="container">
    <form class="userinfoForm" id="userinfoForm">
    <div class="row " >
        <div class="col-sm-2">
            <label>姓名：</label>
        </div>
        <div class="col-sm-8">
            <input type="text" value="" name="name" placeholder="请输入姓名">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-2">
            <p>真实姓名：</p>
        </div>
        <div class="col-sm-8">
            <input type="text" value="" name="nickname" placeholder="请输入真实姓名">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-2">
            <p>密码：</p>
        </div>
        <div class="col-sm-6">
            <input type="password" value="" name="password" placeholder="请输入密码">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-2">
            <p>确认密码：</p>
        </div>
        <div class="col-sm-6">
            <input type="password" value="" name="cofirm" placeholder="请确认密码">
        </div>
    </div>
    <div class="row">
        <div class="col-sm-2">
            <label>登录时间：</label>
        </div>
        <div class="col-sm-6">
            <input type="text" value=""name="newDate" id="loginTime" placeholder="请选 择" readonly value="${date}">
        </div>
    </div>
        <div class="row">
        <input type="submit" value="编辑提交" >
        </div>
    </form>
</div>

<script type="application/javascript">
    $("#userinfoForm").submit(function(e){

        var infoForm = $(this).serialize();
      //  alert("["+infoForm+"]")
        $.post("${ctx}/admin/photo/updateInfo",infoForm,function(data){
          if(data.map==1){
             alert("修改成功！");
             }
        })
        return false;
    })

    jeDate("#loginTime",{
        format:"YYYY-MM-DD hh:mm:ss",
        isTime:false,
        minDate:"2000-01-01 00:00:00",
        festival:true,
        onClose:false
    })

</script>
