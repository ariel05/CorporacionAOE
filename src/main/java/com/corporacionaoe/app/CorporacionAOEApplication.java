package com.corporacionaoe.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.corporacionaoe.app.models.service.IUploadFileService;

@SpringBootApplication
public class CorporacionAOEApplication implements CommandLineRunner{

	@Autowired
	private IUploadFileService uploadFileService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(CorporacionAOEApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.uploadFileService.deleteAll();
		this.uploadFileService.init();
		
		String password = "12345";
		
		for(int i = 0; i<2; i++) {
			String bcryptPassword = passwordEncoder.encode(password);
			
			System.out.println(bcryptPassword);
		}
		
	}

}
