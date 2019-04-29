package br.com.gda.business.planningTime_.info;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor_;

final class PlanPruneVisitorELD implements InfoMergerVisitor_<PlanInfo, PlanInfo, EmplevateInfo> {
	
	@Override public PlanInfo writeRecord(PlanInfo sourceOne, EmplevateInfo sourceTwo) {
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
	
	
	
	private void checkArgument(PlanInfo sourceOne, EmplevateInfo sourceTwo) {		
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private boolean shouldPrune(PlanDataInfo planData, EmplevateInfo empLDate) {
		if (planData.codStore    == empLDate.codStore    &&
			planData.codEmployee == empLDate.codEmployee &&
			isTimeRangeOverlap(planData, empLDate))
			return true;
		
		return false;
	}
	
	
	
	private boolean isTimeRangeOverlap(PlanDataInfo plan, EmplevateInfo empLDate) {
	
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



	@Override public boolean shouldWrite(PlanInfo sourceOne, EmplevateInfo sourceTwo) {
		if (sourceTwo.dateValidFrom == null)
			return false;
		
		if (sourceTwo.dateValidTo == null)
			return false;
		
		if (sourceTwo.timeValidFrom == null)
			return false;
		
		if (sourceTwo.timeValidTo == null)
			return false;
		
		if (sourceTwo.codStore <= 0)
			return false;
		
		if (sourceTwo.codEmployee <= 0)
			return false;
		
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner <= 0)
				return false;
			
			if (eachData.codOwner != sourceTwo.codOwner)
				return false;
			
			if (eachData.codStore <= 0)
				return false;
			
			if (eachData.date == null)
				return false;
			
			if (eachData.beginTime == null)
				return false;
			
			if (eachData.endTime == null)
				return false;
		}
		
		
		return true;
	}
}
