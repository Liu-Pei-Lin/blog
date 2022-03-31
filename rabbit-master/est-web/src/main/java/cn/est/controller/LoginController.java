package cn.est.controller;

import cn.est.resp.Result;
import cn.est.resp.ResultUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiModel("登录")
public class LoginController {

    @ApiOperation(value = "登录", notes = "登录方法")
    @RequestMapping("/login")
    public Result login() {
        return ResultUtils.returnSuccess();
    }
}
