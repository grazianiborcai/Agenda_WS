package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StorapVisiMergeComp implements InfoMergerVisitor_<StorapInfo, CompInfo> {

	@Override public StorapInfo writeRecord(CompInfo sourceOne, StorapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StorapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CompInfo sourceOne, StorapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StorapInfo makeClone(StorapInfo recordInfo) {
		try {
			return (StorapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private StorapInfo merge(CompInfo sourceOne, StorapInfo sourceTwo) {
		sourceTwo.codCompanySnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CompInfo sourceOne, StorapInfo sourceTwo) {
		return (sourceOne.codOwner   == sourceTwo.codOwner &&
				sourceOne.codCompany == sourceTwo.codCompany	);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
