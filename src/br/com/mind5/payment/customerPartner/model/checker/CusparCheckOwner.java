package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckOwner extends ModelCheckerTemplateForwardV2<CusparInfo, OwnerInfo> {
	
	public CusparCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(CusparInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
