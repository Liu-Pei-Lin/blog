package cn.est.dao;

import cn.est.pojo.MaintainOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MaintainOrderMapper {

    public MaintainOrder getMaintainOrderById(@Param(value = "id") String id) throws Exception;

    public List<MaintainOrder> getMaintainOrderListByMap(Map<String, Object> param) throws Exception;

    public Integer getMaintainOrderCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertMaintainOrder(MaintainOrder maintainOrder) throws Exception;

    public Integer updateMaintainOrder(MaintainOrder maintainOrder) throws Exception;

    public Integer deleteMaintainOrderById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteMaintainOrder(Map<String, List<String>> params);

}
