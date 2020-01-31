package br.com.mind5.payment.partnerMoip.accessMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AccemoipVisiMergeSysEnviron implements InfoMergerVisitor_<AccemoipInfo, SysEnvironInfo> {

	@Override public AccemoipInfo writeRecord(SysEnvironInfo sourceOne, AccemoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		AccemoipInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(SysEnvironInfo sourceOne, AccemoipInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private AccemoipInfo makeClone(AccemoipInfo recordInfo) {
		try {
			return (AccemoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private AccemoipInfo merge(SysEnvironInfo sourceOne, AccemoipInfo sourceTwo) {
		sourceTwo.codSysEnviron = sourceOne.codSysEnviron;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(SysEnvironInfo sourceOne, AccemoipInfo sourceTwo) {		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
