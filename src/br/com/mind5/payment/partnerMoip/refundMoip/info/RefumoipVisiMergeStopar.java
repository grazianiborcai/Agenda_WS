package br.com.mind5.payment.partnerMoip.refundMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.payment.storePartner.info.StoparInfo;

final class RefumoipVisiMergeStopar implements InfoMergerVisitor<RefumoipInfo, StoparInfo> {

	@Override public RefumoipInfo writeRecord(StoparInfo sourceOne, RefumoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		RefumoipInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(StoparInfo sourceOne, RefumoipInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private RefumoipInfo makeClone(RefumoipInfo recordInfo) {
		try {
			return (RefumoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private RefumoipInfo merge(StoparInfo sourceOne, RefumoipInfo sourceTwo) {
		sourceTwo.stoparData = makeClone(sourceOne);
		return sourceTwo;
	}
	
	
	
	private StoparInfo makeClone(StoparInfo recordInfo) {
		try {
			return (StoparInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	@Override public boolean shouldWrite(StoparInfo sourceOne, RefumoipInfo sourceTwo) {
		if (sourceTwo.cusparData == null)
			return false;
		
		return (sourceOne.codOwner 		== sourceTwo.codOwner	&&
				sourceOne.codStore 		== sourceTwo.codStore	&&
				sourceOne.codPayPartner == sourceTwo.cusparData.codPayPartner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
