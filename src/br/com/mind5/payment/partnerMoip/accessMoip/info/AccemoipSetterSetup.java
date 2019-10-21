package br.com.mind5.payment.partnerMoip.accessMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.common.Environ;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;
import br.com.moip.auth.Authentication;
import br.com.moip.auth.BasicAuth;
import br.com.moip.models.Setup;
import br.com.moip.models.Setup.Environment;

public final class AccemoipSetterSetup implements InfoSetter<AccemoipInfo> {
	
	public AccemoipInfo setAttr(AccemoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setSetup(recordInfo);
	}
	
	
	
	private void checkArgument(AccemoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private AccemoipInfo setSetup(AccemoipInfo recordInfo) {
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
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
