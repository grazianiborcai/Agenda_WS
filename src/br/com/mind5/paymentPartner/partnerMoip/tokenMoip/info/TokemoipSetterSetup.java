package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.Environ;
import br.com.moip.auth.Authentication;
import br.com.moip.auth.OAuth;
import br.com.moip.models.Setup;
import br.com.moip.models.Setup.Environment;

public final class TokemoipSetterSetup extends InfoSetterTemplate<TokemoipInfo> {
	
	@Override protected TokemoipInfo setAttrHook(TokemoipInfo recordInfo) {
		Authentication auth = getAuthentication(recordInfo);
		Environment environment = getEnvironment(recordInfo);
		
		Setup setup = new Setup().setAuthentication(auth).setEnvironment(environment);

		recordInfo.setup = setup;
		return recordInfo;
	}	
	
	
	
	private Authentication getAuthentication(TokemoipInfo recordInfo) {
		return new OAuth(recordInfo.setuparData.oauthToken);
	}	
	
	
	
	private Environment getEnvironment(TokemoipInfo recordInfo) {
		if(recordInfo.codSysEnviron == null)
			return Environment.CONNECT_SANDBOX;
		
		if(recordInfo.codSysEnviron.equals(Environ.PRODUCTIVE.getCodEnviron()))
			return Environment.CONNECT_PRODUCTION;
		
		
		return Environment.CONNECT_SANDBOX;
	}
}
