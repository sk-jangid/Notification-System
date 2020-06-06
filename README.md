# Notification-System

Notification System for different communication Methods. Gets JSON input regarding event and Event Details and Generate a message according to the message type and message details. After that message is sent over different communication methods like LINE, Alexa etc.

For adding your channel go to the file "src\main\java\com\Amazon\services\sendMessage\APIConfiguration" and replace the channelAccessToken with your channelAccessToken.
 
Since we are not calling any API to retrive customerDetails right now so we have a file named customerDetails in folder "src\main\Abstracts". You can add any user or you can just change details of any User Their.


Input is of the type

{
	"event":"---event Type---",
	"customerId":"----",
	"eventDetails":{

		# Other Information needed for sending Messages


	}
}


If you want to know Your User Id for testing purpose then [click here](https://get-profile.herokuapp.com/)
**NOTE: User Id will be different for different providers, so use that link only if you are using the same ACCESS token that is currently in the Project. No information is stored when you login via this link, this is only for making testing purposes**
