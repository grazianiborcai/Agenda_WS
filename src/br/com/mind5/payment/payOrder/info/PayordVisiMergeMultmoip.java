package br.com.mind5.payment.payOrder.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class PayordVisiMergeMultmoip implements InfoMergerVisitor_<PayordInfo, MultmoipInfo> {

	@Override public PayordInfo writeRecord(MultmoipInfo sourceOne, PayordInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PayordInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MultmoipInfo sourceOne, PayordInfo sourceTwo) {
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
	
	
	
	private PayordInfo merge(MultmoipInfo sourceOne, PayordInfo sourceTwo) {
		sourceTwo.ordmoips = sourceOne.ordmoips;
		sourceTwo.idOrderPartner = sourceOne.idOrderPartner;
		sourceTwo.statusOrderPartner = sourceOne.statusOrderPartner;
		sourceTwo.idPaymentPartner = sourceOne.idPaymentPartner;
		sourceTwo.statusPaymentPartner = sourceOne.statusPaymentPartner;
		sourceTwo.amountTotalPartner = sourceOne.amountTotalPartner;
		sourceTwo.amountCurrencyPartner = sourceOne.amountCurrencyPartner;	
		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(MultmoipInfo sourceOne, PayordInfo sourceTwo) {
		return (sourceOne.codOwner 	 	== sourceTwo.codOwner		&&
				sourceOne.codPayOrder  	== sourceTwo.codPayOrder	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
