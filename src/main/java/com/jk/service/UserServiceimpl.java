package com.jk.service;


import com.jk.utilo.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {



    @Autowired
    private OSSClientUtil ossClient;

    @Override
    public String updateHead(MultipartFile file, int i) {

        if (file == null || file.getSize() <= 0) {
            System.out.println("头像不能为空");
        }
        String name = ossClient.uploadImg2Oss(file);

        String imgUrl = ossClient.getImgUrl(name);

        return imgUrl;
    }











}
