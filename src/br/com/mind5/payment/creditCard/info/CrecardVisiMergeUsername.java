package br.com.mind5.payment.creditCard.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.security.username.info.UsernameInfo;

final class CrecardVisiMergeUsername implements InfoMergerVisitor<CrecardInfo, UsernameInfo> {

	@Override public CrecardInfo writeRecord(UsernameInfo sourceOne, CrecardInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CrecardInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UsernameInfo sourceOne, CrecardInfo sourceTwo) {
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
	
	
	
	private CrecardInfo merge(UsernameInfo sourceOne, CrecardInfo sourceTwo) {
		sourceTwo.lastChangedBy = sourceOne.codUser;
		sourceTwo.codUser = sourceOne.codUser;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(UsernameInfo sourceOne, CrecardInfo sourceTwo) {
		if (sourceOne.username == null ||
			sourceTwo.username == null		)
			return false;
		
		return (sourceOne.codOwner == sourceTwo.codOwner		&&
				sourceOne.username.equals(sourceTwo.username)		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
