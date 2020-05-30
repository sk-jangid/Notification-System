package com.Amazon.services.sendMessage;

import com.Amazon.models.LINEMessage;

//import org.eclipse.egit.github.core.Repository;
//import org.eclipse.egit.github.core.event.DeletePayload;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
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
	
	/*public @POST("/1g8n7J3gYOfprGjGy3Zy")
    Call<responseBody> pushMessage(@Body LINEMessage message);*/
    
    @Headers({
    	"Content-Type:application/json",
    	"Authorization:Bearer MEGhysNQpGvlM3aMs+g9FaQJcOA0oDD2zKxbUU6O933/QTqiB0zBITtUyjjVHSDY42CD76e/0BjibGyZR5iYZynmbcX042lQqy7eP2YApioEFfTExQypkuGECIZ4ayba54Y9PaTrCOIvRbvixAdeoQdB04t89/1O/w1cDnyilFU="
    	})
	@GET("v2/bot/message/quota")
	 Call<MessageQuotaResponse> getMessageQuota();
	


    
   

}
