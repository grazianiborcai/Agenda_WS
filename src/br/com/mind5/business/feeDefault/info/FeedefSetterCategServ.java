package br.com.mind5.business.feeDefault.info;

import br.com.mind5.business.masterData.info.common.FeeCateg;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class FeedefSetterCategServ implements InfoSetter<FeedefInfo> {
	
	public FeedefInfo setAttr(FeedefInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(FeedefInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private FeedefInfo setKey(FeedefInfo recordInfo) {		
		recordInfo.codFeeCateg = FeeCateg.SERVICE.getCodCateg();
		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
