package br.com.gda.payment.customer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class PaycusVisiMergeToSelect implements InfoMergerVisitorV2<PaycusInfo, PaycusInfo> {

	@Override public PaycusInfo writeRecord(PaycusInfo sourceOne, PaycusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PaycusInfo sourceOne, PaycusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PaycusInfo merge(PaycusInfo sourceOne, PaycusInfo sourceTwo) {
		PaycusInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private PaycusInfo makeClone(PaycusInfo recordInfo) {
		try {
			return (PaycusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(PaycusInfo sourceOne, PaycusInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
