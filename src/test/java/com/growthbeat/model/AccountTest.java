package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.growthbeat.BaseTest;

public class AccountTest extends BaseTest {

	@Test
	public void findById() {
		Account account = growthbeat.findAccountByAccountId(testAccount.getId());
		assertEquals(testAccount.getId(), account.getId());
	}

	@Test
	public void create() {
		Account account = growthbeat.createAccount("test account");
		assertNotNull(account);
		assertNotNull(account.getId());
		assertEquals("test account", account.getName());
	}

}
