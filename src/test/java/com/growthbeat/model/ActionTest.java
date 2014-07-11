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
			Action action = growthbeat.findActionById("Action:Growthbeat");
			fail();
		} catch (GrowthbeatException e) {
		}
	}

	@Test
	public void create() {
		// Service credential is required.
		try {
			Action action = growthbeat.createAction("Action:Growthbeat", "XXX");
			fail();
		} catch (GrowthbeatException e) {
		}
	}

	@Test
	public void deleteById() {
		// Service credential is required.
		try {
			growthbeat.deleteActionById("Action:Growthbeat:XXX");
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
