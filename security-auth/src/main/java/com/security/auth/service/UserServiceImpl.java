package com.security.auth.service;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.security.common.domain.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理业务类
 * Created by macro on 2020/6/19.
 */
@Service
public class UserServiceImpl {

    private List<UserDTO> userList;

    public SaTokenInfo login(String username, String password) {
        SaTokenInfo saTokenInfo = null;
        UserDTO userDTO = loadUserByUsername(username);
        if (userDTO == null) {
            return null;
        }
//        if (!SaSecureUtil.md5(password).equals(userDTO.getPassword())) {
//            return null;
//        }
        // 密码校验成功后登录，一行代码实现登录
        StpUtil.login(userDTO.getId());
        // 将用户信息存储到Session中
        StpUtil.getSession().set("userInfo", userDTO);
        // 获取当前登录用户Token信息
        saTokenInfo = StpUtil.getTokenInfo();
        return saTokenInfo;
    }

    private UserDTO loadUserByUsername(String username) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("bb");
        return new UserDTO(1l, username, "123456", list);
    }


}