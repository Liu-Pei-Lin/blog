package cn.est.service;

import cn.est.pojo.SmsLog;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface SmsLogService {

    public SmsLog getSmsLogById(String id) throws Exception;

    public List<SmsLog> getSmsLogListByMap(Map<String, Object> param) throws Exception;

    public Integer getSmsLogCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddSmsLog(SmsLog smsLog) throws Exception;

    public Integer qdtxModifySmsLog(SmsLog smsLog) throws Exception;

    public Integer qdtxDeleteSmsLogById(String id) throws Exception;

    public Integer qdtxBatchDeleteSmsLog(String ids) throws Exception;

}
