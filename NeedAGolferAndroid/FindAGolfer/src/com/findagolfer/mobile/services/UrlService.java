package com.findagolfer.mobile.services;

public class UrlService {
	private String _baseUrl;
	
	private static String createGolferUrl = "/creategolfer";
	private static String getGolferUrl = "/getgolfer";
	private static String getNearbyGolfersUrl = "/getnearbygolfers";
	private static String updateGolferStatusUrl = "/updategolferstatus";
	private static String sendPrivateMessageUrl = "/sendmessage";
	private static String updateGolferProfileUrl = "/updategolfer";
	private static String golferProfileUrl = "/getprofile";
	private static String createRatingUrl = "/createrating";
	private static String getPrivateMessagesUrl = "/getmessages";
	private static String getNearbyGolfCoursesUrl = "/getnearbycourses";
	private static String getGolfCourseById = "/getgolfcourse";
	private static String resetPwordUrl = "/resetpword";
	
	public UrlService(String baseUrl){
		_baseUrl = baseUrl;
	}
	
	public String getCreateGolferUrl(){
		return _baseUrl + createGolferUrl;
	}
	
	public String getGolferUrl(){
		return _baseUrl + getGolferUrl;
	}
	
	public String getNearbyGolfersUrl(){
		return _baseUrl + getNearbyGolfersUrl;
	}
	
	public String getUpdateGolferStatusUrl(){
		return _baseUrl + updateGolferStatusUrl;
	}
	
	public String getSendPrivateMessageUrl(){
		return _baseUrl + sendPrivateMessageUrl;
	}
	
	public String getUpdateCurrentProfileUrl(){
		return _baseUrl + updateGolferProfileUrl;
	}
	
	public String getGolferProfileUrl(){
		return _baseUrl + golferProfileUrl;
	}
	
	public String getCreateRatingUrl(){
		return _baseUrl + createRatingUrl;
	}
	
	public String getPrivateMessagesUrl(){
		return _baseUrl + getPrivateMessagesUrl;
	}
	
	public String getNearbyCoursesUrl(){
		return _baseUrl + getNearbyGolfCoursesUrl;
	}
	
	public String getSingleCourseUrl(){
		return _baseUrl + getGolfCourseById;
	}
	
	public String getResetPwordUrl(){
		return _baseUrl + resetPwordUrl;
	}
}
