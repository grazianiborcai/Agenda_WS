package br.com.mind5.payment.payOrderItemList.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

public final class PayordemistCheckOwner extends ModelCheckerTemplateForwardV2<PayordemistInfo, OwnerInfo> {
	
	public PayordemistCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(PayordemistInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
