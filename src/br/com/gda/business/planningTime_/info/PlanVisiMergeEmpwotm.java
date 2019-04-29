package br.com.gda.business.planningTime_.info;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class PlanVisiMergeEmpwotm implements InfoMergerVisitorV2<PlanInfo, EmpwotmInfo> {

	@Override public PlanInfo writeRecord(EmpwotmInfo sourceOne, PlanInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceTwo.stores);
		resultInfo.employees.addAll(sourceTwo.employees);
		resultInfo.materials.addAll(sourceTwo.materials);
		resultInfo.weekdays.addAll(sourceTwo.weekdays);
		
		for (PlanDataInfo eachData : sourceTwo.datas) {
			if (shouldMerge(eachData, sourceOne)) {
				List<PlanDataInfo> mergedResults = mergeEmpWTime(eachData, sourceOne);
				resultInfo.datas.addAll(mergedResults);
			}
		}
		

		return resultInfo;
	}
	
	
	
	private void checkArgument(EmpwotmInfo sourceOne, PlanInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private boolean shouldMerge(PlanDataInfo planData, EmpwotmInfo empWTime) {
		if (planData.beginTime.isAfter(empWTime.beginTime) ||
			planData.endTime.isBefore(empWTime.endTime))
			return false;
		
		
		if (planData.codStore   == empWTime.codStore &&
			planData.codWeekday == empWTime.codWeekday)
			return true;
		
		
		return false;
	}
	
	
	
	private List<PlanDataInfo> mergeEmpWTime(PlanDataInfo planData, EmpwotmInfo empWTime) {
		PlanDataInfo dataResult = makeClone(planData);
		
		dataResult.codEmployee = empWTime.codEmployee;
		dataResult.beginTime = LocalTime.of(empWTime.beginTime.getHour(), empWTime.beginTime.getMinute());
		dataResult.endTime = LocalTime.of(empWTime.endTime.getHour(), empWTime.endTime.getMinute());		

		List<PlanDataInfo> dataResults = new ArrayList<>();
		dataResults.add(dataResult);
		return dataResults;
	}
	
	
	
	private PlanDataInfo makeClone(PlanDataInfo planData) {
		try {
			return (PlanDataInfo) planData.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(EmpwotmInfo sourceOne, PlanInfo sourceTwo) {
		if (sourceOne.beginTime == null)
			return false;
		
		if (sourceOne.endTime == null)
			return false;
		
		if (sourceOne.codEmployee <= 0)
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
			
			if (eachData.beginTime == null)
				return false;
			
			if (eachData.endTime == null)
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
