package com.growthbeat.model;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.growthbeat.BaseTest;
import com.growthbeat.GrowthbeatException;

public class ActionTest extends BaseTest {

	@Test
	public void findById() {
		// Service credential is required.
		try {
			Action action = Action.findById("Action:Growthbeat", testCredential.getId());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

	@Test
	public void create() {
		// Service credential is required.
		try {
			Action action = Action.create("Action:Growthbeat", "XXX", testCredential.getId());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

	@Test
	public void deleteById() {
		// Service credential is required.
		try {
			Action.deleteById("Action:Growthbeat:XXX", testCredential.getId());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
