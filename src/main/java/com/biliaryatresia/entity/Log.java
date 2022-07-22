package com.biliaryatresia.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 日志管理;
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@ApiModel(value = "日志管理",description = "")
@Table(name="Log")
public class Log implements Serializable,Cloneable{
    /** 日志id */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "日志id",notes = "")
    private Integer logId ;
    /** 访问url */
    @ApiModelProperty(name = "访问url",notes = "")
    private String logUrl ;
    /** 访问的IP地址 */
    @ApiModelProperty(name = "访问的IP地址",notes = "")
    private String logIp ;
    /** 访问时间 */
    @ApiModelProperty(name = "访问时间",notes = "")
    private Date logDate ;
    /** 患者id */
    @ApiModelProperty(name = "患者id",notes = "")
    private Integer pId ;
    /** 医生Id */
    @ApiModelProperty(name = "医生Id",notes = "")
    private Integer docId ;
    /** 管理员id */
    @ApiModelProperty(name = "管理员id",notes = "")
    private Integer adminId ;

    /** 日志id */
    public Integer getLogId(){
        return this.logId;
    }
    /** 日志id */
    public void setLogId(Integer logId){
        this.logId=logId;
    }
    /** 访问url */
    public String getLogUrl(){
        return this.logUrl;
    }
    /** 访问url */
    public void setLogUrl(String logUrl){
        this.logUrl=logUrl;
    }
    /** 访问的IP地址 */
    public String getLogIp(){
        return this.logIp;
    }
    /** 访问的IP地址 */
    public void setLogIp(String logIp){
        this.logIp=logIp;
    }
    /** 访问时间 */
    public Date getLogDate(){
        return this.logDate;
    }
    /** 访问时间 */
    public void setLogDate(Date logDate){
        this.logDate=logDate;
    }
    /** 患者id */
    public Integer getPId(){
        return this.pId;
    }
    /** 患者id */
    public void setPId(Integer pId){
        this.pId=pId;
    }
    /** 医生Id */
    public Integer getDocId(){
        return this.docId;
    }
    /** 医生Id */
    public void setDocId(Integer docId){
        this.docId=docId;
    }
    /** 管理员id */
    public Integer getAdminId(){
        return this.adminId;
    }
    /** 管理员id */
    public void setAdminId(Integer adminId){
        this.adminId=adminId;
    }
}
