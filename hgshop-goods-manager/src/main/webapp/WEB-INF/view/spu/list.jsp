<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spu列表展示</title>
<link href="/public/css/bootstrap.min.css" rel="stylesheet">
<link href="/public/css/index.css" rel="stylesheet">
<script src="/public/js/jquery.min.1.12.4.js"></script>
<script src="/public/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		 <label>输入名称：</label> <input id="queryName" value="${spuVo.goodsName}" type="text">	
		 <button type="button" class="btn btn-primary" onclick="query(0)">搜索</button>&nbsp;&nbsp; 
		 <button type="button" class="btn btn-danger" onclick="delBatch()">批量删除</button> 
		 <button type="button" class="btn btn-warning" onclick="toAdd()"> 添加</button> 
	</div>  
	<div>
		<table class="table">
			<tr>
			
				<th>id  <input type="checkbox" id="ids" onchange="selAll()"></th>
				<th>商品名称</th>
				<th>品牌名称</th>
				<th>分类名称</th>
				<th>是否上架</th>
				<th>副标题</th>
				<th>图片</th> 
				<th>操作</th>
			</tr>
			<c:forEach items="${pageInfo.list}" var="spu">
				<tr>
				
				<td>${spu.id} <input type="checkbox" value="${spu.id}" name="id"> </td>
				<td>${spu.goodsName}</td>
				<td>${spu.brand.name}</td> 
				<td>${spu.category.name}</td> 
				<td>${spu.isMarketable==1?"上架":"未上架"}</td>
				<td>${spu.caption}</td> 
				<td>
					<img alt="no pic" src="/pic/${spu.smallPic}" style="width: 38px; height:20px">
				</td> 
				<td>
					<button type="button" class="btn btn-primary" onclick="toModify(${spu.id})">修改</button>
					<button type="button" class="btn btn-danger" onclick="del(${spu.id})">删除</button>
					<button type="button" class="btn btn-info" onclick="addSku(${spu.id})">+sku</button>
				</td>
				</tr>
			</c:forEach>
			<tr> <td colspan="4">
				<nav aria-label="...">
					  <ul class="pagination">
					    <li class="page-item ">
					      <a class="page-link" href="javascript:query(1)" tabindex="-1" >首页</a>
					    </li>
					    <c:forEach begin="1"  end="${pageInfo.pages}" var="page">
					    	<!-- 显示非当前 -->
					    	<c:if test="${page!=pageInfo.pageSize}">
					    		<li class="page-item"><a class="page-link" href="javascript:query(${page})">${page}</a></li>
					    	</c:if>
					    	<!-- 显示当前页码 -->
					    	<c:if test="${page==pageInfo.pageSize}">
					    		<li class="page-item active" aria-current="page">
					      			<a class="page-link" href="#">${page}<span class="sr-only">(current)</span></a>
					    		</li>
					    	</c:if>
					    </c:forEach>
	
					    <li class="page-item">
					      <a class="page-link" href="javascript:query(${pageInfo.pages})">尾页</a>
					    </li>
					  </ul>
					</nav>
			</td></tr>
		</table>
	</div>  

</body>

	<script type="text/javascript">
	
		// 单个删除
		function del(id){
			
			var result=confirm("确认删除该条数据么？")
			if(!result)
				return;
			
			var delIds = new Array();
			delIds.push(id)
			$.post('/spu/deleteBatch',{ids:delIds},function(data){
				if(data=="success"){
					//删除成功
					alert("删除成功")
					//刷新页面
					query(1);
				}else{
					alert("删除失败")
				}
			})
		
		}
		
		//批删
		function delBatch(){
			//被删除的id
			var delIds = new Array();
			$("[name=id]:checked").each(function(){
				delIds.push($(this).val());
			}
			)
			if(delIds.length<=0){
				alert("没有选择数据");
				return
			}
			var result=confirm("确认删除这些数据么？")
			if(!result)
				return;
			
			$.post('/spu/deleteBatch',{ids:delIds},function(data){
				if(data=="success"){
					//删除成功
					alert("删除成功")
					//刷新页面
					query(1);
				}else{
					alert("删除失败")
				}
			})
			
		}
	
		//添加
		function toAdd(){
			$("#workcontent").load("/spu/toadd");
			$("#workTitle").html("添加品牌");
		}
	
		//添加sku
		function addSku(spuId) {
			$("#workcontent").load("/sku/toadd?spuId="+spuId);
			$("#workTitle").html("添加规格");
		}
		
		
		//修改
		function toModify(id){
			$("#workcontent").load("/spu/toupdate?id="+id);
			$("#workTitle").html("品牌修改");
		}
	
		//分页
		function query(page){
			$("#workcontent").load("/spu/list?page="+page + "&goodsName=" + $("#queryName").val());
		}
		
	</script>
	
</html>