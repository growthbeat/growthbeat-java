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
			Service service = Service.findById(SERVICE_ID, growthbeat.getContext());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

	@Test
	public void findByAccountId() {
		List<Service> services = Service.findByAccountId(testAccount.getId(), growthbeat.getContext());
		assertNotNull(services);
		assertTrue(services.size() > 0);
	}

	@Test
	public void create() {
		// Service credential is required.
		try {
			Service service = Service.create("New Service", "NewService", "http://example.com/", "example.com", growthbeat.getContext());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

	@Test
	public void deleteById() {
		// Service credential is required.
		try {
			Service.deleteById(SERVICE_ID, growthbeat.getContext());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
