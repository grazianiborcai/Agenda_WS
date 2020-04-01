package br.com.mind5.payment.storePartner.info;

import br.com.mind5.business.masterData.info.common.RecordMode;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

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
		
		SystemLog.logError(this.getClass(), e);
	}	
}
