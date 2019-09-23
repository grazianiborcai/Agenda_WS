package br.com.gda.business.storeSearch.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class SotarchVisiMergeToSelect implements InfoMergerVisitor<SotarchInfo, SotarchInfo> {

	@Override public SotarchInfo writeRecord(SotarchInfo sourceOne, SotarchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SotarchInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(SotarchInfo sourceOne, SotarchInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private SotarchInfo makeClone(SotarchInfo recordInfo) {
		try {
			return (SotarchInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private SotarchInfo merge(SotarchInfo sourceOne, SotarchInfo sourceTwo) {
		sourceTwo.codLanguage = sourceOne.codLanguage;
		sourceTwo.username = sourceOne.username;

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(SotarchInfo sourceOne, SotarchInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
