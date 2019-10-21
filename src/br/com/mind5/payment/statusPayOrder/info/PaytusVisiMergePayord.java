package br.com.mind5.payment.statusPayOrder.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class PaytusVisiMergePayord implements InfoMergerVisitor<PaytusInfo, PayordInfo> {

	@Override public PaytusInfo writeRecord(PayordInfo sourceOne, PaytusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PaytusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PayordInfo sourceOne, PaytusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PaytusInfo makeClone(PaytusInfo recordInfo) {
		try {
			return (PaytusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PaytusInfo merge(PayordInfo sourceOne, PaytusInfo sourceTwo) {
		return PaytusInfo.copyFrom(sourceOne);
	}
	
	
	
	@Override public boolean shouldWrite(PayordInfo sourceOne, PaytusInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner 	&&
				sourceOne.codPayOrder 	== sourceTwo.codPayOrder	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
