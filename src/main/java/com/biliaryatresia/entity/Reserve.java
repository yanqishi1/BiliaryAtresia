package com.biliaryatresia.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * 挂号;
 * @author : http://www.chiner.pro
 * @date : 2022-7-18
 */
@ApiModel(value = "挂号",description = "")
public class Reserve implements Serializable,Cloneable{

    /*预约失败是0， 预约成功是1，取消预约2，挂号结束3*/
    public static final Integer FAIL = 0;
    public static final Integer SUCCESS = 1;
    public static final Integer CANCEL = 2;
    public static final Integer END = 3;

    /** 挂号id */
    @ApiModelProperty(name = "挂号id",notes = "")
    private Integer rId ;
    /** 病人id */
    @ApiModelProperty(name = "病人id",notes = "")
    private Integer pId ;
    /** 医生id */
    @ApiModelProperty(name = "医生id",notes = "")
    private Integer docId ;
    /** 创建时间 */
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date rDate ;
    /** 预约时间 */
    @ApiModelProperty(name = "预约时间",notes = "")
    private Date rMeetingDate ;
    /** 挂号费用 */
    @ApiModelProperty(name = "挂号费用",notes = "")
    private Double rFee ;
    /** 挂号状态;预约失败是0， 预约成功是1，取消预约2，挂号结束3 */
    @ApiModelProperty(name = "挂号状态",notes = "预约失败是0， 预约成功是1，取消预约2，挂号结束3")
    private Integer rState ;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public Date getrMeetingDate() {
        return rMeetingDate;
    }

    public void setrMeetingDate(Date rMeetingDate) {
        this.rMeetingDate = rMeetingDate;
    }

    public Double getrFee() {
        return rFee;
    }

    public void setrFee(Double rFee) {
        this.rFee = rFee;
    }

    public Integer getrState() {
        return rState;
    }

    public void setrState(Integer rState) {
        this.rState = rState;
    }
}