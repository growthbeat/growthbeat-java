package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.growthbeat.BaseTest;
import com.growthbeat.GrowthbeatException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest extends BaseTest {

	private static String password = null;

	@BeforeClass
	public static void b1BeforeClass() {
		password = "password_" + random();
	}

	@Test
	public void b2FindByAccountId() {
		User user = growthbeat.findUserByAccountId(testAccount.getId());
		assertNull(user);
	}

	@Test
	public void b3Create1() {
		String mail = random() + "@growthbeat.com";
		User user = growthbeat.createUser(testAccount.getId(), mail, password);
		assertNotNull(user);
		assertEquals(testAccount.getId(), user.getAccount().getId());
		assertEquals(mail, user.getMail());
	}

	@Test
	public void b4Create2() {
		String mail = random() + "@growthbeat.com";
		User user = growthbeat.createUser(mail, password);
		assertNotNull(user);
		assertNotNull(user.getAccount().getId());
		assertEquals(mail, user.getMail());
	}

	@Test
	public void b5UpdateMail() {
		String mail = random() + "@growthbeat.com";
		User user = growthbeat.updateUserMail(testAccount.getId(), mail);
		assertNotNull(user);
		assertEquals(testAccount.getId(), user.getAccount().getId());
		assertEquals(mail, user.getMail());
	}

	@Test
	public void b6UpdatePassword() {
		String newPassword = "password_" + random();
		User user = growthbeat.updateUserPassword(testAccount.getId(), password, newPassword);
		assertNotNull(user);
		assertEquals(testAccount.getId(), user.getAccount().getId());
	}

	@Test
	public void b7DeleteById() {
		try {
			growthbeat.deleteUserByAccountId(testAccount.getId());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

	private static String random() {
		return String.valueOf(Math.abs(new Random().nextInt()));
	}

}
