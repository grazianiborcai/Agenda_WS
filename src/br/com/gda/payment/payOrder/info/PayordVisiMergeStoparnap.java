package br.com.gda.payment.payOrder.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapInfo;

final class PayordVisiMergeStoparnap implements InfoMergerVisitorV2<PayordInfo, StoparnapInfo> {

	@Override public PayordInfo writeRecord(StoparnapInfo sourceOne, PayordInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PayordInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(StoparnapInfo sourceOne, PayordInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PayordInfo makeClone(PayordInfo recordInfo) {
		try {
			return (PayordInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PayordInfo merge(StoparnapInfo sourceOne, PayordInfo sourceTwo) {
		sourceTwo.codSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(StoparnapInfo sourceOne, PayordInfo sourceTwo) {		
		return (sourceOne.codOwner 	  	== sourceTwo.codOwner		&&
				sourceOne.codStore 		== sourceTwo.codStore		&&
				sourceOne.codPayPartner == sourceTwo.codPayPartner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
