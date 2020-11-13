package br.com.mind5.business.addressSearch.model.checker;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class AddarchCheckLangu extends ModelCheckerTemplateForward<AddarchInfo, LanguInfo> {
	
	public AddarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(AddarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
