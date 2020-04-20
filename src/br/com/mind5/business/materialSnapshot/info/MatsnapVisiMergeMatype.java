package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.materialType.info.MatypeInfo;

final class MatsnapVisiMergeMatype implements InfoMergerVisitor_<MatsnapInfo, MatypeInfo> {

	@Override public MatsnapInfo writeRecord(MatypeInfo sourceOne, MatsnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatsnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatypeInfo sourceOne, MatsnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatsnapInfo makeClone(MatsnapInfo recordInfo) {
		try {
			return (MatsnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MatsnapInfo merge(MatypeInfo sourceOne, MatsnapInfo sourceTwo) {
		sourceTwo.codType = sourceOne.codType;
		sourceTwo.txtType = sourceOne.txtType;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatypeInfo sourceOne, MatsnapInfo sourceTwo) {
		return (sourceOne.codType == sourceTwo.codType);
	}		
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
