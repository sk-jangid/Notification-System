package com.Amazon.services.sendMessage;

import com.Amazon.models.LINEMessage;

//import org.eclipse.egit.github.core.Repository;
//import org.eclipse.egit.github.core.event.DeletePayload;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/*
 * Information of the Different POST and GET
 * We only need PUSH other are for testing API
 * Authorization is header that contain the channel access token as its value
 */

public interface messagesend {

	@Headers({
	"Content-Type:application/json"
	})
	public @POST("v2/bot/message/push/")
    Call<responseBody> pushMessage(@Body LINEMessage message,@Header("X-Line-Retry-Key") String retryKey);
	
	


    
   

}
