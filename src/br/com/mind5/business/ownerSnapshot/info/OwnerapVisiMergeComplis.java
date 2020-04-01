package br.com.mind5.business.ownerSnapshot.info;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnerapVisiMergeComplis implements InfoMergerVisitor_<OwnerapInfo, ComplisInfo> {

	@Override public OwnerapInfo writeRecord(ComplisInfo sourceOne, OwnerapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OwnerapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(ComplisInfo sourceOne, OwnerapInfo sourceTwo) {
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
	
	
	
	private OwnerapInfo merge(ComplisInfo sourceOne, OwnerapInfo sourceTwo) {
		sourceTwo.codCompanySnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(ComplisInfo sourceOne, OwnerapInfo sourceTwo) {
		return (sourceOne.codOwner  	== sourceTwo.codOwner	&&
				sourceOne.codCompany 	== sourceTwo.codCompany);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
