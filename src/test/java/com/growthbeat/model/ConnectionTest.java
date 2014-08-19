package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import com.growthbeat.BaseTest;

public class ConnectionTest extends BaseTest {

	@BeforeClass
	public static void beforeClass() {
	}

	@Test
	public void findByChildAccountId() {
		Connection connection = growthbeat.findConnectionByChildAccountId(testConnection.getChildAccount().getId());
		assertNotNull(connection.getId());
		assertEquals(testAccount.getId(), connection.getAccount().getId());
		assertEquals(testConnection.getService().getId(), connection.getService().getId());
	}
}
