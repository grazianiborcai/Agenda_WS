package br.com.mind5.business.storeLeaveDate.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.security.username.info.UsernameInfo;

final class StolateVisiMergeUsername implements InfoMergerVisitor<StolateInfo, UsernameInfo> {

	@Override public StolateInfo writeRecord(UsernameInfo sourceOne, StolateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StolateInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UsernameInfo sourceOne, StolateInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StolateInfo makeClone(StolateInfo recordInfo) {
		try {
			return (StolateInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private StolateInfo merge(UsernameInfo sourceOne, StolateInfo sourceTwo) {
		sourceTwo.lastChangedBy = sourceOne.codUser;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(UsernameInfo sourceOne, StolateInfo sourceTwo) {
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
