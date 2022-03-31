package cn.est.service;

import cn.est.dto.UsersDto;
import cn.est.exception.BaseException;
import cn.est.pojo.Users;

public interface TokenService {
    public String setToken(Users user) throws BaseException;
    public String setToken(UsersDto usersDto) throws BaseException;
}
