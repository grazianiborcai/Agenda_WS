package br.com.gda.payment.statusPayOrder.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class PaytusVisiMergeMultmoip implements InfoMergerVisitor<PaytusInfo, MultmoipInfo> {

	@Override public PaytusInfo writeRecord(MultmoipInfo sourceOne, PaytusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PaytusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MultmoipInfo sourceOne, PaytusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PaytusInfo makeClone(PaytusInfo recordInfo) {
		try {
			return (PaytusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PaytusInfo merge(MultmoipInfo sourceOne, PaytusInfo sourceTwo) {
		sourceTwo.statusOrderPartner = sourceOne.statusOrderPartner;	
		sourceTwo.idPaymentPartner = sourceOne.idPaymentPartner;
		sourceTwo.statusPaymentPartner = sourceOne.statusPaymentPartner;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(MultmoipInfo sourceOne, PaytusInfo sourceTwo) {
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
