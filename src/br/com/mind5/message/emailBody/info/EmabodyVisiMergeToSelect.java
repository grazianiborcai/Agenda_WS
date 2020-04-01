package br.com.mind5.message.emailBody.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmabodyVisiMergeToSelect implements InfoMergerVisitor_<EmabodyInfo, EmabodyInfo> {

	@Override public EmabodyInfo writeRecord(EmabodyInfo sourceOne, EmabodyInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(EmabodyInfo sourceOne, EmabodyInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmabodyInfo merge(EmabodyInfo sourceOne, EmabodyInfo sourceTwo) {
		EmabodyInfo result = makeClone(sourceOne);	
		result.param01 = sourceTwo.param01;
		result.param02 = sourceTwo.param02;
		result.param03 = sourceTwo.param03;
		result.param04 = sourceTwo.param04;
		result.param05 = sourceTwo.param05;
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private EmabodyInfo makeClone(EmabodyInfo recordInfo) {
		try {
			return (EmabodyInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(EmabodyInfo sourceOne, EmabodyInfo sourceTwo) {		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
