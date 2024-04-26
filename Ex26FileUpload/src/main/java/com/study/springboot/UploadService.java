package com.study.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UploadService {
    @Value("${spring.servlet.multipart.location}")
    private String cKImageFolder;

    @Value("/upload/")
    private String ckImagePath;
}
