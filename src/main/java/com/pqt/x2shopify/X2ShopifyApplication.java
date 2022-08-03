package com.pqt.x2shopify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class X2ShopifyApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(X2ShopifyApplication.class, args)));
	}

}
