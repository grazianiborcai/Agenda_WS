package br.com.gda.payment.payOrderItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class PayordemVisiMergeToUpdateStatus implements InfoMergerVisitorV2<PayordemInfo, PayordemInfo> {

	@Override public PayordemInfo writeRecord(PayordemInfo sourceOne, PayordemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PayordemInfo sourceOne, PayordemInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PayordemInfo merge(PayordemInfo sourceOne, PayordemInfo sourceTwo) {
		PayordemInfo result = makeClone(sourceOne);	
		result.statusOrderPartner = sourceTwo.statusOrderPartner;	
		result.idPaymentPartner = sourceTwo.idPaymentPartner;
		result.statusPaymentPartner = sourceTwo.statusPaymentPartner;	
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private PayordemInfo makeClone(PayordemInfo recordInfo) {
		try {
			return (PayordemInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(PayordemInfo sourceOne, PayordemInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
