package br.com.gda.business.planningTime_.info;

import br.com.gda.business.reserve.info.ReserveInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoPrunerVisitor;

final class PlanPruneVisitorReserve implements InfoPrunerVisitor<PlanInfo, ReserveInfo> {
	
	@Override public PlanInfo pruneRecord(PlanInfo sourceOne, ReserveInfo sourceTwo) {
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
		
		if (resultInfo.datas.isEmpty())
			return null;
		
		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, ReserveInfo sourceTwo) {		
		if (sourceTwo.codOwner <= 0)
			throw new IllegalArgumentException("sourceTwo.codOwner" + SystemMessage.NULL_ARGUMENT);
		
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
			
			if (eachData.codMat <= 0)
				throw new IllegalArgumentException("codStore" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private boolean shouldPrune(PlanDataInfo planData, ReserveInfo reserve) {
		ReserveInfo itemToCheck = ReserveInfo.copyFrom(planData);
		return reserve.equals(itemToCheck);
	}
}
