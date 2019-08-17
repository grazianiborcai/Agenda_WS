package br.com.gda.business.scheduleLineSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.security.userList.info.UselisInfo;

final class SchedinapVisiMergeUselis implements InfoMergerVisitor<SchedinapInfo, UselisInfo> {

	@Override public SchedinapInfo writeRecord(UselisInfo sourceOne, SchedinapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedinapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codUserSnapshot = sourceOne.codSnapshot;

		return resultInfo;
	}
	
	
	
	private void checkArgument(UselisInfo sourceOne, SchedinapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	
	
	
	
	private SchedinapInfo makeClone(SchedinapInfo recordInfo) {
		try {
			return (SchedinapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(UselisInfo sourceOne, SchedinapInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner && 
				sourceOne.codUser  == sourceTwo.codUser		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
