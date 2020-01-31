package br.com.mind5.payment.countryPartner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CounparVisiMergePaypar implements InfoMergerVisitor_<CounparInfo, PayparInfo> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;

	@Override public CounparInfo writeRecord(PayparInfo sourceOne, CounparInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CounparInfo clonedInfo = makeClone(sourceTwo);
		clonedInfo.txtPayPartner = sourceOne.txtPayPartner; 
		clonedInfo.description = sourceOne.description;
		return clonedInfo;
	}
	
	
	
	private CounparInfo makeClone(CounparInfo recordInfo) {
		try {
			return (CounparInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void checkArgument(PayparInfo sourceOne, CounparInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(PayparInfo sourceOne, CounparInfo sourceTwo) {
		if (sourceOne.codPayPartner	== sourceTwo.codPayPartner) 
			return SUCCESS;
			
		return FAILED;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
