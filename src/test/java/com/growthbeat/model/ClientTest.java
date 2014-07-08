package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.growthbeat.BaseTest;
import com.growthbeat.GrowthbeatException;

public class ClientTest extends BaseTest {

	@Test
	public void findById() {
		Client client = Client.findById("qz4Jf0fNB7lQvhZf", CREDENTIAL_ID);
		assertEquals("qz4Jf0fNB7lQvhZf", client.getId());
		assertEquals("J9yz06sdPs0buwHP", client.getApplication().getId());
		assertEquals(1404831236000L, client.getCreated().getTime());
	}

	@Test
	public void findByApplicationId() {
		// List<Client> clients = Client.findByApplicationId("J9yz06sdPs0buwHP",
		// null, Order.ascending, null, CREDENTIAL_ID);
	}

	@Test
	public void create() {
		Client client = Client.create("J9yz06sdPs0buwHP", CREDENTIAL_ID);
		assertNotNull(client.getId());
		assertEquals("J9yz06sdPs0buwHP", client.getApplication().getId());
		assertNotNull(client.getCreated());
	}

	@Test
	public void deleteById() {
		try {
			Client.deleteByid("Dummy", CREDENTIAL_ID);
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
