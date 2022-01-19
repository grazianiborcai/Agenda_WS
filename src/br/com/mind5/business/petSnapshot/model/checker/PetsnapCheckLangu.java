package br.com.mind5.business.petSnapshot.model.checker;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PetsnapCheckLangu extends ModelCheckerTemplateForward<PetsnapInfo, LanguInfo> {
	
	public PetsnapCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(PetsnapInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
