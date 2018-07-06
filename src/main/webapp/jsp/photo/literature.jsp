<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${request.contextPath }"></c:set>
<style>

    article{
        margin:auto;
    }
    /**/
    div{
        display: block;
    }
    .newblogs{
        background: #fff;
        background-image: initial;
        background-position-x: initial;
        background-position-y: initial;
        background-size: initial;
        background-repeat-x: initial;
        background-repeat-y: initial;
        background-attachment: initial;
        background-origin: initial;
        background-clip: initial;
        background-color: rgb(255, 255, 255);
        overflow: hidden;
        overflow-x: hidden;
        overflow-y: hidden;
        width: 100%;
        clear: both;
        border-radius: 10px;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        border-bottom-right-radius: 10px;
        border-bottom-left-radius: 10px;
        margin: 20px 0;
    }

    .hometitle span a:after {
        content: '';
        display: block;
        width: 1px;
        height: 20px;
        border-radius: 10px;
        background: #000;
        -webkit-transform: rotate(45deg);
        transform: rotate(45deg);
        position: absolute;
        bottom: -10px;
    }
    .hometitle{
        padding: 0 10px;
        padding-top: 0px;
        padding-right: 10px;
        padding-bottom: 0px;
        padding-left: 10px;
        line-height: 40px;
        height: 40px;
        font-size: 18px;
        border-bottom: #000 2px solid;
        border-bottom-width: 2px;
        border-bottom-style: solid;
        border-bottom-color: rgb(0, 0, 0);
        position: relative;
    }
    h2 {
        display: block;
        font-size: 1.5em;
        -webkit-margin-before: 0.83em;
        -webkit-margin-after: 0.83em;
        -webkit-margin-start: 0px;
        -webkit-margin-end: 0px;
        font-weight: bold;
    }
    .hometitle span{
        float: right;
        font-weight: normal;
        font-size: 14px;
        height: 42px;
        overflow: hidden;
        position: absolute;
        right: 0;
        width: 100%;
        text-align: right;
    }
    .newblogs ul{
        padding:10px;
        padding-top: 10px;
        padding-right: 10px;
        padding-bottom: 10px;
        padding-left: 10px;
        overflow: hidden;
        overflow-x: hidden;
        overflow-y: hidden;
    }
    ul,li{
        list-style: none;
        list-style-type: none;
        list-style-position: initial;
        list-style-image: initial;
    }
    h3.blogtitle{
        line-height: 30px;
        margin: 10px 0;
        margin-top: 10px;
        margin-right: 0px;
        margin-bottom: 10px;
        margin-left: 0px;
    }
    h3 {
        display: block;
        font-size: 1.17em;
        -webkit-margin-before: 1em;
        -webkit-margin-after: 1em;
        -webkit-margin-start: 0px;
        -webkit-margin-end: 0px;
        font-weight: bold;
    }
    .blogpic {
        overflow: hidden;
        width: 30%;
        max-height: 100px;
        display: block;
        float: left;
        margin-right: 20px;
        border-radius: 5px;
    }
    .bloginfo p {
        color: #888;
        overflow: hidden;
        text-overflow: ellipsis;
        -webkit-box-orient: vertical;
        display: -webkit-box;
        -webkit-line-clamp: 3;
        padding-top: 10px;
        font-size: 14px;
    }
    .autor {
        width: 100%;
        overflow: hidden;
        clear: both;
        margin: 20px 0 0 0;
        display: inline-block;
        color: #838383;
        font-size: 12px;
    }
    .lm {
        background: url(../images/newsbg01.png) no-repeat left center;
        background-image: url(../2018/images/newsbg01.png);
        background-position-x: left;
        background-position-y: center;
        background-size: initial;
        background-repeat-x: no-repeat;
        background-repeat-y: no-repeat;
        background-attachment: initial;
        background-origin: initial;
        background-clip: initial;
        background-color: initial;
    }
    .autor span {
        margin: 0 10px 0 0;
        padding-left: 20px;
    }
    .dtime {
        background: url(../2018/images/newsbg02.png) no-repeat left center;
    }
    .f_l {
        float: left;
    }
    .viewnum {
        background: url(../2018/images/newsbg04.png) no-repeat left center;
    }
    .f_r {
        float: right;
    }
</style>
<article>
    <div class="leftbox">
        <div class="newblogs">
            <h2 class="hometitle">
                <span>
                    <a href="javascript:void(0) " target="_blank" title="1" >
                        "日记"

                    </a>
                        <a href="javascript:void(0) " target="_blank" title="2">
                        "欣赏"

                    </a>
                        <a href="javascript:void(0) " target="_blank" title="3">
                        "程序人生"

                    </a>
                        <a href="javascript:void(0) " target="_blank" title="4">
                        "经典语录"

                    </a>
                </span>
                "慢生活"
            </h2>
            <ul>
                <li>
                    <c:forEach items="${literatureList}" var="literature">
                        <h3 class="blogtitle">
                            <a href="/news/life/2018-06-17/873.html" target="_blank">${literature.title}</a>
                        </h3>
                        <div class="bloginfo">
                            <span class="blogpic">
                                <a href="http:www/yangqq.com/news/life/2018-06-17/873.html" title="${literature.title}">
                                    <img src="http:www/yangqq.com/d/file/news/life/2018-06-17/917d732926d79cc2ae1012831ce51d1e.jpg" alt="${literature.title}">
                                </a>
                            </span>
                            <p> ${literature.content}</p>
                        </div>

                        <div class="autor">
                            <span class="lm f_l"><a href="/news/life/" title="${literature.bigTitle}" target="_blank" class="classname">${literature.bigTitle}</a></span>
                            <span class="dtime f_l">${literature.createTime}</span>
                            <span class="viewnum f_l">浏览（<a href="/">${literature.count}</a>）</span>
                            <span class="f_r"><a href="/news/life/2018-06-17/873.html" class="more">阅读原文&gt;&gt;</a></span>
                        </div>
                    </c:forEach>
                </li>
            </ul>
        </div>

    </div>


</article>
<script>
   // document.getElementsByTagName("")
 // document.getElementsByTagName("h2.hometitle > span").elements[]
 //  var x= $(".hometitle a").length;
   $(function () {
      $(".hometitle a").click(function () {
          var target =$(this).attr('title');
          //alert(target);//.innerText();
          <%--$.post("${ctx}/admin/photo/literatureList",{target:target},function(html){--%>
               <%--$("[role='main']").html(html);--%>
          <%--},"html");--%>
          var s=$.param({target:target});//a=1&b=2;
          __goto("${ctx}/admin/photo/literatureList?"+s);
      })
   })
   <%--$.ajax({--%>
       <%--type:"post",--%>
       <%--url:"${ctx}/admin/product/getTwoOrThreeClass",--%>
       <%--data:{--%>
           <%--id:classid--%>
       <%--},--%>
       <%--datatype:'json',--%>
       <%--success:function(classlist){--%>
           <%--for(var i in classlist){--%>
               <%--$("#classifyIdthree").append("<option value='"+classlist[i].id+"'>"+classlist[i].name+"</option>");--%>
           <%--}--%>
       <%--}--%>
   <%--});--%>
  // for(var i=0; i<$(".hometitle a").length;i++){
  //     var jj =$(".hometitle a").innerText;
  //     alert(jj);
  // }
  // alert("x: "+x)

    $(function () {
        // $(".hometitle a")

     })
</script>
