package br.com.mind5.business.materialSearch.model.checker;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatarchCheckLangu extends ModelCheckerTemplateForward<MatarchInfo, LanguInfo> {
	
	public MatarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(MatarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
