package br.com.gda.payment.refundOrder.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class RefuVisiMergePayord implements InfoMergerVisitorV2<RefuInfo, PayordInfo> {

	@Override public RefuInfo writeRecord(PayordInfo sourceOne, RefuInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		RefuInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PayordInfo sourceOne, RefuInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private RefuInfo makeClone(RefuInfo recordInfo) {
		try {
			return (RefuInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private RefuInfo merge(PayordInfo sourceOne, RefuInfo sourceTwo) {
		sourceTwo.payordData =  makeClone(sourceOne);
		return sourceTwo;
	}
	
	
	
	private PayordInfo makeClone(PayordInfo recordInfo) {
		try {
			return (PayordInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(PayordInfo sourceOne, RefuInfo sourceTwo) {		
		return (sourceOne.codOwner 	  == sourceTwo.codOwner	&&
				sourceOne.codPayOrder == sourceTwo.codPayOrder);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
