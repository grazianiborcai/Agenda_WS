package br.com.mind5.business.personBio.model.checker;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PerbioCheckLangu extends ModelCheckerTemplateForward<PerbioInfo, LanguInfo> {
	
	public PerbioCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(PerbioInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
