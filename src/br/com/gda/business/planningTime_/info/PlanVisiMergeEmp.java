package br.com.gda.business.planningTime_.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class PlanVisiMergeEmp implements InfoMergerVisitorV2<PlanInfo, EmpInfo> {

	@Override public PlanInfo writeRecord(EmpInfo sourceOne, PlanInfo sourceTwo) {
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
				EmpInfo copyEmp = makeCopy(sourceOne);
				resultInfo.employees.add(copyEmp);
				break;
			}
		}

		return resultInfo;
	}
	
	
	
	private void checkArgument(EmpInfo sourceOne, PlanInfo sourceTwo) {	
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
		//copyEmp.name = emp.name;				//TODO: Ajustar
		copyEmp.codLanguage = emp.codLanguage;
		
		return copyEmp;
	}



	@Override public boolean shouldWrite(EmpInfo sourceOne, PlanInfo sourceTwo) {
		if (sourceOne.codEmployee <= 0)
			return false;
		
		
		for (PlanDataInfo eachData : sourceTwo.datas) {
			if (eachData.codOwner <= 0 					|| 
				eachData.codOwner != sourceOne.codOwner	||
			    eachData.codEmployee <= 0					)
				
				return false;
		}
		
		
		return true;
	}
}
