package com.findagolfer.mobile.services;

import java.util.List;

import com.findagolfer.mobile.entities.ConfigurationData;
import com.findagolfer.mobile.entities.CreateGolferResult;
import com.findagolfer.mobile.entities.GolfCourse;
import com.findagolfer.mobile.entities.Golfer;
import com.findagolfer.mobile.entities.GolferProfileView;
import com.findagolfer.mobile.entities.PrivateMessage;
import com.findagolfer.mobile.entities.StatusMessage;
import com.findagolfer.mobile.entities.VoidOperationResult;
import com.findagolfer.mobile.parsers.ConfigurationResultParser;
import com.findagolfer.mobile.parsers.CreateGolferParser;
import com.findagolfer.mobile.parsers.GolfCourseNearbyParser;
import com.findagolfer.mobile.parsers.GolfCourseParser;
import com.findagolfer.mobile.parsers.GolferParser;
import com.findagolfer.mobile.parsers.GolferProfileViewParser;
import com.findagolfer.mobile.parsers.NearbyGolfersParser;
import com.findagolfer.mobile.parsers.PrivateMessageParser;
import com.findagolfer.mobile.parsers.VoidOperationParser;


public class ServiceLocator {
	private UrlService _urlService;
	private String _serviceUrl;
	private static ServiceLocator instance = null;
	private UserCredentialService _credentialService;
	
	private ServiceLocator() {
		_credentialService = new UserCredentialService();
	}
	
	public String getServiceUrl() {
		return _serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this._serviceUrl = serviceUrl;
		_urlService = new UrlService(_serviceUrl);
	}
	
	public static ServiceLocator getInstance(){
		if(instance == null){
			instance = new ServiceLocator();
		}		
		return instance;
	}
	
	public ConfigurationData GetCurrentServiceConfiguration(String url, String version){
		_credentialService.setCredentialsForNewUser();
		ConfigurationData success = new ConfigurationResultParser(String.format(url, java.net.URLEncoder.encode(version)), _credentialService.getAuthHeader()).getConfigData();
		this._serviceUrl = success.getBaseUrl();
		return success;
	}
	
	public UrlService getUrlService() {
		return _urlService;
	}

	public void setUrlService(UrlService urlService) {
		this._urlService = urlService;
	}

	public UserCredentialService getCredentialService() {
		return _credentialService;
	}
	
	public void setCredentials(String username, String password){
		_credentialService.setUser(username);
		_credentialService.setPassword(password);		
	}
	
	public Golfer getGolferByUserNameAndPassword(String logInfo){
		Golfer failedGolfer = new GolferParser(_urlService.getGolferUrl(), _credentialService.getAuthHeader(), logInfo).getGolfer();
		return new GolferParser(_urlService.getGolferUrl(), _credentialService.getAuthHeader(), logInfo).getGolfer();
	}
	
	public GolferProfileView getGolferProfileByGolferId(String golferid){
		GolferProfileView failed = new GolferProfileViewParser(_urlService.getGolferProfileUrl(), _credentialService.getAuthHeader(), golferid).getProfileView();
		return new GolferProfileViewParser(_urlService.getGolferProfileUrl(), _credentialService.getAuthHeader(), golferid).getProfileView();
	}
	
	public List<StatusMessage> getNearbyGolfers(String data){
		List<StatusMessage> failed = new NearbyGolfersParser(_urlService.getNearbyGolfersUrl(), _credentialService.getAuthHeader(), data).getStatusMessages();
		return new NearbyGolfersParser(_urlService.getNearbyGolfersUrl(), _credentialService.getAuthHeader(), data).getStatusMessages();
	}
	
	public List<StatusMessage> updateGolferStatus(String data){
		List<StatusMessage> failed = new NearbyGolfersParser(_urlService.getUpdateGolferStatusUrl(), _credentialService.getAuthHeader(), data).getStatusMessages();
		return new NearbyGolfersParser(_urlService.getUpdateGolferStatusUrl(), _credentialService.getAuthHeader(), data).getStatusMessages();
	}
	
	public CreateGolferResult createGolfer(String data){
		_credentialService.setCredentialsForNewUser();
		CreateGolferResult firstFailedResult = new CreateGolferParser(_urlService.getCreateGolferUrl(), _credentialService.getAuthHeader(), data).getGolferResult();
		return new CreateGolferParser(_urlService.getCreateGolferUrl(), _credentialService.getAuthHeader(), data).getGolferResult();
	}
	
	public VoidOperationResult sendPrivateMessage(String data){
		VoidOperationResult failed = new VoidOperationParser(_urlService.getSendPrivateMessageUrl(), _credentialService.getAuthHeader(), data).getResult();
		return new VoidOperationParser(_urlService.getSendPrivateMessageUrl(), _credentialService.getAuthHeader(), data).getResult();
	}
	
	public Golfer updateGolferProfile(String data){
		VoidOperationResult failed = new VoidOperationParser(_urlService.getUpdateCurrentProfileUrl(), _credentialService.getAuthHeader(), data).getResult();
		return new GolferParser(_urlService.getUpdateCurrentProfileUrl(), _credentialService.getAuthHeader(), data).getGolfer();
	}
	
	public VoidOperationResult createGolferRating(String data){
		VoidOperationResult failedd = new VoidOperationParser(_urlService.getCreateRatingUrl(), _credentialService.getAuthHeader(), data).getResult();
		return new VoidOperationParser(_urlService.getCreateRatingUrl(), _credentialService.getAuthHeader(), data).getResult();
	}
	
	public List<PrivateMessage> getPrivateMessages(String data){
		List<PrivateMessage> failed = new PrivateMessageParser(_urlService.getPrivateMessagesUrl(), _credentialService.getAuthHeader(), data).getPrivateMessages();
		return new PrivateMessageParser(_urlService.getPrivateMessagesUrl(), _credentialService.getAuthHeader(), data).getPrivateMessages();
	}
	
	public List<GolfCourse> getNearbyGolfCourses(String data){
		List<GolfCourse> failed = new GolfCourseNearbyParser(_urlService.getNearbyCoursesUrl(), _credentialService.getAuthHeader(), data).getGolfCourses();
		return new GolfCourseNearbyParser(_urlService.getNearbyCoursesUrl(), _credentialService.getAuthHeader(), data).getGolfCourses();
	}
	public GolfCourse getGolfCourseDataById(String courseid){
		GolfCourse failed = new GolfCourseParser(_urlService.getSingleCourseUrl(), _credentialService.getAuthHeader(), courseid).getSingleCourse();
		return new GolfCourseParser(_urlService.getSingleCourseUrl(), _credentialService.getAuthHeader(), courseid).getSingleCourse();
	}
	public VoidOperationResult resetPword(String data){
		_credentialService.setCredentialsForNewUser();
		VoidOperationResult failed = new VoidOperationParser(_urlService.getResetPwordUrl(), _credentialService.getAuthHeader(), data).getResult();
		return new VoidOperationParser(_urlService.getResetPwordUrl(), _credentialService.getAuthHeader(), data).getResult();
	}
	
	
	
}
