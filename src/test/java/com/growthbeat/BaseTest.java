package com.growthbeat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.growthbeat.model.Account;
import com.growthbeat.model.Application;
import com.growthbeat.model.Client;
import com.growthbeat.model.Credential;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BaseTest {

	protected static final String CREDENTIAL_ID = "wXvp0nuo3SmR5zMDAtuoKMxElgUgN968";
	protected static final String SERVICE_ID = "5FjbhqsIHTGdfVeP";

	protected static Account testAccount = null;
	protected static Credential testCredential = null;
	protected static Application testApplication = null;
	protected static Client testClient = null;

	protected Growthbeat growthbeat = null;

	@BeforeClass
	public static void a1BeforeClass() {
		if (testAccount == null)
			init();
	}

	@Before
	public void a2Before() {
		growthbeat = createGrowthbeat(testCredential.getId());
	}

	private static void init() {

		Growthbeat parentGrowthbeat = createGrowthbeat(CREDENTIAL_ID);

		testAccount = parentGrowthbeat.createAccount("Child account for Java SDK test");
		testCredential = parentGrowthbeat.createCredential(testAccount.getId());

		Growthbeat childGrowthbeat = createGrowthbeat(testCredential.getId());

		testApplication = childGrowthbeat.createApplication("Java SDK");
		testClient = childGrowthbeat.createClient(testApplication.getId());

	}

	protected static Growthbeat createGrowthbeat(String credentialId) {
		return new Growthbeat(credentialId);
	}

}
