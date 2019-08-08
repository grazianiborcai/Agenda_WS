package br.com.gda.payment.storePartner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class StoparVisiMergePaypar implements InfoMergerVisitor<StoparInfo, PayparInfo> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;

	@Override public StoparInfo writeRecord(PayparInfo sourceOne, StoparInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StoparInfo clonedInfo = makeClone(sourceTwo);
		clonedInfo.txtPayPartner = sourceOne.txtPayPartner; 
		clonedInfo.description = sourceOne.description;
		return clonedInfo;
	}
	
	
	
	private StoparInfo makeClone(StoparInfo recordInfo) {
		try {
			return (StoparInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void checkArgument(PayparInfo sourceOne, StoparInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(PayparInfo sourceOne, StoparInfo sourceTwo) {
		if (sourceOne.codPayPartner	== sourceTwo.codPayPartner) 
			return SUCCESS;
			
		return FAILED;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
