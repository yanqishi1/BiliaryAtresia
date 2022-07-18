package com.biliaryatresia.controller;

import com.biliaryatresia.entity.Appointment;
import com.biliaryatresia.service.AppointmentService;
import com.biliaryatresia.service.DetectService;
import com.biliaryatresia.service.ReserveService;
import com.biliaryatresia.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.biliaryatresia.entity.Patient;
import com.biliaryatresia.service.PatientService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 患者;(patient)表控制层
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Api(tags = "患者对象功能接口")
@RestController
@RequestMapping("/api/patient")
public class PatientController{
    @Autowired
    private PatientService patientService;

    @Autowired
    DetectService detectService = null;

    @Autowired
    ReserveService reserveService = null;

    @Autowired
    AppointmentService appointmentService = null;



    @ResponseBody
    @ApiOperation("检测接口")
    @PostMapping("/detect")
    public Msg detectBA(MultipartFile file, HttpSession session){
//        Patient patient = new Patient();
//        patient.setPId(9);
//        return detectService.detectBA(file, patient);
        Patient patient = (Patient) session.getAttribute("patient");
        if(patient==null){
            return new Msg(501, "No patient or Not login");
        }else{
            return detectService.detectBA(file, patient);
        }
    }
    @ResponseBody
    @ApiOperation("预约挂号")
    @PostMapping("/reserve")
    public Msg reserve(String name,
                       String birthday,
                       String sex,
                       String date,
                       Integer doctorId,
                       HttpSession session){
        Patient patient = (Patient)session.getAttribute("patient");
        if(patient==null){
            return new Msg(500, "Error");
        }else{
            return reserveService.reserve(name, birthday, sex, date, patient, doctorId);
        }
    }
    @ResponseBody
    @ApiOperation("根据时间查询可以挂号的医生")
    @PostMapping("/getdoctors")
    public ResponseEntity<List<Appointment>> getDoctors(String date){
        return ResponseEntity.ok(appointmentService.getDoctors(date));
    }

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{pid}")
    public ResponseEntity<Patient> queryById(Integer pId){
        return ResponseEntity.ok(patientService.queryById(pId));
    }

    /**
     * 分页查询
     *
     * @param patient 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<Patient>> paginQuery(Patient patient, PageRequest pageRequest){
        return ResponseEntity.ok(patientService.paginQuery(patient, pageRequest));
    }

    /**
     * 新增数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Patient> add(Patient patient){
        return ResponseEntity.ok(patientService.insert(patient));
    }

    /**
     * 更新数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<Patient> edit(Patient patient){
        return ResponseEntity.ok(patientService.update(patient));
    }

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer pId){
        return ResponseEntity.ok(patientService.deleteById(pId));
    }
}