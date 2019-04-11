package br.com.gda.business.planningTime.info;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PlanMergeVisitorEWT implements InfoMergerVisitor<PlanInfo, PlanInfo, EmpwotmInfo> {

	@Override public PlanInfo writeRecord(PlanInfo sourceOne, EmpwotmInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceOne.stores);
		resultInfo.employees.addAll(sourceOne.employees);
		resultInfo.materials.addAll(sourceOne.materials);
		resultInfo.weekdays.addAll(sourceOne.weekdays);
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (shouldMerge(eachData, sourceTwo)) {
				List<PlanDataInfo> mergedResults = mergeEmpWTime(eachData, sourceTwo);
				resultInfo.datas.addAll(mergedResults);
			}
		}
		

		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, EmpwotmInfo sourceTwo) {
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
			throw new IllegalStateException(e);
		}
	}


	
	@Override public boolean shouldWrite(PlanInfo sourceOne, EmpwotmInfo sourceTwo) {
		if (sourceTwo.beginTime == null)
			return false;
		
		if (sourceTwo.endTime == null)
			return false;
		
		if (sourceTwo.codEmployee <= 0)
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
}
