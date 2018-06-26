package com.example.RobotRunnerServiceClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.RobotRunnerServiceClient.service.RobotRunnerService;

@RestController
public class RobotRunnerController {

	@Autowired
	private RobotRunnerService service;
	
	@RequestMapping(value = "/run", method = RequestMethod.POST, consumes = "application/JSON", produces = {"application/JSON"})
	public String run(HttpEntity<String> httpEntity) {
		String json = httpEntity.getBody();
		return service.runRoombaRobot(json);
	}
	
}
