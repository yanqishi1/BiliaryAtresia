package com.biliaryatresia.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 缴费管理;
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@ApiModel(value = "缴费管理",description = "")
@Table(name="fee")
public class Fee implements Serializable,Cloneable{
    /** 付款id */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "付款id",notes = "")
    private Integer fId ;
    /** 付款金额 */
    @ApiModelProperty(name = "付款金额",notes = "")
    private Double fNum ;
    /** 付款人 */
    @ApiModelProperty(name = "付款人",notes = "")
    private Double pId ;
    /** 创建时间 */
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date fDate ;
    /** 付款渠道 */
    @ApiModelProperty(name = "付款渠道",notes = "")
    private String fPay ;
    /** 付款账号 */
    @ApiModelProperty(name = "付款账号",notes = "")
    private String fPayAccount ;
    /** 挂号id */
    @ApiModelProperty(name = "挂号id",notes = "")
    private Integer rId ;

    /** 付款id */
    public Integer getFId(){
        return this.fId;
    }
    /** 付款id */
    public void setFId(Integer fId){
        this.fId=fId;
    }
    /** 付款金额 */
    public Double getFNum(){
        return this.fNum;
    }
    /** 付款金额 */
    public void setFNum(Double fNum){
        this.fNum=fNum;
    }
    /** 付款人 */
    public Double getPId(){
        return this.pId;
    }
    /** 付款人 */
    public void setPId(Double pId){
        this.pId=pId;
    }
    /** 创建时间 */
    public Date getFDate(){
        return this.fDate;
    }
    /** 创建时间 */
    public void setFDate(Date fDate){
        this.fDate=fDate;
    }
    /** 付款渠道 */
    public String getFPay(){
        return this.fPay;
    }
    /** 付款渠道 */
    public void setFPay(String fPay){
        this.fPay=fPay;
    }
    /** 付款账号 */
    public String getFPayAccount(){
        return this.fPayAccount;
    }
    /** 付款账号 */
    public void setFPayAccount(String fPayAccount){
        this.fPayAccount=fPayAccount;
    }
    /** 挂号id */
    public Integer getRId(){
        return this.rId;
    }
    /** 挂号id */
    public void setRId(Integer rId){
        this.rId=rId;
    }
}
