package br.com.mind5.business.customer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class CusVisiMergeCusnap implements InfoMergerVisitor<CusInfo, CusnapInfo> {

	@Override public CusInfo writeRecord(CusnapInfo sourceOne, CusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CusnapInfo sourceOne, CusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CusInfo makeClone(CusInfo recordInfo) {
		try {
			return (CusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CusInfo merge(CusnapInfo sourceOne, CusInfo sourceTwo) {
		sourceTwo.codSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CusnapInfo sourceOne, CusInfo sourceTwo) {
		return (sourceOne.codOwner 	  == sourceTwo.codOwner	&&
				sourceOne.codCustomer == sourceTwo.codCustomer);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
