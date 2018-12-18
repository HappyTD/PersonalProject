package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {

	public List<TbBrand> findAll();
	
	/**
	 * 获取分页数据
	 * @param pageNum 当前页数	
	 * @param pageSize	当前页显示记录条数
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
}
