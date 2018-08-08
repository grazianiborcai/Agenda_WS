package br.com.gda.business.planningTime.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.VisitorMerger;

final class PlanVisitorMat implements VisitorMerger<PlanInfo, PlanInfo, MatInfo> {

	@Override public PlanInfo mergeRecord(PlanInfo sourceOne, MatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
				
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceOne.stores);
		resultInfo.employees.addAll(sourceOne.employees);
		resultInfo.materials.addAll(sourceOne.materials);
		resultInfo.weekdays.addAll(sourceOne.weekdays);
		resultInfo.datas.addAll(sourceOne.datas);
		
		resultInfo.materials.add(sourceTwo);
		

		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, MatInfo sourceTwo) {
		if (sourceOne.datas == null)
			throw new NullPointerException("sourceOne.datas" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceOne.datas.isEmpty())
			throw new IllegalArgumentException("sourceOne.datas" + SystemMessage.EMPTY_ARGUMENT);
		
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner != sourceTwo.codOwner)
				throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
			
			if (eachData.codMat != sourceTwo.codMat)
				throw new IllegalArgumentException("codMat" + SystemMessage.ARGUMENT_DONT_MATCH);
		}
	}
}
