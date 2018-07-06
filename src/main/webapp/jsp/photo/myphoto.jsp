<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${request.contextPath }"></c:set>

  <script type="text/javascript" src="${ctx}/jsp/photo/photoholder/js/hc-sticky.js"></script>
<script type="text/javascript" src="${ctx}/jsp/photo/photoholder/js/comm.js"></script>
<script type="text/javascript" src="${ctx}/jsp/photo/photoholder/js/scrollReveal.js"></script>
<style>
	
</style>


  <div class="picbox">
    <ul>

       <li data-scroll-reveal="enter bottom over 1s" ><a href="/"><i>
           <c:forEach items="${photoList}" var="photoDetail">
               <img src="${photoDetail.path}">
               <div class="picinfo">
                   <h3>个人博客模板《simple》</h3>
                   <span>好咖啡要和朋友一起品尝，好“模板”也要和同样喜欢它的人一起分享。</span> </div>
                 </a>
           </c:forEach>
       </li>




    </ul>

  </div>
