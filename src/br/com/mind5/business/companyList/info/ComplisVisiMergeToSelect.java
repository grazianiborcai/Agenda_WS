package br.com.mind5.business.companyList.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class ComplisVisiMergeToSelect implements InfoMergerVisitor_<ComplisInfo, ComplisInfo> {

	@Override public ComplisInfo writeRecord(ComplisInfo sourceOne, ComplisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(ComplisInfo sourceOne, ComplisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private ComplisInfo merge(ComplisInfo sourceOne, ComplisInfo sourceTwo) {
		ComplisInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private ComplisInfo makeClone(ComplisInfo recordInfo) {
		try {
			return (ComplisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(ComplisInfo sourceOne, ComplisInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
