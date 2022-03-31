package cn.est.controller;

import cn.est.constants.Constants;
import cn.est.constants.ResultEnum;
import cn.est.redis.RedisKeyUtils;
import cn.est.redis.RedisUtils;
import cn.est.resp.Result;
import cn.est.resp.ResultUtils;
import cn.est.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SmsController {
    @Resource
    private RedisUtils redisUtils;

    @Autowired
    private UsersService usersService;

    //实现手机的验证
    @RequestMapping("verifyCode")
    public Result verifyCode(String phone,Integer codeType) throws Exception {
        //验证手机号码格式是否正确
        if(!checkPhone(phone)){
            return ResultUtils.returnFail("手机号码错误", ResultEnum.FAIL_PARAM.getCode());
        }
        //验证操作类型是否正确  登录、注册
        if(!cheCodeType(codeType)){
            return ResultUtils.returnFail("短信类型错误", ResultEnum.FAIL_PARAM.getCode());
        }
        //验证验证码发送的频率
        if(!checkSmsCode(phone,codeType)){
            return ResultUtils.returnFail("短信发送频率过高",ResultEnum.FAIL_PARAM.getCode());
        }
        //发送短信
        usersService.sendMessage(phone,Constants.Sms.TYPE_REGIST_OR_LOGIN);
        return ResultUtils.returnSuccess();
    }

    //手机验证方法
    public boolean checkPhone(String phone){
        if(phone == null || phone.isEmpty()){
            return false;
        }else if (phone.length() != 11){
            return false;
        }else if (!(phone.startsWith("13") || phone.startsWith("15") ||
                phone.startsWith("17") || phone.startsWith("18"))){
            return false;
        }
        return true;
    }

    //验证验证码的类型
    public boolean cheCodeType(Integer codeType){
        if(codeType == null ){
            return false;
        }else if(codeType != 0){
            return false;
        }
        return true;
    }

    //验证验证码发送的频率
    public boolean checkSmsCode(String phone,Integer codeType){
        //判断验证码失效的时间
        //根据手机号获取验证码
        String key = RedisKeyUtils.formatKeyWithPrefix(Constants.Redis.PREFIX_SMS,codeType+"",phone);
        Object code = redisUtils.get(key);
        if(code != null){//判断是否存在验证码
            return false;
        }

        return true;
    }
}
