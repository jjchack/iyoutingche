<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/iyoutingche.css">
	<link rel="stylesheet" type="text/css" href="css/iyoutingche-ajax.css">
	<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=2zsUYzzWb7r8pUeHUCMmhLvD"></script>
	<script type="text/javascript" src="js/myMap.js"></script>
	<title>百度地图自定义搜索</title>
  </head>
  <body>
  <div class="container">
    <div class="row">
        <div class="span2">
            <ul class="nav nav-list jingkao-side-nav">
		<li class="" ><a href="/usermanager/usercenter/page"><i class="icon-chevron-right"></i> 我的首页</a></li>
		
		
		<li class="active" ><a href="/usermanager/usercenter/page?req=baseInfo"><i class="icon-chevron-right"></i> 我的账号</a></li>
	            
		<li class=""><a href="/usermanager/usercenter/page?req=joinedOrgList"><i class="icon-chevron-right"></i> 我的机构</a></li>
		
		<li class="" ><a href="/usermanager/usercenter/page?req=myMessageList&flag=2&type=0"><i class="icon-chevron-right"></i> 我的消息</a></li>
		
		<li class=""><a href="/usermanager/usercenter/page?req=myFriendList"><i class="icon-chevron-right"></i> 我的好友</a></li>
		
		<li class=""><a href="/usermanager/usercenter/page?req=myFriendInviteCode"><i class="icon-chevron-right"></i> 我的邀请</a></li>
		
	</ul>
        </div>
        <div class="span7">
            


<ul class="nav nav-tabs">
    <li class=""><a href="index.jsp">基本信息</a></li>
    <li class="active"><a href="/usermanager/usercenter/page?req=detailInfo">详细信息</a></li>
    <li class=""><a href="/usermanager/usercenter/page?req=setting">个性设置</a></li>
    <li class=""><a href="/usermanager/usercenter/page?req=updateAvatar">更换头像</a></li>
    <li class=""><a href="/usermanager/usercenter/page?req=updatePswd">修改密码</a></li>
    <li class=""><a href="/usermanager/usercenter/page?req=accountValidate">账号安全</a></li>
</ul>
<div class="nav-tabs">
    

<form class="form-horizontal" method="post" action="/usermanager/user/savedetailinfo">
    <fieldset>
        <legend>教育程度<a id="educationInfoBtn" class="pull-right btn-small" href="javascript:void(0)" onclick="SUDOCN.common.toggleShow('educationInfoBtn','educationInfo')">收起</a></legend>
        <div id="educationInfo">
            <div class="control-group ">
    <label class="control-label" for="studentId">学号</label>
    <div class="controls">
        <input type="text" id="studentId" name="studentId" value="311209060215"  placeholder="请输入学号">
        
    </div>
</div>
<div class="control-group ">
    <label class="control-label" for="education">学历</label>
    <div class="controls">
        <select name="education"  placeholder="请选择你的最高学历" >
                <option value="">请选择你的最高学历</option>
            
            <option value="初中及以下"  >初中及以下</option>
            
            <option value="高中（中专）"  >高中（中专）</option>
            
            <option value="大专"  >大专</option>
            
            <option value="本科" selected >本科</option>
            
            <option value="硕士"  >硕士</option>
            
            <option value="博士及以上"  >博士及以上</option>
            
        </select>
        
    </div>
</div>
<div class="control-group ">
    <label class="control-label" for="school">学校</label>
    <div class="controls">
        <input type="text" id="school" name="school"  value="河南理工大学"  placeholder="请输入学校" >
        
    </div>
</div>
<div class="control-group ">
    <label class="control-label" for="major">专业</label>
    <div class="controls">
        <input type="text" id="major" name="major" value="软件JAVA"  placeholder="请输入专业" >
        
    </div>
</div>
<div class="control-group ">
    <label class="control-label" for="grade">年级</label>
    <div class="controls">
        <input type="text" id="grade" name="grade"  value="大三" placeholder="请输入年级" >
        
    </div>
</div>
<div class="control-group ">
    <label class="control-label" for="clas">班级</label>
    <div class="controls">
        <input type="text" id="clas" name="clas" value="软件JAVA12-2班"  placeholder="请输入班级">
        
    </div>
