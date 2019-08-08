package br.com.gda.payment.refundOrderItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.payment.customerPartner.info.CusparInfo;

final class RefemVisiMergeCuspar implements InfoMergerVisitor<RefemInfo, CusparInfo> {

	@Override public RefemInfo writeRecord(CusparInfo sourceOne, RefemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		RefemInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CusparInfo sourceOne, RefemInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private RefemInfo makeClone(RefemInfo recordInfo) {
		try {
			return (RefemInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private RefemInfo merge(CusparInfo sourceOne, RefemInfo sourceTwo) {
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
	
	
	
	@Override public boolean shouldWrite(CusparInfo sourceOne, RefemInfo sourceTwo) {		
		return (sourceOne.codOwner 		 == sourceTwo.codOwner	&&
				sourceOne.codPayCustomer == sourceTwo.codPayCustomer);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
