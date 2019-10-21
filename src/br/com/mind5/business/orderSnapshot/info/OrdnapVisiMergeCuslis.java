package br.com.mind5.business.orderSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class OrdnapVisiMergeCuslis implements InfoMergerVisitor<OrdnapInfo, CuslisInfo> {

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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
