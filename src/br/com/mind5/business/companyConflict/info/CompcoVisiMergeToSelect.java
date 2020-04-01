package br.com.mind5.business.companyConflict.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CompcoVisiMergeToSelect implements InfoMergerVisitor_<CompcoInfo, CompcoInfo> {

	@Override public CompcoInfo writeRecord(CompcoInfo sourceOne, CompcoInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CompcoInfo sourceOne, CompcoInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CompcoInfo merge(CompcoInfo sourceOne, CompcoInfo sourceTwo) {
		CompcoInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private CompcoInfo makeClone(CompcoInfo recordInfo) {
		try {
			return (CompcoInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(CompcoInfo sourceOne, CompcoInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
