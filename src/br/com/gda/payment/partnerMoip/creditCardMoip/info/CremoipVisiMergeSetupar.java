package br.com.gda.payment.partnerMoip.creditCardMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

final class CremoipVisiMergeSetupar implements InfoMergerVisitor<CremoipInfo, SetuparInfo> {

	@Override public CremoipInfo writeRecord(SetuparInfo sourceOne, CremoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CremoipInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(SetuparInfo sourceOne, CremoipInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CremoipInfo makeClone(CremoipInfo recordInfo) {
		try {
			return (CremoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CremoipInfo merge(SetuparInfo sourceOne, CremoipInfo sourceTwo) {
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
	
	
	
	@Override public boolean shouldWrite(SetuparInfo sourceOne, CremoipInfo sourceTwo) {
		if (sourceTwo.cusparData == null)
			return false;
		
		return (sourceOne.codPayPartner == sourceTwo.cusparData.codPayPartner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
