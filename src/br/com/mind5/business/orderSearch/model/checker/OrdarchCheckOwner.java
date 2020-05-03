package br.com.mind5.business.orderSearch.model.checker;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class OrdarchCheckOwner extends ModelCheckerTemplateForwardV2<OrdarchInfo, OwnerInfo> {
	
	public OrdarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(OrdarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
