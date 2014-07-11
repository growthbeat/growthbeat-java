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
	}

	@Test
	public void findByConnectionIdAndServiceId() {
		Connection connection = growthbeat.findConnectionByAccountIdAndServiceId(testAccount.getId(), testConnection.getService().getId());
		assertNotNull(connection.getId());
		assertEquals(testAccount.getId(), connection.getAccount().getId());
		assertEquals(testConnection.getService().getId(), connection.getService().getId());
		assertNotNull(connection.getChildAccount().getId());
	}

	@Test
	public void findByAccountId() {
		List<Connection> connections = growthbeat.findConnectionByAccountId(testAccount.getId());
		assertNotNull(connections);
		assertTrue(connections.size() > 0);
	}

	@Test
	public void create() {
		Connection connection = growthbeat.createConnection(testAccount.getId(), "dwQ1eSfOpxzQEy7C");
		assertNotNull(connection);
		assertNotNull(connection.getId());
		assertEquals(testAccount.getId(), connection.getAccount().getId());
		assertEquals("dwQ1eSfOpxzQEy7C", connection.getService().getId());
		assertNotNull(connection.getChildAccount().getId());
	}

	@Test
	public void deleteByAccountIdAndServiceId() {
		try {
			growthbeat.deleteConnectionByAccountIdAndServiceId(testAccount.getId(), "Dummy");
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
