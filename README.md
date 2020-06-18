# Notification-System

Notification System for different communication Channels. Gets JSON input from usecase. Input has some details regarding event and Event Details. Service Generate  messages according to the usecase and communication channel from eventDetails. Message is sent over multiple communication channel like LINE, Alexa etc.

This service is build with spring boot and maven is used for handling dependencies.

Since we are not calling any API to retrive customerDetails right now so we have a file named customerDetails in folder "src\main\Abstracts". You can add any user or you can just change details of any User Their.

Input is of the type

{
	"event":"---event Type---",
	"customerId":"----",
	"eventDetails":{

		# Other Information needed for sending Messages


	}
}

**currently service is sending message over LINE only**
For Using the Service create a LINE channel and edit file "src\main\java\com\Amazon\services\clients\LINEClient\APIConfiguration.java". Edit value of constant "CHANNEL_ACCESS_TOKEN" with the channel access token of your LINE channel.

public static String CHANNEL_ACCESS_TOKEN= "Your channel access token";

