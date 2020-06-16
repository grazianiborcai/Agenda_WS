package br.com.mind5.business.feeOwner.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.masterData.feeCategory.info.Feecat;

public final class FeewnerSetterCategServ implements InfoSetter<FeewnerInfo> {
	
	public FeewnerInfo setAttr(FeewnerInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(FeewnerInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private FeewnerInfo setKey(FeewnerInfo recordInfo) {		
		recordInfo.codFeeCateg = Feecat.SERVICE.getCodCateg();
		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
