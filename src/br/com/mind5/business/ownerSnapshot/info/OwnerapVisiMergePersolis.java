package br.com.mind5.business.ownerSnapshot.info;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnerapVisiMergePersolis implements InfoMergerVisitor_<OwnerapInfo, PersolisInfo> {

	@Override public OwnerapInfo writeRecord(PersolisInfo sourceOne, OwnerapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OwnerapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersolisInfo sourceOne, OwnerapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OwnerapInfo makeClone(OwnerapInfo recordInfo) {
		try {
			return (OwnerapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OwnerapInfo merge(PersolisInfo sourceOne, OwnerapInfo sourceTwo) {
		sourceTwo.codPersonSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PersolisInfo sourceOne, OwnerapInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner	&&
				sourceOne.codPerson == sourceTwo.codPerson);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
