package br.com.gda.business.planningTime.info;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PlanVisitorEWT implements InfoMergerVisitor<PlanInfo, PlanInfo, EmpWTimeInfo> {

	@Override public PlanInfo mergeRecord(PlanInfo sourceOne, EmpWTimeInfo sourceTwo) {
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
	
	
	
	private void checkArgument(PlanInfo sourceOne, EmpWTimeInfo sourceTwo) {
		if (sourceTwo.beginTime == null)
			throw new NullPointerException("sourceTwo.beginTime" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwo.endTime == null)
			throw new NullPointerException("sourceTwo.endTime" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwo.codEmployee <= 0)
			throw new NullPointerException("sourceTwo.codEmployee" + SystemMessage.NULL_ARGUMENT);
		
		
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner <= 0)
				throw new IllegalArgumentException("codOwner" + SystemMessage.MANDATORY_FIELD_EMPTY);
			
			if (eachData.codOwner != sourceTwo.codOwner)
				throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);

			
			if (eachData.beginTime == null)
				throw new NullPointerException("beginTime" + SystemMessage.NULL_ARGUMENT);
			
			if (eachData.endTime == null)
				throw new NullPointerException("endTime" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private boolean shouldMerge(PlanDataInfo planData, EmpWTimeInfo empWTime) {
		if (planData.beginTime.isAfter(empWTime.beginTime) ||
			planData.endTime.isBefore(empWTime.endTime))
			return false;
		
		
		if (planData.codStore   == empWTime.codStore &&
			planData.codWeekday == empWTime.codWeekday)
			return true;
		
		
		return false;
	}
	
	
	
	private List<PlanDataInfo> mergeEmpWTime(PlanDataInfo planData, EmpWTimeInfo empWTime) {
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
}
