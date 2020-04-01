package br.com.mind5.business.customerList.info;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CuslisVisiMergePersolis implements InfoMergerVisitor_<CuslisInfo, PersolisInfo> {

	@Override public CuslisInfo writeRecord(PersolisInfo sourceOne, CuslisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CuslisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PersolisInfo sourceOne, CuslisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CuslisInfo makeClone(CuslisInfo recordInfo) {
		try {
			return (CuslisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CuslisInfo merge(PersolisInfo sourceOne, CuslisInfo sourceTwo) {
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
	
	
	
	@Override public boolean shouldWrite(PersolisInfo sourceOne, CuslisInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner	&&
				sourceOne.codPerson == sourceTwo.codPerson);
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
