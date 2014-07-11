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
		List<Permission> permissions = Permission.findByAccountId(testAccount.getId(), growthbeat.getContext());
		assertNotNull(permissions);
		assertTrue(permissions.size() > 0);
	}

	@Test
	public void findByTargetAccountId() {
		List<Permission> permissions = Permission.findByTargetAccountId(testAccount.getId(), growthbeat.getContext());
		assertNotNull(permissions);
		assertTrue(permissions.size() > 0);
	}

	@Test
	public void findByAccountIdAndTargetAccountId() {
		List<Permission> permissions = Permission.findByAccountIdAndTargetAccountId(testAccount.getId(), testConnection.getChildAccount()
				.getId(), growthbeat.getContext());
		assertNotNull(permissions);
		assertTrue(permissions.size() > 0);
	}

	@Test
	public void create() {
		Permission permission = Permission.create(testAccount.getId(), testConnection.getChildAccount().getId(), "Resource:Growthbeat",
				"Action:Growthbeat", growthbeat.getContext());
		assertNotNull(permission);
		assertEquals(testAccount.getId(), permission.getAccount().getId());
		assertEquals(testConnection.getChildAccount().getId(), permission.getTargetAccount().getId());
		assertEquals("Resource:Growthbeat", permission.getResource().getId());
		assertEquals("Action:Growthbeat", permission.getAction().getId());
	}

	@Test
	public void delete() {
		Permission.create(testAccount.getId(), testConnection.getChildAccount().getId(), "Resource:Growthbeat",
				"Action:Growthbeat:ListPermission", growthbeat.getContext());
		Permission.delete(testAccount.getId(), testConnection.getChildAccount().getId(), "Resource:Growthbeat",
				"Action:Growthbeat:ListPermission", growthbeat.getContext());
	}

	@Test
	public void authorize() {
		boolean authorized = Permission.authorize(testAccount.getId(), "Resource:Growthbeat:Account:" + testAccount.getId(),
				"Action:Growthbeat:GetAccount", growthbeat.getContext());
		assertEquals(true, authorized);
	}

}
