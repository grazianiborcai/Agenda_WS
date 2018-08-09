package br.com.gda.business.planningTime.info;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PlanVisitorMat implements InfoMergerVisitor<PlanInfo, PlanInfo, MatInfo> {

	@Override public PlanInfo mergeRecord(PlanInfo sourceOne, MatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
				
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceOne.stores);
		resultInfo.employees.addAll(sourceOne.employees);
		resultInfo.materials.addAll(sourceOne.materials);
		resultInfo.weekdays.addAll(sourceOne.weekdays);		
		
		resultInfo.materials.add(sourceTwo);
		
		
		for (PlanDataInfo eachPlanData : sourceOne.datas) {
			if (shouldMerge(eachPlanData, sourceTwo)) {				
				List<PlanDataInfo> mergedResults = mergeMat(eachPlanData, sourceTwo);
				resultInfo.datas.addAll(mergedResults);
			}
		}
		
		
		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, MatInfo sourceTwo) {		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner <= 0)
				throw new IllegalArgumentException("codOwner" + SystemMessage.MANDATORY_FIELD_EMPTY);
			
			if (eachData.codOwner != sourceTwo.codOwner)
				throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		}
	}
	
	
	
	private boolean shouldMerge(PlanDataInfo planData, MatInfo mat) {
		if (planData.codMat == mat.codMat)
			return true;
		
		return false;
	}
	
	
	
	private List<PlanDataInfo> mergeMat(PlanDataInfo planData, MatInfo mat) {
		List<PlanDataInfo> results = new ArrayList<>();
		
		LocalTime minTime = LocalTime.of(planData.beginTime.getHour(), planData.beginTime.getMinute());
		LocalTime maxTime = LocalTime.of(planData.endTime.getHour(), planData.endTime.getMinute());
		
		LocalTime newBeginTime = LocalTime.of(minTime.getHour(), minTime.getMinute());
		LocalTime newEndTime = LocalTime.of(minTime.getHour(), minTime.getMinute());
		
		
		while (maxTime.isAfter(newEndTime)) {
			PlanDataInfo eachResult = makeClone(planData);
			eachResult.codMat = mat.codMat;
			
			newEndTime = newBeginTime.plusMinutes(mat.priceUnit);
			
			eachResult.beginTime = LocalTime.of(newBeginTime.getHour(), newBeginTime.getMinute());
			eachResult.endTime = LocalTime.of(newEndTime.getHour(), newEndTime.getMinute());
			
			newBeginTime = LocalTime.of(newEndTime.getHour(), newEndTime.getMinute());
			
			
			if (isRangeValid(newEndTime, maxTime))
				results.add(eachResult);
		}
		
		return results;
	}
	
	
	
	private PlanDataInfo makeClone(PlanDataInfo planData) {
		try {
			return (PlanDataInfo) planData.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private boolean isRangeValid(LocalTime endTime, LocalTime maxTime) {
		return (maxTime.isAfter(endTime) || maxTime.equals(endTime));
	}
}
