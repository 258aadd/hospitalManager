<%--
  Created by IntelliJ IDEA.
  User: 23163
  Date: 2024/7/9
  Time: 上午11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
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

        $(function () {
            $.getJSON("${pageContext.request.contextPath}/depart/getChildDepartList?pid=0",function (data) {
                //alert(data);
                var opt ="<option value='-1'>请选择科室</option>";
                $.each(data,function (i,item) {
                    //alert(item.department_name)
                    opt += "<option value=\""+item.department_id+"\">" + item.department_name + "</option>";
                })
                $("[name = pid]").html(opt);
            })
        })
        
        function getDepartList(pid) {
            $.getJSON("${pageContext.request.contextPath}/depart/getChildDepartList?pid="+pid,function (data) {
                //alert(data);
                var opt ="<option value='-1'>请选择科室</option>";
                $.each(data,function (i,item) {
                    //alert(item.department_name)
                    opt += "<option value=\""+item.department_id+"\">" + item.department_name + "</option>";
                })
                $("[name = cid]").html(opt);
            })
        }

    </script>

</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/doctor/addDoctor">
            <div class="form-group">
                <div class="label">
                    <label>科室：</label>
                </div>
                <div class="field">
                    <select name="pid" class="input w50" onchange="getDepartList(this.value)">

                    </select>
                    <select name="cid" class="input w50">

                    </select>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>账号数量：</label>
                </div>
                <div class="field">
                    <input type="number" class="input w50" name="num" data-validate="required:请输入生成账号的数量" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body></html>
<%--/*全部上传标签*/--%>