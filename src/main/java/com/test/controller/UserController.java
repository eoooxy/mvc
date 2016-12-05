package com.test.controller;

import com.test.canvert.UserCanvert;
import com.test.dto.UserDto;
import com.test.entity.UserEntity;
import com.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xueyuan
 * @dater 2016-11-23 0023.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login.do")
    public String isLogin(UserDto dto) {
        UserEntity entity = new UserEntity();
        if (dto != null) {
            entity = UserCanvert.canvertFromEntity(dto);
        }
        entity.setId(1);
        if (userService.isUser(entity) > 0) {
            return "success";
        }
        return "error";
    }
}
