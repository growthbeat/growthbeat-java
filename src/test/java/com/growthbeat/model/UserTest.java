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
		User user = User.findByAccountId(testAccount.getId(), testCredential.getId());
		assertNull(user);
	}

	@Test
	public void create1() {
		String mail = new Random().nextInt() + "@growthbeat.com";
		User user = User.create(testAccount.getId(), mail, password, testCredential.getId());
		assertNotNull(user);
		assertEquals(testAccount.getId(), user.getAccount().getId());
		assertEquals(mail, user.getMail());
	}

	@Test
	public void create2() {
		String mail = new Random().nextInt() + "@growthbeat.com";
		User user = User.create(mail, password, testCredential.getId());
		assertNotNull(user);
		assertNotNull(user.getAccount().getId());
		assertEquals(mail, user.getMail());
	}

	@Test
	public void updateMail() {
		String mail = new Random().nextInt() + "@growthbeat.com";
		User user = User.updateMail(testAccount.getId(), mail, testCredential.getId());
		assertNotNull(user);
		assertEquals(testAccount.getId(), user.getAccount().getId());
		assertEquals(mail, user.getMail());
	}

	@Test
	public void updatePassword() {
		String newPassword = "password_" + new Random().nextInt();
		User user = User.updatePassword(testAccount.getId(), password, newPassword, testCredential.getId());
		assertNotNull(user);
		assertEquals(testAccount.getId(), user.getAccount().getId());
	}

	@Test
	public void deleteById() {
		try {
			User.deleteByAccountId(testAccount.getId(), testCredential.getId());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
