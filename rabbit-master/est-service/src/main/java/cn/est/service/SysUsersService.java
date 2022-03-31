package cn.est.service;

import cn.est.pojo.SysUsers;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface SysUsersService {

    public SysUsers getSysUsersById(String id) throws Exception;

    public List<SysUsers> getSysUsersListByMap(Map<String, Object> param) throws Exception;

    public Integer getSysUsersCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddSysUsers(SysUsers sysUsers) throws Exception;

    public Integer qdtxModifySysUsers(SysUsers sysUsers) throws Exception;

    public Integer qdtxDeleteSysUsersById(String id) throws Exception;

    public Integer qdtxBatchDeleteSysUsers(String ids) throws Exception;

}
