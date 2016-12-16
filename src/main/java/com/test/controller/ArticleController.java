package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.test.canvert.ArticleCanvert;
import com.test.dto.ArticleDto;
import com.test.dto.ResultMsgDto;
import com.test.entity.ArticleAndUserEntity;
import com.test.entity.ArticleEntity;
import com.test.services.ArticleService;
import com.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author xueyuan
 * @dater 2016-12-14 0014.
 */
@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;

    @RequestMapping("getArticle.do")
    public void getArticleInfo(HttpServletResponse response) throws IOException {
        List<ArticleAndUserEntity> entities = articleService.selectByTime();
        List<ArticleDto> list = ArticleCanvert.convertFromEntityNew(entities);

        if (list.size() > 0) {
            try {
                ResultMsgDto resultMsg = new ResultMsgDto();
                resultMsg.setResultCode(1);
                resultMsg.setResultObject(list);
                resultMsg.setResultMsg("获取数据成功");
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().println(JSON.toJSON(resultMsg));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            getInfoFiled(response);
        }
    }


    @RequestMapping("addArticle.do")
    public void addArticleInfo(ArticleDto dto, HttpServletRequest request, HttpServletResponse response) throws IOException {


        String pojoStr = request.getParameter("pojoStr");
        dto = JSON.parseObject(pojoStr, new TypeReference<ArticleDto>() {
        });

        ArticleEntity entity = new ArticleEntity();

        if (dto.getUserDto().getUserName() != null && dto.getUserDto().getUserPassword() != null
                && !dto.getUserDto().getUserName().equals("") && !dto.getUserDto().getUserPassword().equals("")
                && dto.getArticleContent() != null && dto.getArticleContent() != "") {
            entity = ArticleCanvert.convertFromDtoSingle(dto);
        }

        if (entity != null) {
            entity.setUserId(userService.selectIdByNameAndPwd(dto.getUserDto().getUserName(), dto.getUserDto().getUserPassword()));
            entity.setCreaterTime(new Date());
            if (articleService.insert(entity) > 0) {
                try {
                    ResultMsgDto resultMsg = new ResultMsgDto();
                    resultMsg.setResultCode(1);
                    resultMsg.setResultMsg("获取数据成功");
                    response.setContentType("text/html");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().println(JSON.toJSON(resultMsg));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                getInfoFiled(response);
            }
        }

    }

    public void getInfoFiled(HttpServletResponse response) throws IOException {
        ResultMsgDto resultMsg = new ResultMsgDto();
        resultMsg.setResultCode(-1);
        resultMsg.setResultMsg("获取数据失败");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(JSON.toJSON(resultMsg));
    }
}
