package br.com.gda.payment.accessMoip.info;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class AccemoipSetterUrl implements InfoSetter<AccemoipInfo> {
	private final String URL_ROOT = "https://connect-sandbox.moip.com.br/oauth/authorize?";
	
	public AccemoipInfo setAttr(AccemoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setUrl(recordInfo);
	}
	
	
	
	private void checkArgument(AccemoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private AccemoipInfo setUrl(AccemoipInfo recordInfo) {
		recordInfo.url = URL_ROOT;
		recordInfo.url = setParamResponseType(recordInfo.url);
		recordInfo.url = setParamClientId(recordInfo.url, recordInfo);
		recordInfo.url = setParamRedirectUri(recordInfo.url, recordInfo);
		recordInfo.url = setParamScope(recordInfo.url);

		return recordInfo;
	}	
	
	
	
	private String setParamResponseType(String url) {
		return url + "response_type=" + "code";
	}
	
	
	
	private String setParamClientId(String url, AccemoipInfo recordInfo) {
		return url + "&client_id=" + recordInfo.sysparData.idPayPartnerApp;
	}
	
	
	
	private String setParamRedirectUri(String url, AccemoipInfo recordInfo) {
		String encodedUrl = "http://www.mind5.com.br:8080/Agenda_WS/MoipApp";
		encodedUrl = encodedUrl + "?codOwner=" + recordInfo.codOwner;
		encodedUrl = encodedUrl + "&codStore=" + recordInfo.codStore;
		encodedUrl = encodedUrl + "&codLanguage=" + recordInfo.codLanguage;
		encodedUrl = encodeUrl(encodedUrl);		
		
		return url + "&redirect_uri=" + encodedUrl;
	}
	
	
	
	private String encodeUrl(String url) {
		try {
			return URLEncoder.encode(url, StandardCharsets.UTF_8.toString());
			
		} catch (UnsupportedEncodingException e) {
			logException(e);
			throw new IllegalArgumentException(e);
		}
	}
	
	
	
	private String setParamScope(String url) {
		return url + "&scope=" + "TRANSFER_FUNDS,RECEIVE_FUNDS";
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
