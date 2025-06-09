package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.MeishipingfenDao;
import com.entity.MeishipingfenEntity;
import com.service.MeishipingfenService;
import com.entity.vo.MeishipingfenVO;
import com.entity.view.MeishipingfenView;

@Service("meishipingfenService")
public class MeishipingfenServiceImpl extends ServiceImpl<MeishipingfenDao, MeishipingfenEntity> implements MeishipingfenService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MeishipingfenEntity> page = this.selectPage(
                new Query<MeishipingfenEntity>(params).getPage(),
                new EntityWrapper<MeishipingfenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MeishipingfenEntity> wrapper) {
		  Page<MeishipingfenView> page =new Query<MeishipingfenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MeishipingfenVO> selectListVO(Wrapper<MeishipingfenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MeishipingfenVO selectVO(Wrapper<MeishipingfenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MeishipingfenView> selectListView(Wrapper<MeishipingfenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MeishipingfenView selectView(Wrapper<MeishipingfenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
