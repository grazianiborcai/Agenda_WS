package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

final class AccemoipVisiMergeSyspar implements InfoMergerVisitor_<AccemoipInfo, SysparInfo> {

	@Override public AccemoipInfo writeRecord(SysparInfo sourceOne, AccemoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		AccemoipInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(SysparInfo sourceOne, AccemoipInfo sourceTwo) {
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
	
	
	
	private AccemoipInfo merge(SysparInfo sourceOne, AccemoipInfo sourceTwo) {
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
	
	
	
	@Override public boolean shouldWrite(SysparInfo sourceOne, AccemoipInfo sourceTwo) {		
		return (sourceOne.codPayPartner == sourceTwo.codPayPartner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
