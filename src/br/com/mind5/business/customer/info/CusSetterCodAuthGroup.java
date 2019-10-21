package br.com.mind5.business.customer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.common.AuthGroup;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CusSetterCodAuthGroup implements InfoSetter<CusInfo> {
	
	public CusInfo setAttr(CusInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodAuthGrRole(recordInfo);
	}
	
	
	
	private void checkArgument(CusInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CusInfo setCodAuthGrRole(CusInfo recordInfo) {
		recordInfo.codAuthGroup = AuthGroup.CUSTOMER.getCodAuthGroup();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
