package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddresnapVisiMergeCuslis implements InfoMergerVisitor_<AddresnapInfo, CuslisInfo> {

	@Override public AddresnapInfo writeRecord(CuslisInfo sourceOne, AddresnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		AddresnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CuslisInfo sourceOne, AddresnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private AddresnapInfo makeClone(AddresnapInfo recordInfo) {
		try {
			return (AddresnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private AddresnapInfo merge(CuslisInfo sourceOne, AddresnapInfo sourceTwo) {
		sourceTwo.codCustomerSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CuslisInfo sourceOne, AddresnapInfo sourceTwo) {
		return (sourceOne.codOwner  	== sourceTwo.codOwner	&&
				sourceOne.codCustomer 	== sourceTwo.codCustomer);
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
