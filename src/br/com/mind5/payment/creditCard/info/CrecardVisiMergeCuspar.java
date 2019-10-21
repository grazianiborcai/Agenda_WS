package br.com.mind5.payment.creditCard.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class CrecardVisiMergeCuspar implements InfoMergerVisitor<CrecardInfo, CusparInfo> {

	@Override public CrecardInfo writeRecord(CusparInfo sourceOne, CrecardInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CrecardInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CusparInfo sourceOne, CrecardInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CrecardInfo makeClone(CrecardInfo recordInfo) {
		try {
			return (CrecardInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CrecardInfo merge(CusparInfo sourceOne, CrecardInfo sourceTwo) {
		sourceTwo.cusparData = makeClone(sourceOne);
		sourceTwo.codPayPartner = sourceOne.codPayPartner;
		sourceTwo.codPayCustomer = sourceOne.codPayCustomer;
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
	
	
	
	@Override public boolean shouldWrite(CusparInfo sourceOne, CrecardInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
