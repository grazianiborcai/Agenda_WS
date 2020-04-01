package br.com.mind5.business.materialText.info;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatextVisiMergeMatextarch implements InfoMergerVisitor_<MatextInfo, MatextarchInfo> {

	@Override public MatextInfo writeRecord(MatextarchInfo sourceOne, MatextInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatextInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatextarchInfo sourceOne, MatextInfo sourceTwo) {
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
	
	
	
	private MatextInfo merge(MatextarchInfo sourceOne, MatextInfo sourceTwo) {
		return MatextInfo.copyFrom(sourceOne);
	}


	
	@Override public boolean shouldWrite(MatextarchInfo sourceOne, MatextInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}		
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
