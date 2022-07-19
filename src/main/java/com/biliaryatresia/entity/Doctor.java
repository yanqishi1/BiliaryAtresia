package com.biliaryatresia.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * 医生;
 * @author : http://www.chiner.pro
 * @date : 2022-7-19
 */
@ApiModel(value = "医生",description = "")
public class Doctor implements Serializable,Cloneable{
    /** 医生id */
    @ApiModelProperty(name = "医生id",notes = "")
    private Integer docId ;
    /** 医生姓名 */
    @ApiModelProperty(name = "医生姓名",notes = "")
    private String docName ;
    /** 密码 */
    @ApiModelProperty(name = "密码",notes = "")
    private String docPassword ;
    /** 医生电话 */
    @ApiModelProperty(name = "医生电话",notes = "")
    private String docTel ;
    /** 创建时间 */
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date docDate ;
    /** 微信 */
    @ApiModelProperty(name = "微信",notes = "")
    private String docWechat ;
    /** 预约人数限制 */
    @ApiModelProperty(name = "预约人数限制",notes = "")
    private Integer docReserve ;
    /** 挂号费用 */
    @ApiModelProperty(name = "挂号费用",notes = "")
    private Double docFee ;
    /** 医生所属科室 */
    @ApiModelProperty(name = "医生所属科室",notes = "")
    private Integer docDept ;
    /** 医生的职称 */
    @ApiModelProperty(name = "医生的职称",notes = "")
    private String docTitle ;

    /** 医生id */
    public Integer getDocId(){
        return this.docId;
    }
    /** 医生id */
    public void setDocId(Integer docId){
        this.docId=docId;
    }
    /** 医生姓名 */
    public String getDocName(){
        return this.docName;
    }
    /** 医生姓名 */
    public void setDocName(String docName){
        this.docName=docName;
    }
    /** 密码 */
    public String getDocPassword(){
        return this.docPassword;
    }
    /** 密码 */
    public void setDocPassword(String docPassword){
        this.docPassword=docPassword;
    }
    /** 医生电话 */
    public String getDocTel(){
        return this.docTel;
    }
    /** 医生电话 */
    public void setDocTel(String docTel){
        this.docTel=docTel;
    }
    /** 创建时间 */
    public Date getDocDate(){
        return this.docDate;
    }
    /** 创建时间 */
    public void setDocDate(Date docDate){
        this.docDate=docDate;
    }
    /** 微信 */
    public String getDocWechat(){
        return this.docWechat;
    }
    /** 微信 */
    public void setDocWechat(String docWechat){
        this.docWechat=docWechat;
    }
    /** 预约人数限制 */
    public Integer getDocReserve(){
        return this.docReserve;
    }
    /** 预约人数限制 */
    public void setDocReserve(Integer docReserve){
        this.docReserve=docReserve;
    }
    /** 挂号费用 */
    public Double getDocFee(){
        return this.docFee;
    }
    /** 挂号费用 */
    public void setDocFee(Double docFee){
        this.docFee=docFee;
    }
    /** 医生所属科室 */
    public Integer getDocDept(){
        return this.docDept;
    }
    /** 医生所属科室 */
    public void setDocDept(Integer docDept){
        this.docDept=docDept;
    }
    /** 医生的职称 */
    public String getDocTitle(){
        return this.docTitle;
    }
    /** 医生的职称 */
    public void setDocTitle(String docTitle){
        this.docTitle=docTitle;
    }
}