package br.com.gda.business.customerSearch.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor_;

final class CusarchVisiMergeLangu implements InfoMergerVisitor_<CusarchInfo, LanguInfo, CusarchInfo> {

	@Override public CusarchInfo writeRecord(LanguInfo sourceOne, CusarchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CusarchInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(LanguInfo sourceOne, CusarchInfo sourceTwo) {
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
	
	
	
	private CusarchInfo merge(LanguInfo sourceOne, CusarchInfo sourceTwo) {
		sourceTwo.codLanguage = sourceOne.codLanguage;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(LanguInfo sourceOne, CusarchInfo sourceTwo) {
		if (sourceOne.codLanguage == null ||
			sourceTwo.codLanguage == null		)
			return false;
		
		
		return (sourceOne.codLanguage.equals(sourceTwo.codLanguage));
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
