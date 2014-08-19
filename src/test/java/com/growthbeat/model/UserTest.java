package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.growthbeat.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest extends BaseTest {

	private static String password = null;

	@BeforeClass
	public static void b1BeforeClass() {
		password = "password_" + random();
	}

	@Test
	public void b3FindByAccountId() {
		User user = growthbeat.findUserByAccountId(testAccount.getId());
		assertNull(user);
	}

	@Test
	public void b4Create() {
		String name = random();
		String mail = name + "@growthbeat.com";
		User user = growthbeat.createUser(mail, password, name, "Test company", "01-2345-6789");
		assertNotNull(user);
		assertNotNull(user.getAccount().getId());
		assertEquals(mail, user.getMail());
		assertEquals(name, user.getName());
		assertEquals("Test company", user.getCompany());
		assertEquals("01-2345-6789", user.getPhone());
	}

	private static String random() {
		return String.valueOf(Math.abs(new Random().nextInt()));
	}

}
