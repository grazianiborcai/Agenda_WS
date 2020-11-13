package br.com.mind5.business.materialText.model.checker;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatextCheckLangu extends ModelCheckerTemplateForward<MatextInfo, LanguInfo> {
	
	public MatextCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(MatextInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
