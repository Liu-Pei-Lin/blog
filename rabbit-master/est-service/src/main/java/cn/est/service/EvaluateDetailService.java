package cn.est.service;

import cn.est.pojo.EvaluateDetail;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface EvaluateDetailService {

    public EvaluateDetail getEvaluateDetailById(String id) throws Exception;

    public List<EvaluateDetail> getEvaluateDetailListByMap(Map<String, Object> param) throws Exception;

    public Integer getEvaluateDetailCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddEvaluateDetail(EvaluateDetail evaluateDetail) throws Exception;

    public Integer qdtxModifyEvaluateDetail(EvaluateDetail evaluateDetail) throws Exception;

    public Integer qdtxDeleteEvaluateDetailById(String id) throws Exception;

    public Integer qdtxBatchDeleteEvaluateDetail(String ids) throws Exception;

}
