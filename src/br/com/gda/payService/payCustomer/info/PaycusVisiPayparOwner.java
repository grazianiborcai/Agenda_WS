package br.com.gda.payService.payCustomer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoMergerVisitor_;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerInfo;

final class PaycusVisiPayparOwner implements InfoMergerVisitor_<PaycusInfo, PayparOwnerInfo, PaycusInfo> {
	@Override public PaycusInfo writeRecord(PayparOwnerInfo sourceOne, PaycusInfo sourceTwo) {
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
	
	
	
	private PaycusInfo merge(PayparOwnerInfo sourceOne, PaycusInfo sourceTwo) {
		sourceTwo.codPayPartner = sourceOne.codPayPartner;
		sourceTwo.txtPayPartner = sourceOne.txtPayPartner;
		return sourceTwo;
	}
	
	
	
	private void checkArgument(PayparOwnerInfo sourceOne, PaycusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(PayparOwnerInfo sourceOne, PaycusInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
