package br.com.mind5.business.orderItemSearch.model.checker;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class OrdemarchCheckOwner extends ModelCheckerTemplateForwardV2<OrdemarchInfo, OwnerInfo> {
	
	public OrdemarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(OrdemarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
