package br.com.mind5.security.userList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UselisVisiMergePersolis implements InfoMergerVisitor_<UselisInfo, PersolisInfo> {

	@Override public UselisInfo writeRecord(PersolisInfo sourceOne, UselisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		UselisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersolisInfo sourceOne, UselisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UselisInfo makeClone(UselisInfo recordInfo) {
		try {
			return (UselisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private UselisInfo merge(PersolisInfo sourceOne, UselisInfo sourceTwo) {
		sourceTwo.personData = makeClone(sourceOne);
		sourceTwo.codPerson = sourceOne.codPerson;
		return sourceTwo;
	}
	
	
	
	private PersolisInfo makeClone(PersolisInfo recordInfo) {
		try {
			return (PersolisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	@Override public boolean shouldWrite(PersolisInfo sourceOne, UselisInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner &&
				sourceOne.codPerson == sourceTwo.codPerson);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
