package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import br.com.mind5.business.masterData.info.common.Environ;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;
import br.com.moip.auth.Authentication;
import br.com.moip.auth.OAuth;
import br.com.moip.models.Setup;
import br.com.moip.models.Setup.Environment;

public final class PaymoipSetterSetup implements InfoSetter<PaymoipInfo> {
	
	public PaymoipInfo setAttr(PaymoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setSetup(recordInfo);
	}
	
	
	
	private void checkArgument(PaymoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PaymoipInfo setSetup(PaymoipInfo recordInfo) {
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
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
