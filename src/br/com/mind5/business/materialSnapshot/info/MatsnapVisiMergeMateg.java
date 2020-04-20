package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.materialCategory.info.MategInfo;

final class MatsnapVisiMergeMateg implements InfoMergerVisitor_<MatsnapInfo, MategInfo> {

	@Override public MatsnapInfo writeRecord(MategInfo sourceOne, MatsnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatsnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MategInfo sourceOne, MatsnapInfo sourceTwo) {
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
	
	
	
	private MatsnapInfo merge(MategInfo sourceOne, MatsnapInfo sourceTwo) {
		sourceTwo.codMatCateg = sourceOne.codMatCateg;
		sourceTwo.txtMatCateg = sourceOne.txtMatCateg;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MategInfo sourceOne, MatsnapInfo sourceTwo) {
		return (sourceOne.codMatCateg == sourceTwo.codMatCateg);
	}		
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
