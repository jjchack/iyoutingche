<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>i优停车</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="bootstrap-3.3.2-dist/css/bootstrap.min.css"
			rel="stylesheet">
		<link rel="stylesheet" type="text/css"
			href="css/iyoutingche-personalcenter.css">
		<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=2zsUYzzWb7r8pUeHUCMmhLvD"></script>
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		<script type="text/javascript" src="js/jquery.form.js"></script>
		<script type="text/javascript" src="js/admincenter.js"></script>
		<script src="js/Address.js"></script>
		<script type="text/javascript">
		window.onload=function(){new PCAS("depot_province","depot_city","depot_region");}
		</script>
	</head>
	<body>
	<div id="iyoutingche-center-frameright">
		<div role="tabpanel">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist" id="adddepot">
				<li role="presentation" class="active"><a href="#home"
					aria-controls="home" role="tab" data-toggle="tab">停车场</a></li>
 				<li role="presentation"><a href="#imgupload"
					aria-controls="messages" role="tab" data-toggle="tab">上传图片</a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="home">
				<form class="form-horizontal" method="post" id="adminAddDepot">
				<h3><strong>添加停车场</strong></h3>
				<hr>
						<div id="iyoutingche-center-formgroup">
							<span for="inputEmail3" id="iyoutingche-center-lable">停车场名字</span>
							<input type="text" class="form-control" name="depot_name"
								id="depot_name">
						</div>
						<div id="iyoutingche-center-formgroup">
							<span for="inputEmail3" id="iyoutingche-center-lable">城市</span> 
							<div id="iyoutingche-center-formselect">
								<select class="form-control" id="depot_province" name="depot_province"></select>
							</div>
							<div id="iyoutingche-center-formselect">
							<select class="form-control" id="depot_city" name="depot_city"></select>
							</div>
							<div id="iyoutingche-center-formselect">
							<select class="form-control" id="depot_region" name="depot_region"></select>
							</div>
						</div>
						<div id="iyoutingche-center-formgroup">
							<span for="inputEmail3" id="iyoutingche-center-lable">具体位置</span>
							<input type="text" class="form-control" name="depot_place"
								id="depot_place">
						</div>
						<div id="iyoutingche-center-formgroup">
							<span for="inputEmail3" id="iyoutingche-center-lable">位置坐标</span>
							<input type="text" class="form-control" name="depot_coord"
								id="depot_coord">
						</div>
						<div id="iyoutingche-center-formgroup">
							<span for="inputEmail3" id="iyoutingche-center-lable">停车位数量</span>
							<input type="text" class="form-control" name="depot_space"
								id="depot_space">
						</div>
						<div id="iyoutingche-center-formsaid">
							<span for="inputPassword3" id="iyoutingche-center-lable">停车场描述</span><br/>
								<div id="text" class="form-control"
								contenteditable="true" placeholder="444"><small id="dis">至少15个字符</small></div>
								<input type="hidden" class="form-control" name="depot_recommend"
								id="depot_recommend">
								<span id="said"></span>
						</div>
						<h3><strong>添加管理员</strong></h3><hr>
						<div id="iyoutingche-center-formgroup">
							<span for="inputEmail3" id="iyoutingche-center-lable">姓名</span>
							<input type="text" class="form-control" name="admin_p_name"
								id="admin_p_name">
						</div>
						<div class="iyoutingche-center-radio">
							<span for="inputPassword3" id="iyoutingche-center-lable">性别</span>

							<input type="radio" name="admin_p_sex" id="admin_p_sex" value="男"
								checked="checked" /> 男 <input type="radio" name="admin_p_sex"
								id="admin_p_sex" value="女" /> 女
						</div>
						<div id="iyoutingche-center-formgroup">
							<span for="inputPassword3" id="iyoutingche-center-lable">邮箱</span>
							<input type="text" class="form-control" id="admin_p_email"
								name="admin_p_email">
						</div>
						<div id="iyoutingche-center-formgroup">
							<span for="inputPassword3" id="iyoutingche-center-lable">联系方式</span>
							<input type="text" class="form-control" id="admin_p_phone"
								name="admin_p_phone">
						</div>
						<div id="iyoutingche-center-formgroup">
							<span for="inputPassword3" id="iyoutingche-center-lable">银行卡号</span>
							<input type="text" class="form-control" id="admin_p_bank"
								name="admin_p_bank">
						</div>
						<div id="iyoutingche-center-formgroup">
							<div class="col-sm-offset-2 col-sm-10">
								<input class="btn btn-primary" type="submit" id="SecondStep"
									value="确认添加">
							</div>
					</div>
					</form>
				</div>
				<div role="tabpanel" class="tab-pane" id="imgupload">
					<form id="imgup" method="post" enctype="multipart/form-data">
						<span>上传停车场图片</span>
						<p></p>
						<input type="file" name="userImg" id="depotImg"> <input
							class="btn btn-primary" type="button" value="上传" id="uploadImg">
					</form>
				</div>
				</div>
			</div>
		</div>
	<div id="iyoutingche-center-rright"></div>
	<script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
	</body>
</html>
