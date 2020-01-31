package br.com.mind5.business.orderList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdistVisiMergeCurrency implements InfoMergerVisitor_<OrdistInfo, CurrencyInfo> {

	@Override public OrdistInfo writeRecord(CurrencyInfo sourceOne, OrdistInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrdistInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CurrencyInfo sourceOne, OrdistInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrdistInfo makeClone(OrdistInfo recordInfo) {
		try {
			return (OrdistInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OrdistInfo merge(CurrencyInfo sourceOne, OrdistInfo sourceTwo) {
		sourceTwo.txtCurr = sourceOne.txtCurr;

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CurrencyInfo sourceOne, OrdistInfo sourceTwo) {
		return (sourceOne.codCurr.equals(sourceTwo.codCurr));
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
