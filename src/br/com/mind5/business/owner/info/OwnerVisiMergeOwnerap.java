package br.com.mind5.business.owner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class OwnerVisiMergeOwnerap implements InfoMergerVisitor<OwnerInfo, OwnerapInfo> {

	@Override public OwnerInfo writeRecord(OwnerapInfo sourceOne, OwnerInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OwnerInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(OwnerapInfo sourceOne, OwnerInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OwnerInfo makeClone(OwnerInfo recordInfo) {
		try {
			return (OwnerInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OwnerInfo merge(OwnerapInfo sourceOne, OwnerInfo sourceTwo) {
		sourceTwo.codSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OwnerapInfo sourceOne, OwnerInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner); 
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
