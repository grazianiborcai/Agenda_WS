package br.com.mind5.business.owner.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnerVisiMergeToUpdate implements InfoMergerVisitor_<OwnerInfo, OwnerInfo> {

	@Override public OwnerInfo writeRecord(OwnerInfo sourceOne, OwnerInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(OwnerInfo sourceOne, OwnerInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OwnerInfo merge(OwnerInfo sourceOne, OwnerInfo sourceTwo) {
		OwnerInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		
		if (sourceTwo.addresses != null)
			result.addresses = sourceTwo.addresses;
		
		if (sourceTwo.phones != null)
			result.phones = sourceTwo.phones;
		
		if (sourceTwo.userData != null)
			result.companyData = sourceTwo.companyData;
		
		if (sourceTwo.personData != null)
			result.personData = sourceTwo.personData;
		
		return result;
	}
	
	
	
	private OwnerInfo makeClone(OwnerInfo recordInfo) {
		try {
			return (OwnerInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(OwnerInfo sourceOne, OwnerInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
