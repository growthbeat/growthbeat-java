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
		Session session = Session.findById(testSession.getId(), growthbeat.getContext());
		assertEquals(testSession.getId(), session.getId());
	}

	@Test
	public void create() {
		Session session = Session.create(testAccount.getId(), SERVICE_ID, growthbeat.getContext());
		assertNotNull(session);
		assertNotNull(session.getId());
		assertEquals(testAccount.getId(), session.getAccount().getId());
		assertEquals(SERVICE_ID, session.getService().getId());
	}

	@Test
	public void deleteById() {
		try {
			Session.deleteById("Dummy", growthbeat.getContext());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
