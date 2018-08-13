package br.com.gda.business.planningTime.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoWriteVisitor;

final class PlanMergeVisitorWeekday implements InfoWriteVisitor<PlanInfo, PlanInfo, WeekdayInfo> {

	@Override public PlanInfo writeRecord(PlanInfo sourceOne, WeekdayInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
				
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceOne.stores);
		resultInfo.employees.addAll(sourceOne.employees);
		resultInfo.materials.addAll(sourceOne.materials);
		resultInfo.weekdays.addAll(sourceOne.weekdays);
		resultInfo.datas.addAll(sourceOne.datas);
		
		//TODO: substituir por lambda
		for (PlanDataInfo eachPlanData : sourceOne.datas) {
			if (shouldMerge(eachPlanData, sourceTwo)) {		
				WeekdayInfo clonedWeekday = makeClone(sourceTwo);
				resultInfo.weekdays.add(clonedWeekday);
				break;
			}
		}
		
		
		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, WeekdayInfo sourceTwo) {		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner <= 0)
				throw new IllegalArgumentException("codOwner" + SystemMessage.NULL_ARGUMENT);
			
			if (eachData.codWeekday <= 0)
				throw new IllegalArgumentException("codWeekday" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private boolean shouldMerge(PlanDataInfo planData, WeekdayInfo emp) {
		if (planData.codWeekday == emp.codWeekday)
			return true;
		
		return false;
	}
	
	
	
	private WeekdayInfo makeClone(WeekdayInfo weekday) {
		try {
			return (WeekdayInfo) weekday.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
