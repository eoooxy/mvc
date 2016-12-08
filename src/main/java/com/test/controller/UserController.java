package com.test.controller;

import com.test.canvert.UserCanvert;
import com.test.dto.UserDto;
import com.test.entity.ResultMsg;
import com.test.entity.UserEntity;
import com.test.services.UserService;
import com.test.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author xueyuan
 * @dater 2016-11-23 0023.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login.do")
    public void isLogin(UserDto dto, HttpServletResponse response) {
        UserEntity entity = new UserEntity();
        UserEntity tempEntity;

        if (dto.getUserName() != null && dto.getUserPwd() != null && !dto.getUserName().equals("") && !dto.getUserPwd().equals("")) {
            entity = UserCanvert.canvertFromEntity(dto);
        }

        if (entity != null) {
            tempEntity = userService.isUser(entity);
            if (tempEntity != null) {
                try {
                    response.getWriter().println(JsonUtil.toJson(tempEntity));
                    //return JsonUtil.toJson(tempEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //return "";
    }

    @RequestMapping("register.do")
    public void registerAcc(UserDto dto, HttpServletResponse response) {
        UserEntity entity = null;
        if (dto != null && dto.getUserName() != null && dto.getUserPwd() != null &&
                !dto.getUserName().equals("") && !dto.getUserPwd().equals("")) {
            entity = UserCanvert.canvertFromEntity(dto);
        }
        if (entity != null) {
            if (userService.insert(entity) > 0) {
                try {
                    ResultMsg resultMsg = new ResultMsg();
                    resultMsg.setResultCode(1);
                    resultMsg.setResultMsg("注册成功");
                    response.getWriter().println(JsonUtil.toJson(resultMsg));
                    //return JsonUtil.toJson(tempEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

