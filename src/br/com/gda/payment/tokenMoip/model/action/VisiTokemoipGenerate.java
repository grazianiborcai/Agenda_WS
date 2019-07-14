package br.com.gda.payment.tokenMoip.model.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.model.action.ActionVisitor;
import br.com.gda.payment.tokenMoip.info.TokemoipInfo;
import br.com.moip.Moip;
import br.com.moip.models.Setup;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

final class VisiTokemoipGenerate implements ActionVisitor<TokemoipInfo> {
	
	@Override public List<TokemoipInfo> executeTransformation(List<TokemoipInfo> recordInfos) {
		List<TokemoipInfo> results = new ArrayList<>();
		
		for(TokemoipInfo eachRecod : recordInfos) {
			Map<String, Object> body = setBody(eachRecod);			
			Map<String, Object> response = tryToGenerateToken(eachRecod.setup, body);
			
			if (response == null)
				return Collections.emptyList();
			
			eachRecod = setAttribute(eachRecod, response);
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private Map<String, Object> setBody(TokemoipInfo recordInfo) {
		return payloadFactory(
			    value("client_id", 		recordInfo.sysparData.idPayPartnerApp),
			    value("client_secret", 	recordInfo.setuparData.secret),
			    value("redirect_uri", 	recordInfo.sysparData.urlReturn),
			    value("grant_type", 	"authorization_code"),
			    value("code", 			recordInfo.stoparData.codePayPartnerStore)
			);
	}
	
	
	
	private Map<String, Object> tryToGenerateToken(Setup setup, Map<String, Object> body) {
		try {
			return Moip.API.connect().generateAccessToken(body, setup);
			
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}
	
	
	
	private TokemoipInfo setAttribute(TokemoipInfo recordInfo, Map<String, Object> response) {
		recordInfo.accessToken = (String) response.get("access_token");
		recordInfo.tokenExpiresIn = stringToDate((String) response.get("expires_in"));
		recordInfo.refreshToken = (String) response.get("refresh_token");
		recordInfo.scope = (String) response.get("scope");
		
		@SuppressWarnings("unchecked")
		Map<String, Object> account = (Map<String, Object>) response.get("moipAccount");			
		recordInfo.idPayPartnerStore = (String) account.get("id");
		
		return recordInfo;
	}
	
	
	
	private LocalDate stringToDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(date, formatter);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
