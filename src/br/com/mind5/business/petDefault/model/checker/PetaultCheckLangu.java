package br.com.mind5.business.petDefault.model.checker;

import br.com.mind5.business.petDefault.info.PetaultInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PetaultCheckLangu extends ModelCheckerTemplateForward<PetaultInfo, LanguInfo> {
	
	public PetaultCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(PetaultInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
