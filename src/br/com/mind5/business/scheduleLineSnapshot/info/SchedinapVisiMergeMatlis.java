package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedinapVisiMergeMatlis implements InfoMergerVisitor_<SchedinapInfo, MatlisInfo> {

	@Override public SchedinapInfo writeRecord(MatlisInfo sourceOne, SchedinapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedinapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codMatSnapshot = sourceOne.codSnapshot;

		return resultInfo;
	}
	
	
	
	private void checkArgument(MatlisInfo sourceOne, SchedinapInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(MatlisInfo sourceOne, SchedinapInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner && 
				sourceOne.codMat   == sourceTwo.codMat		);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
