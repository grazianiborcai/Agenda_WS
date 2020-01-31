package br.com.mind5.business.employeeList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmplisVisiMergeFimist implements InfoMergerVisitor_<EmplisInfo, FimistInfo> {

	@Override public EmplisInfo writeRecord(FimistInfo sourceOne, EmplisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmplisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(FimistInfo sourceOne, EmplisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmplisInfo makeClone(EmplisInfo recordInfo) {
		try {
			return (EmplisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmplisInfo merge(FimistInfo sourceOne, EmplisInfo sourceTwo) {
		sourceTwo.fimistData = sourceOne;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(FimistInfo sourceOne, EmplisInfo sourceTwo) {
		return (sourceOne.codOwner    == sourceTwo.codOwner 	&&
				sourceOne.codEmployee == sourceTwo.codEmployee		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
