
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${request.contextPath }"></c:set>


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
