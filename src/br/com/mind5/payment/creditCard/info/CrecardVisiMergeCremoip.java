package br.com.mind5.payment.creditCard.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

final class CrecardVisiMergeCremoip implements InfoMergerVisitor_<CrecardInfo, CremoipInfo> {

	@Override public CrecardInfo writeRecord(CremoipInfo sourceOne, CrecardInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CrecardInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CremoipInfo sourceOne, CrecardInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CrecardInfo makeClone(CrecardInfo recordInfo) {
		try {
			return (CrecardInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CrecardInfo merge(CremoipInfo sourceOne, CrecardInfo sourceTwo) {
		sourceTwo.creditCardId = sourceOne.creditCardId;
		sourceTwo.creditCardBrand = sourceOne.creditCardBrand;
		sourceTwo.creditCardLast4 = sourceOne.creditCardLast4;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CremoipInfo sourceOne, CrecardInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
