package cn.est.dao;

import cn.est.pojo.Malfunction;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MalfunctionMapper {

    public Malfunction getMalfunctionById(@Param(value = "id") String id) throws Exception;

    public List<Malfunction> getMalfunctionListByMap(Map<String, Object> param) throws Exception;

    public Integer getMalfunctionCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertMalfunction(Malfunction malfunction) throws Exception;

    public Integer updateMalfunction(Malfunction malfunction) throws Exception;

    public Integer deleteMalfunctionById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteMalfunction(Map<String, List<String>> params);

}
