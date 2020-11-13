package br.com.mind5.business.materialStoreSearch.model.checker;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatorarchCheckLangu extends ModelCheckerTemplateForward<MatorarchInfo, LanguInfo> {
	
	public MatorarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(MatorarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
