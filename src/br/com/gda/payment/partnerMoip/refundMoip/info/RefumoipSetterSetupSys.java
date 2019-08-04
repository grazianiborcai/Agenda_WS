package br.com.gda.payment.partnerMoip.refundMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;
import br.com.moip.auth.Authentication;
import br.com.moip.auth.OAuth;
import br.com.moip.models.Setup;
import br.com.moip.models.Setup.Environment;

public final class RefumoipSetterSetupSys implements InfoSetter<RefumoipInfo> {
	
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
		Setup setup = new Setup().setAuthentication(auth).setEnvironment(Environment.SANDBOX);
	//  TODO: parametizar environment no BD
		recordInfo.setup = setup;
		return recordInfo;
	}	
	
	
	
	private Authentication getAuthentication(RefumoipInfo recordInfo) {
		return new OAuth(recordInfo.setuparData.oauthToken);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
