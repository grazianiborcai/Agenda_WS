package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import br.com.mind5.business.masterData.info.common.Environ;
import br.com.mind5.info.InfoSetterTemplate;
import br.com.moip.auth.Authentication;
import br.com.moip.auth.BasicAuth;
import br.com.moip.models.Setup;
import br.com.moip.models.Setup.Environment;

public final class CremoipSetterSetup extends InfoSetterTemplate<CremoipInfo> {
	
	@Override protected CremoipInfo setAttrHook(CremoipInfo recordInfo) {
		Authentication auth = getAuthentication(recordInfo);
		Environment environment = getEnvironment(recordInfo);
		
		Setup setup = new Setup().setAuthentication(auth).setEnvironment(environment);
		
		recordInfo.setup = setup;
		return recordInfo;
	}	
	
	
	
	private Authentication getAuthentication(CremoipInfo recordInfo) {
		return new BasicAuth(recordInfo.setuparData.basicToken, recordInfo.setuparData.basicKey);
	}	
	
	
	
	private Environment getEnvironment(CremoipInfo recordInfo) {
		if(recordInfo.codSysEnviron == null)
			return Environment.SANDBOX;
		
		if(recordInfo.codSysEnviron.equals(Environ.PRODUCTIVE.getCodEnviron()))
			return Environment.PRODUCTION;
		
		
		return Environment.SANDBOX;
	}
}
