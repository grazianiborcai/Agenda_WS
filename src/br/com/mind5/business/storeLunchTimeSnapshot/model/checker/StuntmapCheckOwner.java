package br.com.mind5.business.storeLunchTimeSnapshot.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StuntmapCheckOwner extends ModelCheckerTemplateForward<StuntmapInfo, OwnerInfo> {
	
	public StuntmapCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(StuntmapInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
