package br.com.mind5.payment.creditCard.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckOwner extends ModelCheckerTemplateForwardV2<CrecardInfo, OwnerInfo> {
	
	public CrecardCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(CrecardInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
