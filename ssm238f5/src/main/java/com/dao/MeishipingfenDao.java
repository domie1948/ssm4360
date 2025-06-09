package com.dao;

import com.entity.MeishipingfenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MeishipingfenVO;
import com.entity.view.MeishipingfenView;


/**
 * 美食评分
 * 
 * @author 
 * @email 
 * @date 2021-02-25 10:22:02
 */
public interface MeishipingfenDao extends BaseMapper<MeishipingfenEntity> {
	
	List<MeishipingfenVO> selectListVO(@Param("ew") Wrapper<MeishipingfenEntity> wrapper);
	
	MeishipingfenVO selectVO(@Param("ew") Wrapper<MeishipingfenEntity> wrapper);
	
	List<MeishipingfenView> selectListView(@Param("ew") Wrapper<MeishipingfenEntity> wrapper);

	List<MeishipingfenView> selectListView(Pagination page,@Param("ew") Wrapper<MeishipingfenEntity> wrapper);
	
	MeishipingfenView selectView(@Param("ew") Wrapper<MeishipingfenEntity> wrapper);
	
}
