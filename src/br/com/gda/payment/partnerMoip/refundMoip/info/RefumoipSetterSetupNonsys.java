package br.com.gda.payment.partnerMoip.refundMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.common.Environ;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;
import br.com.moip.auth.Authentication;
import br.com.moip.auth.OAuth;
import br.com.moip.models.Setup;
import br.com.moip.models.Setup.Environment;

public final class RefumoipSetterSetupNonsys implements InfoSetter<RefumoipInfo> {
	
	public RefumoipInfo setAttr(RefumoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setSetup(recordInfo);
	}
	
	
	
	private void checkArgument(RefumoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private RefumoipInfo setSetup(RefumoipInfo recordInfo) {
		Authentication auth = getAuthentication(recordInfo);
		Environment environment = getEnvironment(recordInfo);
		
		Setup setup = new Setup().setAuthentication(auth).setEnvironment(environment);

		recordInfo.setup = setup;
		return recordInfo;
	}	
	
	
	
	private Authentication getAuthentication(RefumoipInfo recordInfo) {
		return new OAuth(recordInfo.stoparData.accessToken);
	}	
	
	
	
	private Environment getEnvironment(RefumoipInfo recordInfo) {
		if(recordInfo.codSysEnviron == null)
			return Environment.SANDBOX;
		
		if(recordInfo.codSysEnviron.equals(Environ.PRODUCTIVE.getCodEnviron()))
			return Environment.PRODUCTION;
		
		
		return Environment.SANDBOX;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
