package br.com.gda.payment.customerPartner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

final class CusparVisiMergeSetupar implements InfoMergerVisitor<CusparInfo, SetuparInfo> {

	@Override public CusparInfo writeRecord(SetuparInfo sourceOne, CusparInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CusparInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(SetuparInfo sourceOne, CusparInfo sourceTwo) {
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
	
	
	
	private CusparInfo merge(SetuparInfo sourceOne, CusparInfo sourceTwo) {
		sourceTwo.setuparData = makeClone(sourceOne);
		return sourceTwo;
	}
	
	
	
	private SetuparInfo makeClone(SetuparInfo recordInfo) {
		try {
			return (SetuparInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(SetuparInfo sourceOne, CusparInfo sourceTwo) {
		
		return (sourceOne.codPayPartner == sourceTwo.codPayPartner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
