package br.com.gda.business.orderSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.security.userList.info.UselisInfo;

final class OrdnapVisiMergeUselis implements InfoMergerVisitor<OrdnapInfo, UselisInfo> {

	@Override public OrdnapInfo writeRecord(UselisInfo sourceOne, OrdnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrdnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UselisInfo sourceOne, OrdnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrdnapInfo makeClone(OrdnapInfo recordInfo) {
		try {
			return (OrdnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OrdnapInfo merge(UselisInfo sourceOne, OrdnapInfo sourceTwo) {
		sourceTwo.codUserSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(UselisInfo sourceOne, OrdnapInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codUser  == sourceTwo.codUser		); 
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
