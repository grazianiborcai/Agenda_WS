package br.com.mind5.business.storeNearby.model.checker;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StorbyCheckOwner extends ModelCheckerTemplateForward<StorbyInfo, OwnerInfo> {
	
	public StorbyCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(StorbyInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
