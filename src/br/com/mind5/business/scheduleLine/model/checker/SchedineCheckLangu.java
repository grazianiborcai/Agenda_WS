package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedineCheckLangu extends ModelCheckerTemplateForward<SchedineInfo, LanguInfo> {
	
	public SchedineCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(SchedineInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
