package br.com.gda.business.materialSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatsnapVisiMergeMatextsnap implements InfoMergerVisitor<MatsnapInfo, MatextsnapInfo> {

	@Override public MatsnapInfo writeRecord(MatextsnapInfo sourceOne, MatsnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatsnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatextsnapInfo sourceOne, MatsnapInfo sourceTwo) {
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
	
	
	
	private MatsnapInfo merge(MatextsnapInfo sourceOne, MatsnapInfo sourceTwo) {
		sourceTwo.txtMat = sourceOne.txtMat;
		sourceTwo.description = sourceOne.description;
		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(MatextsnapInfo sourceOne, MatsnapInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner		&&
				sourceOne.codSnapshot 	== sourceTwo.codSnapshot	&&
				sourceOne.codMat 		== sourceTwo.codMat				);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
