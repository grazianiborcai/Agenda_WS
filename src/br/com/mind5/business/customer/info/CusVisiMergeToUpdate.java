package br.com.mind5.business.customer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CusVisiMergeToUpdate implements InfoMergerVisitor_<CusInfo, CusInfo> {

	@Override public CusInfo writeRecord(CusInfo sourceOne, CusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CusInfo sourceOne, CusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CusInfo merge(CusInfo sourceOne, CusInfo sourceTwo) {
		CusInfo result = makeClone(sourceOne);	
		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		
		if (sourceTwo.addresses != null)
			result.addresses = sourceTwo.addresses;
		
		if (sourceTwo.phones != null)
			result.phones = sourceTwo.phones;
		
		if (sourceTwo.personData != null)
			result.personData = sourceTwo.personData;
		
		return result;
	}
	
	
	
	private CusInfo makeClone(CusInfo recordInfo) {
		try {
			return (CusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(CusInfo sourceOne, CusInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
