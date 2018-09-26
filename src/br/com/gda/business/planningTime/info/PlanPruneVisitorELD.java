package br.com.gda.business.planningTime.info;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PlanPruneVisitorELD implements InfoMergerVisitor<PlanInfo, PlanInfo, EmpLDateInfo> {
	
	@Override public PlanInfo writeRecord(PlanInfo sourceOne, EmpLDateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceOne.stores);
		resultInfo.employees.addAll(sourceOne.employees);
		resultInfo.materials.addAll(sourceOne.materials);
		resultInfo.weekdays.addAll(sourceOne.weekdays);
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (shouldPrune(eachData, sourceTwo) == false) {
				resultInfo.datas.add(eachData);
			}
		}		

		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, EmpLDateInfo sourceTwo) {		
		if (sourceTwo.dateValidFrom == null)
			throw new NullPointerException("sourceTwo.dateValidFrom" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwo.dateValidTo == null)
			throw new NullPointerException("sourceTwo.dateValidTo" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwo.timeValidFrom == null)
			throw new NullPointerException("sourceTwo.timeValidFrom" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwo.timeValidTo == null)
			throw new NullPointerException("sourceTwo.timeValidTo" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwo.codStore <= 0)
			throw new IllegalArgumentException("sourceTwo.codStore" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwo.codEmployee <= 0)
			throw new IllegalArgumentException("sourceTwo.codEmployee" + SystemMessage.NULL_ARGUMENT);
		
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner <= 0)
				throw new IllegalArgumentException("codOwner" + SystemMessage.NULL_ARGUMENT);
			
			if (eachData.codOwner != sourceTwo.codOwner)
				throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
			
			if (eachData.codStore <= 0)
				throw new IllegalArgumentException("codStore" + SystemMessage.NULL_ARGUMENT);
			
			if (eachData.date == null)
				throw new IllegalArgumentException("date" + SystemMessage.NULL_ARGUMENT);
			
			if (eachData.beginTime == null)
				throw new IllegalArgumentException("beginTime" + SystemMessage.NULL_ARGUMENT);
			
			if (eachData.endTime == null)
				throw new IllegalArgumentException("endTime" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private boolean shouldPrune(PlanDataInfo planData, EmpLDateInfo empLDate) {
		if (planData.codStore    == empLDate.codStore    &&
			planData.codEmployee == empLDate.codEmployee &&
			isTimeRangeOverlap(planData, empLDate))
			return true;
		
		return false;
	}
	
	
	
	private boolean isTimeRangeOverlap(PlanDataInfo plan, EmpLDateInfo empLDate) {
	
		if ((plan.date.isAfter(empLDate.dateValidFrom)      || plan.date.isEqual(empLDate.dateValidFrom)) 	  &&
			(plan.date.isBefore(empLDate.dateValidTo)       || plan.date.isEqual(empLDate.dateValidTo)) 	  &&
			(plan.beginTime.isAfter(empLDate.timeValidFrom) || plan.beginTime.equals(empLDate.timeValidFrom)) &&
			(plan.beginTime.isBefore(empLDate.timeValidTo)  || plan.beginTime.equals(empLDate.timeValidTo)))
			return true;		
		
		
		if ((plan.date.isAfter(empLDate.dateValidFrom)    || plan.date.isEqual(empLDate.dateValidFrom))   &&
			(plan.date.isBefore(empLDate.dateValidTo)     || plan.date.isEqual(empLDate.dateValidTo)) 	  &&
			(plan.endTime.isAfter(empLDate.timeValidFrom) || plan.endTime.equals(empLDate.timeValidFrom)) &&
			(plan.endTime.isBefore(empLDate.timeValidTo)  || plan.endTime.equals(empLDate.timeValidTo)))
			return true;	
		
		return false;
	}
}
