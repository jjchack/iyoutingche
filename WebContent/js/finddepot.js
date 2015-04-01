/**
 * 管理员查询停车场
 */
$(document).ready(function(){
	$("#btn").click(function(){
			 if($("#address_depot").val()==null){
				 return false;
			 }
			$.ajax({
				url:"AdminFindDepotSer",
				data:{
					address_depot:$("#address_depot").val(),
				},
				success:function(data){
					 json=$.parseJSON(data);
					 alert(json.length);
					$.each(json,function(index,val){
	  					var place = val.depot_place;   //详细地址
	  					alert(place);
	  				});
				},
			});
	});
});