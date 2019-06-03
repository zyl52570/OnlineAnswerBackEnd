package com.onlineanswer.hc.answer.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 程序题实体类
 * 作者:K1732
 * 时间：2019-05-10
 */
@TableName("programitems")
public class Programitems implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private Integer examtypeid;
    private String description;
    private String originalname;
    private String originalpath;
    private String filename;
    private String filepath;
    @TableField(exist = false)
    private String examtypename;

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

    public String getOriginalname() {
        return originalname;
    }

    public void setOriginalname(String originalname) {
        this.originalname = originalname;
    }

    public String getOriginalpath() {
        return originalpath;
    }

    public void setOriginalpath(String originalpath) {
        this.originalpath = originalpath;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getExamtypename() {
        return examtypename;
    }

    public void setExamtypename(String examtypename) {
        this.examtypename = examtypename;
    }
}
