package br.com.gda.business.employeePosition.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class EmposVisiMergePosition implements InfoMergerVisitorV2<EmposInfo, PositionInfo> {

	@Override public EmposInfo writeRecord(PositionInfo sourceOne, EmposInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmposInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PositionInfo sourceOne, EmposInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmposInfo makeClone(EmposInfo recordInfo) {
		try {
			return (EmposInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private EmposInfo merge(PositionInfo sourceOne, EmposInfo sourceTwo) {
		sourceTwo.txtPosition = sourceOne.txtPosition;

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PositionInfo sourceOne, EmposInfo sourceTwo) {
		return (sourceOne.codPosition == sourceTwo.codPosition);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
