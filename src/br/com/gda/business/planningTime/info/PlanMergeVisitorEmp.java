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
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
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



	@Override public boolean shouldWrite(PlanInfo sourceOne, EmpInfo sourceTwo) {
		if (sourceTwo.codEmployee <= 0)
			return false;
		
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner <= 0 					|| 
				eachData.codOwner != sourceTwo.codOwner	||
			    eachData.codEmployee <= 0					)
				
				return false;
		}
		
		
		return true;
	}
}
