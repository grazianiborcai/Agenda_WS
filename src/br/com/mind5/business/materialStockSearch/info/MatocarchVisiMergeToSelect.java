package br.com.mind5.business.materialStockSearch.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatocarchVisiMergeToSelect implements InfoMergerVisitor_<MatocarchInfo, MatocarchInfo> {

	@Override public MatocarchInfo writeRecord(MatocarchInfo sourceOne, MatocarchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(MatocarchInfo sourceOne, MatocarchInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatocarchInfo merge(MatocarchInfo sourceOne, MatocarchInfo sourceTwo) {
		MatocarchInfo result = makeClone(sourceOne);
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private MatocarchInfo makeClone(MatocarchInfo recordInfo) {
		try {
			return (MatocarchInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(MatocarchInfo sourceOne, MatocarchInfo sourceTwo) {		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
