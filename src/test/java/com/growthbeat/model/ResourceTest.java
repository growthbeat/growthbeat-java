package com.growthbeat.model;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.growthbeat.BaseTest;
import com.growthbeat.GrowthbeatException;

public class ResourceTest extends BaseTest {

	@Test
	public void findById() {
		// Service credential is required.
		try {
			Resource resource = growthbeat.findResourceById("Resource:Growthbeat");
			fail();
		} catch (GrowthbeatException e) {
		}
	}

	@Test
	public void create() {
		// Service credential is required.
		try {
			Resource resource = growthbeat.createResource("Resource:Growthbeat", "XXX");
			fail();
		} catch (GrowthbeatException e) {
		}
	}

	@Test
	public void deleteById() {
		// Service credential is required.
		try {
			growthbeat.deleteResourceById("Resource:Growthbeat:XXX");
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
