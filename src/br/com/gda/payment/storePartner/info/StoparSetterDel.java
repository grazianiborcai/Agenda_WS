package br.com.gda.payment.storePartner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.common.RecordMode;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class StoparSetterDel implements InfoSetter<StoparInfo> {
	
	public StoparInfo setAttr(StoparInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodDel(recordInfo);
	}
	
	
	
	private void checkArgument(StoparInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private StoparInfo setCodDel(StoparInfo recordInfo) {
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
