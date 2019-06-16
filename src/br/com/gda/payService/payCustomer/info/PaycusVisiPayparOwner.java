package br.com.gda.payService.payCustomer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoMergerVisitor_;
import br.com.gda.payment.ownerPartner.info.OwnparInfo;

final class PaycusVisiPayparOwner implements InfoMergerVisitor_<PaycusInfo, OwnparInfo, PaycusInfo> {
	@Override public PaycusInfo writeRecord(OwnparInfo sourceOne, PaycusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PaycusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private PaycusInfo makeClone(PaycusInfo recordInfo) {
		try {
			return (PaycusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PaycusInfo merge(OwnparInfo sourceOne, PaycusInfo sourceTwo) {
		sourceTwo.codPayPartner = sourceOne.codPayPartner;
		sourceTwo.txtPayPartner = sourceOne.txtPayPartner;
		return sourceTwo;
	}
	
	
	
	private void checkArgument(OwnparInfo sourceOne, PaycusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(OwnparInfo sourceOne, PaycusInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
