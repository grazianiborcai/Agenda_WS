package br.com.gda.payment.payOrderItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PayordemVisiMergeToUpdate implements InfoMergerVisitor<PayordemInfo, PayordemInfo> {

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
		result.idOrderPartner = sourceTwo.idOrderPartner;
		result.statusOrderPartner = sourceTwo.statusOrderPartner;	
		result.idPaymentPartner = sourceTwo.idPaymentPartner;
		result.statusPaymentPartner = sourceTwo.statusPaymentPartner;	
		result.codPayPartner = sourceTwo.codPayPartner;
		result.codOrder = sourceTwo.codOrder;
		result.codOrderItem = sourceTwo.codOrderItem;
		result.ownId = sourceTwo.ownId;
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
