package br.com.mind5.business.customerSearch.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CusarchVisiMergeToSelect implements InfoMergerVisitor_<CusarchInfo, CusarchInfo> {

	@Override public CusarchInfo writeRecord(CusarchInfo sourceOne, CusarchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CusarchInfo clonedInfo = makeClone(sourceOne);
		return merge(clonedInfo, sourceTwo);
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
		sourceOne.codLanguage = sourceTwo.codLanguage;
		sourceOne.username = sourceTwo.username;
		return sourceOne;
	}
	
	
	
	@Override public boolean shouldWrite(CusarchInfo sourceOne, CusarchInfo sourceTwo) {
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
