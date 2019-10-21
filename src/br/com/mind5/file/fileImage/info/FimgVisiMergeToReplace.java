package br.com.mind5.file.fileImage.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class FimgVisiMergeToReplace implements InfoMergerVisitor<FimgInfo, FimgInfo> {

	@Override public FimgInfo writeRecord(FimgInfo sourceOne, FimgInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(FimgInfo sourceOne, FimgInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private FimgInfo merge(FimgInfo sourceOne, FimgInfo sourceTwo) {
		FimgInfo result = makeClone(sourceTwo);		
		result.createdBy = sourceOne.createdBy;
		result.createdOn = sourceOne.createdOn;
		return result;
	}
	
	
	
	private FimgInfo makeClone(FimgInfo recordInfo) {
		try {
			return (FimgInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(FimgInfo sourceOne, FimgInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
