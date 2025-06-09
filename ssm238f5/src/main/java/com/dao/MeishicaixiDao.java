package com.dao;

import com.entity.MeishicaixiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MeishicaixiVO;
import com.entity.view.MeishicaixiView;


/**
 * 美食菜系
 * 
 * @author 
 * @email 
 * @date 2021-02-25 10:22:02
 */
public interface MeishicaixiDao extends BaseMapper<MeishicaixiEntity> {
	
	List<MeishicaixiVO> selectListVO(@Param("ew") Wrapper<MeishicaixiEntity> wrapper);
	
	MeishicaixiVO selectVO(@Param("ew") Wrapper<MeishicaixiEntity> wrapper);
	
	List<MeishicaixiView> selectListView(@Param("ew") Wrapper<MeishicaixiEntity> wrapper);

	List<MeishicaixiView> selectListView(Pagination page,@Param("ew") Wrapper<MeishicaixiEntity> wrapper);
	
	MeishicaixiView selectView(@Param("ew") Wrapper<MeishicaixiEntity> wrapper);
	
}
