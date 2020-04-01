package br.com.mind5.business.customerList.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CuslisVisiMergeFimist implements InfoMergerVisitor_<CuslisInfo, FimistInfo> {

	@Override public CuslisInfo writeRecord(FimistInfo sourceOne, CuslisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CuslisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(FimistInfo sourceOne, CuslisInfo sourceTwo) {
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
	
	
	
	private CuslisInfo merge(FimistInfo sourceOne, CuslisInfo sourceTwo) {
		sourceTwo.fimistData = sourceOne;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(FimistInfo sourceOne, CuslisInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner	&&
				sourceOne.codCustomer	== sourceTwo.codCustomer	);
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
