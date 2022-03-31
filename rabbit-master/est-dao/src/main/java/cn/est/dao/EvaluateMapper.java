package cn.est.dao;

import cn.est.pojo.Evaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EvaluateMapper {

    public Evaluate getEvaluateById(@Param(value = "id") String id) throws Exception;

    public List<Evaluate> getEvaluateListByMap(Map<String, Object> param) throws Exception;

    public Integer getEvaluateCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertEvaluate(Evaluate evaluate) throws Exception;

    public Integer updateEvaluate(Evaluate evaluate) throws Exception;

    public Integer deleteEvaluateById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteEvaluate(Map<String, List<String>> params);

}
