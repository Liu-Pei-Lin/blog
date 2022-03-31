package cn.est.dao;

import cn.est.pojo.SmsLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsLogMapper {

    public SmsLog getSmsLogById(@Param(value = "id") String id) throws Exception;

    public List<SmsLog> getSmsLogListByMap(Map<String, Object> param) throws Exception;

    public Integer getSmsLogCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertSmsLog(SmsLog smsLog) throws Exception;

    public Integer updateSmsLog(SmsLog smsLog) throws Exception;

    public Integer deleteSmsLogById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteSmsLog(Map<String, List<String>> params);

}
