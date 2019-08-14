package br.com.gda.business.company.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.companySnapshot.info.CompnapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class CompVisiMergeCompnap implements InfoMergerVisitor<CompInfo, CompnapInfo> {

	@Override public CompInfo writeRecord(CompnapInfo sourceOne, CompInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CompInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CompnapInfo sourceOne, CompInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CompInfo makeClone(CompInfo recordInfo) {
		try {
			return (CompInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CompInfo merge(CompnapInfo sourceOne, CompInfo sourceTwo) {
		sourceTwo.codSnapshot = sourceOne.codSnapshot;

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CompnapInfo sourceOne, CompInfo sourceTwo) {
		return (sourceOne.codOwner	 == sourceTwo.codOwner	&&
				sourceOne.codCompany == sourceTwo.codCompany);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
