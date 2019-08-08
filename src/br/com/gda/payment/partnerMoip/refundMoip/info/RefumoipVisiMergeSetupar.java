package br.com.gda.payment.partnerMoip.refundMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

final class RefumoipVisiMergeSetupar implements InfoMergerVisitor<RefumoipInfo, SetuparInfo> {

	@Override public RefumoipInfo writeRecord(SetuparInfo sourceOne, RefumoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		RefumoipInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(SetuparInfo sourceOne, RefumoipInfo sourceTwo) {
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
	
	
	
	private RefumoipInfo merge(SetuparInfo sourceOne, RefumoipInfo sourceTwo) {
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
	
	
	
	@Override public boolean shouldWrite(SetuparInfo sourceOne, RefumoipInfo sourceTwo) {
		if (sourceTwo.cusparData == null)
			return false;
		
		return (sourceOne.codPayPartner == sourceTwo.cusparData.codPayPartner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
