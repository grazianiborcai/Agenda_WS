package br.com.mind5.payment.customerPartnerSearch.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;

public final class CusparchCheckOwner extends ModelCheckerTemplateForwardV2<CusparchInfo, OwnerInfo> {
	
	public CusparchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(CusparchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
