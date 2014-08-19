package com.growthbeat.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.growthbeat.BaseTest;

public class PlanTest extends BaseTest {

	@Test
	public void findByAccountId() {
		Plan plan = growthbeat.findPlanByAccountId(testAccount.getId());
		assertNotNull(plan);
		assertNotNull(plan.getId());
	}

}
