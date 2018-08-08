package br.com.gda.business.planningTime.info;

import java.time.LocalDate;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.VisitorMerger;

final class PlanVisitorSWT implements VisitorMerger<PlanInfo, PlanInfo, StoreWTimeInfo> {

	@Override public PlanInfo mergeRecord(PlanInfo sourceOne, StoreWTimeInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceOne.stores);
		resultInfo.employees.addAll(sourceOne.employees);
		resultInfo.materials.addAll(sourceOne.materials);
		resultInfo.weekdays.addAll(sourceOne.weekdays);
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			PlanDataInfo dataInfo = PlanDataInfo.copyFrom(sourceTwo);
			dataInfo.date = LocalDate.of(eachData.date.getYear(), eachData.date.getMonth(), eachData.date.getDayOfMonth());		
			dataInfo.codEmployee = eachData.codEmployee;
			resultInfo.datas.add(dataInfo);
		}
		

		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, StoreWTimeInfo sourceTwo) {
		if (sourceOne.datas == null)
			throw new NullPointerException("sourceOne.datas" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceOne.datas.isEmpty())
			throw new IllegalArgumentException("sourceOne.datas" + SystemMessage.EMPTY_ARGUMENT);
		
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner != sourceTwo.codOwner)
				throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
			
			if (eachData.codStore != sourceTwo.codStore)
				throw new IllegalArgumentException("codStore" + SystemMessage.ARGUMENT_DONT_MATCH);
		}
	}
}
