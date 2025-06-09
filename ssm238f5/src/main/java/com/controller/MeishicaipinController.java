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

import com.entity.MeishicaipinEntity;
import com.entity.view.MeishicaipinView;

import com.service.MeishicaipinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 美食菜品
 * 后端接口
 * @author 
 * @email 
 * @date 2021-02-25 10:22:02
 */
@RestController
@RequestMapping("/meishicaipin")
public class MeishicaipinController {
    @Autowired
    private MeishicaipinService meishicaipinService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MeishicaipinEntity meishicaipin, HttpServletRequest request){

        EntityWrapper<MeishicaipinEntity> ew = new EntityWrapper<MeishicaipinEntity>();
		PageUtils page = meishicaipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishicaipin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MeishicaipinEntity meishicaipin, HttpServletRequest request){
        EntityWrapper<MeishicaipinEntity> ew = new EntityWrapper<MeishicaipinEntity>();
		PageUtils page = meishicaipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishicaipin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MeishicaipinEntity meishicaipin){
       	EntityWrapper<MeishicaipinEntity> ew = new EntityWrapper<MeishicaipinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( meishicaipin, "meishicaipin")); 
        return R.ok().put("data", meishicaipinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MeishicaipinEntity meishicaipin){
        EntityWrapper< MeishicaipinEntity> ew = new EntityWrapper< MeishicaipinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( meishicaipin, "meishicaipin")); 
		MeishicaipinView meishicaipinView =  meishicaipinService.selectView(ew);
		return R.ok("查询美食菜品成功").put("data", meishicaipinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MeishicaipinEntity meishicaipin = meishicaipinService.selectById(id);
		meishicaipin.setClicknum(meishicaipin.getClicknum()+1);
		meishicaipin.setClicktime(new Date());
		meishicaipinService.updateById(meishicaipin);
        return R.ok().put("data", meishicaipin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MeishicaipinEntity meishicaipin = meishicaipinService.selectById(id);
		meishicaipin.setClicknum(meishicaipin.getClicknum()+1);
		meishicaipin.setClicktime(new Date());
		meishicaipinService.updateById(meishicaipin);
        return R.ok().put("data", meishicaipin);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        MeishicaipinEntity meishicaipin = meishicaipinService.selectById(id);
        if(type.equals("1")) {
        	meishicaipin.setThumbsupnum(meishicaipin.getThumbsupnum()+1);
        } else {
        	meishicaipin.setCrazilynum(meishicaipin.getCrazilynum()+1);
        }
        meishicaipinService.updateById(meishicaipin);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MeishicaipinEntity meishicaipin, HttpServletRequest request){
    	meishicaipin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meishicaipin);

        meishicaipinService.insert(meishicaipin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MeishicaipinEntity meishicaipin, HttpServletRequest request){
    	meishicaipin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meishicaipin);

        meishicaipinService.insert(meishicaipin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MeishicaipinEntity meishicaipin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(meishicaipin);
        meishicaipinService.updateById(meishicaipin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        meishicaipinService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<MeishicaipinEntity> wrapper = new EntityWrapper<MeishicaipinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = meishicaipinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,MeishicaipinEntity meishicaipin, HttpServletRequest request,String pre){
        EntityWrapper<MeishicaipinEntity> ew = new EntityWrapper<MeishicaipinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = meishicaipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishicaipin), params), params));
        return R.ok().put("data", page);
    }


}
