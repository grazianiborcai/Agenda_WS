package br.com.mind5.business.owner.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnerVisiMergeFimist implements InfoMergerVisitor_<OwnerInfo, FimistInfo> {

	@Override public OwnerInfo writeRecord(FimistInfo sourceOne, OwnerInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OwnerInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(FimistInfo sourceOne, OwnerInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OwnerInfo makeClone(OwnerInfo recordInfo) {
		try {
			return (OwnerInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OwnerInfo merge(FimistInfo sourceOne, OwnerInfo sourceTwo) {
		sourceTwo.fimistData = sourceOne;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(FimistInfo sourceOne, OwnerInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
