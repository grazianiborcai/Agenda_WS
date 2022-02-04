package br.com.mind5.stats.statsUserAccount.userAccountLive.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveInfo;

public final class UseraciveCheckOwner extends ModelCheckerTemplateForward<UseraciveInfo, OwnerInfo> {
	
	public UseraciveCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(UseraciveInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
