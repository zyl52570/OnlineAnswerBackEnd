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
@TableName("studentsanswer")
public class Studentsanswer implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 业务主键
	 */
	@TableId
	private Integer id;
	/**
	 * 题目类别ID
	 */

	private Integer examtypeid;



	@TableField(exist = false)
	private String examinfoname;
	/**
	 * 成绩
	 */
	private Integer grade;
	private Integer studentid;

	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	/**
	 * 创建时间
	 */
	private Date createtime;

	/**
	 * 设置：业务主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：业务主键
	 */
	public Integer getId() {
		return id;
	}

	public Integer getExamtypeid() {
		return examtypeid;
	}

	public void setExamtypeid(Integer examtypeid) {
		this.examtypeid = examtypeid;
	}

	/**
	 * 设置：成绩
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	/**
	 * 获取：成绩
	 */
	public Integer getGrade() {
		return grade;
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

	public String getExaminfoname() {
		return examinfoname;
	}

	public void setExaminfoname(String examinfoname) {
		this.examinfoname = examinfoname;
	}
}
