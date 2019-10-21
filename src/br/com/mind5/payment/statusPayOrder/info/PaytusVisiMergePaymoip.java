package br.com.mind5.payment.statusPayOrder.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

final class PaytusVisiMergePaymoip implements InfoMergerVisitor<PaytusInfo, PaymoipInfo> {

	@Override public PaytusInfo writeRecord(PaymoipInfo sourceOne, PaytusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PaytusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PaymoipInfo sourceOne, PaytusInfo sourceTwo) {
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
	
	
	
	private PaytusInfo merge(PaymoipInfo sourceOne, PaytusInfo sourceTwo) {
		sourceTwo.idPaymentPartner = sourceOne.idPaymentPartner;
		sourceTwo.statusPaymentPartner = sourceOne.statusPaymentPartner;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PaymoipInfo sourceOne, PaytusInfo sourceTwo) {
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
