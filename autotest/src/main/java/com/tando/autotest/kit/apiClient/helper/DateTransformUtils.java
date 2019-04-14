package tools.apiClient.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

import tools.accountSimulator.RegisteringUser;
import tools.apiClient.HPCRequest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class DateTransformUtils
{
	private static ObjectMapper objectMapper = new ObjectMapper();
	
//	public static JsonNode s(Object obj){
//		objectMapper.readValue()
//	}

	public static void main(String [] args){
		
		RegisteringUser user = RegisteringUser.generateNewGmailUser(County);
		String createAccountPayLoads = FileUtils.loadFile("data/requestData/registSnapfishUser.xml");
		user.setSnapfishOptIn(false);
		user.setPartnerOptIn(false);
		
		HPCRequest
        .POST("https://www2.snapfish.com")
        .path("/snapfish/registrationsubmit/regversion=regver1/fromTS=true/module=true/topWindowHost=www.snapfish.com/istws=true/pns/snapfish/welcome/isFromReg=true")
        .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")			
        .header("Accept-Encoding", "gzip")
        .header("Content-type", "application/x-www-form-urlencoded")
        .setTrustAllSSL()
        .body(
            "session_retuser=FALSE&session_cobrandOid=1000&retuser=FALSE&password=" + user.getPassword() 
            + "&COBRAND_NAME=snapfish&session_siteentry=FDR&accept=true&regpromo=true&session_COBRAND_NAME=snapfish&lastname=" + user.getLastName() 
            + "&emailpromo=true&podifiedflag=true&y=10&source_pagename=front_page&x=71&displayCobrand=1000&password_auto_gen_flag=N&password2=" + user.getPassword() 
            + "&emailaddress=" + user.getEmail().replace("+", "%2B").replace("@", "%40") + "&siteentry=FDR&ref_src_code=FT3&firstname=" + user.getFirstName() + "&cobrandOid=1000").execute();
	}
}
