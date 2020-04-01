package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import br.com.mind5.business.masterData.info.common.Environ;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;
import br.com.moip.auth.Authentication;
import br.com.moip.auth.OAuth;
import br.com.moip.models.Setup;
import br.com.moip.models.Setup.Environment;

public final class TokemoipSetterSetup implements InfoSetter<TokemoipInfo> {
	
	public TokemoipInfo setAttr(TokemoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setSetup(recordInfo);
	}
	
	
	
	private void checkArgument(TokemoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private TokemoipInfo setSetup(TokemoipInfo recordInfo) {
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
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
