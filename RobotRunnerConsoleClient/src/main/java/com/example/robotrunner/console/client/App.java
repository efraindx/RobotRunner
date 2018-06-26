package com.example.robotrunner.console.client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import com.example.robotrunner.RobotRunner;
import com.example.robotrunner.enums.RobotEnum;

/**
 * 
 * @author efraintoribioreyes
 *
 */
public class App {
	public static void main(String[] args) {
		String inputJson = getFileContent(args[0]);
		String outputJson = RobotRunner.runRobot(RobotEnum.ROOMBA, inputJson);
		writeContentToFile(args[1], outputJson);
	}

	private static String getFileContent(String fileName) {
		String content = null;
		File file = new File(fileName);
		FileInputStream fis;
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

	private static void writeContentToFile(String fileName, String content) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
			writer.append(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
