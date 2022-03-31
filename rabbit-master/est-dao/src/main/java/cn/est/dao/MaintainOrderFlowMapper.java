package cn.est.dao;

import cn.est.pojo.MaintainOrderFlow;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MaintainOrderFlowMapper {

    public MaintainOrderFlow getMaintainOrderFlowById(@Param(value = "id") String id) throws Exception;

    public List<MaintainOrderFlow> getMaintainOrderFlowListByMap(Map<String, Object> param) throws Exception;

    public Integer getMaintainOrderFlowCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertMaintainOrderFlow(MaintainOrderFlow maintainOrderFlow) throws Exception;

    public Integer updateMaintainOrderFlow(MaintainOrderFlow maintainOrderFlow) throws Exception;

    public Integer deleteMaintainOrderFlowById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteMaintainOrderFlow(Map<String, List<String>> params);

}
