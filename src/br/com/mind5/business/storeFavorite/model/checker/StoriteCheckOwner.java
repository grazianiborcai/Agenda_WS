package br.com.mind5.business.storeFavorite.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.business.storeFavorite.info.StoriteInfo;

public final class StoriteCheckOwner extends ModelCheckerTemplateForwardV2<StoriteInfo, OwnerInfo> {
	
	public StoriteCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(StoriteInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
