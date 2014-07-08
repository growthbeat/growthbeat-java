package com.growthbeat;

import org.junit.BeforeClass;

public class BaseTest {

	protected static final String CREDENTIAL_ID = "wXvp0nuo3SmR5zMDAtuoKMxElgUgN968";

	@BeforeClass
	public static void setUp() {
		Growthbeat.getInstance().setHttpClientBaseUrl("http://api.growthbeat.com/");
	}

}
