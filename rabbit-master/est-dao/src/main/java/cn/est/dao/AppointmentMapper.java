package cn.est.dao;

import cn.est.pojo.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppointmentMapper {

    public Appointment getAppointmentById(@Param(value = "id") String id) throws Exception;

    public List<Appointment> getAppointmentListByMap(Map<String, Object> param) throws Exception;

    public Integer getAppointmentCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertAppointment(Appointment appointment) throws Exception;

    public Integer updateAppointment(Appointment appointment) throws Exception;

    public Integer deleteAppointmentById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteAppointment(Map<String, List<String>> params);

}
