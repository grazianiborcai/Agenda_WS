package br.com.gda.business.materialSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatsnapVisiMergeMatUnit implements InfoMergerVisitor<MatsnapInfo, MatUnitInfo> {

	@Override public MatsnapInfo writeRecord(MatUnitInfo sourceOne, MatsnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatsnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatUnitInfo sourceOne, MatsnapInfo sourceTwo) {
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
	
	
	
	private MatsnapInfo merge(MatUnitInfo sourceOne, MatsnapInfo sourceTwo) {
		sourceTwo.codUnit = sourceOne.codUnit;
		sourceTwo.txtUnit = sourceOne.txtUnit;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatUnitInfo sourceOne, MatsnapInfo sourceTwo) {
		return (sourceOne.codUnit.equals(sourceTwo.codUnit));
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
