package br.com.mind5.stats.statsUserAccount.userAccount.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsUserAccount.userAccount.info.SuseracInfo;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.SuseraciveInfo;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.checker.SuseraciveCheckExist;

public final class SuseracCheckSuseracive extends ModelCheckerTemplateForward<SuseracInfo, SuseraciveInfo> {
	
	public SuseracCheckSuseracive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SuseraciveInfo> getCheckerHook(ModelCheckerOption option) {
		return new SuseraciveCheckExist(option);
	}
	
	
	
	@Override protected SuseraciveInfo toForwardClass(SuseracInfo baseRecord) {
		return SuseraciveInfo.copyFrom(baseRecord);
	}
}
