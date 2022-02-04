package br.com.mind5.stats.statsUserAccount.userAccountLive.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveInfo;

public final class UseraciveCheckLangu extends ModelCheckerTemplateForward<UseraciveInfo, LanguInfo> {
	
	public UseraciveCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(UseraciveInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
