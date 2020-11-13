package br.com.mind5.business.materialGroupStore.model.checker;

import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatoporeCheckLangu extends ModelCheckerTemplateForward<MatoporeInfo, LanguInfo> {
	
	public MatoporeCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(MatoporeInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
