package br.com.mind5.payment.payOrder.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class PayordVisiMergeCrecard implements InfoMergerVisitor<PayordInfo, CrecardInfo> {

	@Override public PayordInfo writeRecord(CrecardInfo sourceOne, PayordInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PayordInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CrecardInfo sourceOne, PayordInfo sourceTwo) {
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
	
	
	
	private PayordInfo merge(CrecardInfo sourceOne, PayordInfo sourceTwo) {
		sourceTwo.crecardData = makeClone(sourceOne);
		return sourceTwo;
	}
	
	
	
	private CrecardInfo makeClone(CrecardInfo recordInfo) {
		try {
			return (CrecardInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	@Override public boolean shouldWrite(CrecardInfo sourceOne, PayordInfo sourceTwo) {
		return (sourceOne.codOwner 	 	 == sourceTwo.codOwner		&&
				sourceOne.codPayPartner  == sourceTwo.codPayPartner	&&
				sourceOne.codPayCustomer == sourceTwo.codPayCustomer	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
