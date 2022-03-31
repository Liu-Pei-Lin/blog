package cn.est.dao;

import cn.est.pojo.SysUsers;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUsersMapper {

    public SysUsers getSysUsersById(@Param(value = "id") String id) throws Exception;

    public List<SysUsers> getSysUsersListByMap(Map<String, Object> param) throws Exception;

    public Integer getSysUsersCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertSysUsers(SysUsers sysUsers) throws Exception;

    public Integer updateSysUsers(SysUsers sysUsers) throws Exception;

    public Integer deleteSysUsersById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteSysUsers(Map<String, List<String>> params);

}
