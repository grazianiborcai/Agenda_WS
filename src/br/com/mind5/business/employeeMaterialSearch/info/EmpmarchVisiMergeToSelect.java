package br.com.mind5.business.employeeMaterialSearch.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpmarchVisiMergeToSelect implements InfoMergerVisitor_<EmpmarchInfo, EmpmarchInfo> {

	@Override public EmpmarchInfo writeRecord(EmpmarchInfo sourceOne, EmpmarchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(EmpmarchInfo sourceOne, EmpmarchInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpmarchInfo merge(EmpmarchInfo sourceOne, EmpmarchInfo sourceTwo) {
		EmpmarchInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private EmpmarchInfo makeClone(EmpmarchInfo recordInfo) {
		try {
			return (EmpmarchInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(EmpmarchInfo sourceOne, EmpmarchInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
