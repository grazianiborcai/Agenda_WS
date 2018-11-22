package br.com.gda.business.planningTime.info;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PlanPruneVisitorSLD implements InfoMergerVisitor<PlanInfo, PlanInfo, StoreLDateInfo> {
	
	@Override public PlanInfo writeRecord(PlanInfo sourceOne, StoreLDateInfo sourceTwo) {
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
	
	
	
	private void checkArgument(PlanInfo sourceOne, StoreLDateInfo sourceTwo) {		
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private boolean shouldPrune(PlanDataInfo planData, StoreLDateInfo storeLDate) {
		if (planData.codStore == storeLDate.codStore && isTimeRangeOverlap(planData, storeLDate))
			return true;
		
		return false;
	}
	
	
	
	private boolean isTimeRangeOverlap(PlanDataInfo plan, StoreLDateInfo storeLDate) {
	
		if ((plan.date.isAfter(storeLDate.dateValidFrom)      || plan.date.isEqual(storeLDate.dateValidFrom)) 	  &&
			(plan.date.isBefore(storeLDate.dateValidTo)       || plan.date.isEqual(storeLDate.dateValidTo)) 	  &&
			(plan.beginTime.isAfter(storeLDate.timeValidFrom) || plan.beginTime.equals(storeLDate.timeValidFrom)) &&
			(plan.beginTime.isBefore(storeLDate.timeValidTo)  || plan.beginTime.equals(storeLDate.timeValidTo)))
			return true;		
		
		
		if ((plan.date.isAfter(storeLDate.dateValidFrom)    || plan.date.isEqual(storeLDate.dateValidFrom))   &&
			(plan.date.isBefore(storeLDate.dateValidTo)     || plan.date.isEqual(storeLDate.dateValidTo)) 	  &&
			(plan.endTime.isAfter(storeLDate.timeValidFrom) || plan.endTime.equals(storeLDate.timeValidFrom)) &&
			(plan.endTime.isBefore(storeLDate.timeValidTo)  || plan.endTime.equals(storeLDate.timeValidTo)))
			return true;	
		
		return false;
	}



	@Override public boolean shouldWrite(PlanInfo sourceOne, StoreLDateInfo sourceTwo) {
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
