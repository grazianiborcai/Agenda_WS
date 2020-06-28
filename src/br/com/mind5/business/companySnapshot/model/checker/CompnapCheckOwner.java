package br.com.mind5.business.companySnapshot.model.checker;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CompnapCheckOwner extends ModelCheckerTemplateForwardV2<CompnapInfo, OwnerInfo> {
	
	public CompnapCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(CompnapInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
