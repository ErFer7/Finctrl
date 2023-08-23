package com.erfer.finctrl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.erfer.model.ModelConfiguration;

@SpringBootApplication
@EntityScan(basePackageClasses = { ModelConfiguration.class })
public class FinctrlApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinctrlApplication.class, args);
	}

}
