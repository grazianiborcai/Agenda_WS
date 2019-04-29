package br.com.gda.business.planningTime_.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class PlanVisiMergeWeekday implements InfoMergerVisitorV2<PlanInfo, WeekdayInfo> {

	@Override public PlanInfo writeRecord(WeekdayInfo sourceOne, PlanInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
				
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceTwo.stores);
		resultInfo.employees.addAll(sourceTwo.employees);
		resultInfo.materials.addAll(sourceTwo.materials);
		resultInfo.weekdays.addAll(sourceTwo.weekdays);
		resultInfo.datas.addAll(sourceTwo.datas);
		
		//TODO: substituir por lambda
		for (PlanDataInfo eachPlanData : sourceTwo.datas) {
			if (shouldMerge(eachPlanData, sourceOne)) {		
				WeekdayInfo clonedWeekday = makeClone(sourceOne);
				resultInfo.weekdays.add(clonedWeekday);
				break;
			}
		}
		
		
		return resultInfo;
	}
	
	
	
	private void checkArgument(WeekdayInfo sourceOne, PlanInfo sourceTwo) {		
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
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
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(WeekdayInfo sourceOne, PlanInfo sourceTwo) {
		for (PlanDataInfo eachData : sourceTwo.datas) {
			if (eachData.codOwner <= 0)
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
