package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.moip.Moip;

final class VisiAccemoipUrl extends ActionVisitorTemplateSimple<AccemoipInfo> {
	
	public VisiAccemoipUrl(DeciTreeOption<AccemoipInfo> option) {
		super(option);
	}
	
	
	
	@Override public List<AccemoipInfo> executeTransformationHook(List<AccemoipInfo> recordInfos) {
		List<AccemoipInfo> results = new ArrayList<>();
		
		for(AccemoipInfo eachRecod : recordInfos) {
			String response;
			response = tryToBuildUrl(eachRecod);
			
			if (response == null)
				return Collections.emptyList();
			
			eachRecod = setAttribute(eachRecod, response);
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private String tryToBuildUrl(AccemoipInfo recordInfo) {
		try {
			String urlRedirect = addQueryParam(recordInfo, recordInfo.sysparData.urlReturn);
			urlRedirect = encodeUrl(urlRedirect);
			
			return Moip.API.connect().buildUrl(recordInfo.sysparData.idPayPartnerApp, 
											   urlRedirect, 
											   recordInfo.scopes, 
											   recordInfo.setup);
			
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	
	
	private String addQueryParam(AccemoipInfo recordInfo, String url) {
		url = url + "?codOwner=" + recordInfo.codOwner;
		url = url + "&username=" + recordInfo.username;
		url = url + "&codStore=" + recordInfo.codStore;		
		url = url + "&codLanguage=" + recordInfo.codLanguage;
		return url;
	}
	
	
	
	private String encodeUrl(String url) {
		try {
			return URLEncoder.encode(url, StandardCharsets.UTF_8.toString());
			
		} catch (UnsupportedEncodingException e) {
			logException(e);
			throw new IllegalArgumentException(e);
		}
	}
	
	
	
	private AccemoipInfo setAttribute(AccemoipInfo recordInfo, String response) {
		recordInfo.url = response;
		
		return recordInfo;
	}
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.PAY_CUS_MOIP_CREATION_ERROR;
	}
}
