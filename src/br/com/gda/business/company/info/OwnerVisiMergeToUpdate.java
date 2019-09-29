package br.com.gda.business.company.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OwnerVisiMergeToUpdate implements InfoMergerVisitor<CompInfo, CompInfo> {

	@Override public CompInfo writeRecord(CompInfo sourceOne, CompInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CompInfo sourceOne, CompInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CompInfo merge(CompInfo sourceOne, CompInfo sourceTwo) {
		CompInfo result = makeClone(sourceTwo);		
		result.codEntityCateg = sourceOne.codEntityCateg;
		
		if (sourceOne.cnpj != null)
			result.cnpj = sourceOne.cnpj;
		
		return result;
	}
	
	
	
	private CompInfo makeClone(CompInfo recordInfo) {
		try {
			return (CompInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(CompInfo sourceOne, CompInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
