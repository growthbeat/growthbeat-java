package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.growthbeat.BaseTest;
import com.growthbeat.GrowthbeatException;

public class ApplicationTest extends BaseTest {

	@Test
	public void findById() {
		Application application = Application.findById("J9yz06sdPs0buwHP", CREDENTIAL_ID);
		assertEquals("J9yz06sdPs0buwHP", application.getId());
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
		Application application = Application.update("J9yz06sdPs0buwHP", "Java SDK", CREDENTIAL_ID);
		assertNotNull(application);
		assertNotNull(application.getId());
		assertEquals("Java SDK", application.getName());
	}

	@Test
	public void deleteById() {
		try {
			Application.deleteByid("Dummy", CREDENTIAL_ID);
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
