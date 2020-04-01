package br.com.mind5.business.materialMovement.info;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatmovVisiMergeMatmarch implements InfoMergerVisitor_<MatmovInfo, MatmarchInfo> {

	@Override public MatmovInfo writeRecord(MatmarchInfo sourceOne, MatmovInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatmovInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatmarchInfo sourceOne, MatmovInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatmovInfo makeClone(MatmovInfo recordInfo) {
		try {
			return (MatmovInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MatmovInfo merge(MatmarchInfo sourceOne, MatmovInfo sourceTwo) {
		return MatmovInfo.copyFrom(sourceOne);
	}
	
	
	
	@Override public boolean shouldWrite(MatmarchInfo sourceOne, MatmovInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
