package cn.est.dao;

import cn.est.pojo.Classify;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassifyMapper {

    public Classify getClassifyById(@Param(value = "id") String id) throws Exception;

    public List<Classify> getClassifyListByMap(Map<String, Object> param) throws Exception;

    public Integer getClassifyCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertClassify(Classify classify) throws Exception;

    public Integer updateClassify(Classify classify) throws Exception;

    public Integer deleteClassifyById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteClassify(Map<String, List<String>> params);

//    public List<ClassifyDto> getClassifyTree();

}
