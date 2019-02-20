package com.jk.controller;


import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OssController {
    @RequestMapping("domeOss")
    public String domeOss(){

        return "ossdome";
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/headImgUpload.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> headImgUpload(HttpServletRequest request, MultipartFile file) throws IOException {
        Map<String, Object> value = new HashMap<String, Object>();
        value.put("success", true);
        value.put("errorCode", 0);
        value.put("errorMsg", "");
        String head = userService.updateHead(file, 4);//此处是调用上传服务接口，4是需要更新的userId 测试数据。
        System.out.println(head);
        value.put("data", head);
        return value;
    }





}
