package br.com.gda.business.owner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OwnerVisiMergeOwntore implements InfoMergerVisitor<OwnerInfo, OwntoreInfo, OwnerInfo> {

	@Override public OwnerInfo writeRecord(OwntoreInfo sourceOne, OwnerInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OwnerInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(OwntoreInfo sourceOne, OwnerInfo sourceTwo) {
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
	
	
	
	private OwnerInfo merge(OwntoreInfo sourceOne, OwnerInfo sourceTwo) {
		sourceTwo.owntores.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OwntoreInfo sourceOne, OwnerInfo sourceTwo) {
		return ( sourceOne.codOwner == sourceTwo.codOwner );
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
