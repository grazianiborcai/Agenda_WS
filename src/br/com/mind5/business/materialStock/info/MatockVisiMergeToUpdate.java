package br.com.mind5.business.materialStock.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatockVisiMergeToUpdate implements InfoMergerVisitor_<MatockInfo, MatockInfo> {

	@Override public MatockInfo writeRecord(MatockInfo sourceOne, MatockInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(MatockInfo sourceOne, MatockInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatockInfo merge(MatockInfo sourceOne, MatockInfo sourceTwo) {
		MatockInfo result = makeClone(sourceOne);		
		result.quantityToUpdate = sourceTwo.quantityToUpdate;
		result.codMatmovType = sourceTwo.codMatmovType;
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private MatockInfo makeClone(MatockInfo recordInfo) {
		try {
			return (MatockInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(MatockInfo sourceOne, MatockInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner	&& 
				sourceOne.codStore == sourceTwo.codStore	&&
				sourceOne.codMat   == sourceTwo.codMat		);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
