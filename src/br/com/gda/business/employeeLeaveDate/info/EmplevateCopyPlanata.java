package br.com.gda.business.employeeLeaveDate.info;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.info.InfoUniquifyHelper;

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
