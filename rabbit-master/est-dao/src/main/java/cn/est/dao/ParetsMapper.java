package cn.est.dao;

import cn.est.pojo.Parets;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParetsMapper {

    public Parets getParetsById(@Param(value = "id") String id) throws Exception;

    public List<Parets> getParetsListByMap(Map<String, Object> param) throws Exception;

    public Integer getParetsCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertParets(Parets parets) throws Exception;

    public Integer updateParets(Parets parets) throws Exception;

    public Integer deleteParetsById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteParets(Map<String, List<String>> params);

}
