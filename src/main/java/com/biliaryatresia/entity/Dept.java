package com.biliaryatresia.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 科室;
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@ApiModel(value = "科室",description = "")
@Table(name="dept")
public class Dept implements Serializable,Cloneable{
    /** 科室id */
    @Id
    @GeneratedValue
    @ApiModelProperty(name = "科室id",notes = "")
    private Integer deptId ;
    /** 科室名称 */
    @ApiModelProperty(name = "科室名称",notes = "")
    private String deptName ;
    /** 科室主任 */
    @ApiModelProperty(name = "科室主任",notes = "")
    private Integer deptMaster ;
    /** 科室创建时间 */
    @ApiModelProperty(name = "科室创建时间",notes = "")
    private Date deptDate ;
    /** 科室人数 */
    @ApiModelProperty(name = "科室人数",notes = "")
    private Integer deptNum ;

    /** 科室id */
    public Integer getDeptId(){
        return this.deptId;
    }
    /** 科室id */
    public void setDeptId(Integer deptId){
        this.deptId=deptId;
    }
    /** 科室名称 */
    public String getDeptName(){
        return this.deptName;
    }
    /** 科室名称 */
    public void setDeptName(String deptName){
        this.deptName=deptName;
    }
    /** 科室主任 */
    public Integer getDeptMaster(){
        return this.deptMaster;
    }
    /** 科室主任 */
    public void setDeptMaster(Integer deptMaster){
        this.deptMaster=deptMaster;
    }
    /** 科室创建时间 */
    public Date getDeptDate(){
        return this.deptDate;
    }
    /** 科室创建时间 */
    public void setDeptDate(Date deptDate){
        this.deptDate=deptDate;
    }
    /** 科室人数 */
    public Integer getDeptNum(){
        return this.deptNum;
    }
    /** 科室人数 */
    public void setDeptNum(Integer deptNum){
        this.deptNum=deptNum;
    }
}
