package br.com.mind5.business.orderList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class OrdistVisiMergeToSelect implements InfoMergerVisitor<OrdistInfo, OrdistInfo> {

	@Override public OrdistInfo writeRecord(OrdistInfo sourceOne, OrdistInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(OrdistInfo sourceOne, OrdistInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrdistInfo merge(OrdistInfo sourceOne, OrdistInfo sourceTwo) {
		OrdistInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private OrdistInfo makeClone(OrdistInfo recordInfo) {
		try {
			return (OrdistInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(OrdistInfo sourceOne, OrdistInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
