package br.com.mind5.business.company.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CompVisiMergeToDelete implements InfoMergerVisitor_<CompInfo, CompInfo> {

	@Override public CompInfo writeRecord(CompInfo sourceOne, CompInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CompInfo sourceOne, CompInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CompInfo merge(CompInfo sourceOne, CompInfo sourceTwo) {
		CompInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private CompInfo makeClone(CompInfo recordInfo) {
		try {
			return (CompInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(CompInfo sourceOne, CompInfo sourceTwo) {		
		return (sourceOne.codOwner   == sourceTwo.codOwner 		&&
				sourceOne.codCompany == sourceTwo.codCompany		);
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
