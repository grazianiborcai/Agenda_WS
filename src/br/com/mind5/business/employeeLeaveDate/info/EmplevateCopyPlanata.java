package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.info.InfoUniquifyHelper;

final class EmplevateCopyPlanata extends InfoCopierTemplate<EmplevateInfo, PlanataInfo>{
	
	public EmplevateCopyPlanata() {
		super(new InfoUniquifyHelper<EmplevateInfo>());
	}
	
	
	
	@Override protected EmplevateInfo makeCopyHook(PlanataInfo source) {
		EmplevateInfo result = new EmplevateInfo();
			
		result.codOwner = source.codOwner;	
		result.codStore = source.codStore;
		result.codEmployee = source.codEmployee;
		result.dateValidFrom = source.date;
		result.dateValidTo = source.date;
		
		return result;
	}
}
