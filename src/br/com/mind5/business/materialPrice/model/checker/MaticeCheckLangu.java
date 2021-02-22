package br.com.mind5.business.materialPrice.model.checker;

import br.com.mind5.business.materialPrice.info.MaticeInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MaticeCheckLangu extends ModelCheckerTemplateForward<MaticeInfo, LanguInfo> {
	
	public MaticeCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(MaticeInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
