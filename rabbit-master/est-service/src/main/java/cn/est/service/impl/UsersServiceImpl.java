package cn.est.service.impl;

import cn.est.common.MathUtils;
import cn.est.constants.Constants;
import cn.est.dao.UsersMapper;
import cn.est.pojo.Users;
import cn.est.redis.RedisKeyUtils;
import cn.est.redis.RedisUtils;
import cn.est.service.UsersService;
import cn.est.sms.Smsutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.CoderMalfunctionError;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private RedisUtils redisUtils;//redis工具对象
    @Autowired
    private Smsutils smsutils;//短信的工具对象
    @Resource
    private UsersMapper usersMapper;

    public Users getUsersById(String id) throws Exception {
        return usersMapper.getUsersById(id);
    }

    public List<Users> getUsersListByMap(Map<String, Object> param) throws Exception {
        return usersMapper.getUsersListByMap(param);
    }

    public Integer getUsersCountByMap(Map<String, Object> param) throws Exception {
        return usersMapper.getUsersCountByMap(param);
    }

    public Integer qdtxAddUsers(Users users) throws Exception {
        //users.setCreatedTime(new Date());
        return usersMapper.insertUsers(users);
    }

    public Integer qdtxModifyUsers(Users users) throws Exception {
        //users.setUpdatedTime(new Date());
        return usersMapper.updateUsers(users);
    }

    public Integer qdtxDeleteUsersById(String id) throws Exception {
        return usersMapper.deleteUsersById(id);
    }

    public Integer qdtxBatchDeleteUsers(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return usersMapper.batchDeleteUsers(param);
    }

    @Override
    public void sendMessage(String phone, Integer codeType) throws Exception {
        //向手机发送验证码
        //随机四位验证码
        String code = MathUtils.random();
        String result = smsutils.sendSms(phone,code);
        if(result.equals("OK")){
            //将验证码存在redis中
            String key = RedisKeyUtils.formatKeyWithPrefix(Constants.Redis.PREFIX_SMS,codeType+"",phone);
            redisUtils.set(key, Constants.Duration.MINUTE_INT);//保存1分钟
        }


    }


}
