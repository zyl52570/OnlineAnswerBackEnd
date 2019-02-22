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
@TableName("examinfo")
public class Examinfo implements Serializable {
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
	private String examtypename;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 答案A
	 */
	private String a;
	/**
	 * 答案B
	 */
	private String b;
	/**
	 * 答案C
	 */
	private String c;
	/**
	 * 答案D
	 */
	private String d;
	/**
	 * 正确答案
	 */
	private String correctanswer;
	/**
	 * 解释
	 */
	private String explaininfo;
	/**
	 * 创建时间
	 */
	private Date createtime;

	public String getExamtypename() {
		return examtypename;
	}

	public void setExamtypename(String examtypename) {
		this.examtypename = examtypename;
	}

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
	/**
	 * 设置：题目类别ID
	 */
	public void setExamtypeid(Integer examtypeid) {
		this.examtypeid = examtypeid;
	}
	/**
	 * 获取：题目类别ID
	 */
	public Integer getExamtypeid() {
		return examtypeid;
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
	 * 设置：答案A
	 */
	public void setA(String a) {
		this.a = a;
	}
	/**
	 * 获取：答案A
	 */
	public String getA() {
		return a;
	}
	/**
	 * 设置：答案B
	 */
	public void setB(String b) {
		this.b = b;
	}
	/**
	 * 获取：答案B
	 */
	public String getB() {
		return b;
	}
	/**
	 * 设置：答案C
	 */
	public void setC(String c) {
		this.c = c;
	}
	/**
	 * 获取：答案C
	 */
	public String getC() {
		return c;
	}
	/**
	 * 设置：答案D
	 */
	public void setD(String d) {
		this.d = d;
	}
	/**
	 * 获取：答案D
	 */
	public String getD() {
		return d;
	}
	/**
	 * 设置：正确答案
	 */
	public void setCorrectanswer(String correctanswer) {
		this.correctanswer = correctanswer;
	}
	/**
	 * 获取：正确答案
	 */
	public String getCorrectanswer() {
		return correctanswer;
	}
	/**
	 * 设置：解释
	 */
	public void setExplaininfo(String explaininfo) {
		this.explaininfo = explaininfo;
	}
	/**
	 * 获取：解释
	 */
	public String getExplaininfo() {
		return explaininfo;
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
