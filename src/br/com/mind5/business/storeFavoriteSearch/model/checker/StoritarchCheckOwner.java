package br.com.mind5.business.storeFavoriteSearch.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;

public final class StoritarchCheckOwner extends ModelCheckerTemplateForwardV2<StoritarchInfo, OwnerInfo> {
	
	public StoritarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(StoritarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}