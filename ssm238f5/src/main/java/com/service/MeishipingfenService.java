package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MeishipingfenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MeishipingfenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MeishipingfenView;


/**
 * 美食评分
 *
 * @author 
 * @email 
 * @date 2021-02-25 10:22:02
 */
public interface MeishipingfenService extends IService<MeishipingfenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MeishipingfenVO> selectListVO(Wrapper<MeishipingfenEntity> wrapper);
   	
   	MeishipingfenVO selectVO(@Param("ew") Wrapper<MeishipingfenEntity> wrapper);
   	
   	List<MeishipingfenView> selectListView(Wrapper<MeishipingfenEntity> wrapper);
   	
   	MeishipingfenView selectView(@Param("ew") Wrapper<MeishipingfenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MeishipingfenEntity> wrapper);
   	
}

