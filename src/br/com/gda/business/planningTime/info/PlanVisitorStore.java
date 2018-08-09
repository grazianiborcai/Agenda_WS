package br.com.gda.business.planningTime.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PlanVisitorStore implements InfoMergerVisitor<PlanInfo, PlanInfo, StoreInfo> {

	@Override public PlanInfo mergeRecord(PlanInfo sourceOne, StoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
				
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceOne.stores);
		resultInfo.employees.addAll(sourceOne.employees);
		resultInfo.materials.addAll(sourceOne.materials);
		resultInfo.weekdays.addAll(sourceOne.weekdays);
		resultInfo.datas.addAll(sourceOne.datas);
		
		resultInfo.stores.add(sourceTwo);
		
		
		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, StoreInfo sourceTwo) {		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner <= 0)
				throw new IllegalArgumentException("codOwner" + SystemMessage.MANDATORY_FIELD_EMPTY);
			
			if (eachData.codOwner != sourceTwo.codOwner)
				throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		}
	}
}
