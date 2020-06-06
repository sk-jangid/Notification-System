package com.Amazon.services.clients.LINEClient;

import com.Amazon.models.LINEMessage;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface sendService {
	@Headers({
		"Content-Type:application/json"
		})
		public @POST("v2/bot/message/push/")
	    Call<responseBody> pushMessage(@Body LINEMessage message,@Header("X-Line-Retry-Key") String retryKey);
}
