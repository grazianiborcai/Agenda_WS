package br.com.gda.business.planningTime_.info;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class PlanVisiMergeStowotm implements InfoMergerVisitorV2<PlanInfo, StowotmInfo> {

	@Override public PlanInfo writeRecord(StowotmInfo sourceOne, PlanInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceTwo.stores);
		resultInfo.employees.addAll(sourceTwo.employees);
		resultInfo.materials.addAll(sourceTwo.materials);
		resultInfo.weekdays.addAll(sourceTwo.weekdays);
		
		for (PlanDataInfo eachData : sourceTwo.datas) {
			if (shouldMerge(eachData, sourceOne)) {
				List<PlanDataInfo> mergedResults = mergeStoreWTime(eachData, sourceOne);
				resultInfo.datas.addAll(mergedResults);
			}
		}
		

		return resultInfo;
	}
	
	
	
	private void checkArgument(StowotmInfo sourceOne, PlanInfo sourceTwo) {		
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
			logException(e);
			throw new IllegalStateException(e); 
		}
	}



	@Override public boolean shouldWrite(StowotmInfo sourceOne, PlanInfo sourceTwo) {
		if (sourceOne.beginTime == null)
			return false;
		
		if (sourceOne.endTime == null)
			return false;
		
		if (sourceOne.codStore <= 0)
			return false;
		
		if (sourceOne.codWeekday <= 0)
			return false;
		
		
		for (PlanDataInfo eachData : sourceTwo.datas) {
			if (eachData.codOwner <= 0)
				return false;
			
			if (eachData.codOwner != sourceOne.codOwner)
				return false;
			
			if (eachData.codStore <= 0)
				return false;
			
			if (eachData.codWeekday <= 0)
				return false;
		}
		
		
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
