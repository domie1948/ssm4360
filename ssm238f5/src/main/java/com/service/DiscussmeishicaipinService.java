package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussmeishicaipinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussmeishicaipinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussmeishicaipinView;


/**
 * 美食菜品评论表
 *
 * @author 
 * @email 
 * @date 2021-02-25 10:22:02
 */
public interface DiscussmeishicaipinService extends IService<DiscussmeishicaipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmeishicaipinVO> selectListVO(Wrapper<DiscussmeishicaipinEntity> wrapper);
   	
   	DiscussmeishicaipinVO selectVO(@Param("ew") Wrapper<DiscussmeishicaipinEntity> wrapper);
   	
   	List<DiscussmeishicaipinView> selectListView(Wrapper<DiscussmeishicaipinEntity> wrapper);
   	
   	DiscussmeishicaipinView selectView(@Param("ew") Wrapper<DiscussmeishicaipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmeishicaipinEntity> wrapper);
   	
}

