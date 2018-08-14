package br.com.gda.business.storeLeaveDate.info;

import java.time.LocalDate;
import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.info.InfoUniquifyHelper;

final class StoreLDateCopyPlan extends InfoCopierTemplate<StoreLDateInfo, PlanDataInfo>{
	
	public StoreLDateCopyPlan() {
		super(new InfoUniquifyHelper<StoreLDateInfo>());
	}
	
	
	
	@Override protected StoreLDateInfo makeCopyHook(PlanDataInfo source) {
		StoreLDateInfo result = new StoreLDateInfo();
			
		result.codOwner = source.codOwner;	
		result.codStore = source.codStore;
		result.dateValidFrom = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());
		result.dateValidTo = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());
		return result;
	}
}
