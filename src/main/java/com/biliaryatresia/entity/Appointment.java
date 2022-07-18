
package com.biliaryatresia.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * 挂号查询;
 * @author : GyberPunk
 * @date : 2022-7-18
 */
@ApiModel(value = "挂号查询",description = "")
public class Appointment implements Serializable,Cloneable{
    /** id */
    @ApiModelProperty(name = "id",notes = "")
    private Integer aId ;
    /** 医生id */
    @ApiModelProperty(name = "医生id",notes = "")
    private Integer docId ;
    /** 剩余数量 */
    @ApiModelProperty(name = "剩余数量",notes = "")
    private Integer num ;
    /** 更新时间 */
    @ApiModelProperty(name = "更新时间",notes = "")
    private Date date ;
    /** 费用 */
    @ApiModelProperty(name = "医生挂号费用",notes = "")
    private Double fee;
    /** 医生姓名 */
    @ApiModelProperty(name = "医生姓名",notes = "")
    private String doctor_name;

    /** 医生职称 */
    @ApiModelProperty(name = "医生职称",notes = "")
    private String title;

    /** id */
    public Integer getAId(){
        return this.aId;
    }
    /** id */
    public void setAId(Integer aId){
        this.aId=aId;
    }
    /** 医生id */
    public Integer getDocId(){
        return this.docId;
    }
    /** 医生id */
    public void setDocId(Integer docId){
        this.docId=docId;
    }
    /** 剩余数量 */
    public Integer getNum(){
        return this.num;
    }
    /** 剩余数量 */
    public void setNum(Integer num){
        this.num=num;
    }
    /** 更新时间 */
    public Date getDate(){
        return this.date;
    }
    /** 更新时间 */
    public void setDate(Date date){
        this.date=date;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}