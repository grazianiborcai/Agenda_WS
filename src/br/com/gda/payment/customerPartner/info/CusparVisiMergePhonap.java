package br.com.gda.payment.customerPartner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class CusparVisiMergePhonap implements InfoMergerVisitorV2<CusparInfo, PhonapInfo> {

	@Override public CusparInfo writeRecord(PhonapInfo sourceOne, CusparInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CusparInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PhonapInfo sourceOne, CusparInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CusparInfo makeClone(CusparInfo recordInfo) {
		try {
			return (CusparInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CusparInfo merge(PhonapInfo sourceOne, CusparInfo sourceTwo) {
		sourceTwo.phonapData = makeClone(sourceOne);
		return sourceTwo;
	}
	
	
	
	private PhonapInfo makeClone(PhonapInfo recordInfo) {
		try {
			return (PhonapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(PhonapInfo sourceOne, CusparInfo sourceTwo) {		
		return (sourceOne.codOwner    == sourceTwo.codOwner		&&
				sourceOne.codPhone    == sourceTwo.codPhone		&&
				sourceOne.codSnapshot == sourceTwo.codPhoneSnapshot);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
