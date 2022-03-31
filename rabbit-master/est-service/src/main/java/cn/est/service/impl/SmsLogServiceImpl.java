package cn.est.service.impl;

import cn.est.dao.SmsLogMapper;
import cn.est.pojo.SmsLog;
import cn.est.service.SmsLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class SmsLogServiceImpl implements SmsLogService {

    @Resource
    private SmsLogMapper smsLogMapper;

    public SmsLog getSmsLogById(String id) throws Exception {
        return smsLogMapper.getSmsLogById(id);
    }

    public List<SmsLog> getSmsLogListByMap(Map<String, Object> param) throws Exception {
        return smsLogMapper.getSmsLogListByMap(param);
    }

    public Integer getSmsLogCountByMap(Map<String, Object> param) throws Exception {
        return smsLogMapper.getSmsLogCountByMap(param);
    }

    public Integer qdtxAddSmsLog(SmsLog smsLog) throws Exception {
        //smsLog.setCreatedTime(new Date());
        return smsLogMapper.insertSmsLog(smsLog);
    }

    public Integer qdtxModifySmsLog(SmsLog smsLog) throws Exception {
        //smsLog.setUpdatedTime(new Date());
        return smsLogMapper.updateSmsLog(smsLog);
    }

    public Integer qdtxDeleteSmsLogById(String id) throws Exception {
        return smsLogMapper.deleteSmsLogById(id);
    }

    public Integer qdtxBatchDeleteSmsLog(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return smsLogMapper.batchDeleteSmsLog(param);
    }


}
