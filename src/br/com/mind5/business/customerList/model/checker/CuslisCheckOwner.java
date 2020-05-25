package br.com.mind5.business.customerList.model.checker;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CuslisCheckOwner extends ModelCheckerTemplateForwardV2<CuslisInfo, OwnerInfo> {
	
	public CuslisCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(CuslisInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
