package br.com.gda.business.customerSearch.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class CusarchVisiMergeToSelect implements InfoMergerVisitorV2<CusarchInfo, CusarchInfo> {

	@Override public CusarchInfo writeRecord(CusarchInfo sourceOne, CusarchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CusarchInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CusarchInfo sourceOne, CusarchInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CusarchInfo makeClone(CusarchInfo recordInfo) {
		try {
			return (CusarchInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CusarchInfo merge(CusarchInfo sourceOne, CusarchInfo sourceTwo) {
		sourceTwo.codLanguage = sourceOne.codLanguage;
		sourceTwo.username = sourceOne.username;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CusarchInfo sourceOne, CusarchInfo sourceTwo) {
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
