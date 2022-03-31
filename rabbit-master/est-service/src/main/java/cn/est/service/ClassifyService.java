package cn.est.service;

import cn.est.pojo.Classify;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface ClassifyService {

    public Classify getClassifyById(String id) throws Exception;

    public List<Classify> getClassifyListByMap(Map<String, Object> param) throws Exception;

    public Integer getClassifyCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddClassify(Classify classify) throws Exception;

    public Integer qdtxModifyClassify(Classify classify) throws Exception;

    public Integer qdtxDeleteClassifyById(String id) throws Exception;

    public Integer qdtxBatchDeleteClassify(String ids) throws Exception;

}
