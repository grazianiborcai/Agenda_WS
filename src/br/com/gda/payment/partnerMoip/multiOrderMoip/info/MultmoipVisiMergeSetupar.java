package br.com.gda.payment.partnerMoip.multiOrderMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

final class MultmoipVisiMergeSetupar implements InfoMergerVisitorV2<MultmoipInfo, SetuparInfo> {

	@Override public MultmoipInfo writeRecord(SetuparInfo sourceOne, MultmoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MultmoipInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(SetuparInfo sourceOne, MultmoipInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MultmoipInfo makeClone(MultmoipInfo recordInfo) {
		try {
			return (MultmoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MultmoipInfo merge(SetuparInfo sourceOne, MultmoipInfo sourceTwo) {
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
	
	
	
	@Override public boolean shouldWrite(SetuparInfo sourceOne, MultmoipInfo sourceTwo) {
		if (sourceTwo.cusparData == null)
			return false;
		
		return (sourceOne.codPayPartner == sourceTwo.cusparData.codPayPartner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
