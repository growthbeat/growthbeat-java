package com.growthbeat;

import org.junit.Before;
import org.junit.BeforeClass;

import com.growthbeat.model.Account;
import com.growthbeat.model.Application;
import com.growthbeat.model.Client;
import com.growthbeat.model.Connection;
import com.growthbeat.model.Credential;
import com.growthbeat.model.Session;

public class BaseTest {

	protected static final String BASE_URL = "http://api.growthbeat.com/";
	protected static final String CREDENTIAL_ID = "wXvp0nuo3SmR5zMDAtuoKMxElgUgN968";
	protected static final String SERVICE_ID = "5FjbhqsIHTGdfVeP";

	protected static Account testAccount = null;
	protected static Credential testCredential = null;
	protected static Application testApplication = null;
	protected static Client testClient = null;
	protected static Connection testConnection = null;
	protected static Session testSession = null;

	protected Growthbeat growthbeat = null;

	@BeforeClass
	public static void beforeClass() {
		if (testAccount == null)
			init();
	}

	@Before
	public void before() {
		growthbeat = createGrowthbeat(testCredential.getId());
	}

	private static void init() {

		Growthbeat parentGrowthbeat = createGrowthbeat(CREDENTIAL_ID);

		testAccount = Account.create(parentGrowthbeat.getContext());
		testCredential = Credential.create(testAccount.getId(), parentGrowthbeat.getContext());

		Growthbeat childGrowthbeat = createGrowthbeat(testCredential.getId());

		testApplication = Application.create("Java SDK", childGrowthbeat.getContext());
		testClient = Client.create(testApplication.getId(), childGrowthbeat.getContext());
		testConnection = Connection.create(testAccount.getId(), SERVICE_ID, childGrowthbeat.getContext());
		testSession = Session.create(testAccount.getId(), SERVICE_ID, childGrowthbeat.getContext());

	}

	protected static Growthbeat createGrowthbeat(String credentialId) {
		Growthbeat growthbeat = new Growthbeat(CREDENTIAL_ID);
		growthbeat.getContext().getGrowthbeatHttpClient().setBaseUrl(BASE_URL);
		return growthbeat;
	}

}
