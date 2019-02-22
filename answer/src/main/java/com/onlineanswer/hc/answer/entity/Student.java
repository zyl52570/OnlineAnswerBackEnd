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
@TableName("student")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 所属校区
	 */
	private Integer campusid;
	@TableField(exist=false) //表示该列不是表中的字段
	private String campusname;
	/**
	 * 班级id
	 */
	private Integer classinfoid;
	@TableField(exist=false) //表示该列不是表中的字段
	private String classinfoname;
	/**
	 * 姓名
	 */
	private String stuname;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * QQ
	 */
	private String qq;
	/**
	 * 毕业学校
	 */
	private String school;
	/**
	 * 专业
	 */
	private String profession;
	/**
	 * 学历
	 */
	private String education;
	/**
	 * 性质
	 */
	private String nature;
	/**
	 * 毕业时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date graduationtime;
	/**
	 * 身份证
	 */
	private String idnumber;
	/**
	 * 父母姓名
	 */
	private String parentsname;
	/**
	 * 关系
	 */
	private String relation;
	/**
	 * 父母电话
	 */
	private String parentstel;
	/**
	 * 联系地址
	 */
	private String address;
	/**
	 * 账号
	 */
	private String login;
	/**
	 * 密码
	 */
	private String pwd;
	/**
	 * 讲师
	 */
	private String lecturer;
	/**
	 * 班主任
	 */
	private String teacher;
	/**
	 * 
	 */
	private Date createtime;

	public String getCampusname() {
		return campusname;
	}

	public void setCampusname(String campusname) {
		this.campusname = campusname;
	}

	public String getClassinfoname() {
		return classinfoname;
	}

	public void setClassinfoname(String classinfoname) {
		this.classinfoname = classinfoname;
	}

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
	 * 设置：所属校区
	 */
	public void setCampusid(Integer campusid) {
		this.campusid = campusid;
	}
	/**
	 * 获取：所属校区
	 */
	public Integer getCampusid() {
		return campusid;
	}
	/**
	 * 设置：班级id
	 */
	public void setClassinfoid(Integer classinfoid) {
		this.classinfoid = classinfoid;
	}
	/**
	 * 获取：班级id
	 */
	public Integer getClassinfoid() {
		return classinfoid;
	}
	/**
	 * 设置：姓名
	 */
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	/**
	 * 获取：姓名
	 */
	public String getStuname() {
		return stuname;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：QQ
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * 获取：QQ
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * 设置：毕业学校
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	/**
	 * 获取：毕业学校
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * 设置：专业
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}
	/**
	 * 获取：专业
	 */
	public String getProfession() {
		return profession;
	}
	/**
	 * 设置：学历
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * 获取：学历
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * 设置：性质
	 */
	public void setNature(String nature) {
		this.nature = nature;
	}
	/**
	 * 获取：性质
	 */
	public String getNature() {
		return nature;
	}
	/**
	 * 设置：毕业时间
	 */
	public void setGraduationtime(Date graduationtime) {
		this.graduationtime = graduationtime;
	}
	/**
	 * 获取：毕业时间
	 */
	public Date getGraduationtime() {
		return graduationtime;
	}
	/**
	 * 设置：身份证
	 */
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	/**
	 * 获取：身份证
	 */
	public String getIdnumber() {
		return idnumber;
	}
	/**
	 * 设置：父母姓名
	 */
	public void setParentsname(String parentsname) {
		this.parentsname = parentsname;
	}
	/**
	 * 获取：父母姓名
	 */
	public String getParentsname() {
		return parentsname;
	}
	/**
	 * 设置：关系
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	}
	/**
	 * 获取：关系
	 */
	public String getRelation() {
		return relation;
	}
	/**
	 * 设置：父母电话
	 */
	public void setParentstel(String parentstel) {
		this.parentstel = parentstel;
	}
	/**
	 * 获取：父母电话
	 */
	public String getParentstel() {
		return parentstel;
	}
	/**
	 * 设置：联系地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：联系地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：账号
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * 获取：账号
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * 设置：密码
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * 获取：密码
	 */
	public String getPwd() {
		return pwd;
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
	 * 设置：班主任
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	/**
	 * 获取：班主任
	 */
	public String getTeacher() {
		return teacher;
	}
	/**
	 * 设置：
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatetime() {
		return createtime;
	}
}
