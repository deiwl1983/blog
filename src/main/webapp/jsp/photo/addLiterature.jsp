<style>

    article{
        margin:auto;
    }
    .leftbox{
        float: left;
        overflow: hidden;
    }
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
        background: url(http:www.yangqq.com/skin/2018/images/newsbg01.png) no-repeat left center;
        background-image: url(http:www.yangqq.com/skin/2018/images/newsbg01.png);
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
        background: url(http:www.yangqq.com/skin/2018/images/newsbg02.png) no-repeat left center;
    }
    .f_l {
        float: left;
    }
    .viewnum {
        background: url(http:www.yangqq.com/skin/2018/images/newsbg04.png) no-repeat left center;
    }
    .f_r {
        float: right;
    }
</style>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>或许换一个活法,能让你走出阴霾</title>
    <meta name="keywords" content="阴霾" />
    <meta name="description" content="或许换一个活法,能让你走出阴霾" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/skin/2018/css/base.css" rel="stylesheet">
    <link href="/skin/2018/css/index.css" rel="stylesheet">
    <link href="/skin/2018/css/m.css" rel="stylesheet">
    <script src="/skin/2018/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="/e/data/js/ajax.js"></script>
    <!--[if lt IE 9]>
    <script src="/skin/2018/js/modernizr.js"></script>
    <![endif]-->
</head>
<body>
<header>
    <div id="mnav">
        <div class="logo"><a href="/">杨青个人博客</a></div>
        <h2 id="mnavh"><span class="navicon"></span></h2>
        <ul id="starlist">

            <li class=""><a href="/blogs/">博客日记</a></li>


            <li class=""><a href="/jstt/">学无止境</a></li>


            <li class="selected"><a href="/news/">慢生活</a></li>


        </ul>
    </div>
    <script>
        window.onload = function ()
        {
            var oH2 = document.getElementById("mnavh");
            var oUl = document.getElementById("starlist");
            oH2.onclick = function ()
            {
                var style = oUl.style;
                style.display = style.display == "block" ? "none" : "block";
                oH2.className = style.display == "block" ? "open" : ""
            }
            var obj=null;
            var As=document.getElementById('starlist').getElementsByTagName('a');
            obj = As[0];
            for(i=1;i<As.length;i++){if(window.location.href.indexOf(As[i].href)>=0)
                obj=As[i];}
            obj.id='selected'
        }
    </script>
</header>
<div class="line46"></div>
<div class="blank"></div>
<article>
    <div class="leftbox">
        <div class="infos">
            <div class="newsview">
                <h2 class="intitle">您现在的位置是：<a href="/">首页</a>&nbsp;>&nbsp;<a href="/news/">慢生活</a>&nbsp;>&nbsp;<a href="/news/s/">日记</a></h2>
                <h3 class="news_title">或许换一个活法,能让你走出阴霾</h3>
                <div class="news_author"><span class="au01"><a href='mailto:dancesmiling@qq.com'>杨青</a></span><span class="au02">2018-02-26</span><span class="au03">共<b><script src=/e/public/ViewClick/?classid=3&id=800&addclick=1></script></b>人围观</span></div>
                <div class="tags"><a href="/e/tags/?tagname=%D2%F5%F6%B2&tempid=13" target="_blank">阴霾</a></div>
                <div class="news_about"><strong>简介</strong>前段时间回成都,去见了几年未见的老友.一起吃了饭,还带我家宝宝去玩.我问她为什么这么久都还没有打算要孩子,她说,她有一段时间患上了忧郁症,很长的时间才走出来,我听她这么说,我都很惊讶!想问问她原因,可见她欲言又止的神情,我便不再主动问她.就听着她慢慢的说.其实主要的原因还是源自于工作和家庭,工作压力大,每天的程序代码,上级不停的催,她甚至连续好几个通宵的熬夜,,,</div>
                <div class="news_infos">
                    <p><span style="font-family:微软雅黑;"><span style="font-size:16px;">前段时间回成都,去见了几年未见的老友.一起吃了饭,还带我家宝宝去玩.我问她为什么这么久都还没有打算要孩子,她说,她有一段时间患上了忧郁症,很长的时间才走出来,我听她这么说,我都很惊讶!想问问她原因,可见她欲言又止的神情,我便不再主动问她.就听着她慢慢的说.其实主要的原因还是源自于工作和家庭,工作压力大,每天的程序代码,上级不停的催,她甚至连续好几个通宵的熬夜,,,工作上她的这种敬业精神,真的让人佩服,她说她顾及了这一头,就顾及不了那一头,她的家人也不停催促她生孩子,她想过跳楼自杀,,,斟酌了好久,有一天她一朋友就跟她说,&quot;<span style="background-color: rgb(227, 108, 9);"><span style="color: rgb(255, 255, 255);">如果你真自杀了,你倒是轻松解脱了,可你能想象你爸妈该怎么活?他们白发人送黑发人,又多久能走出来呢</span><span style="background-color: rgb(227, 108, 9); color: rgb(255, 255, 255);"><span style="background-color: rgb(227, 108, 9);">?</span></span></span>&quot;,,,她说就是因为这句话,她又重新鼓励自己坚强的活下去.</span></span></p>

                    <p><span style="font-family:微软雅黑;"><span style="font-size:16px;">听她这么诉说着,我调侃着问她,&quot;你真的就走出来了么?&quot;她看着我家宝宝说&quot;真的很可爱,我想我辞职是正确的选择!&quot;原来,她辞职了.做编码工作,确实挺枯燥的,程序员自杀的新闻也已经屡见不鲜了,压力之大.不管是女程序员还是男程序员,都承载了很多的压力.面对压力,有一部分人选择了退出,有一部分人选择了继续拼搏,我想说的是,无论压力再大,都要消除那些消极的情绪,大不了,辞职换一个工作,<span style="color: rgb(255, 255, 255);"><span style="background-color: rgb(227, 108, 9);">不要把生命看得如此轻,为自己,为家人活下去</span>!</span></span></span></p>
                </div>
            </div>

            <!--share end-->

        </div>

    </div>

</article>

<script src="/e/public/onclick/?enews=donews&classid=3&id=800"></script></body>
</html>
