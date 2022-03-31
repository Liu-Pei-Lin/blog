package cn.est.dao;

import cn.est.pojo.MalfunctionOptions;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MalfunctionOptionsMapper {

    public MalfunctionOptions getMalfunctionOptionsById(@Param(value = "id") String id) throws Exception;

    public List<MalfunctionOptions> getMalfunctionOptionsListByMap(Map<String, Object> param) throws Exception;

    public Integer getMalfunctionOptionsCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertMalfunctionOptions(MalfunctionOptions malfunctionOptions) throws Exception;

    public Integer updateMalfunctionOptions(MalfunctionOptions malfunctionOptions) throws Exception;

    public Integer deleteMalfunctionOptionsById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteMalfunctionOptions(Map<String, List<String>> params);

}
