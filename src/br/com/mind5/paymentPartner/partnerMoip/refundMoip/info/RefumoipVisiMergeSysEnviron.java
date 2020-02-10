package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class RefumoipVisiMergeSysEnviron implements InfoMergerVisitor_<RefumoipInfo, SysEnvironInfo> {

	@Override public RefumoipInfo writeRecord(SysEnvironInfo sourceOne, RefumoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		RefumoipInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(SysEnvironInfo sourceOne, RefumoipInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private RefumoipInfo makeClone(RefumoipInfo recordInfo) {
		try {
			return (RefumoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private RefumoipInfo merge(SysEnvironInfo sourceOne, RefumoipInfo sourceTwo) {
		sourceTwo.codSysEnviron = sourceOne.codSysEnviron;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(SysEnvironInfo sourceOne, RefumoipInfo sourceTwo) {		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
