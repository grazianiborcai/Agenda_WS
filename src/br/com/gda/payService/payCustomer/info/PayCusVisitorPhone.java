package br.com.gda.payService.payCustomer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PayCusVisitorPhone implements InfoMergerVisitor<PayCusInfo, PhoneInfo, PayCusInfo> {

	@Override public PayCusInfo writeRecord(PhoneInfo sourceOne, PayCusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PayCusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PhoneInfo sourceOne, PayCusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PayCusInfo makeClone(PayCusInfo recordInfo) {
		try {
			return (PayCusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PayCusInfo merge(PhoneInfo sourceOne, PayCusInfo sourceTwo) {
		sourceTwo.phones.add(sourceOne);

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(PhoneInfo sourceOne, PayCusInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codCustomer == sourceTwo.codPayCustomer);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
