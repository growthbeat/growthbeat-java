package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.growthbeat.BaseTest;
import com.growthbeat.GrowthbeatException;

public class SessionTest extends BaseTest {

	@Test
	public void findById() {
		Session session = Session.findById(testSession.getId(), testCredential.getId());
		assertEquals(testSession.getId(), session.getId());
	}

	@Test
	public void create() {
		Session session = Session.create(testAccount.getId(), SERVICE_ID, testCredential.getId());
		assertNotNull(session);
		assertNotNull(session.getId());
		assertEquals(testAccount.getId(), session.getAccount().getId());
		assertEquals(SERVICE_ID, session.getService().getId());
	}

	@Test
	public void deleteById() {
		try {
			Session.deleteById("Dummy", testCredential.getId());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
