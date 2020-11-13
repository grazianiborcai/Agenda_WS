package br.com.mind5.business.storeFavoriteSearch.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;

public final class StoritarchCheckOwner extends ModelCheckerTemplateForward<StoritarchInfo, OwnerInfo> {
	
	public StoritarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(StoritarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
