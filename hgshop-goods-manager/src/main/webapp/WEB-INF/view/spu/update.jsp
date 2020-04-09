<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<link href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" >
<script type="text/javascript" src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"> </script>

<div class="container">
	<div class="container">
	<form action="" id="spuForm">
		<input type="hidden"  name="id" value="${spu.id}">
		<div class="form-group row">
		    <label  class="col-sm-2 col-form-label">商品名称</label>
		    <div class="col-sm-10">
		      <input type="text" name="goodsName" class="form-control" value="${spu.goodsName}" >
		    </div>
		 </div>
		 <div class="form-group row">
		    <label  class="col-sm-2 col-form-label">标题</label>
		    <div class="col-sm-10">
		      <input type="text" name="caption" class="form-control" value="${spu.caption}" >
		    </div>
		 </div>
		 <div class="form-group row">
		    <label  class="col-sm-2 col-form-label">品牌</label>
		    <div class="col-sm-10">
		     	<select name="brandId" >
		     		<c:forEach items="${brandList}" var="brand">
		     			
		     			<option value="${brand.id}" 
		     			   <c:if test="${brand.id==spu.brandId}">
							  selected="selected"
		     			    </c:if>  
		     			>${brand.name}</option>
		     		</c:forEach>
		     	</select>
		    </div>
		 </div>
		 <div class="form-group row">
		    <label  class="col-sm-2 col-form-label">分类</label>
		    <div class="col-sm-8">
		    	<input type="hidden" name="categoryId" id="categoryId" value="${spu.categoryId}" >
		    	<input type="text" class="form-control" id="categoryName" value="${spu.category.name}" disabled="disabled" >
		    </div>
		    <div class="col-sm-2">
		    	<button type="button" class="btn btn-secondary" onclick="showCategory()">分类选择</button>
		    </div>
		    <div id="addCategoryTree"
				style="display: none; position: absolute; z-index: 1010; background-color: white; width: 96%">
			</div>
		 </div>
		 <div class="form-group row">
		    <label  class="col-sm-2 col-form-label">是否上架</label>
		     <div class="col-sm-8">
		     	<div class="form-check form-check-inline">
		     	 
				  <input class="form-check-input" type="radio" name="isMarketable"  
				    <c:if test="${spu.isMarketable==1}"> checked="checked" </c:if>
				   id="inlineRadio1" value="1">
				  <label class="form-check-label" for="inlineRadio1">上架</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="radio" name="isMarketable"
				   <c:if test="${spu.isMarketable==0}"> checked="checked" </c:if>
				   id="inlineRadio2" value="0">
				  <label class="form-check-label" for="inlineRadio2">未上架</label>
			  </div>
		     </div>
		 
		 </div>
		 <div class="form-group row">
		    <label  class="col-sm-2 col-form-label">小图</label>
		    <div class="col-sm-10">
		    	<input type="file" class="form-control-file" id="file" name="file" >  
		   	 	<img alt="no pic" src="/pic/${spu.smallPic}" style="width: 38px; height:20px">
		    </div>
		 </div>
		  <div class="form-group row">
		  	<button type="button" class="btn btn-primary" onclick="update()">提交数据</button>
		  </div>
	</form>
	</div>
	
</div>

<script>

/**
 * 提交数据
 */
function update(){
	
	  var formData= new FormData($("#spuForm")[0])
	  $.ajax({url:"/spu/update",
		//  dataType:"json",
		  data:formData,
		  // 让jQuery 不要再提交数据之前进行处理
		  processData : false,
		  // 提交的数据不能加消息头
		  contentType : false,
		  // 提交的方式 
		  type:"post",
		  // 成功后的回调函数
		  success:function(data){
			  //提交成功以后，要书信页面
			  if(data=="success"){
				  alert('成功')
				  $("#workcontent").load('/spu/list');
				  $("#workTitle").html("商品管理");
			  }else{
				  alert(data);
			  }
			  
		  }
		})
}

//显示商品分类的树
function showCategory(){
	$('#addCategoryTree').show()
}

function initTree() {
	//发送ajax获取树需要的数据
//	alert($.ajaxSettings.async=true)
	$.post("/cat/treeData", {},
			function(treeData) {
				//初始化添加的时候分类的树
				$("#addCategoryTree").treeview({
					data : treeData,
					levels : 2,
					onNodeSelected : function(event, node) {
						
						if (node.nodes.length==0) {
							//alert("末级")
							$("#categoryName").val(node.text);
							$("#categoryId").val(node.id);
							$("#addCategoryTree").hide();
						}
						
					}
				});

			}, "json");
}

initTree();

</script>

