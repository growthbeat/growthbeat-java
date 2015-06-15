package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.growthbeat.Context;
import com.growthbeat.constants.Constants;

public class GooglePartner extends Model {

	private String googleId;
	private String accessToken;
	private int expiresIn;
	private String refreshToken;
	private Date updated;
	private Date created;

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.ISO_8601_DATETIME_FORMAT)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public static List<GooglePartner> find(Context context) {
		return get(context, String.format("1/google_partners"), new HashMap<String, Object>(), new TypeReference<List<GooglePartner>>() {
		});
	}

	public static List<GooglePartner> findByGoogleId(String googleId, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("googleId", googleId);
		return get(context, String.format("1/google_partners"), params, new TypeReference<List<GooglePartner>>() {
		});
	}

}
