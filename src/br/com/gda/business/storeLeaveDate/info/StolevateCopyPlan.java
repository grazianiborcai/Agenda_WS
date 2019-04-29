package br.com.gda.business.storeLeaveDate.info;

import java.time.LocalDate;

import br.com.gda.business.planningTime_.info.PlanDataInfo;
import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.info.InfoUniquifyHelper;

final class StolevateCopyPlan extends InfoCopierTemplate<StolevateInfo, PlanDataInfo>{
	
	public StolevateCopyPlan() {
		super(new InfoUniquifyHelper<StolevateInfo>());
	}
	
	
	
	@Override protected StolevateInfo makeCopyHook(PlanDataInfo source) {
		StolevateInfo result = new StolevateInfo();
			
		result.codOwner = source.codOwner;	
		result.codStore = source.codStore;
		result.dateValidFrom = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());
		result.dateValidTo = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());
		return result;
	}
}
