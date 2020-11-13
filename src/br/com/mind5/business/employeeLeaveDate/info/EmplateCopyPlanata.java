package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class EmplateCopyPlanata extends InfoCopierTemplate<EmplateInfo, PlanataInfo> {
	
	public EmplateCopyPlanata() {
		super(new EmplateUniquifier());
	}
	
	
	
	@Override protected EmplateInfo makeCopyHook(PlanataInfo source) {
		EmplateInfo result = new EmplateInfo();
			
		result.codOwner = source.codOwner;	
		result.codStore = source.codStore;
		result.codEmployee = source.codEmployee;
		result.dateValidFrom = source.date;
		result.dateValidTo = source.date;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
