package com.jk.service;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    String updateHead(MultipartFile file, int i);
}
