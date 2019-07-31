package br.com.gda.payment.statusPayOrderItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

final class PaytusemVisiMergeOrdmoip implements InfoMergerVisitorV2<PaytusemInfo, OrdmoipInfo> {

	@Override public PaytusemInfo writeRecord(OrdmoipInfo sourceOne, PaytusemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PaytusemInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(OrdmoipInfo sourceOne, PaytusemInfo sourceTwo) {
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
	
	
	
	private PaytusemInfo merge(OrdmoipInfo sourceOne, PaytusemInfo sourceTwo) {
		sourceTwo.statusOrderPartner = sourceOne.statusOrderPartner;	
		sourceTwo.idPaymentPartner = sourceOne.idPaymentPartner;
		sourceTwo.statusPaymentPartner = sourceOne.statusPaymentPartner;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OrdmoipInfo sourceOne, PaytusemInfo sourceTwo) {
		if (sourceOne.idOrderPartner == null ||
			sourceTwo.idOrderPartner == null	)
			return false;
		
		return (sourceOne.idOrderPartner.equals(sourceTwo.idOrderPartner));
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
