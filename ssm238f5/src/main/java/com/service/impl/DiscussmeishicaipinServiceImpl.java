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


import com.dao.DiscussmeishicaipinDao;
import com.entity.DiscussmeishicaipinEntity;
import com.service.DiscussmeishicaipinService;
import com.entity.vo.DiscussmeishicaipinVO;
import com.entity.view.DiscussmeishicaipinView;

@Service("discussmeishicaipinService")
public class DiscussmeishicaipinServiceImpl extends ServiceImpl<DiscussmeishicaipinDao, DiscussmeishicaipinEntity> implements DiscussmeishicaipinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussmeishicaipinEntity> page = this.selectPage(
                new Query<DiscussmeishicaipinEntity>(params).getPage(),
                new EntityWrapper<DiscussmeishicaipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussmeishicaipinEntity> wrapper) {
		  Page<DiscussmeishicaipinView> page =new Query<DiscussmeishicaipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussmeishicaipinVO> selectListVO(Wrapper<DiscussmeishicaipinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussmeishicaipinVO selectVO(Wrapper<DiscussmeishicaipinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussmeishicaipinView> selectListView(Wrapper<DiscussmeishicaipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussmeishicaipinView selectView(Wrapper<DiscussmeishicaipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
