package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MeishicaipinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MeishicaipinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MeishicaipinView;


/**
 * 美食菜品
 *
 * @author 
 * @email 
 * @date 2021-02-25 10:22:02
 */
public interface MeishicaipinService extends IService<MeishicaipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MeishicaipinVO> selectListVO(Wrapper<MeishicaipinEntity> wrapper);
   	
   	MeishicaipinVO selectVO(@Param("ew") Wrapper<MeishicaipinEntity> wrapper);
   	
   	List<MeishicaipinView> selectListView(Wrapper<MeishicaipinEntity> wrapper);
   	
   	MeishicaipinView selectView(@Param("ew") Wrapper<MeishicaipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MeishicaipinEntity> wrapper);
   	
}

