package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class TokemoipVisiMergeSysEnviron implements InfoMergerVisitor_<TokemoipInfo, SysEnvironInfo> {

	@Override public TokemoipInfo writeRecord(SysEnvironInfo sourceOne, TokemoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		TokemoipInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(SysEnvironInfo sourceOne, TokemoipInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private TokemoipInfo makeClone(TokemoipInfo recordInfo) {
		try {
			return (TokemoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private TokemoipInfo merge(SysEnvironInfo sourceOne, TokemoipInfo sourceTwo) {
		sourceTwo.codSysEnviron = sourceOne.codSysEnviron;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(SysEnvironInfo sourceOne, TokemoipInfo sourceTwo) {		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
