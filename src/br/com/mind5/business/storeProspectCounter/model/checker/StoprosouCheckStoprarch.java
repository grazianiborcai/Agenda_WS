package br.com.mind5.business.storeProspectCounter.model.checker;

import br.com.mind5.business.storeProspectCounter.info.StoprosouInfo;
import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.business.storeProspectSearch.model.checker.StoprarchCheckExistCreated;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class StoprosouCheckStoprarch extends ModelCheckerTemplateForward<StoprosouInfo, StoprarchInfo> {
	
	public StoprosouCheckStoprarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoprarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoprarchCheckExistCreated(option);
	}
	
	
	
	@Override protected StoprarchInfo toForwardClass(StoprosouInfo baseRecord) {
		return StoprarchInfo.copyFrom(baseRecord);
	}
}
