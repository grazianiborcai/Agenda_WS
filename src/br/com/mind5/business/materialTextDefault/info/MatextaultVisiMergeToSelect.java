package br.com.mind5.business.materialTextDefault.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatextaultVisiMergeToSelect implements InfoMergerVisitor_<MatextaultInfo, MatextaultInfo> {

	@Override public MatextaultInfo writeRecord(MatextaultInfo sourceOne, MatextaultInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(MatextaultInfo sourceOne, MatextaultInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatextaultInfo merge(MatextaultInfo sourceOne, MatextaultInfo sourceTwo) {
		MatextaultInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		return result;
	}
	
	
	
	private MatextaultInfo makeClone(MatextaultInfo recordInfo) {
		try {
			return (MatextaultInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(MatextaultInfo sourceOne, MatextaultInfo sourceTwo) {	
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
