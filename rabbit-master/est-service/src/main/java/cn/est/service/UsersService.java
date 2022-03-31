package cn.est.service;

import cn.est.pojo.Users;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface UsersService {

    public Users getUsersById(String id) throws Exception;

    public List<Users> getUsersListByMap(Map<String, Object> param) throws Exception;

    public Integer getUsersCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddUsers(Users users) throws Exception;

    public Integer qdtxModifyUsers(Users users) throws Exception;

    public Integer qdtxDeleteUsersById(String id) throws Exception;

    public Integer qdtxBatchDeleteUsers(String ids) throws Exception;

    public void sendMessage(String phone,Integer codeType) throws Exception;
}
