package com.growthbeat.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.growthbeat.BaseTest;
import com.growthbeat.GrowthbeatException;

public class ServiceTest extends BaseTest {

	@Test
	public void findById() {
		// Service credential is required.
		try {
			Service service = growthbeat.findServiceById(SERVICE_ID);
			fail();
		} catch (GrowthbeatException e) {
		}
	}

	@Test
	public void findByAccountId() {
		List<Service> services = growthbeat.findServiceByAccountId(testAccount.getId());
		assertNotNull(services);
		assertTrue(services.size() > 0);
	}

	@Test
	public void create() {
		// Service credential is required.
		try {
			Service service = growthbeat.createService("New Service", "NewService", "http://example.com/", "example.com");
			fail();
		} catch (GrowthbeatException e) {
		}
	}

	@Test
	public void deleteById() {
		// Service credential is required.
		try {
			growthbeat.deleteServiceById(SERVICE_ID);
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
