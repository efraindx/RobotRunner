package com.example.robotrunner;

import com.example.robotrunner.enums.RobotEnum;
import com.example.robotrunner.robot.Robot;
import com.example.robotrunner.robot.RoombaRobot;
import com.google.gson.Gson;

/**
 * Starting point of RobotRunner
 * 
 * @author efraintoribioreyes
 *
 */
public class RobotRunner {
	
	/**
	 * Run the specified Robot and returns the json built by this
	 * 
	 * @param robot
	 * @param json
	 * @return
	 */
	public static String runRobot(RobotEnum robot, String json) {
    	Robot robotObject = getRobotObject(robot, json);
    	return robotObject.run();
    }
	
	public static Robot getRobotObject(RobotEnum robot, String json) {
		Gson gson = new Gson();
		
		switch(robot) {
		case ROOMBA:
			return gson.fromJson(json, RoombaRobot.class);
		//here we can add more robots
		default:
			throw new IllegalArgumentException("The specified robot is not supported");
		}
	}
}
