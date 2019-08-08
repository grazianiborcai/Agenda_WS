package br.com.gda.payment.refundOrderItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class RefemVisiMergePayord implements InfoMergerVisitor<RefemInfo, PayordInfo> {

	@Override public RefemInfo writeRecord(PayordInfo sourceOne, RefemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		RefemInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PayordInfo sourceOne, RefemInfo sourceTwo) {
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
	
	
	
	private RefemInfo merge(PayordInfo sourceOne, RefemInfo sourceTwo) {
		sourceTwo.codPayCustomer = sourceOne.codPayCustomer;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PayordInfo sourceOne, RefemInfo sourceTwo) {		
		return (sourceOne.codOwner 	  == sourceTwo.codOwner	&&
				sourceOne.codPayOrder == sourceTwo.codPayOrder);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
