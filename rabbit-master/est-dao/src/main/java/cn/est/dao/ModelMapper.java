package cn.est.dao;

import cn.est.pojo.Model;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ModelMapper {

    public Model getModelById(@Param(value = "id") String id) throws Exception;

    public List<Model> getModelListByMap(Map<String, Object> param) throws Exception;

    public Integer getModelCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertModel(Model model) throws Exception;

    public Integer updateModel(Model model) throws Exception;

    public Integer deleteModelById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteModel(Map<String, List<String>> params);

}
