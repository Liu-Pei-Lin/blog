package cn.est.service;

import cn.est.pojo.Model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface ModelService {

    public Model getModelById(String id) throws Exception;

    public List<Model> getModelListByMap(Map<String, Object> param) throws Exception;

    public Integer getModelCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddModel(Model model) throws Exception;

    public Integer qdtxModifyModel(Model model) throws Exception;

    public Integer qdtxDeleteModelById(String id) throws Exception;

    public Integer qdtxBatchDeleteModel(String ids) throws Exception;

}
