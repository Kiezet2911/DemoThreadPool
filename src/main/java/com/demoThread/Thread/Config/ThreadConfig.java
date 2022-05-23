//package com.demoThread.Thread.Config;
//
//import java.util.concurrent.*;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//@Configurable
//@EnableAsync
//public class ThreadConfig {
//
//	@Bean(name = "taskExecutor")
//	public Executor taskExecutor() {
//		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//		executor.setCorePoolSize(2);
//		executor.setMaxPoolSize(2);
//		executor.setQueueCapacity(100);
//		executor.setThreadNamePrefix("userThread-");
//		executor.initialize();
//		return executor;
//	}
//}
