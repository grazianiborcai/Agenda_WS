package br.com.mind5.business.storeList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolisVisiMergeCurrency implements InfoMergerVisitor_<StolisInfo, CurrencyInfo> {

	@Override public StolisInfo writeRecord(CurrencyInfo sourceOne, StolisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StolisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CurrencyInfo sourceOne, StolisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StolisInfo makeClone(StolisInfo recordInfo) {
		try {
			return (StolisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private StolisInfo merge(CurrencyInfo sourceOne, StolisInfo sourceTwo) {
		sourceTwo.txtCurr = sourceOne.txtCurr;

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CurrencyInfo sourceOne, StolisInfo sourceTwo) {
		return (sourceOne.codCurr.equals(sourceTwo.codCurr));
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
