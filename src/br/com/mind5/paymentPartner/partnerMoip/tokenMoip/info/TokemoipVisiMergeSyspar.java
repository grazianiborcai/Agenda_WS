package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

final class TokemoipVisiMergeSyspar implements InfoMergerVisitor_<TokemoipInfo, SysparInfo> {

	@Override public TokemoipInfo writeRecord(SysparInfo sourceOne, TokemoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		TokemoipInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(SysparInfo sourceOne, TokemoipInfo sourceTwo) {
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
	
	
	
	private TokemoipInfo merge(SysparInfo sourceOne, TokemoipInfo sourceTwo) {
		sourceTwo.sysparData = makeClone(sourceOne);
		return sourceTwo;
	}
	
	
	
	private SysparInfo makeClone(SysparInfo recordInfo) {
		try {
			return (SysparInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	@Override public boolean shouldWrite(SysparInfo sourceOne, TokemoipInfo sourceTwo) {		
		return (sourceOne.codPayPartner == sourceTwo.codPayPartner);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
