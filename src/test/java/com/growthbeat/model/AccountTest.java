package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.growthbeat.BaseTest;
import com.growthbeat.GrowthbeatException;

public class AccountTest extends BaseTest {

	@Test
	public void findById() {
		Account account = Account.findById("GfgtutZ09JDesWQs", CREDENTIAL_ID);
		assertEquals("GfgtutZ09JDesWQs", account.getId());
	}

	@Test
	public void create() {
		Account account = Account.create(CREDENTIAL_ID);
		assertNotNull(account);
		assertNotNull(account.getId());
	}

	@Test
	public void deleteById() {
		try {
			Account.deleteById("Dummy", CREDENTIAL_ID);
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
