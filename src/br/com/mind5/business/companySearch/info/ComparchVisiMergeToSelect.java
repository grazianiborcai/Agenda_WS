package br.com.mind5.business.companySearch.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class ComparchVisiMergeToSelect implements InfoMergerVisitor_<ComparchInfo, ComparchInfo> {

	@Override public ComparchInfo writeRecord(ComparchInfo sourceOne, ComparchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(ComparchInfo sourceOne, ComparchInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private ComparchInfo merge(ComparchInfo sourceOne, ComparchInfo sourceTwo) {
		ComparchInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private ComparchInfo makeClone(ComparchInfo recordInfo) {
		try {
			return (ComparchInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(ComparchInfo sourceOne, ComparchInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
