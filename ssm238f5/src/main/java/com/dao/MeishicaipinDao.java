package com.dao;

import com.entity.MeishicaipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MeishicaipinVO;
import com.entity.view.MeishicaipinView;


/**
 * 美食菜品
 * 
 * @author 
 * @email 
 * @date 2021-02-25 10:22:02
 */
public interface MeishicaipinDao extends BaseMapper<MeishicaipinEntity> {
	
	List<MeishicaipinVO> selectListVO(@Param("ew") Wrapper<MeishicaipinEntity> wrapper);
	
	MeishicaipinVO selectVO(@Param("ew") Wrapper<MeishicaipinEntity> wrapper);
	
	List<MeishicaipinView> selectListView(@Param("ew") Wrapper<MeishicaipinEntity> wrapper);

	List<MeishicaipinView> selectListView(Pagination page,@Param("ew") Wrapper<MeishicaipinEntity> wrapper);
	
	MeishicaipinView selectView(@Param("ew") Wrapper<MeishicaipinEntity> wrapper);
	
}
