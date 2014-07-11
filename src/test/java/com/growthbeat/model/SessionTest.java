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
		Session session = growthbeat.findSessionById(testSession.getId());
		assertEquals(testSession.getId(), session.getId());
	}

	@Test
	public void create() {
		Session session = growthbeat.createSession(testAccount.getId(), SERVICE_ID);
		assertNotNull(session);
		assertNotNull(session.getId());
		assertEquals(testAccount.getId(), session.getAccount().getId());
		assertEquals(SERVICE_ID, session.getService().getId());
	}

	@Test
	public void deleteById() {
		try {
			growthbeat.deleteSessionById("Dummy");
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
