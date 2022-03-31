package cn.est.service.impl;

import cn.est.dao.SysUsersMapper;
import cn.est.pojo.SysUsers;
import cn.est.service.SysUsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class SysUsersServiceImpl implements SysUsersService {

    @Resource
    private SysUsersMapper sysUsersMapper;

    public SysUsers getSysUsersById(String id) throws Exception {
        return sysUsersMapper.getSysUsersById(id);
    }

    public List<SysUsers> getSysUsersListByMap(Map<String, Object> param) throws Exception {
        return sysUsersMapper.getSysUsersListByMap(param);
    }

    public Integer getSysUsersCountByMap(Map<String, Object> param) throws Exception {
        return sysUsersMapper.getSysUsersCountByMap(param);
    }

    public Integer qdtxAddSysUsers(SysUsers sysUsers) throws Exception {
        //sysUsers.setCreatedTime(new Date());
        return sysUsersMapper.insertSysUsers(sysUsers);
    }

    public Integer qdtxModifySysUsers(SysUsers sysUsers) throws Exception {
        //sysUsers.setUpdatedTime(new Date());
        return sysUsersMapper.updateSysUsers(sysUsers);
    }

    public Integer qdtxDeleteSysUsersById(String id) throws Exception {
        return sysUsersMapper.deleteSysUsersById(id);
    }

    public Integer qdtxBatchDeleteSysUsers(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return sysUsersMapper.batchDeleteSysUsers(param);
    }


}
