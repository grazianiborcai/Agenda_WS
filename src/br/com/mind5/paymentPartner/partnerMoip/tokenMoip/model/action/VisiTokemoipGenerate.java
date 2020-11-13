package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionVisitorTemplateSimple;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.moip.Moip;
import br.com.moip.models.Setup;

final class VisiTokemoipGenerate extends ActionVisitorTemplateSimple<TokemoipInfo> {
	
	public VisiTokemoipGenerate(DeciTreeOption<TokemoipInfo> option) {
		super(option);
	}
	
	
	
	@Override public List<TokemoipInfo> executeTransformationHook(List<TokemoipInfo> recordInfos) {
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
			    value("code", 			recordInfo.code)
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
	
	
	
	@Override protected int getErrorCodeHook() {
		return SystemCode.PAY_CUS_MOIP_CREATION_ERROR;
	}
}
