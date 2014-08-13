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
		Account account = growthbeat.findAccountById(testAccount.getId());
		assertEquals(testAccount.getId(), account.getId());
	}

	@Test
	public void create() {
		Account account = growthbeat.createAccount("test account");
		assertNotNull(account);
		assertNotNull(account.getId());
		assertEquals("test account", account.getName());
	}

	@Test
	public void deleteById() {
		try {
			growthbeat.deleteAccountById("Dummy");
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
