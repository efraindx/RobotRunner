package com.example.RobotRunnerServiceClient.service;

import org.springframework.stereotype.Service;

import com.example.robotrunner.RobotRunner;
import com.example.robotrunner.enums.RobotEnum;

/**
 * Service that call a RobotRunner
 * 
 * @author efraintoribioreyes
 *
 */
@Service
public class RobotRunnerService {

	public String runRoombaRobot(String json) {
		String response = RobotRunner.runRobot(RobotEnum.ROOMBA, json);
		return response;
	}
	
}
