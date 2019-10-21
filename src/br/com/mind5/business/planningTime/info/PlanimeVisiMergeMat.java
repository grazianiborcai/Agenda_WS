package br.com.mind5.business.planningTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class PlanimeVisiMergeMat implements InfoMergerVisitor<PlanimeInfo, MatInfo> {

	@Override public PlanimeInfo writeRecord(MatInfo sourceOne, PlanimeInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
				
		checkArgument(sourceOne, sourceTwo);
		
		MatInfo clonedMat = makeClone(sourceOne);
		sourceTwo.materials.add(clonedMat);
		
		return sourceTwo;
	}
	
	
	
	private void checkArgument(MatInfo sourceOne, PlanimeInfo sourceTwo) {	
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatInfo makeClone(MatInfo mat) {
		try {
			return (MatInfo) mat.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}



	@Override public boolean shouldWrite(MatInfo sourceOne, PlanimeInfo sourceTwo) {		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
