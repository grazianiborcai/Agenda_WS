package br.com.mind5.payment.storePartnerSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class StoparnapVisiMergePaypar implements InfoMergerVisitor<StoparnapInfo, PayparInfo> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;

	@Override public StoparnapInfo writeRecord(PayparInfo sourceOne, StoparnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StoparnapInfo clonedInfo = makeClone(sourceTwo);
		clonedInfo.txtPayPartner = sourceOne.txtPayPartner; 
		clonedInfo.description = sourceOne.description;
		return clonedInfo;
	}
	
	
	
	private StoparnapInfo makeClone(StoparnapInfo recordInfo) {
		try {
			return (StoparnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void checkArgument(PayparInfo sourceOne, StoparnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(PayparInfo sourceOne, StoparnapInfo sourceTwo) {
		if (sourceOne.codPayPartner	== sourceTwo.codPayPartner) 
			return SUCCESS;
			
		return FAILED;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
