package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.canvert.UserCanvert;
import com.test.dto.ArticleDto;
import com.test.dto.ResultMsgDto;
import com.test.dto.UserDto;
import com.test.entity.ResultMsg;
import com.test.entity.UserEntity;
import com.test.services.UserService;
import com.test.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        if (dto.getUserName() != null && dto.getUserPassword() != null && !dto.getUserName().equals("") && !dto.getUserPassword().equals("")) {
            entity = UserCanvert.canvertFromDto(dto);
        }

        if (entity != null) {
            tempEntity = userService.isUser(entity);
            if (tempEntity != null) {
                try {
                    ResultMsgDto resultMsg = new ResultMsgDto();
                    resultMsg.setResultCode(1);
                    resultMsg.setResultMsg("登录成功");
                    resultMsg.setResultObject(tempEntity);
                    response.setContentType("text/html");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().println(JSON.toJSON(resultMsg));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    ResultMsgDto resultMsg = new ResultMsgDto();
                    resultMsg.setResultCode(-1);
                    resultMsg.setResultMsg("登录失败");
                    response.setContentType("text/html");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().println(JSON.toJSON(resultMsg));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        //return "";
    }

    @RequestMapping("register.do")
    public void registerAcc(UserDto dto, HttpServletResponse response) {
        UserEntity entity = null;
        if (dto != null && dto.getUserName() != null && dto.getUserPassword() != null &&
                !dto.getUserName().equals("") && !dto.getUserPassword().equals("")) {
            entity = UserCanvert.canvertFromDto(dto);
        }
        if (entity != null) {
            if (userService.insert(entity) > 0) {
                try {
                    ResultMsgDto resultMsg = new ResultMsgDto();
                    resultMsg.setResultCode(1);
                    resultMsg.setResultMsg("注册成功");
                    response.getWriter().println(JsonUtil.toJson(resultMsg));
                    //return JsonUtil.toJson(tempEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {

            }
        }
    }

    @RequestMapping("update.do")
    public void updateAcc(UserDto dto, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String pojoStr = request.getParameter("pojoStr");
        dto = JSON.parseObject(pojoStr, new TypeReference<UserDto>() {
        });
        UserEntity entity = null;
        if (dto != null && dto.getUserName() != null && !dto.getUserName().equals("")) {
            entity = UserCanvert.canvertFromDto(dto);
        }
        if (entity != null && entity.getUserName() != "" && entity.getUserName() != null) {
            if (userService.update(entity) > 0) {
                ResultMsgDto resultMsg = new ResultMsgDto();
                resultMsg.setResultCode(1);
                resultMsg.setResultMsg("修改成功");
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().println(JsonUtil.toJson(resultMsg));
            } else {
                ResultMsgDto resultMsg = new ResultMsgDto();
                resultMsg.setResultCode(-1);
                resultMsg.setResultMsg("修改失败");
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().println(JsonUtil.toJson(resultMsg));
            }
        }

    }
}

