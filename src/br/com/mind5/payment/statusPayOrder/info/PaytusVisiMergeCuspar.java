package br.com.mind5.payment.statusPayOrder.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class PaytusVisiMergeCuspar implements InfoMergerVisitor_<PaytusInfo, CusparInfo> {

	@Override public PaytusInfo writeRecord(CusparInfo sourceOne, PaytusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PaytusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CusparInfo sourceOne, PaytusInfo sourceTwo) {
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
	
	
	
	private PaytusInfo merge(CusparInfo sourceOne, PaytusInfo sourceTwo) {
		sourceTwo.cusparData = makeClone(sourceOne);
		return sourceTwo;
	}
	
	
	
	private CusparInfo makeClone(CusparInfo recordInfo) {
		try {
			return (CusparInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(CusparInfo sourceOne, PaytusInfo sourceTwo) {		
		return (sourceOne.codOwner 		 == sourceTwo.codOwner	&&
				sourceOne.codPayCustomer == sourceTwo.codPayCustomer);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
