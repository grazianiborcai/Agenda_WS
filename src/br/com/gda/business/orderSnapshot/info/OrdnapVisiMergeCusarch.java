package br.com.gda.business.orderSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrdnapVisiMergeCusarch implements InfoMergerVisitor<OrdnapInfo, CusarchInfo> {

	@Override public OrdnapInfo writeRecord(CusarchInfo sourceOne, OrdnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrdnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CusarchInfo sourceOne, OrdnapInfo sourceTwo) {
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
	
	
	
	private OrdnapInfo merge(CusarchInfo sourceOne, OrdnapInfo sourceTwo) {
		sourceTwo.codCustomer = sourceOne.codCustomer;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CusarchInfo sourceOne, OrdnapInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codUser  == sourceTwo.codUser);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
