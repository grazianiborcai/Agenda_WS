package br.com.gda.business.planningTime_.info;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoMergerVisitor_;

final class PlanVisiMergeStowotm_ implements InfoMergerVisitor_<PlanInfo, PlanInfo, StowotmInfo> {

	@Override public PlanInfo writeRecord(PlanInfo sourceOne, StowotmInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceOne.stores);
		resultInfo.employees.addAll(sourceOne.employees);
		resultInfo.materials.addAll(sourceOne.materials);
		resultInfo.weekdays.addAll(sourceOne.weekdays);
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (shouldMerge(eachData, sourceTwo)) {
				List<PlanDataInfo> mergedResults = mergeStoreWTime(eachData, sourceTwo);
				resultInfo.datas.addAll(mergedResults);
			}
		}
		

		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, StowotmInfo sourceTwo) {		
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private boolean shouldMerge(PlanDataInfo planData, StowotmInfo storeWTime) {
		if (planData.codStore == storeWTime.codStore &&
			planData.codWeekday == storeWTime.codWeekday )
			return true;
		
		return false;
	}
	
	
	
	private List<PlanDataInfo> mergeStoreWTime(PlanDataInfo planData, StowotmInfo storeWTime) {
		PlanDataInfo resultInfo = makeClone(planData);
		resultInfo.beginTime = LocalTime.of(storeWTime.beginTime.getHour(), storeWTime.beginTime.getMinute());
		resultInfo.endTime = LocalTime.of(storeWTime.endTime.getHour(), storeWTime.endTime.getMinute());
		
		List<PlanDataInfo> results = new ArrayList<>();
		results.add(resultInfo);
		return results;
	}
	
	
	
	private PlanDataInfo makeClone(PlanDataInfo planData) {
		try {
			return (PlanDataInfo) planData.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}



	@Override public boolean shouldWrite(PlanInfo sourceOne, StowotmInfo sourceTwo) {
		if (sourceTwo.beginTime == null)
			return false;
		
		if (sourceTwo.endTime == null)
			return false;
		
		if (sourceTwo.codStore <= 0)
			return false;
		
		if (sourceTwo.codWeekday <= 0)
			return false;
		
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner <= 0)
				return false;
			
			if (eachData.codOwner != sourceTwo.codOwner)
				return false;
			
			if (eachData.codStore <= 0)
				return false;
			
			if (eachData.codWeekday <= 0)
				return false;
		}
		
		
		return true;
	}
}
