package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.Environ;
import br.com.moip.auth.Authentication;
import br.com.moip.auth.OAuth;
import br.com.moip.models.Setup;
import br.com.moip.models.Setup.Environment;

public final class PaymoipSetterSetup extends InfoSetterTemplate<PaymoipInfo> {
	
	@Override protected PaymoipInfo setAttrHook(PaymoipInfo recordInfo) {
		Authentication auth = getAuthentication(recordInfo);
		Environment environment = getEnvironment(recordInfo);
		
		Setup setup = new Setup().setAuthentication(auth).setEnvironment(environment);

		recordInfo.setup = setup;
		return recordInfo;
	}	
	
	
	
	private Authentication getAuthentication(PaymoipInfo recordInfo) {
		return new OAuth(recordInfo.setuparData.oauthToken);
	}	
	
	
	
	private Environment getEnvironment(PaymoipInfo recordInfo) {
		if(recordInfo.codSysEnviron == null)
			return Environment.SANDBOX;
		
		if(recordInfo.codSysEnviron.equals(Environ.PRODUCTIVE.getCodEnviron()))
			return Environment.PRODUCTION;
		
		
		return Environment.SANDBOX;
	}	
}
