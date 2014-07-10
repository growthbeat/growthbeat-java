package com.growthbeat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.growthbeat.BaseTest;
import com.growthbeat.GrowthbeatException;

public class CredentialTest extends BaseTest {

	@Test
	public void findById() {
		Credential credential = Credential.findById(testCredential.getId(), testCredential.getId());
		assertEquals(testCredential.getId(), credential.getId());
		assertEquals(testCredential.getAccount().getId(), credential.getAccount().getId());
	}

	@Test
	public void findByAccountId() {
		List<Credential> credentials = Credential.findByAccountId(testAccount.getId(), testCredential.getId());
		assertTrue(credentials.size() > 0);
	}

	@Test
	public void create() {
		Credential credential = Credential.create(testAccount.getId(), testCredential.getId());
		assertNotNull(credential);
		assertNotNull(credential.getId());
		assertEquals(testAccount.getId(), credential.getAccount().getId());
	}

	@Test
	public void deleteById() {
		try {
			Credential.deleteById(testCredential.getId(), testCredential.getId());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

	@Test
	public void findBySessionId() {
		// Service credential is required.
		try {
			List<Credential> credentials = Credential.findBySessionId(testSession.getId(), testCredential.getId());
			fail();
		} catch (GrowthbeatException e) {
		}
	}

}
