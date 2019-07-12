package br.com.gda.payment.tokenMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.common.Paypar;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class TokemoipSetterCodPayPartner implements InfoSetter<TokemoipInfo> {
	
	public TokemoipInfo setAttr(TokemoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(TokemoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private TokemoipInfo setKey(TokemoipInfo recordInfo) {
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
