package utils;

//Install the Java helper library from twilio.com/docs/java/install

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;

public class SMSSender {
 // Find your Account SID and Auth Token at twilio.com/console
 // and set the environment variables. See http://twil.io/secure
 public static final String ACCOUNT_SID = "AC7e3e2f2cc9e5701faaf4cac50c62c60d";
 public static final String AUTH_TOKEN = "f9ea91906a1387cd3286238ef9fa1bc9";

 public static void sendOTP(String contactNo,String msg) {
     Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
     Message message = Message.creator(
             new com.twilio.type.PhoneNumber("+91"+contactNo),
             new com.twilio.type.PhoneNumber("+17194254553"),
             msg)
         .create();

     System.out.println(message.getSid());
 }
}
