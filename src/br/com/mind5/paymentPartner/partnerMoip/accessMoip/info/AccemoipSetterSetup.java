package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.Environ;
import br.com.moip.auth.Authentication;
import br.com.moip.auth.BasicAuth;
import br.com.moip.models.Setup;
import br.com.moip.models.Setup.Environment;

public final class AccemoipSetterSetup extends InfoSetterTemplate<AccemoipInfo> {
	
	@Override protected AccemoipInfo setAttrHook(AccemoipInfo recordInfo) {
		Authentication auth = getAuthentication(recordInfo);
		Environment environment = getEnvironment(recordInfo);
		
		Setup setup = new Setup().setAuthentication(auth).setEnvironment(environment);

		recordInfo.setup = setup;
		return recordInfo;
	}
	
	
	
	private Authentication getAuthentication(AccemoipInfo recordInfo) {
		return new BasicAuth(recordInfo.setuparData.basicToken, recordInfo.setuparData.basicKey);
	}	
	
	
	
	private Environment getEnvironment(AccemoipInfo recordInfo) {
		if(recordInfo.codSysEnviron == null)
			return Environment.CONNECT_SANDBOX;
		
		if(recordInfo.codSysEnviron.equals(Environ.PRODUCTIVE.getCodEnviron()))
			return Environment.CONNECT_PRODUCTION;
		
		
		return Environment.CONNECT_SANDBOX;
	}	
}