</div>
        </div>
    </fieldset>
    <fieldset>
        <legend>联系信息<a id="addressInfoBtn" class="pull-right btn-small" href="javascript:void(0)" onclick="SUDOCN.common.toggleShow('addressInfoBtn','addressInfo')">收起</a></legend>
        <div id="addressInfo">
            <div class="control-group ">
    <label class="control-label" for="province">所在省份</label>
    <div class="controls">
        <select name="province"  id="province" ></select>
        
    </div>
</div>
<div class="control-group ">
    <label class="control-label" for="city">所在城市</label>
    <div class="controls">
        <select name="city" id="city"></select>
        
    </div>
</div>
<div class="control-group ">
    <label class="control-label" for="area">所在地区</label>
    <div class="controls">
        <select name="area" id="area"  ></select>
        
    </div>
</div>
<script src="http://cdn.jingkao.me/usermanager/public/common/javascripts/area.js" ></script>
<script language="javascript" defer="">
    var default_province = "河南省";
    var default_city = "焦作市";
    var default_area = "山阳区";
    new PCAS("province", "city", "area", default_province, default_city, default_area);
</script>
<div class="control-group ">
    <label class="control-label" for="street">街道</label>
    <div class="controls">
        <input type="text" id="street" name="street" value="世纪大道2001"   placeholder="请输入详细街道地址" />
     
    </div>
</div>
<div class="control-group ">
    <label class="control-label" for="zipCode">邮编</label>
    <div class="controls">
        <input type="text" id="zipCode" name="zipCode" value="454000"  placeholder="请输入邮政编码" >
         
    </div>
</div>
<div class="control-group ">
    <label class="control-label" for="telephone">固定电话</label>
    <div class="controls">
        <input type="text" id="telephone" name="telephone" value="" placeholder="请输入如：020-2323232" >
        
    </div>
</div>
<div class="control-group ">
    <label class="control-label" for="cellphone2">其他手机号码</label>
    <div class="controls">
        <input type="text" id="cellphone2" name="cellphone2" value="" placeholder="请输入手机号码" >
        
    </div>
</div>
<div class="control-group ">
    <label class="control-label" for="email2">其他邮箱</label>
    <div class="controls">
        <input type="text" id="email2" name="email2" value="824337531@qq.com" placeholder="请输入邮箱" >
        
    </div>
</div>


        </div>
    </fieldset>
    <fieldset class="hidden">
        <legend>婚姻情况<a id="marriageInfoBtn" class="pull-right btn-small" href="javascript:void(0)" onclick="SUDOCN.common.toggleShow('marriageInfoBtn','marriageInfo')">展开</a></legend>
        <div id="marriageInfo" style="display: none" data-show="show">
            <div class="control-group ">
    <label class="control-label" for="marriage"></label>
    <div class="controls">
        <select name="marriage"  placeholder="请选择你的婚姻情况" >
                <option value="">请选择你的婚姻情况</option>
            
            <option value="已婚"  >已婚</option>
            
            <option value="未婚"  >未婚</option>
            
        </select>
        
    </div>
</div>
        </div>
    </fieldset>
    <fieldset>
        <legend>当前工作<a id="jobInfoBtn" class="pull-right btn-small" href="javascript:void(0)" onclick="SUDOCN.common.toggleShow('jobInfoBtn','jobInfo')">展开</a></legend>
        <div id="jobInfo" data-show="show">
            
<div class="control-group  ">
    <label class="control-label" for="job">当前职业</label>
    <div class="controls">
        <input type="text" name="job" id="job" value="学生"  placeholder="请输入您当前的职业" />
         
    </div>
</div>
<div class="control-group  ">
    <label class="control-label" for="company">所在公司</label>
    <div class="controls">
        <input type="text" name="company" id="company" value="" placeholder="请输入公司名称" />
        
    </div>
</div>
<div class="control-group  ">
    <label class="control-label" for="dutyName">职位</label>
    <div class="controls">
        <input type="text" name="dutyName" id="dutyName" value="" placeholder="请输入职位或者职称" />
        
    </div>
</div>

        </div>
    </fieldset>
    <div class="control-group ">
        <div class="controls">
            <button type="submit" class="btn btn-primary">保存</button>
        </div>
    </div>
</form>
</div>
        </div>
		<script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
  </body>
</html>
