package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import com.growthbeat.BaseTest;
import com.growthbeat.GrowthbeatException;

public class UserTest extends BaseTest {

	private static String password = null;

	@BeforeClass
	public static void beforeClass() {
		password = "password_" + new Random().nextInt();
	}

	@Test
	public void findByAccountId() {
		User user = growthbeat.findUserByAccountId(testAccount.getId());
		assertNull(user);
	}

	@Test
	public void create1() {
		String mail = new Random().nextInt() + "@growthbeat.com";
		User user = growthbeat.createUser(testAccount.getId(), mail, password);
		assertNotNull(user);
		assertEquals(testAccount.getId(), user.getAccount().getId());
		assertEquals(mail, user.getMail());
	}

	@Test
	public void create2() {
		String mail = new Random().nextInt() + "@growthbeat.com";
		User user = growthbeat.createUser(mail, password);
		assertNotNull(user);
		assertNotNull(user.getAccount().getId());
		assertEquals(mail, user.getMail());
	}

	@Test
	public void updateMail() {
		String mail = new Random().nextInt() + "@growthbeat.com";
		User user = growthbeat.updateUserMail(testAccount.getId(), mail);
		assertNotNull(user);
		assertEquals(testAccount.getId(), user.getAccount().getId());
		assertEquals(mail, user.getMail());
	}

	@Test
	public void updatePassword() {
		String newPassword = "password_" + new Random().nextInt();
		User user = growthbeat.updateUserPassword(testAccount.getId(), password, newPassword);
		assertNotNull(user);
		assertEquals(testAccount.getId(), user.getAccount().getId());
	}

	@Test
	public void deleteById() {
		try {
			growthbeat.deleteUserByAccountId(testAccount.getId());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
