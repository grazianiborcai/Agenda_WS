package br.com.gda.business.materialSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatsnapVisiMergeMatType implements InfoMergerVisitor<MatsnapInfo, MatTypeInfo> {

	@Override public MatsnapInfo writeRecord(MatTypeInfo sourceOne, MatsnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatsnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatTypeInfo sourceOne, MatsnapInfo sourceTwo) {
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
	
	
	
	private MatsnapInfo merge(MatTypeInfo sourceOne, MatsnapInfo sourceTwo) {
		sourceTwo.codType = sourceOne.codType;
		sourceTwo.txtType = sourceOne.txtType;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatTypeInfo sourceOne, MatsnapInfo sourceTwo) {
		return (sourceOne.codType == sourceTwo.codType);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
