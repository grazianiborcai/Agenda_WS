package br.com.gda.business.planingData.info;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.common.MatUnit;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerOneToManyVisitor;

final class PlanataVisiMergeMat implements InfoMergerOneToManyVisitor<PlanataInfo, MatInfo> {

	@Override public List<PlanataInfo> writeRecord(MatInfo sourceOne, PlanataInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);	
		
		List<PlanataInfo> results = new ArrayList<>();
		LocalTime maxEndTime = sourceTwo.endTime;
		
		PlanataInfo eachResult = setEndTime(sourceOne, sourceTwo);
		
		if (shouldAdd(eachResult, maxEndTime))
			results.add(eachResult);
		
		
		while(shouldAdd(eachResult, maxEndTime)) {
			eachResult = shiftTime(sourceOne, eachResult);
			
			if (shouldAdd(eachResult, maxEndTime))
				results.add(eachResult);
		}
		

		return results;
	}
	
	
	
	private PlanataInfo setEndTime(MatInfo mat, PlanataInfo planata) {
		MatUnit matUnit = MatUnit.getMatUnit(mat.codUnit);		
		PlanataInfo resultInfo = makeClone(planata);
		
		if (MatUnit.MINUTE == matUnit)
			resultInfo.endTime = resultInfo.beginTime.plusMinutes(mat.priceUnit);
		
		return resultInfo;
	}
	
	
	
	private PlanataInfo shiftTime(MatInfo sourceOne, PlanataInfo sourceTwo) {
		MatUnit matUnit = MatUnit.getMatUnit(sourceOne.codUnit);		
		PlanataInfo resultInfo = makeClone(sourceTwo);
		
		if (MatUnit.MINUTE == matUnit) {
			resultInfo.beginTime = resultInfo.beginTime.plusMinutes(sourceOne.priceUnit);
			resultInfo.endTime = resultInfo.endTime.plusMinutes(sourceOne.priceUnit);
		}
		
		return resultInfo;
	}
	
	
	
	private boolean shouldAdd(PlanataInfo eachResult, LocalTime maxEndTime) {
		return eachResult.endTime.isBefore(maxEndTime) || eachResult.endTime.equals(maxEndTime);
	}
	
	
	
	private void checkArgument(MatInfo sourceOne, PlanataInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(MatInfo sourceOne, PlanataInfo sourceTwo) {
		return (sourceOne.codOwner 	== sourceTwo.codOwner && 
				sourceOne.codMat 	== sourceTwo.codMat			);
	}
	
	
	
	private PlanataInfo makeClone(PlanataInfo recordInfo) {
		try {
			return (PlanataInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
