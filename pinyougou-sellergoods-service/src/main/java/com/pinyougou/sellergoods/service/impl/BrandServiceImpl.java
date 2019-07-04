package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandService;

import entity.Result;
import entity.pageResult;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private TbBrandMapper tbBrandMapper;

	@Override
	public List<TbBrand> findAll() {
		
		return tbBrandMapper.selectByExample(null);
	}

	@Override
	public pageResult findPage(int pageNum, int pageSize) {
		/*分页插件pageHelper*/
		PageHelper.startPage(pageNum, pageSize);
		Page<TbBrand> page = (Page<TbBrand>)tbBrandMapper.selectByExample(null);
		//因为pageResult里面封装的是一个总记录数和一个当前数据的list集合数,所以getResult得到一个list结果集
		return new pageResult(page.getTotal(),page.getResult());
		
	}

	@Override
	public void add(TbBrand brand) {
	   tbBrandMapper.insert(brand);
	}

	@Override
	public TbBrand findOne(Long id) {
		return tbBrandMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(TbBrand brand) {
		tbBrandMapper.updateByPrimaryKey(brand);
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			tbBrandMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public pageResult findPage(TbBrand brand, int pageNum, int pageSize) {
		/*分页插件pageHelper*/
		PageHelper.startPage(pageNum, pageSize);
		TbBrandExample example = new TbBrandExample();
		Criteria criteria = example.createCriteria();
		if(brand!=null) {
			if(brand.getName()!=null && brand.getName()!="" && brand.getName().length()>0) {
				criteria.andNameLike("%"+brand.getName()+"%");
			}
			if(brand.getFirstChar()!=null && brand.getFirstChar()!="" && brand.getFirstChar().length()>0) {
				criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
			}
		}
		
		Page<TbBrand> page = (Page<TbBrand>)tbBrandMapper.selectByExample(example);
		//因为pageResult里面封装的是一个总记录数和一个当前数据的list集合数,所以getResult得到一个list结果集
		return new pageResult(page.getTotal(),page.getResult());
		
	}

}
