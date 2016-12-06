package com.test.controller;

import com.test.canvert.UserCanvert;
import com.test.dto.UserDto;
import com.test.entity.UserEntity;
import com.test.services.UserService;
import com.test.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xueyuan
 * @dater 2016-11-23 0023.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login.do")
    public String isLogin(UserDto dto, HttpServletRequest request, HttpServletResponse response) {
        UserEntity entity = new UserEntity();

        //Android端获取的参数
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        if (name != null && pwd != null) {
            entity.setUserName(name);
            entity.setUserPwd(pwd);
        }
        //网页端发送的dto
        if (dto.getUserName() != null && dto.getUserPwd() != null && !dto.getUserName().equals("") && !dto.getUserPwd().equals("")) {
            entity = UserCanvert.canvertFromEntity(dto);
        }

        if (entity != null) {
            if (userService.isUser(entity) > 0) {
                try {
                    response.getWriter().println(JsonUtil.toJson("true"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "success";
            }
        } else {
            return "error";
        }

        return "error";
    }
}
