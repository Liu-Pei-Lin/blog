package cn.est.service;

import cn.est.pojo.Appointment;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface AppointmentService {

    public Appointment getAppointmentById(String id) throws Exception;

    public List<Appointment> getAppointmentListByMap(Map<String, Object> param) throws Exception;

    public Integer getAppointmentCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddAppointment(Appointment appointment) throws Exception;

    public Integer qdtxModifyAppointment(Appointment appointment) throws Exception;

    public Integer qdtxDeleteAppointmentById(String id) throws Exception;

    public Integer qdtxBatchDeleteAppointment(String ids) throws Exception;

}
