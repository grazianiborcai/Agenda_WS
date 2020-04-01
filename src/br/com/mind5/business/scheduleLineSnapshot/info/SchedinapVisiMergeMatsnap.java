package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedinapVisiMergeMatsnap implements InfoMergerVisitor_<SchedinapInfo, MatsnapInfo> {

	@Override public SchedinapInfo writeRecord(MatsnapInfo sourceOne, SchedinapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedinapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.matData = sourceOne;

		return resultInfo;
	}
	
	
	
	private void checkArgument(MatsnapInfo sourceOne, SchedinapInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(MatsnapInfo sourceOne, SchedinapInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner && 
				sourceOne.codMat   		== sourceTwo.codMat	  &&
				sourceOne.codSnapshot   == sourceTwo.codMatSnapshot);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
