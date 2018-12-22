package br.com.gda.business.materialSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatSnapVisitorCurrency implements InfoMergerVisitor<MatSnapInfo, CurrencyInfo, MatSnapInfo> {

	@Override public MatSnapInfo writeRecord(CurrencyInfo sourceOne, MatSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatSnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CurrencyInfo sourceOne, MatSnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatSnapInfo makeClone(MatSnapInfo recordInfo) {
		try {
			return (MatSnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MatSnapInfo merge(CurrencyInfo sourceOne, MatSnapInfo sourceTwo) {
		sourceTwo.codCurr = sourceOne.codCurr;
		sourceTwo.txtCurr = sourceOne.txtCurr;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(CurrencyInfo sourceOne, MatSnapInfo sourceTwo) {
		return (sourceTwo.codCurr.equals(sourceOne.codCurr));
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
