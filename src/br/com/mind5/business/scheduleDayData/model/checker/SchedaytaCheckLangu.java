package br.com.mind5.business.scheduleDayData.model.checker;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedaytaCheckLangu extends ModelCheckerTemplateForward<SchedaytaInfo, LanguInfo> {
	
	public SchedaytaCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(SchedaytaInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
