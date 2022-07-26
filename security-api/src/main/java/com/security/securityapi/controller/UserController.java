package com.security.securityapi.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.security.common.domain.UserDTO;
import com.security.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "用户信息")
@RestController
@RequestMapping("/user")
public class UserController{

    @ApiOperation("获取用户信息")
    @ApiImplicitParam(name = "accessToken", required = false,paramType = "header",dataType = "String")
    @GetMapping("/info")
    public CommonResult<UserDTO> userInfo() {
        UserDTO userDTO = (UserDTO) StpUtil.getSession().get("userInfo");
        return CommonResult.success(userDTO);
    }

    @PostMapping("/login")
    public CommonResult<UserDTO> usderInfo() {
        UserDTO userDTO = (UserDTO) StpUtil.getSession().get("userInfo");
        return CommonResult.success(userDTO);
    }



}