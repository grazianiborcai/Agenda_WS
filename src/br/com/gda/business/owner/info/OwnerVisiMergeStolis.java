package br.com.gda.business.owner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OwnerVisiMergeStolis implements InfoMergerVisitor<OwnerInfo, StolisInfo> {

	@Override public OwnerInfo writeRecord(StolisInfo sourceOne, OwnerInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OwnerInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(StolisInfo sourceOne, OwnerInfo sourceTwo) {
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
	
	
	
	private OwnerInfo merge(StolisInfo sourceOne, OwnerInfo sourceTwo) {
		sourceTwo.stolises.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(StolisInfo sourceOne, OwnerInfo sourceTwo) {
		return ( sourceOne.codOwner == sourceTwo.codOwner );
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
