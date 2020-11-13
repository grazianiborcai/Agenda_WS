package br.com.mind5.business.materialMovementSearch.model.checker;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatmarchCheckLangu extends ModelCheckerTemplateForward<MatmarchInfo, LanguInfo> {
	
	public MatmarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(MatmarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
