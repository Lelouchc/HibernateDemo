package com.demo.controller;

import com.demo.service.intf.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yy on 2016/3/14.
 * 日志操作类
 */
@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    /**
     * 获取日志列表接口
     * @param model
     * @return
     */
    @RequestMapping("/getLogs")
    public String getLogs(Model model){
        model.addAttribute("logList", logService.getLogs());
        return "main/log_list";
    }
}
