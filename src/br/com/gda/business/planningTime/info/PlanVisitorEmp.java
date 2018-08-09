package br.com.gda.business.planningTime.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PlanVisitorEmp implements InfoMergerVisitor<PlanInfo, PlanInfo, EmpInfo> {

	@Override public PlanInfo mergeRecord(PlanInfo sourceOne, EmpInfo sourceTwo) {
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
				resultInfo.employees.add(sourceTwo);
				break;
			}
		}

		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, EmpInfo sourceTwo) {		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner <= 0)
				throw new IllegalArgumentException("codOwner" + SystemMessage.MANDATORY_FIELD_EMPTY);
			
			if (eachData.codOwner != sourceTwo.codOwner)
				throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		}
	}
	
	
	
	private boolean shouldMerge(PlanDataInfo planData, EmpInfo emp) {
		if (planData.codEmployee == emp.codEmployee)
			return true;
		
		return false;
	}
}
