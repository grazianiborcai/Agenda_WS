package br.com.mind5.payment.storePartnerList.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class StoplisCheckOwner extends ModelCheckerTemplateForwardV2<StoplisInfo, OwnerInfo> {
	
	public StoplisCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(StoplisInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
