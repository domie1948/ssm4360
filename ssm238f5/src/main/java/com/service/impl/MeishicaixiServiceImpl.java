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


import com.dao.MeishicaixiDao;
import com.entity.MeishicaixiEntity;
import com.service.MeishicaixiService;
import com.entity.vo.MeishicaixiVO;
import com.entity.view.MeishicaixiView;

@Service("meishicaixiService")
public class MeishicaixiServiceImpl extends ServiceImpl<MeishicaixiDao, MeishicaixiEntity> implements MeishicaixiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MeishicaixiEntity> page = this.selectPage(
                new Query<MeishicaixiEntity>(params).getPage(),
                new EntityWrapper<MeishicaixiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MeishicaixiEntity> wrapper) {
		  Page<MeishicaixiView> page =new Query<MeishicaixiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MeishicaixiVO> selectListVO(Wrapper<MeishicaixiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MeishicaixiVO selectVO(Wrapper<MeishicaixiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MeishicaixiView> selectListView(Wrapper<MeishicaixiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MeishicaixiView selectView(Wrapper<MeishicaixiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
