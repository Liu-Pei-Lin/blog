package cn.est.service.impl;

import cn.est.constants.Constants;
import cn.est.dto.UsersDto;
import cn.est.exception.BaseException;
import cn.est.pojo.Users;
import cn.est.redis.RedisKeyUtils;
import cn.est.redis.RedisUtils;
import cn.est.resp.UUIDUtils;
import cn.est.service.TokenService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public String setToken(Users user) throws BaseException {
        String token = UUIDUtils.getUUID32();//生成token编号
        //将user用户信息存储在redis
        String key = RedisKeyUtils.formatKeyWithPrefix(Constants.Redis.PREFIX_TOKEN,token);
        redisUtils.set(key, JSONObject.toJSONString(user),Constants.Duration.HALF_AN_HOUR);
        System.out.println("token"+token);
        return token;
    }

    //存储用户信息在redis
    @Override
    public String setToken(UsersDto usersDto) throws BaseException {
        String token = UUIDUtils.getUUID32();//生成token编号
        usersDto.setToken(token);
        //将user用户信息存储在redis
        String key = RedisKeyUtils.formatKeyWithPrefix(Constants.Redis.PREFIX_TOKEN,token);
        redisUtils.set(key, JSONObject.toJSONString(usersDto),Constants.Duration.HALF_AN_HOUR);
        System.out.println("token"+token);
        return token;
    }
}
