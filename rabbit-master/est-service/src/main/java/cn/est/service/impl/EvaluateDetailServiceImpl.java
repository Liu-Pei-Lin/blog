package cn.est.service.impl;

import cn.est.dao.EvaluateDetailMapper;
import cn.est.pojo.EvaluateDetail;
import cn.est.service.EvaluateDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class EvaluateDetailServiceImpl implements EvaluateDetailService {

    @Resource
    private EvaluateDetailMapper evaluateDetailMapper;

    public EvaluateDetail getEvaluateDetailById(String id) throws Exception {
        return evaluateDetailMapper.getEvaluateDetailById(id);
    }

    public List<EvaluateDetail> getEvaluateDetailListByMap(Map<String, Object> param) throws Exception {
        return evaluateDetailMapper.getEvaluateDetailListByMap(param);
    }

    public Integer getEvaluateDetailCountByMap(Map<String, Object> param) throws Exception {
        return evaluateDetailMapper.getEvaluateDetailCountByMap(param);
    }

    public Integer qdtxAddEvaluateDetail(EvaluateDetail evaluateDetail) throws Exception {
        //evaluateDetail.setCreatedTime(new Date());
        return evaluateDetailMapper.insertEvaluateDetail(evaluateDetail);
    }

    public Integer qdtxModifyEvaluateDetail(EvaluateDetail evaluateDetail) throws Exception {
        //evaluateDetail.setUpdatedTime(new Date());
        return evaluateDetailMapper.updateEvaluateDetail(evaluateDetail);
    }

    public Integer qdtxDeleteEvaluateDetailById(String id) throws Exception {
        return evaluateDetailMapper.deleteEvaluateDetailById(id);
    }

    public Integer qdtxBatchDeleteEvaluateDetail(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return evaluateDetailMapper.batchDeleteEvaluateDetail(param);
    }


}
