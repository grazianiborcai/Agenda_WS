package br.com.mind5.business.addressDefault.model.checker;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class AddaultCheckLangu extends ModelCheckerTemplateForward<AddaultInfo, LanguInfo> {
	
	public AddaultCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(AddaultInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
