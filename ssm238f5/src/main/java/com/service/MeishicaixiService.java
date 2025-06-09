package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MeishicaixiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MeishicaixiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MeishicaixiView;


/**
 * 美食菜系
 *
 * @author 
 * @email 
 * @date 2021-02-25 10:22:02
 */
public interface MeishicaixiService extends IService<MeishicaixiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MeishicaixiVO> selectListVO(Wrapper<MeishicaixiEntity> wrapper);
   	
   	MeishicaixiVO selectVO(@Param("ew") Wrapper<MeishicaixiEntity> wrapper);
   	
   	List<MeishicaixiView> selectListView(Wrapper<MeishicaixiEntity> wrapper);
   	
   	MeishicaixiView selectView(@Param("ew") Wrapper<MeishicaixiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MeishicaixiEntity> wrapper);
   	
}

