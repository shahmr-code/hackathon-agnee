package com.db.hackathon.onlineBanking.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	public String storeFile(MultipartFile file);
}
