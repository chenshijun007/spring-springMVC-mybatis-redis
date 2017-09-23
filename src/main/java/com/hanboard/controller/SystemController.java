package com.hanboard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by csj on 2017/9/5.
 */
@RestController
public class SystemController {


    @RequestMapping("/")
    public ModelAndView index() {
        String url = "redirect:http://localhost:80/index.html";
        return new ModelAndView(url);
    }

    @RequestMapping("/ip")
    @ResponseBody
    public String findIP(HttpServletRequest request, HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin","*");

        String devIp = request.getHeader("x-forwarded-for");
        if (devIp == null || devIp.length() == 0 || "unknown".equalsIgnoreCase(devIp))
        {
            devIp = request.getHeader("Proxy-Client-IP");
        }
        if (devIp == null || devIp.length() == 0 || "unknown".equalsIgnoreCase(devIp))
        {
            devIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (devIp == null || devIp.length() == 0 || "unknown".equalsIgnoreCase(devIp))
        {
            devIp = request.getRemoteAddr();
        }
        return devIp;
    }

}
