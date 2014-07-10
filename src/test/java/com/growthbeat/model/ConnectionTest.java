package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.growthbeat.BaseTest;
import com.growthbeat.GrowthbeatException;

public class ConnectionTest extends BaseTest {

	@BeforeClass
	public static void beforeClass() {
		Connection.create("GfgtutZ09JDesWQs", "5FjbhqsIHTGdfVeP", CREDENTIAL_ID);
	}

	@Test
	public void findByConnectionIdAndServiceId() {
		Connection connection = Connection.findByAccountIdAndServiceId("GfgtutZ09JDesWQs", "5FjbhqsIHTGdfVeP", CREDENTIAL_ID);
		assertNotNull(connection);
		assertNotNull(connection.getId());
		assertEquals("GfgtutZ09JDesWQs", connection.getAccount().getId());
		assertEquals("5FjbhqsIHTGdfVeP", connection.getService().getId());
		assertNotNull(connection.getChildAccount().getId());
	}

	@Test
	public void findByAccountId() {
		List<Connection> connections = Connection.findByAccountId("GfgtutZ09JDesWQs", CREDENTIAL_ID);
		assertNotNull(connections);
		assertTrue(connections.size() > 0);
	}

	@Test
	public void create() {
		Connection connection = Connection.create("GfgtutZ09JDesWQs", "dwQ1eSfOpxzQEy7C", CREDENTIAL_ID);
		assertNotNull(connection);
		assertNotNull(connection.getId());
		assertEquals("GfgtutZ09JDesWQs", connection.getAccount().getId());
		assertEquals("dwQ1eSfOpxzQEy7C", connection.getService().getId());
		assertNotNull(connection.getChildAccount().getId());
	}

	@Test
	public void deleteByAccountIdAndServiceId() {
		try {
			Connection.deleteByAccountIdAndServiceId("GfgtutZ09JDesWQs", "Dummy", CREDENTIAL_ID);
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
