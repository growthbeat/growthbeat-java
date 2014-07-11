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
		Account account = Account.findById(testAccount.getId(), growthbeat.getContext());
		assertEquals(testAccount.getId(), account.getId());
	}

	@Test
	public void create() {
		Account account = Account.create(growthbeat.getContext());
		assertNotNull(account);
		assertNotNull(account.getId());
	}

	@Test
	public void deleteById() {
		try {
			Account.deleteById("Dummy", growthbeat.getContext());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
