package com.wjiayi.hgshop.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.wjiayi.hgshop.pojo.Category;
import com.wjiayi.hgshop.pojo.Spu;
import com.wjiayi.hgshop.pojo.SpuEsVo;
import com.wjiayi.hgshop.pojo.SpuVo;
import com.wjiayi.hgshop.service.CategoryService;
import com.wjiayi.hgshop.service.SpuService;
import com.wjiayi.hgshop.utils.ElSearchUtil;

@Controller
@RequestMapping
public class IndexController {

	@Reference
	private SpuService spuService;
	@Reference
	private CategoryService catService;
	@Autowired
	private RedisTemplate<String, PageInfo<Spu>> redisTemplate;
	@Autowired
	ElSearchUtil<SpuEsVo> es;
	
	
	//首页
	@RequestMapping({"/","index","main"})	
	public String index(HttpServletRequest request, 
			@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "12")Integer pageSize,
			@RequestParam(defaultValue = "0")int catId) {
		
		if(catId==0 && page==1) {
			if(getRedisTemplate().hasKey("GOODS_FIRST_PAGE")) {
				ValueOperations<String, PageInfo<Spu>> operations = 
						getRedisTemplate().opsForValue();
				PageInfo<Spu> pageInfo = operations.get("GOODS_FIRST_PAGE");
				request.setAttribute("pageInfo",pageInfo);
				request.setAttribute("catId",catId);
				return "index";
			}
		}
		
		SpuVo vo = new SpuVo();
		vo.setCategoryId(catId);
		PageInfo<Spu> pageInfo = spuService.list(vo, page, pageSize);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("catId", catId);
		
		// 应该放入缓存
		if(catId==0 && page==1) {
			ValueOperations<String, PageInfo<Spu>> operations = 
					getRedisTemplate().opsForValue();
			operations.set("GOODS_FIRST_PAGE", pageInfo, 100, TimeUnit.SECONDS);			
		}
		
		return "index";
	}
	
	//树状
	@ResponseBody
	@RequestMapping("treeData")
	public List<Category> treeData() {
		List<Category> catTree = catService.getTree();
		return catTree;
	}
	
	public RedisTemplate<String, PageInfo<Spu>> getRedisTemplate() {
		return redisTemplate;
	}


	public void setRedisTemplate(RedisTemplate<String, PageInfo<Spu>> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	@RequestMapping("search")
	public String search(HttpServletRequest request,String key,@RequestParam(defaultValue = "1") int page) {
		
		AggregatedPage<SpuEsVo> pageInfo =
				es.queryObjects(SpuEsVo.class, page, 10, new String[] {"goodsName","brandName","caption","categoryName"}, key);
		request.setAttribute("pageInfo", pageInfo);
		return "search";
	}
	
}
