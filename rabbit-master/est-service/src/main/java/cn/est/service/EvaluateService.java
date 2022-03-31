package cn.est.service;

import cn.est.pojo.Evaluate;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface EvaluateService {

    public Evaluate getEvaluateById(String id) throws Exception;

    public List<Evaluate> getEvaluateListByMap(Map<String, Object> param) throws Exception;

    public Integer getEvaluateCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddEvaluate(Evaluate evaluate) throws Exception;

    public Integer qdtxModifyEvaluate(Evaluate evaluate) throws Exception;

    public Integer qdtxDeleteEvaluateById(String id) throws Exception;

    public Integer qdtxBatchDeleteEvaluate(String ids) throws Exception;

}
