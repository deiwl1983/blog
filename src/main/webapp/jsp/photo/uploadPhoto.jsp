<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${request.contextPath }"></c:set>
<!-- -->
<link rel="stylesheet" type="text/css" href="${ctx}/jsp/photo/uploadPhoto/webuploader.css" />
  <link rel="stylesheet" type="text/css" href="${ctx}/jsp/photo/uploadPhoto/style.css" />

 <script>
 __ctx="${ctx}";
 </script>
   <div id="uploader">
                <div class="queueList">
                    <div id="dndArea" class="placeholder">
                        <div id="filePicker"></div>
                        <p>或将照片拖到这里，单次最多可选300张</p>
                    </div>
                </div>
                <div class="statusBar" style="display:none;">
                    <div class="progress">
                        <span class="text">0%</span>
                        <span class="percentage"></span>
                    </div><div class="info"></div>
                    <div class="btns">
                        <div id="filePicker2"></div><div class="uploadBtn">开始上传</div>
                    </div>
                </div>
            </div>

            </div>
  	
    <script type="text/javascript" src="${ctx}/jsp/photo/uploadPhoto/webuploader.js"></script>
    <script type="text/javascript" src="${ctx}/jsp/photo/uploadPhoto/upload.js"></script>


<button class="btn btn-primary" >yangshi</button>
<button class="btn btn-link" >yangshi</button>
