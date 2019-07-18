package br.com.gda.payment.payOrderItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.payment.storePartner.info.StoparInfo;

final class PayordemVisiMergeStopar implements InfoMergerVisitorV2<PayordemInfo, StoparInfo> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;

	@Override public PayordemInfo writeRecord(StoparInfo sourceOne, PayordemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PayordemInfo clonedInfo = makeClone(sourceTwo);
		clonedInfo.itemReceiver = sourceOne.idPayPartnerStore; 
		return clonedInfo;
	}
	
	
	
	private PayordemInfo makeClone(PayordemInfo recordInfo) {
		try {
			return (PayordemInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void checkArgument(StoparInfo sourceOne, PayordemInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(StoparInfo sourceOne, PayordemInfo sourceTwo) {
		if (sourceOne.codOwner		 == sourceTwo.codOwner	&&
			sourceOne.codStore  	 == sourceTwo.codStore	&&
			sourceOne.codPayPartner  == sourceTwo.codPayPartner) 
			return SUCCESS;
			
		return FAILED;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
