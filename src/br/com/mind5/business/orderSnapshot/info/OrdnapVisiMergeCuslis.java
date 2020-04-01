package br.com.mind5.business.orderSnapshot.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdnapVisiMergeCuslis implements InfoMergerVisitor_<OrdnapInfo, CuslisInfo> {

	@Override public OrdnapInfo writeRecord(CuslisInfo sourceOne, OrdnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrdnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CuslisInfo sourceOne, OrdnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrdnapInfo makeClone(OrdnapInfo recordInfo) {
		try {
			return (OrdnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OrdnapInfo merge(CuslisInfo sourceOne, OrdnapInfo sourceTwo) {
		sourceTwo.codCustomerSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CuslisInfo sourceOne, OrdnapInfo sourceTwo) {		
		return (sourceOne.codOwner     == sourceTwo.codOwner &&
				sourceOne.codCustomer  == sourceTwo.codCustomer);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
