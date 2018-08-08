package br.com.gda.business.planningTime.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.VisitorMerger;

final class PlanVisitorEmp implements VisitorMerger<PlanInfo, PlanInfo, EmpInfo> {

	@Override public PlanInfo mergeRecord(PlanInfo sourceOne, EmpInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
				
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceOne.stores);
		resultInfo.employees.addAll(sourceOne.employees);
		resultInfo.materials.addAll(sourceOne.materials);
		resultInfo.weekdays.addAll(sourceOne.weekdays);
		resultInfo.datas.addAll(sourceOne.datas);
		
		resultInfo.employees.add(sourceTwo);
		

		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, EmpInfo sourceTwo) {
		if (sourceOne.datas == null)
			throw new NullPointerException("sourceOne.datas" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceOne.datas.isEmpty())
			throw new IllegalArgumentException("sourceOne.datas" + SystemMessage.EMPTY_ARGUMENT);
		
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner != sourceTwo.codOwner)
				throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		}
	}
}
