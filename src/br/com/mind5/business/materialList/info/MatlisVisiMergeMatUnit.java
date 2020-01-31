package br.com.mind5.business.materialList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatlisVisiMergeMatUnit implements InfoMergerVisitor_<MatlisInfo, MatUnitInfo> {

	@Override public MatlisInfo writeRecord(MatUnitInfo sourceOne, MatlisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatlisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatUnitInfo sourceOne, MatlisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatlisInfo makeClone(MatlisInfo recordInfo) {
		try {
			return (MatlisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MatlisInfo merge(MatUnitInfo sourceOne, MatlisInfo sourceTwo) {
		sourceTwo.codUnit = sourceOne.codUnit;
		sourceTwo.txtUnit = sourceOne.txtUnit;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatUnitInfo sourceOne, MatlisInfo sourceTwo) {
		return (sourceOne.codUnit.equals(sourceTwo.codUnit));
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
