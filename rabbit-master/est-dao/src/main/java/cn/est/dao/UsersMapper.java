package cn.est.dao;

import cn.est.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {

    public Users getUsersById(@Param(value = "id") String id) throws Exception;

    public List<Users> getUsersListByMap(Map<String, Object> param) throws Exception;

    public Integer getUsersCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertUsers(Users users) throws Exception;

    public Integer updateUsers(Users users) throws Exception;

    public Integer deleteUsersById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteUsers(Map<String, List<String>> params);

}
