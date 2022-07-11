package com.biliaryatresia.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 上传图片;
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@ApiModel(value = "上传图片",description = "")
@Table(name="image")
public class Image implements Serializable,Cloneable{
    /** 图片id */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "图片id",notes = "")
    private Integer imgId ;
    /** 病人id */
    @ApiModelProperty(name = "病人id",notes = "")
    private Integer pId ;
    /** 上传时间 */
    @ApiModelProperty(name = "上传时间",notes = "")
    private Date imgDate ;
    /** 图片保存路径 */
    @ApiModelProperty(name = "图片保存路径",notes = "")
    private String imgDir ;
    /** 算法识别结果 */
    @ApiModelProperty(name = "算法识别结果",notes = "")
    private String detectResult ;
    /** 医生判别结果;对机器识别结果进行修正 */
    @ApiModelProperty(name = "医生判别结果",notes = "对机器识别结果进行修正")
    private Integer docResult ;
    /** 医生id;纠正识别结果的医生id */
    @ApiModelProperty(name = "医生id",notes = "纠正识别结果的医生id")
    private Integer docId ;
    /** 患者自我辨别颜色;患者自我辨别颜色 */
    @ApiModelProperty(name = "患者自我辨别颜色",notes = "患者自我辨别颜色")
    private String imgColor ;

    /** 图片id */
    public Integer getImgId(){
        return this.imgId;
    }
    /** 图片id */
    public void setImgId(Integer imgId){
        this.imgId=imgId;
    }
    /** 病人id */
    public Integer getPId(){
        return this.pId;
    }
    /** 病人id */
    public void setPId(Integer pId){
        this.pId=pId;
    }
    /** 上传时间 */
    public Date getImgDate(){
        return this.imgDate;
    }
    /** 上传时间 */
    public void setImgDate(Date imgDate){
        this.imgDate=imgDate;
    }
    /** 图片保存路径 */
    public String getImgDir(){
        return this.imgDir;
    }
    /** 图片保存路径 */
    public void setImgDir(String imgDir){
        this.imgDir=imgDir;
    }
    /** 算法识别结果 */
    public String getDetectResult(){
        return this.detectResult;
    }
    /** 算法识别结果 */
    public void setDetectResult(String detectResult){
        this.detectResult=detectResult;
    }
    /** 医生判别结果;对机器识别结果进行修正 */
    public Integer getDocResult(){
        return this.docResult;
    }
    /** 医生判别结果;对机器识别结果进行修正 */
    public void setDocResult(Integer docResult){
        this.docResult=docResult;
    }
    /** 医生id;纠正识别结果的医生id */
    public Integer getDocId(){
        return this.docId;
    }
    /** 医生id;纠正识别结果的医生id */
    public void setDocId(Integer docId){
        this.docId=docId;
    }
    /** 患者自我辨别颜色;患者自我辨别颜色 */
    public String getImgColor(){
        return this.imgColor;
    }
    /** 患者自我辨别颜色;患者自我辨别颜色 */
    public void setImgColor(String imgColor){
        this.imgColor=imgColor;
    }
}