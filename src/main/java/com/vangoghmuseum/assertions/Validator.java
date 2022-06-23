package com.vangoghmuseum.assertions;

import org.testng.Assert;

import com.vangoghmuseum.utility.Log;

public class Validator {
	public static void verify(String actual, String expected) {
		Log.info("Actual value: " + actual + "\t Expected value: " + expected);
		Assert.assertEquals(actual, expected);
		Log.info("Verification successfully done.");
	}
	
	public static void intVerify(int actual, int expected) {
		Log.info("Actual value: " + actual + "\t Expected value: " + expected);
		Assert.assertTrue(actual < expected);
		Log.info("Number Verification successfully done.");
	}
}
