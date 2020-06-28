package br.com.mind5.business.companySearch.model.checker;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class ComparchCheckOwner extends ModelCheckerTemplateForwardV2<ComparchInfo, OwnerInfo> {
	
	public ComparchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(ComparchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
