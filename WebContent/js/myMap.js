$(function(){
	  var sContent ;   //定义窗口内容
	  var url ="showInfo.jsp";    //定义跳转界面
	  //调用jquery的ajax与后天数据库进行交互，并得到返回的json数据
	  $('#btn').click(function(){
		  if($("#address_1").val()==""){
			  return false;
		  }
		  $.ajax({
			  type:'POST',
			  
			  url:'FindDepotByKeys',
			  data:{
			  			keys: $("#address_1").val(),
		  			},
		  	success:function(data){
		  				$("#Pcar_left").html("");//清空info内容
		  				 json=$.parseJSON(data);
		  				$.each(json,function(index,val){
		  					var place = val.depot_place;   //详细地址
		  					var img = val.depot_img;		//图片
		  					var depot_code = val.depot_code; //停车场二维码
		  					var name = val.depot_name;	//停车场名称
		  					var coordinate = val.depot_coord;  //坐标
		  					var x = coordinate.split(",")[0];   //将坐标截取出啦  x坐标
		  					var y = coordinate.split(",")[1];	//y坐标
		  				//	alert('name='+name+'place='+place);
		  					sContent = 
		  						"<div id='div1'>"+
			  						"<div id='div2'>"+
		  								"<span>"+name+"</span>"+
		  								"<a href='FindSpaceSer?depotcode="+depot_code+"' target='_blank'>查看详情</a>"+
	  								"</div>"+
	  								"<div id='div3'>"+
		  								"<a href='FindSpaceSer?depotcode="+depot_code+"' target='_blank'><img src='"+img+"'/></a>"+
		  								"<div id='div4'>"+
		  								"<p>总车位：</p>"+
		  								"<p>剩余车位：</p>"+
		  								"<p>地点："+place+"<br/></p>"+
		  								"</div>"
	  								"</div>"
		  						"</div>";
		  					fun_geocoder_getPoint(place,x,y);
		  					$("#Pcar_left").append(sContent+"</br>");
		  				});
		  			},
		  });
	  });
	  //地址解析的函数
		 function fun_geocoder_getPoint(place,x,y){
			 var infoWindow = new BMap.InfoWindow(sContent);  // 创建信息窗口对象
		      var value_address_1 = document.getElementById("address_1").value;
		      myGeo.getPoint(place,function(point){
		        if (point) {
		        	map.centerAndZoom(point, 15);
		        	var point = new BMap.Point(x,y);
		        	var marker = new BMap.Marker(point);
			        map.addOverlay(marker);
			        marker.addEventListener("click", function(){          
			     	   this.openInfoWindow(infoWindow);
			     	   //图片加载完毕重绘infowindow
			     	   document.getElementById('imgDemo').onload = function (){
			     		   infoWindow.redraw();   //防止在网速较慢，图片未加载时，生成的信息框高度比图片的总高度小，导致图片部分被隐藏
			     	   }
			     	});
		        }
		      }, value_address_1);
		  }
	//创建和初始化地图函数：
	  function initMap(){
	        createMap();//创建地图
	        setMapEvent();//设置地图事件
	        addMapControl();//向地图添加控件
	    }
	    //创建地图函数：
	    function createMap(){
	        var map = new BMap.Map("Map_Content");//在百度地图容器中创建一个地图
	        var point = new BMap.Point(121.409863,31.161258);//定义一个中心点坐标
	        map.centerAndZoom(point,15);//设定地图的中心点和坐标并将地图显示在地图容器中
	        window.map = map;//将map变量存储在全局
	    }
	    
	    //地图事件设置函数：
	    function setMapEvent(){
	        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
	        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
	        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
	        map.enableKeyboard();//启用键盘上下左右键移动地图
	    }
	    
	    //地图控件添加函数：
	    function addMapControl(){
	        //向地图中添加缩放控件
		var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
		map.addControl(ctrl_nav);
	        //向地图中添加缩略图控件
		var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
		map.addControl(ctrl_ove);
	        //向地图中添加比例尺控件
		var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
		map.addControl(ctrl_sca);
	    }
	    var myGeo = new BMap.Geocoder();
	  initMap();//创建和初始化地图
  });

    
