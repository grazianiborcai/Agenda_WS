package br.com.gda.business.planningTime.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PlanMergeVisitorEmp implements InfoMergerVisitor<PlanInfo, PlanInfo, EmpInfo> {

	@Override public PlanInfo writeRecord(PlanInfo sourceOne, EmpInfo sourceTwo) {
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
				EmpInfo copyEmp = makeCopy(sourceTwo);
				resultInfo.employees.add(copyEmp);
				break;
			}
		}

		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, EmpInfo sourceTwo) {	
		if (sourceTwo.codEmployee <= 0)
			throw new IllegalArgumentException("sourceTwo.codEmployee" + SystemMessage.NULL_ARGUMENT);
		
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner <= 0)
				throw new IllegalArgumentException("codOwner" + SystemMessage.NULL_ARGUMENT);
			
			if (eachData.codOwner != sourceTwo.codOwner)
				throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
			
			if (eachData.codEmployee <= 0)
				throw new IllegalArgumentException("codOwner" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private boolean shouldMerge(PlanDataInfo planData, EmpInfo emp) {
		if (planData.codEmployee == emp.codEmployee)
			return true;
		
		return false;
	}
	
	
	
	private EmpInfo makeCopy(EmpInfo emp) {
		EmpInfo copyEmp = new EmpInfo();
		
		copyEmp.codOwner = emp.codOwner;
		copyEmp.codEmployee = emp.codEmployee;
		copyEmp.name = emp.name;
		copyEmp.codLanguage = emp.codLanguage;
		
		return copyEmp;
	}
}
