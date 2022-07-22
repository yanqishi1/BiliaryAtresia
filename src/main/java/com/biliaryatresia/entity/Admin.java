package com.biliaryatresia.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 管理员;
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@ApiModel(value = "管理员",description = "")
@Table(name="Admin")
public class Admin implements Serializable,Cloneable{
    /** id */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "id",notes = "")
    private Integer adminId ;
    /** 用户名 */
    @ApiModelProperty(name = "用户名",notes = "")
    private String adminName ;
    /** 电话号码 */
    @ApiModelProperty(name = "电话号码",notes = "")
    private String adminTel ;
    /** 创建时间 */
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date adminDate ;
    /** 密码 */
    @ApiModelProperty(name = "密码",notes = "")
    private String adminPassword ;
    /** 管理员权限 */
    @ApiModelProperty(name = "管理员权限",notes = "")
    private String adminPower ;

    /** id */
    public Integer getAdminId(){
        return this.adminId;
    }
    /** id */
    public void setAdminId(Integer adminId){
        this.adminId=adminId;
    }
    /** 用户名 */
    public String getAdminName(){
        return this.adminName;
    }
    /** 用户名 */
    public void setAdminName(String adminName){
        this.adminName=adminName;
    }
    /** 电话号码 */
    public String getAdminTel(){
        return this.adminTel;
    }
    /** 电话号码 */
    public void setAdminTel(String adminTel){
        this.adminTel=adminTel;
    }
    /** 创建时间 */
    public Date getAdminDate(){
        return this.adminDate;
    }
    /** 创建时间 */
    public void setAdminDate(Date adminDate){
        this.adminDate=adminDate;
    }
    /** 密码 */
    public String getAdminPassword(){
        return this.adminPassword;
    }
    /** 密码 */
    public void setAdminPassword(String adminPassword){
        this.adminPassword=adminPassword;
    }
    /** 管理员权限 */
    public String getAdminPower(){
        return this.adminPower;
    }
    /** 管理员权限 */
    public void setAdminPower(String adminPower){
        this.adminPower=adminPower;
    }
}