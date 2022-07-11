package com.biliaryatresia.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 患者;
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@ApiModel(value = "患者",description = "")
@Table(name="patient")
public class Patient implements Serializable,Cloneable{
    /** 病人id */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "病人id",notes = "")
    private Integer pId ;
    /** 病人姓名 */
    @ApiModelProperty(name = "病人姓名",notes = "")
    private String pName ;
    /** 密码 */
    @ApiModelProperty(name = "密码",notes = "")
    private String pPassword ;
    /** 家长电话号码 */
    @ApiModelProperty(name = "家长电话号码",notes = "")
    private String pTel ;
    /** 创建时间 */
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date pDate ;
    /** 家长微信 */
    @ApiModelProperty(name = "家长微信",notes = "")
    private String pWechat ;
    /** 生日 */
    @ApiModelProperty(name = "生日",notes = "")
    private String pBirthday ;
    /** 性别 */
    @ApiModelProperty(name = "性别",notes = "")
    private String pGender ;
    /** 体重 */
    @ApiModelProperty(name = "体重",notes = "")
    private Double pWeight ;
    /** 喂养方式;母乳/奶粉/其他 */
    @ApiModelProperty(name = "喂养方式",notes = "母乳/奶粉/其他")
    private String pEat ;

    /** 病人id */
    public Integer getPId(){
        return this.pId;
    }
    /** 病人id */
    public void setPId(Integer pId){
        this.pId=pId;
    }
    /** 病人姓名 */
    public String getPName(){
        return this.pName;
    }
    /** 病人姓名 */
    public void setPName(String pName){
        this.pName=pName;
    }
    /** 密码 */
    public String getPPassword(){
        return this.pPassword;
    }
    /** 密码 */
    public void setPPassword(String pPassword){
        this.pPassword=pPassword;
    }
    /** 家长电话号码 */
    public String getPTel(){
        return this.pTel;
    }
    /** 家长电话号码 */
    public void setPTel(String pTel){
        this.pTel=pTel;
    }
    /** 创建时间 */
    public Date getPDate(){
        return this.pDate;
    }
    /** 创建时间 */
    public void setPDate(Date pDate){
        this.pDate=pDate;
    }
    /** 家长微信 */
    public String getPWechat(){
        return this.pWechat;
    }
    /** 家长微信 */
    public void setPWechat(String pWechat){
        this.pWechat=pWechat;
    }
    /** 生日 */
    public String getPBirthday(){
        return this.pBirthday;
    }
    /** 生日 */
    public void setPBirthday(String pBirthday){
        this.pBirthday=pBirthday;
    }
    /** 性别 */
    public String getPGender(){
        return this.pGender;
    }
    /** 性别 */
    public void setPGender(String pGender){
        this.pGender=pGender;
    }
    /** 体重 */
    public Double getPWeight(){
        return this.pWeight;
    }
    /** 体重 */
    public void setPWeight(Double pWeight){
        this.pWeight=pWeight;
    }
    /** 喂养方式;母乳/奶粉/其他 */
    public String getPEat(){
        return this.pEat;
    }
    /** 喂养方式;母乳/奶粉/其他 */
    public void setPEat(String pEat){
        this.pEat=pEat;
    }
}
