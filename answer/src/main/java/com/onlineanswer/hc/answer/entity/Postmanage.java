package com.onlineanswer.hc.answer.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author k1732
 * @email zyl52570@163.com
 * @date 2019-01-10 09:29:07
 */
@TableName("postmanage")
public class Postmanage implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 校区id
	 */
	private Integer campusid;
	/**
	 * 岗位名称
	 */
	private String postname;
	/**
	 * 创建时间
	 */
	private Date createtime;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：校区id
	 */
	public void setCampusid(Integer campusid) {
		this.campusid = campusid;
	}
	/**
	 * 获取：校区id
	 */
	public Integer getCampusid() {
		return campusid;
	}
	/**
	 * 设置：岗位名称
	 */
	public void setPostname(String postname) {
		this.postname = postname;
	}
	/**
	 * 获取：岗位名称
	 */
	public String getPostname() {
		return postname;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
}
