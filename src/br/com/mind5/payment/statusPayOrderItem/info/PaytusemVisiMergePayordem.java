package br.com.mind5.payment.statusPayOrderItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class PaytusemVisiMergePayordem implements InfoMergerVisitor_<PaytusemInfo, PayordemInfo> {

	@Override public PaytusemInfo writeRecord(PayordemInfo sourceOne, PaytusemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PaytusemInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PayordemInfo sourceOne, PaytusemInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PaytusemInfo makeClone(PaytusemInfo recordInfo) {
		try {
			return (PaytusemInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PaytusemInfo merge(PayordemInfo sourceOne, PaytusemInfo sourceTwo) {
		PaytusemInfo result = PaytusemInfo.copyFrom(sourceOne);
		result.cusparData = sourceTwo.cusparData;
		
		return result;
	}
	
	
	
	@Override public boolean shouldWrite(PayordemInfo sourceOne, PaytusemInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner 	&&
				sourceOne.codPayOrder 	== sourceTwo.codPayOrder	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
