package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.ReturnResult;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;
	
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		return brandService.findAll();		
	}
	
	@RequestMapping("/findPage")
	public PageResult findPage(int pageNum,int pageSize){
		return brandService.findPage(pageNum, pageSize);
	}
	
	
	@RequestMapping("/add")
	public ReturnResult add(@RequestBody TbBrand brand){
		try {
			brandService.add(brand);
			return new ReturnResult(true, "添加成功");
		} catch (Exception e) {
			return new ReturnResult(false, "添加失败");
		}
	}
	
	@RequestMapping("/findOne")
	public TbBrand findOne(Long id){
		return brandService.findOne(id);
	}
	
	@RequestMapping("/update")
	public ReturnResult update(@RequestBody TbBrand brand){
		try {
			brandService.update(brand);
			return new ReturnResult(true, "修改成功");
		} catch (Exception e) {
			return new ReturnResult(false, "修改失败");
		}
	}
	
	@RequestMapping("/delete")
	public ReturnResult delete(Long[] ids){
		try {
			brandService.delete(ids);
			return new ReturnResult(true, "删除成功");
		} catch (Exception e) {
			return new ReturnResult(false, "删除失败");
		}
	}
	
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand brand,int pageNum,int pageSize){
		return brandService.findPage(brand,pageNum, pageSize);
	}
	
}
