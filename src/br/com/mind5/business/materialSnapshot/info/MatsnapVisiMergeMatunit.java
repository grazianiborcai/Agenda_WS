package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;

final class MatsnapVisiMergeMatunit implements InfoMergerVisitor_<MatsnapInfo, MatunitInfo> {

	@Override public MatsnapInfo writeRecord(MatunitInfo sourceOne, MatsnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatsnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatunitInfo sourceOne, MatsnapInfo sourceTwo) {
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
	
	
	
	private MatsnapInfo merge(MatunitInfo sourceOne, MatsnapInfo sourceTwo) {
		sourceTwo.codUnit = sourceOne.codUnit;
		sourceTwo.txtUnit = sourceOne.txtUnit;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatunitInfo sourceOne, MatsnapInfo sourceTwo) {
		return (sourceOne.codUnit.equals(sourceTwo.codUnit));
	}		
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
