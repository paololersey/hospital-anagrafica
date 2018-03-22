package com.application.util;

import org.json.JSONObject;

public class JsonUtil {

	public static JSONObject writeJsonError(String errorCode, String errorDescription) {
		JSONObject jsonObject = new JSONObject() {
			{
				this.put("errorCode", 1);
				this.put("description",errorDescription);
			}
		};
		return jsonObject;
	}

}