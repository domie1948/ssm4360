package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.MeishicaixiEntity;
import com.entity.view.MeishicaixiView;

import com.service.MeishicaixiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 美食菜系
 * 后端接口
 * @author 
 * @email 
 * @date 2021-02-25 10:22:02
 */
@RestController
@RequestMapping("/meishicaixi")
public class MeishicaixiController {
    @Autowired
    private MeishicaixiService meishicaixiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MeishicaixiEntity meishicaixi, HttpServletRequest request){

        EntityWrapper<MeishicaixiEntity> ew = new EntityWrapper<MeishicaixiEntity>();
		PageUtils page = meishicaixiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishicaixi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MeishicaixiEntity meishicaixi, HttpServletRequest request){
        EntityWrapper<MeishicaixiEntity> ew = new EntityWrapper<MeishicaixiEntity>();
		PageUtils page = meishicaixiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishicaixi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MeishicaixiEntity meishicaixi){
       	EntityWrapper<MeishicaixiEntity> ew = new EntityWrapper<MeishicaixiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( meishicaixi, "meishicaixi")); 
        return R.ok().put("data", meishicaixiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MeishicaixiEntity meishicaixi){
        EntityWrapper< MeishicaixiEntity> ew = new EntityWrapper< MeishicaixiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( meishicaixi, "meishicaixi")); 
		MeishicaixiView meishicaixiView =  meishicaixiService.selectView(ew);
		return R.ok("查询美食菜系成功").put("data", meishicaixiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MeishicaixiEntity meishicaixi = meishicaixiService.selectById(id);
        return R.ok().put("data", meishicaixi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MeishicaixiEntity meishicaixi = meishicaixiService.selectById(id);
        return R.ok().put("data", meishicaixi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MeishicaixiEntity meishicaixi, HttpServletRequest request){
    	meishicaixi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meishicaixi);

        meishicaixiService.insert(meishicaixi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MeishicaixiEntity meishicaixi, HttpServletRequest request){
    	meishicaixi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meishicaixi);

        meishicaixiService.insert(meishicaixi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MeishicaixiEntity meishicaixi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(meishicaixi);
        meishicaixiService.updateById(meishicaixi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        meishicaixiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<MeishicaixiEntity> wrapper = new EntityWrapper<MeishicaixiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = meishicaixiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
