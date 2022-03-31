package cn.est.service.impl;

import cn.est.dao.MaintainOrderFlowMapper;
import cn.est.pojo.MaintainOrderFlow;
import cn.est.service.MaintainOrderFlowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MaintainOrderFlowServiceImpl implements MaintainOrderFlowService {

    @Resource
    private MaintainOrderFlowMapper maintainOrderFlowMapper;

    public MaintainOrderFlow getMaintainOrderFlowById(String id) throws Exception {
        return maintainOrderFlowMapper.getMaintainOrderFlowById(id);
    }

    public List<MaintainOrderFlow> getMaintainOrderFlowListByMap(Map<String, Object> param) throws Exception {
        return maintainOrderFlowMapper.getMaintainOrderFlowListByMap(param);
    }

    public Integer getMaintainOrderFlowCountByMap(Map<String, Object> param) throws Exception {
        return maintainOrderFlowMapper.getMaintainOrderFlowCountByMap(param);
    }

    public Integer qdtxAddMaintainOrderFlow(MaintainOrderFlow maintainOrderFlow) throws Exception {
        //maintainOrderFlow.setCreatedTime(new Date());
        return maintainOrderFlowMapper.insertMaintainOrderFlow(maintainOrderFlow);
    }

    public Integer qdtxModifyMaintainOrderFlow(MaintainOrderFlow maintainOrderFlow) throws Exception {
        //maintainOrderFlow.setUpdatedTime(new Date());
        return maintainOrderFlowMapper.updateMaintainOrderFlow(maintainOrderFlow);
    }

    public Integer qdtxDeleteMaintainOrderFlowById(String id) throws Exception {
        return maintainOrderFlowMapper.deleteMaintainOrderFlowById(id);
    }

    public Integer qdtxBatchDeleteMaintainOrderFlow(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return maintainOrderFlowMapper.batchDeleteMaintainOrderFlow(param);
    }


}
