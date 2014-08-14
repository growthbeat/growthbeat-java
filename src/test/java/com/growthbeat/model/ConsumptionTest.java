package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import com.growthbeat.BaseTest;

public class ConsumptionTest extends BaseTest {

	@BeforeClass
	public static void beforeClass() {
	}

	@Test
	public void create() {
		Consumption consumption = growthbeat.createConsumption(testAccount.getId(), "Action:Growthbeat:GetAccount", 1);
		assertNotNull(consumption);
		assertEquals(testAccount.getId(), consumption.getAccount().getId());
		assertEquals("Action:Growthbeat:GetAccount", consumption.getAction().getId());
		assertEquals(1, consumption.getCount());
		assertNotNull(consumption.getCreated());
	}

}
