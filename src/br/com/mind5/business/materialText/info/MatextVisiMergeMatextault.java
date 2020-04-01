package br.com.mind5.business.materialText.info;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatextVisiMergeMatextault implements InfoMergerVisitor_<MatextInfo, MatextaultInfo> {

	@Override public MatextInfo writeRecord(MatextaultInfo sourceOne, MatextInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatextInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatextaultInfo sourceOne, MatextInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatextInfo makeClone(MatextInfo recordInfo) {
		try {
			return (MatextInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MatextInfo merge(MatextaultInfo sourceOne, MatextInfo sourceTwo) {
		return MatextInfo.copyFrom(sourceOne);
	}


	
	@Override public boolean shouldWrite(MatextaultInfo sourceOne, MatextInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}		
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
