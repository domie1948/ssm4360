package com.entity.view;

import com.entity.MeishipingfenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 美食评分
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-02-25 10:22:02
 */
@TableName("meishipingfen")
public class MeishipingfenView  extends MeishipingfenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MeishipingfenView(){
	}
 
 	public MeishipingfenView(MeishipingfenEntity meishipingfenEntity){
 	try {
			BeanUtils.copyProperties(this, meishipingfenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
