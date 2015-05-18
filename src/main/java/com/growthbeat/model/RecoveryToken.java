package com.growthbeat.model;

import java.util.HashMap;
import java.util.Map;

import com.growthbeat.Context;

public class RecoveryToken extends Model {

	public static RecoveryToken createAndSendMail(String mail, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mail", mail);
		return post(context, "1/recovery_tokens", params, RecoveryToken.class);
	}

}
