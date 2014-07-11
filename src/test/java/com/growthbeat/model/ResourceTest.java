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
			Resource resource = Resource.findById("Resource:Growthbeat", growthbeat.getContext());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

	@Test
	public void create() {
		// Service credential is required.
		try {
			Resource resource = Resource.create("Resource:Growthbeat", "XXX", growthbeat.getContext());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

	@Test
	public void deleteById() {
		// Service credential is required.
		try {
			Resource.deleteById("Resource:Growthbeat:XXX", growthbeat.getContext());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
