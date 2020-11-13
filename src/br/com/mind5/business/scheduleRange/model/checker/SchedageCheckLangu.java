package br.com.mind5.business.scheduleRange.model.checker;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedageCheckLangu extends ModelCheckerTemplateForward<SchedageInfo, LanguInfo> {
	
	public SchedageCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(SchedageInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
