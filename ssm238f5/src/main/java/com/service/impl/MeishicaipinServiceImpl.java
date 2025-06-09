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


import com.dao.MeishicaipinDao;
import com.entity.MeishicaipinEntity;
import com.service.MeishicaipinService;
import com.entity.vo.MeishicaipinVO;
import com.entity.view.MeishicaipinView;

@Service("meishicaipinService")
public class MeishicaipinServiceImpl extends ServiceImpl<MeishicaipinDao, MeishicaipinEntity> implements MeishicaipinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MeishicaipinEntity> page = this.selectPage(
                new Query<MeishicaipinEntity>(params).getPage(),
                new EntityWrapper<MeishicaipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MeishicaipinEntity> wrapper) {
		  Page<MeishicaipinView> page =new Query<MeishicaipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MeishicaipinVO> selectListVO(Wrapper<MeishicaipinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MeishicaipinVO selectVO(Wrapper<MeishicaipinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MeishicaipinView> selectListView(Wrapper<MeishicaipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MeishicaipinView selectView(Wrapper<MeishicaipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
