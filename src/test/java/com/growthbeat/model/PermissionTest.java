package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.growthbeat.BaseTest;

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
		assertEquals("Action:Growthbeat", permission.getAction().getId());
	}

	@Test
	public void delete() {
		Permission.create(testAccount.getId(), testConnection.getChildAccount().getId(), "Resource:Growthbeat",
				"Action:Growthbeat:ListPermission", testCredential.getId());
		Permission.delete(testAccount.getId(), testConnection.getChildAccount().getId(), "Resource:Growthbeat",
				"Action:Growthbeat:ListPermission", testCredential.getId());
	}

	@Test
	public void authorize() {
		boolean authorized = Permission.authorize(testAccount.getId(), "Resource:Growthbeat:Account:" + testAccount.getId(),
				"Action:Growthbeat:GetAccount", testCredential.getId());
		assertEquals(true, authorized);
	}

}
