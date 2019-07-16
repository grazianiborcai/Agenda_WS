package br.com.gda.payment.partnerMoip.orderMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.payment.storePartner.info.StoparInfo;

final class OrdmoipVisiMergeStopar implements InfoMergerVisitorV2<OrdmoipInfo, StoparInfo> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;

	@Override public OrdmoipInfo writeRecord(StoparInfo sourceOne, OrdmoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrdmoipInfo clonedInfo = makeClone(sourceTwo);
		clonedInfo.stoparData = makeClone(sourceOne); 
		
		return clonedInfo;
	}
	
	
	
	private OrdmoipInfo makeClone(OrdmoipInfo recordInfo) {
		try {
			return (OrdmoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private StoparInfo makeClone(StoparInfo recordInfo) {
		try {
			return (StoparInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void checkArgument(StoparInfo sourceOne, OrdmoipInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(StoparInfo sourceOne, OrdmoipInfo sourceTwo) {
		if (sourceOne.codOwner		 == sourceTwo.payordemData.codOwner	&&
			sourceOne.codStore  	 == sourceTwo.payordemData.codStore	&&
			sourceOne.codPayPartner  == sourceTwo.payordemData.codPayPartner) 
			return SUCCESS;
			
		return FAILED;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
