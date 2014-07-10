package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.growthbeat.BaseTest;
import com.growthbeat.GrowthbeatException;

public class ApplicationTest extends BaseTest {

	private static String applicationId = null;

	@BeforeClass
	public static void beforeClass() {
		Application application = Application.create("Java SDK", CREDENTIAL_ID);
		applicationId = application.getId();
	}

	@Test
	public void findById() {
		Application application = Application.findById(applicationId, CREDENTIAL_ID);
		assertEquals(applicationId, application.getId());
		assertEquals("Java SDK", application.getName());
	}

	@Test
	public void findByAccountId() {
		List<Application> applications = Application.findByAccountId("GfgtutZ09JDesWQs", CREDENTIAL_ID);
		assertTrue(applications.size() > 0);
	}

	@Test
	public void create() {
		Application application = Application.create("Test App", CREDENTIAL_ID);
		assertNotNull(application);
		assertNotNull(application.getId());
		assertEquals("Test App", application.getName());
	}

	@Test
	public void update() {
		Application application = Application.update(applicationId, "Java SDK", CREDENTIAL_ID);
		assertNotNull(application);
		assertNotNull(application.getId());
		assertEquals("Java SDK", application.getName());
	}

	@Test
	public void deleteById() {
		try {
			Application.deleteById(applicationId, CREDENTIAL_ID);
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
