package com.growthbeat;

import org.junit.BeforeClass;

import com.growthbeat.model.Account;
import com.growthbeat.model.Application;
import com.growthbeat.model.Client;
import com.growthbeat.model.Connection;
import com.growthbeat.model.Credential;
import com.growthbeat.model.Session;

public class BaseTest {

	protected static final String CREDENTIAL_ID = "wXvp0nuo3SmR5zMDAtuoKMxElgUgN968";
	protected static Account testAccount = null;
	protected static Credential testCredential = null;
	protected static Application testApplication = null;
	protected static Client testClient = null;
	protected static Connection testConnection = null;
	protected static Session testSession = null;

	@BeforeClass
	public static void setUp() {
		Growthbeat.getInstance().setHttpClientBaseUrl("http://api.growthbeat.com/");
		if (testAccount == null)
			init();
	}

	private static void init() {

		testAccount = Account.create(CREDENTIAL_ID);
		testCredential = Credential.create(testAccount.getId(), CREDENTIAL_ID);
		testApplication = Application.create("Java SDK", testCredential.getId());
		testClient = Client.create(testApplication.getId(), testCredential.getId());
		testConnection = Connection.create(testAccount.getId(), "5FjbhqsIHTGdfVeP", testCredential.getId());
		testSession = Session.create(testAccount.getId(), "5FjbhqsIHTGdfVeP", testCredential.getId());

	}

}
