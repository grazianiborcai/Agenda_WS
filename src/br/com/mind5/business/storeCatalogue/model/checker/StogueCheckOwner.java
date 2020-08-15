package br.com.mind5.business.storeCatalogue.model.checker;

import br.com.mind5.business.storeCatalogue.info.StogueInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StogueCheckOwner extends ModelCheckerTemplateForwardV2<StogueInfo, OwnerInfo> {
	
	public StogueCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(StogueInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
