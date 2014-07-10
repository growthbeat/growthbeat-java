package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.growthbeat.BaseTest;
import com.growthbeat.GrowthbeatException;

public class PermissionTest extends BaseTest {

	@Test
	public void findByAccountId() {
		List<Permission> permissions = Permission.findByAccountId(testAccount.getId(), testCredential.getId());
		assertNotNull(permissions);
		assertTrue(permissions.size() > 0);
	}

	@Test
	public void findByTargetAccountId() {
		List<Permission> permissions = Permission.findByTargetAccountId(testAccount.getId(), testCredential.getId());
		assertNotNull(permissions);
		assertTrue(permissions.size() > 0);
	}

	@Test
	public void findByAccountIdAndTargetAccountId() {
		List<Permission> permissions = Permission.findByAccountIdAndTargetAccountId(testAccount.getId(), testConnection.getChildAccount()
				.getId(), testCredential.getId());
		assertNotNull(permissions);
		assertTrue(permissions.size() > 0);
	}

	@Test
	public void create() {
		Permission permission = Permission.create(testAccount.getId(), testConnection.getChildAccount().getId(), "Resource:Growthbeat",
				"Action:Growthbeat", testCredential.getId());
		assertNotNull(permission);
		assertEquals(testAccount.getId(), permission.getAccount().getId());
		assertEquals(testConnection.getChildAccount().getId(), permission.getTargetAccount().getId());
		assertEquals("Resource:Growthbeat", permission.getResource().getId());
		assertEquals("Action:Growthbeat", permission.getAccount().getId());
	}

	@Test
	public void deleteById() {
		try {
			Permission.delete(testAccount.getId(), testConnection.getChildAccount().getId(), "Resource:Growthbeat", "Action:Growthbeat",
					testCredential.getId());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

	@Test
	public void authorize() {
		boolean authorized = Permission.authorize(testAccount.getId(), "Resource:Growthbeat:Account:" + testAccount.getId(),
				"Action:Growthbeat:GetAccount", testCredential.getId());
		assertEquals(true, authorized);
	}

}
