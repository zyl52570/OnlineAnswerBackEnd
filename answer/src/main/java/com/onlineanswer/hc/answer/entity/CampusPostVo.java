package com.onlineanswer.hc.answer.entity;

import com.baomidou.mybatisplus.annotations.TableField;
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
public class CampusPostVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 岗位主键
	 */
	private Integer id;
	/**
	 * 校区id
	 */
	private Integer campusid;
	/**
	 * 校区名称
	 */
	@TableField(exist=false) //表示该列不是表中的字段
	private String campusname;
	/**
	 * 岗位名称
	 */
	private String postname;
	/**
	 * 创建时间
	 */
	private Date createtime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCampusid() {
		return campusid;
	}

	public void setCampusid(Integer campusid) {
		this.campusid = campusid;
	}

	public String getCampusname() {
		return campusname;
	}

	public void setCampusname(String campusname) {
		this.campusname = campusname;
	}

	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}
