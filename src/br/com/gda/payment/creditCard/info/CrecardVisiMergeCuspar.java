package br.com.gda.payment.creditCard.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.payment.customerPartner.info.CusparInfo;

final class CrecardVisiMergeCuspar implements InfoMergerVisitorV2<CrecardInfo, CusparInfo> {

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
		sourceTwo.codPayPartner = sourceOne.codPayPartner;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CusparInfo sourceOne, CrecardInfo sourceTwo) {
		return (sourceOne.codOwner		 == sourceTwo.codOwner			&&
				sourceOne.codPayCustomer == sourceTwo.codPayCustomer		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
