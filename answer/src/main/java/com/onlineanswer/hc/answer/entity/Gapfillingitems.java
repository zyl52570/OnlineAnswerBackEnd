package com.onlineanswer.hc.answer.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 填空题实体类
 * 作者:K1732
 * 时间：2019-05-10
 */
@TableName("gapfillingitems")
public class Gapfillingitems implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private Integer examtypeid;
    private String description;
    private String result;
    @TableField(exist = false)
    private String examtypename;
    public String getExamtypename() {
        return examtypename;
    }

    public void setExamtypename(String examtypename) {
        this.examtypename = examtypename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExamtypeid() {
        return examtypeid;
    }

    public void setExamtypeid(Integer examtypeid) {
        this.examtypeid = examtypeid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
