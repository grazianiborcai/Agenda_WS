package br.com.gda.file.fileUpload.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.file.filePath.info.FathInfo;
import br.com.gda.info.InfoMergerVisitor;

final class FilupVisiMergeFath implements InfoMergerVisitor<FilupInfo, FathInfo> {

	@Override public FilupInfo writeRecord(FathInfo sourceOne, FilupInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		FilupInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(FathInfo sourceOne, FilupInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private FilupInfo makeClone(FilupInfo recordInfo) {
		try {
			return (FilupInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private FilupInfo merge(FathInfo sourceOne, FilupInfo sourceTwo) {
		sourceTwo.fileImgPath = sourceOne.filePath;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(FathInfo sourceOne, FilupInfo sourceTwo) {
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
