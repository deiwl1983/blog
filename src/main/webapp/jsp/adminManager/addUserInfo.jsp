<%--
  Created by IntelliJ IDEA.
  User: jaosn
  Date: 2018/7/5
  Time: 12:09
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

<div class="container">
    <div class="row">

        <div class="col-sm-6">
            <label>姓名：</label>
            <input type="text" name="name" placeholder="请输入姓名">
        </div>
        <div class="col-sm-6">
            <label>真实姓名：</label>
            <input type="text" name="name" placeholder="请输入真实姓名">
        </div>

    </div>
    <div class="row">

        <div class="col-sm-6">
            <label>密码：</label>
            <input type="text" name="name" placeholder="请输入密码">
        </div>
        <div class="col-sm-6">
            <label>登录时间：</label>
            <input type="text" value=""name="newDate" id="loginTime" placeholder="请选 择" readonly value="${date}">
        </div>

    </div>
</div>
