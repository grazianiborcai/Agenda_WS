package br.com.mind5.payment.partnerMoip.multiOrderMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class MultmoipVisiMergeSysEnviron implements InfoMergerVisitor<MultmoipInfo, SysEnvironInfo> {

	@Override public MultmoipInfo writeRecord(SysEnvironInfo sourceOne, MultmoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MultmoipInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(SysEnvironInfo sourceOne, MultmoipInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MultmoipInfo makeClone(MultmoipInfo recordInfo) {
		try {
			return (MultmoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MultmoipInfo merge(SysEnvironInfo sourceOne, MultmoipInfo sourceTwo) {
		sourceTwo.codSysEnviron = sourceOne.codSysEnviron;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(SysEnvironInfo sourceOne, MultmoipInfo sourceTwo) {		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
