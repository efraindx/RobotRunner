package com.example.RobotRunner;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

import com.example.robotrunner.RobotRunner;
import com.example.robotrunner.enums.RobotEnum;
import com.example.robotrunner.robot.schema.RoombaResponse;
import com.google.gson.Gson;

/**
 * Tests for RobotRunner
 * 
 * @author efraintoribioreyes
 *
 */
public class RobotRunnerTests {

	private String getJson(String name) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(name).getFile());
		FileInputStream fis;
		String content = null;
		try {
			fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			content = new String(data, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return content;
	}
	
	private void validateRoombaEquals(RoombaResponse current, RoombaResponse expected) {
		assertTrue(current.getVisited().equals(expected.getVisited()));
		assertTrue(current.getCleaned().equals(expected.getCleaned()));
		assertTrue(current.getFinalPosition().equals(expected.getFinalPosition()));
		assertTrue(current.getBattery() == expected.getBattery());
	}
	
	@Test
	public void test1() {
		String inputJson = getJson("test1/source.json");
		String outputJson = RobotRunner.runRobot(RobotEnum.ROOMBA, inputJson);
		
		Gson gson = new Gson();
		RoombaResponse roombaResponse = gson.fromJson(outputJson, RoombaResponse.class);
		
		String resultJson = getJson("test1/result.json");
		RoombaResponse expectedResponse = gson.fromJson(resultJson, RoombaResponse.class);
		
		validateRoombaEquals(roombaResponse, expectedResponse);
	}
	
	@Test
	public void test2() {
		String inputJson = getJson("test2/source.json");
		String outputJson = RobotRunner.runRobot(RobotEnum.ROOMBA, inputJson);
		
		Gson gson = new Gson();
		RoombaResponse roombaResponse = gson.fromJson(outputJson, RoombaResponse.class);
		
		String resultJson = getJson("test2/result.json");
		RoombaResponse expectedResponse = gson.fromJson(resultJson, RoombaResponse.class);
		
		validateRoombaEquals(roombaResponse, expectedResponse);
	}
}
