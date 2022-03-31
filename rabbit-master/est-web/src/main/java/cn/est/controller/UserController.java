package cn.est.controller;

import cn.est.constants.Constants;
import cn.est.pojo.Users;
import cn.est.redis.RedisKeyUtils;
import cn.est.redis.RedisUtils;
import cn.est.resp.Result;
import cn.est.resp.ResultUtils;
import cn.est.service.TokenService;
import cn.est.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/login/sms")
    public Result login(String phone,String sms) throws Exception {
        //验证手机号是否已在数据库存在,如果不存在,要注册;已存在,直接登录
        //根据手机号获取用户的信息
        Map<String,Object> map = new HashMap<String,Object>();
        Users u = new Users();
        map.put("account",phone);
            List<Users> users = usersService.getUsersListByMap(map);
            if(users == null || users.size() == 0){//先注册再登陆
                u.setAccount(phone);
                u.setIsAuthentication(0);
                u.setCreatdTime(new Date());
                u.setIsDelete(0);
                usersService.qdtxAddUsers(u);
            }else {
                u = users.get(0);
            }
            //登录,登陆成功存储用户信息
            //验证登录是否成功
            String key = RedisKeyUtils.formatKeyWithPrefix(Constants.Redis.PREFIX_SMS,Constants.Sms.TYPE_REGIST_OR_LOGIN+"",phone);
            String code = redisUtils.get(key).toString();
            if(sms.equals(code)){
                String token = tokenService.setToken(u);
                return ResultUtils.returnSuccess(token);
            }
            return ResultUtils.returnFail();

    }
}
