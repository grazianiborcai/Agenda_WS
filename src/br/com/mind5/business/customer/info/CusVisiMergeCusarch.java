package br.com.mind5.business.customer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class CusVisiMergeCusarch implements InfoMergerVisitor<CusInfo, CusarchInfo> {

	@Override public CusInfo writeRecord(CusarchInfo sourceOne, CusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CusarchInfo sourceOne, CusInfo sourceTwo) {
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
	
	
	
	private CusInfo merge(CusarchInfo sourceOne, CusInfo sourceTwo) {
		sourceTwo.codUser = sourceOne.codUser;
		sourceTwo.codCustomer = sourceOne.codCustomer;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CusarchInfo sourceOne, CusInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
