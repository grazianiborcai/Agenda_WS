package br.com.mind5.business.planningTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PlanimeVisiMergeMatlis implements InfoMergerVisitor_<PlanimeInfo, MatlisInfo> {

	@Override public PlanimeInfo writeRecord(MatlisInfo sourceOne, PlanimeInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatlisInfo clonedMat = makeClone(sourceOne);
		sourceTwo.materials.add(clonedMat);
		
		return sourceTwo;
	}
	
	
	
	private void checkArgument(MatlisInfo sourceOne, PlanimeInfo sourceTwo) {	
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatlisInfo makeClone(MatlisInfo mat) {
		try {
			return (MatlisInfo) mat.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}



	@Override public boolean shouldWrite(MatlisInfo sourceOne, PlanimeInfo sourceTwo) {		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
