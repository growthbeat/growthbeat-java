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
		Connection connection = Connection.findByAccountIdAndServiceId(testAccount.getId(), testConnection.getService().getId(),
				growthbeat.getContext());
		assertNotNull(connection);
		assertNotNull(connection.getId());
		assertEquals(testAccount.getId(), connection.getAccount().getId());
		assertEquals(testConnection.getService().getId(), connection.getService().getId());
		assertNotNull(connection.getChildAccount().getId());
	}

	@Test
	public void findByAccountId() {
		List<Connection> connections = Connection.findByAccountId(testAccount.getId(), growthbeat.getContext());
		assertNotNull(connections);
		assertTrue(connections.size() > 0);
	}

	@Test
	public void create() {
		Connection connection = Connection.create(testAccount.getId(), "dwQ1eSfOpxzQEy7C", growthbeat.getContext());
		assertNotNull(connection);
		assertNotNull(connection.getId());
		assertEquals(testAccount.getId(), connection.getAccount().getId());
		assertEquals("dwQ1eSfOpxzQEy7C", connection.getService().getId());
		assertNotNull(connection.getChildAccount().getId());
	}

	@Test
	public void deleteByAccountIdAndServiceId() {
		try {
			Connection.deleteByAccountIdAndServiceId(testAccount.getId(), "Dummy", growthbeat.getContext());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
