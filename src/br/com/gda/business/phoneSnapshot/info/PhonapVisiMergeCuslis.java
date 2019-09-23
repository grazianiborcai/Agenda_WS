package br.com.gda.business.phoneSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PhonapVisiMergeCuslis implements InfoMergerVisitor<PhonapInfo, CuslisInfo> {

	@Override public PhonapInfo writeRecord(CuslisInfo sourceOne, PhonapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PhonapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CuslisInfo sourceOne, PhonapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PhonapInfo makeClone(PhonapInfo recordInfo) {
		try {
			return (PhonapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PhonapInfo merge(CuslisInfo sourceOne, PhonapInfo sourceTwo) {
		sourceTwo.codCustomerSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CuslisInfo sourceOne, PhonapInfo sourceTwo) {
		return (sourceOne.codOwner  	== sourceTwo.codOwner	&&
				sourceOne.codCustomer 	== sourceTwo.codCustomer);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
