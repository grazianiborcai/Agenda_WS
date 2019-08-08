package br.com.gda.payment.storePartner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapInfo;

final class StoparVisiMergeStoparnap implements InfoMergerVisitor<StoparInfo, StoparnapInfo> {

	@Override public StoparInfo writeRecord(StoparnapInfo sourceOne, StoparInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StoparInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(StoparnapInfo sourceOne, StoparInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StoparInfo makeClone(StoparInfo recordInfo) {
		try {
			return (StoparInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private StoparInfo merge(StoparnapInfo sourceOne, StoparInfo sourceTwo) {
		sourceTwo.codSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(StoparnapInfo sourceOne, StoparInfo sourceTwo) {		
		return (sourceOne.codOwner 	  	== sourceTwo.codOwner		&&
				sourceOne.codStore 		== sourceTwo.codStore		&&
				sourceOne.codPayPartner == sourceTwo.codPayPartner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
