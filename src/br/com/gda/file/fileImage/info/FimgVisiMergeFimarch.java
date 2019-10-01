package br.com.gda.file.fileImage.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.file.fileImageSearch.info.FimarchInfo;
import br.com.gda.info.InfoMergerVisitor;

final class FimgVisiMergeFimarch implements InfoMergerVisitor<FimgInfo, FimarchInfo> {

	@Override public FimgInfo writeRecord(FimarchInfo sourceOne, FimgInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		FimgInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(FimarchInfo sourceOne, FimgInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private FimgInfo makeClone(FimgInfo recordInfo) {
		try {
			return (FimgInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private FimgInfo merge(FimarchInfo sourceOne, FimgInfo sourceTwo) {
		sourceTwo.codFileImg = sourceOne.codFileImg;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(FimarchInfo sourceOne, FimgInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
