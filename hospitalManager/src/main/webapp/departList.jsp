<%--
  Created by IntelliJ IDEA.
  User: 23163
  Date: 2024/7/8
  Time: 下午3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  String contextPath = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<base href="<%=basePath%>">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <meta name="renderer" content="webkit">
  <title></title>
  <link rel="stylesheet" href="css/pintuer.css">
  <link rel="stylesheet" href="css/admin.css">
  <script src="js/jquery.js"></script>
  <script src="js/pintuer.js"></script>

  <script>
    function getChildList(pid) {
      //alert(pid);
      $.getJSON("${pageContext.request.contextPath}/depart/getChildDepartList?pid="+pid,function (date){
        //alert(2);

        var trstr = "<tr id='trchild_" + pid + "'><td colspan='4'><table class=\"table table-hover text-center\">";
        $.each(date, function (i, item) {
          //alert(item.department_name);
          trstr += "<tr><td>" + item.department_id + "</td><td>" + item.department_name + "</td><td>" + item.department_description;
          trstr += "</td><td><div class=\"button-group\"> <a class=\"button border-main\" href=\"${pageContext.request.contextPath}/depart/toUpdate?did="+item.department_id+"\"><span class=\"icon-edit\"></span> 修改</a> <a class=\"button border-red\" href=\"javascript:void(0)\" onclick=\"deleteById("+item.department_id+")\"><span class=\"icon-trash-o\"></span> 删除</a> </div></td></td></tr>";
        })
        trstr += "</table></td></tr>";
        var childid = $("#trchild_" + pid).attr("id");
        var getid = "trchild_" + pid;
        if (childid == getid) {
          $("#trchild_" + pid).remove();
        } else {
          $("#tr_" + pid).after(trstr);
        }

      });

    }

    function deleteById(id) {
      //alert(id);
      if(confirm("确认删除？")){
        //alert("删除成功");
        window.location.href="${pageContext.request.contextPath}/depart/deleteById?id="+id;
      }
    }

  </script>

</head>
<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="addDepart.jsp?pid=0"> 添加内容</a> </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">编号</th>
        <th>科室名称</th>
        <th>科室简介</th>
        <th width="310">操作</th>
      </tr>
      <volist name="list" id="vo">
        <c:forEach items="${pageInfo.list}" var="depart">
          <c:choose>
            <c:when test="${depart.haveChild}">
              <tr id="tr_${depart.department_id}" onclick="getChildList(${depart.department_id})">
                <td>${depart.department_id}</td>
                <td>${depart.department_name}</td>
                <td>${depart.department_description}</td>
                <td>
                  <div class="button-group">
                    <a class="button border-main" href="addDepart.jsp?pid=${depart.department_id}">
                      <span class="icon-edit"></span> 添加
                    </a>
                  </div>
                </td>
              </tr>
            </c:when>
            <c:otherwise>
              <tr id="tr_${depart.department_id}">
                <td>${depart.department_id}</td>
                <td>${depart.department_name}</td>
                <td>${depart.department_description}</td>
                <td>
                  <div class="button-group">
                    <a class="button border-main" href="addDepart.jsp?pid=${depart.department_id}">
                      <span class="icon-edit"></span> 添加
                    </a>
                    <a class="button border-red" onclick="deleteById(${depart.department_id})">
                      <span class="icon-trash-o"></span> 删除
                    </a>
                  </div>
                </td>
              </tr>
            </c:otherwise>
          </c:choose>

        </c:forEach>

        <tr>
          <td colspan="8">
            <div class="pagelist">
              <span class="current">总记录数:${pageInfo.total}</span>
              <a href="${pageContext.request.contextPath}/depart/getDepartList?page=${pageInfo.prePage}">上一页</a>
              <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                <c:choose>
                  <c:when test="${num == pageInfo.pageNum}">
                    <span class="current">${num}</span>
                  </c:when>
                  <c:otherwise>
                    <a href="${pageContext.request.contextPath}/depart/getDepartList?page=${num}">${num}</a>
                  </c:otherwise>
                </c:choose>
              </c:forEach>
              <a href="${pageContext.request.contextPath}/depart/getDepartList?page=${pageInfo.nextPage}">下一页</a>
              <a href="${pageContext.request.contextPath}/depart/getDepartList?page=${pageInfo.pages}">尾页</a>
            </div></td>
        </tr>
    </table>
  </div>
</form>
<script type="text/javascript">

  //搜索
  function changesearch(){

  }

  //单个删除
  function del(id,mid,iscid){
    if(confirm("您确定要删除吗?")){

    }
  }

  //全选
  $("#checkall").click(function(){
    $("input[name='id[]']").each(function(){
      if (this.checked) {
        this.checked = false;
      }
      else {
        this.checked = true;
      }
    });
  })

  //批量删除
  function DelSelect(){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){
      var t=confirm("您确认要删除选中的内容吗？");
      if (t==false) return false;
      $("#listform").submit();
    }
    else{
      alert("请选择您要删除的内容!");
      return false;
    }
  }

  //批量排序
  function sorts(){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){

      $("#listform").submit();
    }
    else{
      alert("请选择要操作的内容!");
      return false;
    }
  }


  //批量首页显示
  function changeishome(o){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){

      $("#listform").submit();
    }
    else{
      alert("请选择要操作的内容!");

      return false;
    }
  }

  //批量推荐
  function changeisvouch(o){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){


      $("#listform").submit();
    }
    else{
      alert("请选择要操作的内容!");

      return false;
    }
  }

  //批量置顶
  function changeistop(o){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){

      $("#listform").submit();
    }
    else{
      alert("请选择要操作的内容!");

      return false;
    }
  }


  //批量移动
  function changecate(o){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){

      $("#listform").submit();
    }
    else{
      alert("请选择要操作的内容!");

      return false;
    }
  }

  //批量复制
  function changecopy(o){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){
      var i = 0;
      $("input[name='id[]']").each(function(){
        if (this.checked==true) {
          i++;
        }
      });
      if(i>1){
        alert("只能选择一条信息!");
        $(o).find("option:first").prop("selected","selected");
      }else{

        $("#listform").submit();
      }
    }
    else{
      alert("请选择要复制的内容!");
      $(o).find("option:first").prop("selected","selected");
      return false;
    }
  }

</script>
</body>
</html>
<%--/*全部上传标签*/--%>