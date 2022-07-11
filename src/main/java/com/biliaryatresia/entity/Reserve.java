package com.biliaryatresia.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 挂号;
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@ApiModel(value = "挂号",description = "")
@Table(name="reserve")
public class Reserve implements Serializable,Cloneable{
    /** 挂号id */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "挂号id",notes = "")
    private Integer rId ;
    /** 病人id */
    @ApiModelProperty(name = "病人id",notes = "")
    private String pId ;
    /** 医生id */
    @ApiModelProperty(name = "医生id",notes = "")
    private String docId ;
    /** 创建时间 */
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date rDate ;
    /** 预约时间 */
    @ApiModelProperty(name = "预约时间",notes = "")
    private String rMeetingDate ;
    /** 挂号费用 */
    @ApiModelProperty(name = "挂号费用",notes = "")
    private Date rFee ;
    /** 挂号状态;预约失败是0， 预约成功是1，取消预约2，挂号结束3 */
    @ApiModelProperty(name = "挂号状态",notes = "预约失败是0， 预约成功是1，取消预约2，挂号结束3")
    private Integer rState ;

    /** 挂号id */
    public Integer getRId(){
        return this.rId;
    }
    /** 挂号id */
    public void setRId(Integer rId){
        this.rId=rId;
    }
    /** 病人id */
    public String getPId(){
        return this.pId;
    }
    /** 病人id */
    public void setPId(String pId){
        this.pId=pId;
    }
    /** 医生id */
    public String getDocId(){
        return this.docId;
    }
    /** 医生id */
    public void setDocId(String docId){
        this.docId=docId;
    }
    /** 创建时间 */
    public Date getRDate(){
        return this.rDate;
    }
    /** 创建时间 */
    public void setRDate(Date rDate){
        this.rDate=rDate;
    }
    /** 预约时间 */
    public String getRMeetingDate(){
        return this.rMeetingDate;
    }
    /** 预约时间 */
    public void setRMeetingDate(String rMeetingDate){
        this.rMeetingDate=rMeetingDate;
    }
    /** 挂号费用 */
    public Date getRFee(){
        return this.rFee;
    }
    /** 挂号费用 */
    public void setRFee(Date rFee){
        this.rFee=rFee;
    }
    /** 挂号状态;预约失败是0， 预约成功是1，取消预约2，挂号结束3 */
    public Integer getRState(){
        return this.rState;
    }
    /** 挂号状态;预约失败是0， 预约成功是1，取消预约2，挂号结束3 */
    public void setRState(Integer rState){
        this.rState=rState;
    }
}
