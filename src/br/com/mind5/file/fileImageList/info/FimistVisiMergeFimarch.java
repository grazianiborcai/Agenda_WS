package br.com.mind5.file.fileImageList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class FimistVisiMergeFimarch implements InfoMergerVisitor_<FimistInfo, FimarchInfo> {

	@Override public FimistInfo writeRecord(FimarchInfo sourceOne, FimistInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		FimistInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(FimarchInfo sourceOne, FimistInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private FimistInfo makeClone(FimistInfo recordInfo) {
		try {
			return (FimistInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private FimistInfo merge(FimarchInfo sourceOne, FimistInfo sourceTwo) {
		return FimistInfo.copyFrom(sourceOne);
	}
	
	
	
	@Override public boolean shouldWrite(FimarchInfo sourceOne, FimistInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
