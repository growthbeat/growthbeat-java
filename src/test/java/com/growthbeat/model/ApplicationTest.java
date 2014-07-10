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
		Application application = Application.findById(testApplication.getId(), testCredential.getId());
		assertEquals(testApplication.getId(), application.getId());
		assertEquals("Java SDK", application.getName());
	}

	@Test
	public void findByAccountId() {
		List<Application> applications = Application.findByAccountId(testAccount.getId(), testCredential.getId());
		assertTrue(applications.size() > 0);
	}

	@Test
	public void create() {
		Application application = Application.create("Test App", testCredential.getId());
		assertNotNull(application);
		assertNotNull(application.getId());
		assertEquals("Test App", application.getName());
	}

	@Test
	public void update() {
		Application application = Application.update(testApplication.getId(), "Java SDK", testCredential.getId());
		assertNotNull(application);
		assertNotNull(application.getId());
		assertEquals("Java SDK", application.getName());
	}

	@Test
	public void deleteById() {
		try {
			Application.deleteById(testApplication.getId(), testCredential.getId());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
