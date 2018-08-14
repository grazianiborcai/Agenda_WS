package br.com.gda.business.employeeLeaveDate.info;

import java.time.LocalDate;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.info.InfoUniquifyHelper;

final class EmpLDateCopyPlan extends InfoCopierTemplate<EmpLDateInfo, PlanDataInfo>{
	
	public EmpLDateCopyPlan() {
		super(new InfoUniquifyHelper<EmpLDateInfo>());
	}
	
	
	
	@Override protected EmpLDateInfo makeCopyHook(PlanDataInfo source) {
		EmpLDateInfo result = new EmpLDateInfo();
			
		result.codOwner = source.codOwner;	
		result.codStore = source.codStore;
		result.codEmployee = source.codEmployee;
		result.dateValidFrom = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());
		result.dateValidTo = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());
		
		return result;
	}
}
