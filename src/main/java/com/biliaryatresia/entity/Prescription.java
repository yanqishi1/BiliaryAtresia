package com.biliaryatresia.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 处方;
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@ApiModel(value = "处方",description = "")
@Table(name="prescription")
public class Prescription implements Serializable,Cloneable{
    /** 处方id */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "处方id",notes = "")
    private Integer preId ;
    /** 医生id */
    @ApiModelProperty(name = "医生id",notes = "")
    private Integer docId ;
    /** 病人id */
    @ApiModelProperty(name = "病人id",notes = "")
    private Integer pId ;
    /** 挂号id */
    @ApiModelProperty(name = "挂号id",notes = "")
    private Integer rId ;
    /** 创建时间 */
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date preDate ;
    /** 处方内容 */
    @ApiModelProperty(name = "处方内容",notes = "")
    private String preContent ;

    /** 处方id */
    public Integer getPreId(){
        return this.preId;
    }
    /** 处方id */
    public void setPreId(Integer preId){
        this.preId=preId;
    }
    /** 医生id */
    public Integer getDocId(){
        return this.docId;
    }
    /** 医生id */
    public void setDocId(Integer docId){
        this.docId=docId;
    }
    /** 病人id */
    public Integer getPId(){
        return this.pId;
    }
    /** 病人id */
    public void setPId(Integer pId){
        this.pId=pId;
    }
    /** 挂号id */
    public Integer getRId(){
        return this.rId;
    }
    /** 挂号id */
    public void setRId(Integer rId){
        this.rId=rId;
    }
    /** 创建时间 */
    public Date getPreDate(){
        return this.preDate;
    }
    /** 创建时间 */
    public void setPreDate(Date preDate){
        this.preDate=preDate;
    }
    /** 处方内容 */
    public String getPreContent(){
        return this.preContent;
    }
    /** 处方内容 */
    public void setPreContent(String preContent){
        this.preContent=preContent;
    }
}
