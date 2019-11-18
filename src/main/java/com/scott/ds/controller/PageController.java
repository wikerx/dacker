package com.scott.ds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName :PageController
 * @Description :页面处理类
 * @Author :Mr.薛
 * @Data :2019/11/7  11:35
 * @Version :V1.0
 * @Status : 编写
 **/
@Controller
public class PageController {
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
