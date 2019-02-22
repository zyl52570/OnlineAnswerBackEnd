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
@TableName("answerresult")
public class Answerresult implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 业务主键
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer studentid;
	/**
	 * 学员答题主表ID
	 */
	private Integer ssid;
	/**
	 * 题目id
	 */
	private Integer examid;
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
	 * 学生答案
	 */
	private String studentanswer;
	/**
	 * 正确答案
	 */
	private String correctanswer;

	/**
	 * 答题是否正确0错误，1正确
	 */
	private String istrue;
	/**
	 * 创建时间
	 */
	private Date createtime;

	@TableField(exist = false)
	private String examname;
	@TableField(exist = false)
	private String  exama;
	@TableField(exist = false)
	private String examb;
	@TableField(exist = false)
	private String examc;
	@TableField(exist = false)
	private String examd;
	@TableField(exist = false)
	private String examcorrectanswer;
	@TableField(exist = false)
	private String examexplaininfo;

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public String getExama() {
		return exama;
	}

	public void setExama(String exama) {
		this.exama = exama;
	}

	public String getExamb() {
		return examb;
	}

	public void setExamb(String examb) {
		this.examb = examb;
	}

	public String getExamc() {
		return examc;
	}

	public void setExamc(String examc) {
		this.examc = examc;
	}

	public String getExamd() {
		return examd;
	}

	public void setExamd(String examd) {
		this.examd = examd;
	}

	public String getExamcorrectanswer() {
		return examcorrectanswer;
	}

	public void setExamcorrectanswer(String examcorrectanswer) {
		this.examcorrectanswer = examcorrectanswer;
	}

	public String getExamexplaininfo() {
		return examexplaininfo;
	}

	public void setExamexplaininfo(String examexplaininfo) {
		this.examexplaininfo = examexplaininfo;
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
	 * 设置：
	 */
	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}
	/**
	 * 获取：
	 */
	public Integer getStudentid() {
		return studentid;
	}
	/**
	 * 设置：学员答题主表ID
	 */
	public void setSsid(Integer ssid) {
		this.ssid = ssid;
	}
	/**
	 * 获取：学员答题主表ID
	 */
	public Integer getSsid() {
		return ssid;
	}
	/**
	 * 设置：题目ID
	 */
	public void setExamid(Integer examid) {
		this.examid = examid;
	}
	/**
	 * 获取：题目ID
	 */
	public Integer getExamid() {
		return examid;
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
	 * 设置：学生答案
	 */
	public void setStudentanswer(String studentanswer) {
		this.studentanswer = studentanswer;
	}
	/**
	 * 获取：学生答案
	 */
	public String getStudentanswer() {
		return studentanswer;
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
	 * 设置：答题是否正确0错误，1正确
	 */
	public void setIstrue(String istrue) {
		this.istrue = istrue;
	}
	/**
	 * 获取：答题是否正确0错误，1正确
	 */
	public String getIstrue() {
		return istrue;
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
