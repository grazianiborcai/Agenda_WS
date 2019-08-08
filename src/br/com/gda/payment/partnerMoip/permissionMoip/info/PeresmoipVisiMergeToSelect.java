package br.com.gda.payment.partnerMoip.permissionMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PeresmoipVisiMergeToSelect implements InfoMergerVisitor<PeresmoipInfo, PeresmoipInfo> {

	@Override public PeresmoipInfo writeRecord(PeresmoipInfo sourceOne, PeresmoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PeresmoipInfo sourceOne, PeresmoipInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PeresmoipInfo merge(PeresmoipInfo sourceOne, PeresmoipInfo sourceTwo) {
		PeresmoipInfo result = makeClone(sourceOne);
		result.code = sourceTwo.code;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private PeresmoipInfo makeClone(PeresmoipInfo recordInfo) {
		try {
			return (PeresmoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(PeresmoipInfo sourceOne, PeresmoipInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
