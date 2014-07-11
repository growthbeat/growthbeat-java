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
		List<Permission> permissions = growthbeat.findPermissionByAccountId(testAccount.getId());
		assertNotNull(permissions);
		assertTrue(permissions.size() > 0);
	}

	@Test
	public void findByTargetAccountId() {
		List<Permission> permissions = growthbeat.findPermissionByTargetAccountId(testAccount.getId());
		assertNotNull(permissions);
		assertTrue(permissions.size() > 0);
	}

	@Test
	public void findByAccountIdAndTargetAccountId() {
		List<Permission> permissions = growthbeat.findPermissionByAccountIdAndTargetAccountId(testAccount.getId(), testConnection
				.getChildAccount().getId());
		assertNotNull(permissions);
		assertTrue(permissions.size() > 0);
	}

	@Test
	public void create() {
		Permission permission = growthbeat.createPermission(testAccount.getId(), testConnection.getChildAccount().getId(),
				"Resource:Growthbeat", "Action:Growthbeat");
		assertNotNull(permission);
		assertEquals(testAccount.getId(), permission.getAccount().getId());
		assertEquals(testConnection.getChildAccount().getId(), permission.getTargetAccount().getId());
		assertEquals("Resource:Growthbeat", permission.getResource().getId());
		assertEquals("Action:Growthbeat", permission.getAction().getId());
	}

	@Test
	public void delete() {
		growthbeat.createPermission(testAccount.getId(), testConnection.getChildAccount().getId(), "Resource:Growthbeat",
				"Action:Growthbeat:ListPermission");
		growthbeat.deletePermission(testAccount.getId(), testConnection.getChildAccount().getId(), "Resource:Growthbeat",
				"Action:Growthbeat:ListPermission");
	}

	@Test
	public void authorize() {
		boolean authorized = growthbeat.authorize(testAccount.getId(), "Resource:Growthbeat:Account:" + testAccount.getId(),
				"Action:Growthbeat:GetAccount");
		assertEquals(true, authorized);
	}

}
