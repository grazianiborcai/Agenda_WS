package br.com.mind5.payment.partnerMoip.orderMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdmoipVisiMergeSysEnviron implements InfoMergerVisitor_<OrdmoipInfo, SysEnvironInfo> {

	@Override public OrdmoipInfo writeRecord(SysEnvironInfo sourceOne, OrdmoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrdmoipInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(SysEnvironInfo sourceOne, OrdmoipInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrdmoipInfo makeClone(OrdmoipInfo recordInfo) {
		try {
			return (OrdmoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OrdmoipInfo merge(SysEnvironInfo sourceOne, OrdmoipInfo sourceTwo) {
		sourceTwo.codSysEnviron = sourceOne.codSysEnviron;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(SysEnvironInfo sourceOne, OrdmoipInfo sourceTwo) {		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
