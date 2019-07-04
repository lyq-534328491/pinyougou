package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

import entity.pageResult;

/**
 * 品牌接口
 * @author lyq
 */
public interface BrandService {

	public List<TbBrand> findAll();
	
	/**
	 * 分页查询品牌
	 * @param pageNum 当前页码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public pageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加品牌
	 * @param brand
	 * @return
	 */
	public void add(TbBrand brand);
	
	/**
	 * 根据id查询修改
	 * @param id
	 * @return
	 */
	public TbBrand findOne(Long id);
	
	/**
	 * 修改
	 * @param brand
	 * @return
	 */
	public void update(TbBrand brand);
	
	/**
	 * 根据id数组删除复选框中的品牌
	 * @param ids
	 */
	public void delete(Long[] ids);
	
	/**
	 * 根据条件分页查询
	 * @param brand
	 * @param page
	 * @param size
	 * @return
	 */
	public pageResult findPage(TbBrand brand,int pageNum,int pageSize);
	
}
