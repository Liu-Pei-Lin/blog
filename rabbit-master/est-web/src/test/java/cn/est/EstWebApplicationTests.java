package cn.est;

import cn.est.constants.Constants;
import cn.est.dto.UsersDto;
import cn.est.redis.RedisKeyUtils;
import cn.est.redis.RedisUtils;
import cn.est.resp.UUIDUtils;
import cn.est.sms.Smsutils;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EstWebApplicationTests {
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private Smsutils smsUtils;

    @Test
    public void contextLoads() {
        System.out.println(redisUtils);
    }

    @Test
    public void sendSms() {

    }

    @Test
    public void setToken(){
        UsersDto usersDto = new UsersDto();
        usersDto.setId(1L);
        usersDto.setAccount("13927706283");
        String token = UUIDUtils.getUUID32();//生成token编号
        usersDto.setToken(token);
        //将user用户信息存储在redis
        String key = RedisKeyUtils.formatKeyWithPrefix(Constants.Redis.PREFIX_TOKEN,token);
        redisUtils.set(key, JSONObject.toJSONString(usersDto),Constants.Duration.HALF_AN_HOUR);
        System.out.println("token"+token);
    }

}
