package br.com.mind5.business.personBioSnapshot.model.checker;

import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PerbionapCheckLangu extends ModelCheckerTemplateForward<PerbionapInfo, LanguInfo> {
	
	public PerbionapCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(PerbionapInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
