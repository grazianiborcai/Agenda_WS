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
}
