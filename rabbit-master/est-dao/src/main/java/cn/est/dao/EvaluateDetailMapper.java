package cn.est.dao;

import cn.est.pojo.EvaluateDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EvaluateDetailMapper {

    public EvaluateDetail getEvaluateDetailById(@Param(value = "id") String id) throws Exception;

    public List<EvaluateDetail> getEvaluateDetailListByMap(Map<String, Object> param) throws Exception;

    public Integer getEvaluateDetailCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertEvaluateDetail(EvaluateDetail evaluateDetail) throws Exception;

    public Integer updateEvaluateDetail(EvaluateDetail evaluateDetail) throws Exception;

    public Integer deleteEvaluateDetailById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteEvaluateDetail(Map<String, List<String>> params);

}
