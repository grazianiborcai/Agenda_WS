package br.com.mind5.business.ownerList.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnelisVisiMergeToSelect implements InfoMergerVisitor_<OwnelisInfo, OwnelisInfo> {

	@Override public OwnelisInfo writeRecord(OwnelisInfo sourceOne, OwnelisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(OwnelisInfo sourceOne, OwnelisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OwnelisInfo merge(OwnelisInfo sourceOne, OwnelisInfo sourceTwo) {
		OwnelisInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private OwnelisInfo makeClone(OwnelisInfo recordInfo) {
		try {
			return (OwnelisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(OwnelisInfo sourceOne, OwnelisInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
