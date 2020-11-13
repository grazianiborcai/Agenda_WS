package br.com.mind5.business.phoneSnapshot.model.checker;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PhonapCheckLangu extends ModelCheckerTemplateForward<PhonapInfo, LanguInfo> {
	
	public PhonapCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(PhonapInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
