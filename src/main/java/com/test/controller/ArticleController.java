package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.canvert.ArticleCanvert;
import com.test.dto.ArticleDto;
import com.test.dto.ResultMsgDto;
import com.test.entity.ArticleEntity;
import com.test.services.ArticleService;
import com.test.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author xueyuan
 * @dater 2016-12-14 0014.
 */
@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("getArticle.do")
    public void getArticleInfo(HttpServletResponse response) {
        List<ArticleEntity> entities = articleService.selectByTime();
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
            try {
                ResultMsgDto resultMsg = new ResultMsgDto();
                resultMsg.setResultCode(-1);
                //resultMsg.setResultObject(list);
                resultMsg.setResultMsg("获取数据失败");
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().println(JSON.toJSON(resultMsg));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
