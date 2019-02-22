package com.onlineanswer.hc.answer.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author k1732
 * @email zyl52570@163.com
 * @date 2019-01-10 09:29:07
 */
@TableName("classinfo")
public class Classinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 所属校区ID
	 */
	private Integer campusid;
	/**
	 * 校区名称
	 */
	@TableField(exist=false) //表示该列不是表中的字段
	private String campusname;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 开班时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date classtime;
	/**
	 * 讲师
	 */
	private String lecturer;
	/**
	 * 
	 */
	private String teacher;
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
	 * 设置：所属校区ID
	 */
	public void setCampusid(Integer campusid) {
		this.campusid = campusid;
	}

	public String getCampusname() {
		return campusname;
	}

	public void setCampusname(String campusname) {
		this.campusname = campusname;
	}

	/**
	 * 获取：所属校区ID
	 */
	public Integer getCampusid() {
		return campusid;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：开班时间
	 */
	public void setClasstime(Date classtime) {
		this.classtime = classtime;
	}
	/**
	 * 获取：开班时间
	 */
	public Date getClasstime() {
		return classtime;
	}
	/**
	 * 设置：讲师
	 */
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	/**
	 * 获取：讲师
	 */
	public String getLecturer() {
		return lecturer;
	}
	/**
	 * 设置：
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	/**
	 * 获取：
	 */
	public String getTeacher() {
		return teacher;
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
