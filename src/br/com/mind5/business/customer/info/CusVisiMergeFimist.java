package br.com.mind5.business.customer.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CusVisiMergeFimist implements InfoMergerVisitor_<CusInfo, FimistInfo> {

	@Override public CusInfo writeRecord(FimistInfo sourceOne, CusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(FimistInfo sourceOne, CusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CusInfo makeClone(CusInfo recordInfo) {
		try {
			return (CusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CusInfo merge(FimistInfo sourceOne, CusInfo sourceTwo) {
		sourceTwo.fimistData = sourceOne;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(FimistInfo sourceOne, CusInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner	&&
				sourceOne.codCustomer	== sourceTwo.codCustomer	);
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
