package cn.est.service;

import cn.est.pojo.MaintainOrder;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface MaintainOrderService {

    public MaintainOrder getMaintainOrderById(String id) throws Exception;

    public List<MaintainOrder> getMaintainOrderListByMap(Map<String, Object> param) throws Exception;

    public Integer getMaintainOrderCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddMaintainOrder(MaintainOrder maintainOrder) throws Exception;

    public Integer qdtxModifyMaintainOrder(MaintainOrder maintainOrder) throws Exception;

    public Integer qdtxDeleteMaintainOrderById(String id) throws Exception;

    public Integer qdtxBatchDeleteMaintainOrder(String ids) throws Exception;

}
