package br.com.mind5.business.scheduleList.model.checker;

import br.com.mind5.business.scheduleList.info.SchedistInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedistCheckLangu extends ModelCheckerTemplateForward<SchedistInfo, LanguInfo> {
	
	public SchedistCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(SchedistInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
