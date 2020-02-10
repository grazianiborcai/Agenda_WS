package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PaymoipVisiMergeSysEnviron implements InfoMergerVisitor_<PaymoipInfo, SysEnvironInfo> {

	@Override public PaymoipInfo writeRecord(SysEnvironInfo sourceOne, PaymoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PaymoipInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(SysEnvironInfo sourceOne, PaymoipInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PaymoipInfo makeClone(PaymoipInfo recordInfo) {
		try {
			return (PaymoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PaymoipInfo merge(SysEnvironInfo sourceOne, PaymoipInfo sourceTwo) {
		sourceTwo.codSysEnviron = sourceOne.codSysEnviron;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(SysEnvironInfo sourceOne, PaymoipInfo sourceTwo) {		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
