package br.com.mind5.payment.creditCard.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CrecardVisiMergeToUpdate implements InfoMergerVisitor_<CrecardInfo, CrecardInfo> {

	@Override public CrecardInfo writeRecord(CrecardInfo sourceOne, CrecardInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CrecardInfo sourceOne, CrecardInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CrecardInfo merge(CrecardInfo sourceOne, CrecardInfo sourceTwo) {		
		CrecardInfo result = makeClone(sourceTwo);		
		result.codCreditCard = sourceOne.codCreditCard;
		return result;
	}
	
	
	
	private CrecardInfo makeClone(CrecardInfo recordInfo) {
		try {
			return (CrecardInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(CrecardInfo sourceOne, CrecardInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
