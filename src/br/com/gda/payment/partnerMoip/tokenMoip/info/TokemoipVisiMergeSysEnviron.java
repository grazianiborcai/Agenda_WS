package br.com.gda.payment.partnerMoip.tokenMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class TokemoipVisiMergeSysEnviron implements InfoMergerVisitorV2<TokemoipInfo, SysEnvironInfo> {

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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
