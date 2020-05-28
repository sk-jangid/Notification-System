package com.Amazon.services.sendMessage;

import com.Amazon.models.LINEMessage;

//import org.eclipse.egit.github.core.Repository;
//import org.eclipse.egit.github.core.event.DeletePayload;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/*
 * Information of the Different POST and GET
 * We only need PUSH other are for testing API
 * Authorization is header that contain the channel access token as its value
 */

public interface messagesend {

	@Headers({
	"Content-Type:application/json",
	"Authorization:Bearer hTSkfFzESX5HgSPLiVNjpicqc9ZRIdl5iqbx4TIHiSYOdysGDXxqYz4fvmzZgEonW/fr9CtkE6qSLx6NOP2t/ln9h9v8FDbD43g8u0zxmBmg7zLRg7eYwTQELS7Gwe+eyuQooepxmaj1vFBypM+uBQdB04t89/1O/w1cDnyilFU="
	})
	public @POST("v2/bot/message/push")
    Call<responseBody> pushMessage(@Body LINEMessage message);
	
	/*public @POST("/1g8n7J3gYOfprGjGy3Zy")
    Call<responseBody> pushMessage(@Body LINEMessage message);*/
    
    @Headers({
    	"Content-Type:application/json",
    	"Authorization:Bearer MEGhysNQpGvlM3aMs+g9FaQJcOA0oDD2zKxbUU6O933/QTqiB0zBITtUyjjVHSDY42CD76e/0BjibGyZR5iYZynmbcX042lQqy7eP2YApioEFfTExQypkuGECIZ4ayba54Y9PaTrCOIvRbvixAdeoQdB04t89/1O/w1cDnyilFU="
    	})
	@GET("v2/bot/message/quota")
	 Call<MessageQuotaResponse> getMessageQuota();
	


    
   

}
