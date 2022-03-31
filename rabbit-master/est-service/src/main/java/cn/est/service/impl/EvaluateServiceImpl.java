package cn.est.service.impl;

import cn.est.dao.EvaluateMapper;
import cn.est.pojo.Evaluate;
import cn.est.service.EvaluateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Resource
    private EvaluateMapper evaluateMapper;

    public Evaluate getEvaluateById(String id) throws Exception {
        return evaluateMapper.getEvaluateById(id);
    }

    public List<Evaluate> getEvaluateListByMap(Map<String, Object> param) throws Exception {
        return evaluateMapper.getEvaluateListByMap(param);
    }

    public Integer getEvaluateCountByMap(Map<String, Object> param) throws Exception {
        return evaluateMapper.getEvaluateCountByMap(param);
    }

    public Integer qdtxAddEvaluate(Evaluate evaluate) throws Exception {
        //evaluate.setCreatedTime(new Date());
        return evaluateMapper.insertEvaluate(evaluate);
    }

    public Integer qdtxModifyEvaluate(Evaluate evaluate) throws Exception {
        //evaluate.setUpdatedTime(new Date());
        return evaluateMapper.updateEvaluate(evaluate);
    }

    public Integer qdtxDeleteEvaluateById(String id) throws Exception {
        return evaluateMapper.deleteEvaluateById(id);
    }

    public Integer qdtxBatchDeleteEvaluate(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return evaluateMapper.batchDeleteEvaluate(param);
    }


}
