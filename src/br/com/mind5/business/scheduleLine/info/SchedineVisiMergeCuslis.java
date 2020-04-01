package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedineVisiMergeCuslis implements InfoMergerVisitor_<SchedineInfo, CuslisInfo> {

	@Override public SchedineInfo writeRecord(CuslisInfo sourceOne, SchedineInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedineInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codUser = sourceOne.codUser;

		return resultInfo;
	}
	
	
	
	private void checkArgument(CuslisInfo sourceOne, SchedineInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	
	
	
	
	private SchedineInfo makeClone(SchedineInfo recordInfo) {
		try {
			return (SchedineInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(CuslisInfo sourceOne, SchedineInfo sourceTwo) {
		return (sourceOne.codOwner    == sourceTwo.codOwner && 
				sourceOne.codCustomer == sourceTwo.codCustomer		);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
