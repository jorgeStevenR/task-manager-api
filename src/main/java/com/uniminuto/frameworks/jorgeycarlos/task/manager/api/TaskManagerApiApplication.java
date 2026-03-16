package com.uniminuto.frameworks.jorgeycarlos.task.manager.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaskManagerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApiApplication.class, args);
	}

}
