package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * 添加
	 * @param brand
	 */
	public void add(TbBrand brand);
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public TbBrand findOne(Long id);
	
	/**
	 * 更新
	 * @param brand
	 */
	public void update(TbBrand brand);
	
	/**
	 * 删除通过id
	 * @param ids
	 */
	public void delete(Long[] ids);
	
	public PageResult findPage(TbBrand brand,int pageNum,int pageSize);
	
	public List<Map> selectOptionList();
		
	
}
