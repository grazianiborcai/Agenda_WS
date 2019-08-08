package br.com.gda.business.material.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatVisiMergeMatUnit implements InfoMergerVisitor<MatInfo, MatUnitInfo> {

	@Override public MatInfo writeRecord(MatUnitInfo sourceOne, MatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatUnitInfo sourceOne, MatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatInfo makeClone(MatInfo recordInfo) {
		try {
			return (MatInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MatInfo merge(MatUnitInfo sourceOne, MatInfo sourceTwo) {
		sourceTwo.codUnit = sourceOne.codUnit;
		sourceTwo.txtUnit = sourceOne.txtUnit;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatUnitInfo sourceOne, MatInfo sourceTwo) {
		return (sourceOne.codUnit.equals(sourceTwo.codUnit));
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
