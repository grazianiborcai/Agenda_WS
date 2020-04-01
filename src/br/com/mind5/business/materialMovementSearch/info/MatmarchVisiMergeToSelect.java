package br.com.mind5.business.materialMovementSearch.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatmarchVisiMergeToSelect implements InfoMergerVisitor_<MatmarchInfo, MatmarchInfo> {

	@Override public MatmarchInfo writeRecord(MatmarchInfo sourceOne, MatmarchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(MatmarchInfo sourceOne, MatmarchInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatmarchInfo merge(MatmarchInfo sourceOne, MatmarchInfo sourceTwo) {
		MatmarchInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private MatmarchInfo makeClone(MatmarchInfo recordInfo) {
		try {
			return (MatmarchInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(MatmarchInfo sourceOne, MatmarchInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
