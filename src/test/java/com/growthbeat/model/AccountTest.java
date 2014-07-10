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
		Account account = Account.findById(testAccount.getId(), testCredential.getId());
		assertEquals(testAccount.getId(), account.getId());
	}

	@Test
	public void create() {
		Account account = Account.create(testCredential.getId());
		assertNotNull(account);
		assertNotNull(account.getId());
	}

	@Test
	public void deleteById() {
		try {
			Account.deleteById("Dummy", testCredential.getId());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
