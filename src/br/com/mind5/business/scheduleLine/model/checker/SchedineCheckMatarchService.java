package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckExistService;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedineCheckMatarchService extends ModelCheckerTemplateForward<SchedineInfo, MatarchInfo> {
	
	public SchedineCheckMatarchService(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatarchCheckExistService(option);
	}
	
	
	
	@Override protected MatarchInfo toForwardClass(SchedineInfo baseRecord) {
		return MatarchInfo.copyFrom(baseRecord);
	}
}
