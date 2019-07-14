package br.com.gda.payment.accessMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;
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
		Setup setup = new Setup().setAuthentication(auth).setEnvironment(Environment.CONNECT_SANDBOX);
	//  TODO: parametizar environment no BD
		recordInfo.setup = setup;
		return recordInfo;
	}	
	
	
	
	private Authentication getAuthentication(AccemoipInfo recordInfo) {
		return new BasicAuth(recordInfo.setuparData.basicToken, recordInfo.setuparData.basicKey);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
