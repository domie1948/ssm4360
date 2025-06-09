package com.entity.model;

import com.entity.MeishipingfenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 美食评分
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-02-25 10:22:02
 */
public class MeishipingfenModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 订单号
	 */
	
	private String dingdanhao;
		
	/**
	 * 配送分
	 */
	
	private String peisongfen;
		
	/**
	 * 包装分
	 */
	
	private String baozhuangfen;
		
	/**
	 * 菜品分
	 */
	
	private String caipinfen;
		
	/**
	 * 日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date riqi;
		
	/**
	 * 建议
	 */
	
	private String jianyi;
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：订单号
	 */
	 
	public void setDingdanhao(String dingdanhao) {
		this.dingdanhao = dingdanhao;
	}
	
	/**
	 * 获取：订单号
	 */
	public String getDingdanhao() {
		return dingdanhao;
	}
				
	
	/**
	 * 设置：配送分
	 */
	 
	public void setPeisongfen(String peisongfen) {
		this.peisongfen = peisongfen;
	}
	
	/**
	 * 获取：配送分
	 */
	public String getPeisongfen() {
		return peisongfen;
	}
				
	
	/**
	 * 设置：包装分
	 */
	 
	public void setBaozhuangfen(String baozhuangfen) {
		this.baozhuangfen = baozhuangfen;
	}
	
	/**
	 * 获取：包装分
	 */
	public String getBaozhuangfen() {
		return baozhuangfen;
	}
				
	
	/**
	 * 设置：菜品分
	 */
	 
	public void setCaipinfen(String caipinfen) {
		this.caipinfen = caipinfen;
	}
	
	/**
	 * 获取：菜品分
	 */
	public String getCaipinfen() {
		return caipinfen;
	}
				
	
	/**
	 * 设置：日期
	 */
	 
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	
	/**
	 * 获取：日期
	 */
	public Date getRiqi() {
		return riqi;
	}
				
	
	/**
	 * 设置：建议
	 */
	 
	public void setJianyi(String jianyi) {
		this.jianyi = jianyi;
	}
	
	/**
	 * 获取：建议
	 */
	public String getJianyi() {
		return jianyi;
	}
			
}
