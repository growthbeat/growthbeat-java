package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.growthbeat.BaseTest;
import com.growthbeat.GrowthbeatException;

public class ClientTest extends BaseTest {

	@Test
	public void findById() {
		Client client = growthbeat.findClientById(testClient.getId());
		assertEquals(testClient.getId(), client.getId());
		assertEquals(testApplication.getId(), client.getApplication().getId());
		assertNotNull(client.getCreated());
	}

	@Test
	public void findByApplicationId() {
		List<Client> clients = growthbeat.findClientByApplicationId(testApplication.getId(), null, Order.ascending, null);
		assertTrue(clients.size() > 0);
	}

	@Test
	public void create() {
		Client client = growthbeat.createClient(testApplication.getId());
		assertNotNull(client.getId());
		assertEquals(testApplication.getId(), client.getApplication().getId());
		assertNotNull(client.getCreated());
	}

	@Test
	public void deleteById() {
		try {
			growthbeat.deleteClientById("Dummy");
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
