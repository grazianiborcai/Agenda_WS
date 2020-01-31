package br.com.mind5.file.fileImage.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class FimgVisiMergeFath implements InfoMergerVisitor_<FimgInfo, FathInfo> {

	@Override public FimgInfo writeRecord(FathInfo sourceOne, FimgInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		FimgInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(FathInfo sourceOne, FimgInfo sourceTwo) {
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
	
	
	
	private FimgInfo merge(FathInfo sourceOne, FimgInfo sourceTwo) {
		sourceTwo.fileImgPath = sourceOne.filePath;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(FathInfo sourceOne, FimgInfo sourceTwo) {
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
