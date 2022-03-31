package cn.est.service.impl;

import cn.est.dao.AppointmentMapper;
import cn.est.pojo.Appointment;
import cn.est.service.AppointmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Resource
    private AppointmentMapper appointmentMapper;

    public Appointment getAppointmentById(String id) throws Exception {
        return appointmentMapper.getAppointmentById(id);
    }

    public List<Appointment> getAppointmentListByMap(Map<String, Object> param) throws Exception {
        return appointmentMapper.getAppointmentListByMap(param);
    }

    public Integer getAppointmentCountByMap(Map<String, Object> param) throws Exception {
        return appointmentMapper.getAppointmentCountByMap(param);
    }

    public Integer qdtxAddAppointment(Appointment appointment) throws Exception {
        //appointment.setCreatedTime(new Date());
        return appointmentMapper.insertAppointment(appointment);
    }

    public Integer qdtxModifyAppointment(Appointment appointment) throws Exception {
        //appointment.setUpdatedTime(new Date());
        return appointmentMapper.updateAppointment(appointment);
    }

    public Integer qdtxDeleteAppointmentById(String id) throws Exception {
        return appointmentMapper.deleteAppointmentById(id);
    }

    public Integer qdtxBatchDeleteAppointment(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return appointmentMapper.batchDeleteAppointment(param);
    }


}
