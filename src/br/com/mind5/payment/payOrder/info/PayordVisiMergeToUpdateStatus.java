package br.com.mind5.payment.payOrder.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class PayordVisiMergeToUpdateStatus implements InfoMergerVisitor<PayordInfo, PayordInfo> {

	@Override public PayordInfo writeRecord(PayordInfo sourceOne, PayordInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PayordInfo sourceOne, PayordInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PayordInfo merge(PayordInfo sourceOne, PayordInfo sourceTwo) {
		PayordInfo result = makeClone(sourceOne);	
		result.statusOrderPartner = sourceTwo.statusOrderPartner;	
		result.idPaymentPartner = sourceTwo.idPaymentPartner;
		result.statusPaymentPartner = sourceTwo.statusPaymentPartner;
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private PayordInfo makeClone(PayordInfo recordInfo) {
		try {
			return (PayordInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(PayordInfo sourceOne, PayordInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
