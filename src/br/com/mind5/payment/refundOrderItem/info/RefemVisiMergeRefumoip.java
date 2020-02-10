package br.com.mind5.payment.refundOrderItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

final class RefemVisiMergeRefumoip implements InfoMergerVisitor_<RefemInfo, RefumoipInfo> {

	@Override public RefemInfo writeRecord(RefumoipInfo sourceOne, RefemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		RefemInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(RefumoipInfo sourceOne, RefemInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private RefemInfo makeClone(RefemInfo recordInfo) {
		try {
			return (RefemInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private RefemInfo merge(RefumoipInfo sourceOne, RefemInfo sourceTwo) {
		sourceTwo.idRefundPartner = sourceOne.idRefundPartner;
		sourceTwo.statusRefundPartner = sourceOne.statusRefundPartner;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(RefumoipInfo sourceOne, RefemInfo sourceTwo) {		
		if (sourceOne.idOrderPartner == null ||
			sourceTwo.idOrderPartner == null	)
			return false;
		
		return (sourceOne.idOrderPartner.equals(sourceTwo.idOrderPartner));
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
