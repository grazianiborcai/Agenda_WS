package br.com.gda.payment.creditCard.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class CrecardVisiMergePhone implements InfoMergerVisitorV2<CrecardInfo, PhoneInfo> {

	@Override public CrecardInfo writeRecord(PhoneInfo sourceOne, CrecardInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CrecardInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PhoneInfo sourceOne, CrecardInfo sourceTwo) {
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
	
	
	
	private CrecardInfo merge(PhoneInfo sourceOne, CrecardInfo sourceTwo) {
		sourceTwo.phoneData = makeClone(sourceOne);
		sourceTwo.codPhoneSnapshotHolder = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	private PhoneInfo makeClone(PhoneInfo recordInfo) {
		try {
			return (PhoneInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	@Override public boolean shouldWrite(PhoneInfo sourceOne, CrecardInfo sourceTwo) {		
		return (sourceOne.codOwner 	 == sourceTwo.codOwner		&&
				sourceOne.codPhone == sourceTwo.codPhoneHolder		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
