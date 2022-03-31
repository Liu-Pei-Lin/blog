package cn.est.service;

import cn.est.pojo.MaintainOrderFlow;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface MaintainOrderFlowService {

    public MaintainOrderFlow getMaintainOrderFlowById(String id) throws Exception;

    public List<MaintainOrderFlow> getMaintainOrderFlowListByMap(Map<String, Object> param) throws Exception;

    public Integer getMaintainOrderFlowCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddMaintainOrderFlow(MaintainOrderFlow maintainOrderFlow) throws Exception;

    public Integer qdtxModifyMaintainOrderFlow(MaintainOrderFlow maintainOrderFlow) throws Exception;

    public Integer qdtxDeleteMaintainOrderFlowById(String id) throws Exception;

    public Integer qdtxBatchDeleteMaintainOrderFlow(String ids) throws Exception;

}
