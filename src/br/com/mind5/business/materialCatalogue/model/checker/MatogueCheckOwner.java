package br.com.mind5.business.materialCatalogue.model.checker;

import br.com.mind5.business.materialCatalogue.info.MatogueInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatogueCheckOwner extends ModelCheckerTemplateForwardV2<MatogueInfo, OwnerInfo> {
	
	public MatogueCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(MatogueInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
