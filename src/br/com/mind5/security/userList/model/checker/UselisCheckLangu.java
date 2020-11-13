package br.com.mind5.security.userList.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.userList.info.UselisInfo;

public final class UselisCheckLangu extends ModelCheckerTemplateForward<UselisInfo, LanguInfo> {
	
	public UselisCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(UselisInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
