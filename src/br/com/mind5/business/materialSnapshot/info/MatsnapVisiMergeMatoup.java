package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

final class MatsnapVisiMergeMatoup implements InfoMergerVisitor_<MatsnapInfo, MatoupInfo> {

	@Override public MatsnapInfo writeRecord(MatoupInfo sourceOne, MatsnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatsnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatoupInfo sourceOne, MatsnapInfo sourceTwo) {
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
	
	
	
	private MatsnapInfo merge(MatoupInfo sourceOne, MatsnapInfo sourceTwo) {
		sourceTwo.codGroup = sourceOne.codGroup;
		sourceTwo.txtGroup = sourceOne.txtGroup;
		sourceTwo.codBusiness = sourceOne.codBusiness;
		sourceTwo.txtBusiness = sourceOne.txtBusiness;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatoupInfo sourceOne, MatsnapInfo sourceTwo) {
		return (sourceOne.codGroup == sourceTwo.codGroup);
	}		
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
