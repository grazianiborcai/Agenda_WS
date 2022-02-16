package br.com.mind5.stats.statsStoreDashboard.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;

public final class StorashCheckOwner extends ModelCheckerTemplateForward<StorashInfo, OwnerInfo> {
	
	public StorashCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(StorashInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
