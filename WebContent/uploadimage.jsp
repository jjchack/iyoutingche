<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%
  String picUrl = request.getParameter("Picurl"); 
  String  step = request.getParameter("step"); 
  String defaultPic ="image/man.GIF";
  if("3".equals(step))
    defaultPic = "User/UserHeadImage/"+picUrl;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<title></title>
<link href="css/main.css" type="text/css" rel="Stylesheet" />
    <script type="text/javascript" src="js/jquery1.2.6.pack.js"></script>
    <script  type="text/javascript" src="js/ui.core.packed.js" ></script>
    <script type="text/javascript" src="js/ui.draggable.packed.js" ></script>
    <script type="text/javascript" src="js/CutPic.js"></script>
    <script type="text/javascript">
        function Step1() {
            $("#Step2Container").hide();           
        }

        function Step2() {
            $("#CurruntPicContainer").hide();
        }
        function Step3() {
            $("#Step2Container").hide();          
       }
    </script>
</head>
<body>
   

    <div>
     <div class="left">
         <!--��ǰ��Ƭ-->
         <div id="CurruntPicContainer">
            <div class="title"><b>��ǰ��Ƭ</b></div>
            <div class="photocontainer">
                <img id="imgphoto" src="<%=defaultPic%>" style="border-width:0px;" />
            </div>
         </div>
         <!--Step 2-->
         <div id="Step2Container">
           <div class="title"><b> ����ͷ����Ƭ</b></div>
           <div class="uploadtooltip">�������϶���Ƭ�Բü������ͷ��</div>                              
                   <div id="Canvas" class="uploaddiv">
                   
                            <div id="ImageDragContainer">                               
                               <img id="ImageDrag" class="imagePhoto" src="UploadPhoto/<%=picUrl %>" style="border-width:0px;" />                                                        
                            </div>
                            <div id="IconContainer">                               
                               <img id="ImageIcon" class="imagePhoto" src="UploadPhoto/<%=picUrl%>" style="border-width:0px;" />                                                        
                            </div>                          
                    </div>
                    <div class="uploaddiv">
                       <table>
                            <tr>
                                <td id="Min">
                                        <img alt="��С" src="image/_c.gif" onmouseover="this.src='image/_c.gif';" onmouseout="this.src='image/_h.gif';" id="moresmall" class="smallbig" />
                                </td>
                                <td>
                                    <div id="bar">
                                        <div class="child">
                                        </div>
                                    </div>
                                </td>
                                <td id="Max">
                                        <img alt="�Ŵ�" src="image/c.gif" onmouseover="this.src='image/c.gif';" onmouseout="this.src='image/h.gif';" id="morebig" class="smallbig" />
                                </td>
                            </tr>
                        </table>
                    </div>
                    <form action="/ZoomImageDemo/servlet/ZoomImage" method="post">
                    <input type="hidden" name="picture" value="<%=picUrl%>"/>
                    <div class="uploaddiv">
                        <input type="submit" name="btn_Image" value="����ͷ��" id="btn_Image" />
                    </div>           
      			  </form>
         </div>
     
     </div>
      <form name="form1" method="post" action="/ZoomImageDemo/servlet/UpLoadUserHeadImage" id="form1" enctype="multipart/form-data">
     <div class="right">
         <!--Step 1-->
         <div id="Step1Container">
            <div class="title"><b>������Ƭ</b></div>
            <div id="uploadcontainer">
                <div class="uploadtooltip">��ѡ���µ���Ƭ�ļ����ļ���С��2.5MB</div>
                <div class="uploaddiv"><input type="file" name="fuPhoto" id="fuPhoto" title="ѡ����Ƭ" /></div>
                <div class="uploaddiv"><input type="submit" name="btnUpload" value="�� ��" id="btnUpload" /></div>
            </div>
         
         </div>
     </div>
     </form>
    </div>
    <% 
      if(null==picUrl||"".equals(picUrl))
      {%>
          <script type='text/javascript'>Step1();</script>
      <%}else if(!"".equals(picUrl)&& "2".equals(step)){
      %>
      <script type='text/javascript'>Step2();</script>
      <%}else if(!"".equals(picUrl)&& "3".equals(step)){
      %>
      <script type='text/javascript'>Step3();</script>
      <%}%>

</body>
</html>