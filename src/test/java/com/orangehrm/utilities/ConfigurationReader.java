package com.orangehrm.utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class ConfigurationReader {
	static Properties configurationProps;

	static {

		try {
			configurationProps = new Properties();
			FileInputStream input = new FileInputStream(".//src//test//resources//Configuration.properties");
			configurationProps.load(input);
			input.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static String getProperty(String keyName) {
		return configurationProps.getProperty(keyName);
	}
}
