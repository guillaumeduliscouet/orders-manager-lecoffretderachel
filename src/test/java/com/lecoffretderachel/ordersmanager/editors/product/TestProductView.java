package com.lecoffretderachel.ordersmanager.editors.product;

import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lecoffretderachel.ordersmanager.injectionconfig.AppConfig;

public class TestProductView implements Lifecycle {
	private static AnnotationConfigApplicationContext context;
	
	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.registerShutdownHook();
		context.getBean(ProductController.class).show();
	}

	public boolean isRunning() {
		return false;
	}

	public void start() {
	}

	public void stop() {
		context.close();
	}
}
