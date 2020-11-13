package br.com.mind5.business.scheduleSearch.model.checker;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedarchCheckLangu extends ModelCheckerTemplateForward<SchedarchInfo, LanguInfo> {
	
	public SchedarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(SchedarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
