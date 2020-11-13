package br.com.mind5.payment.payOrderItem.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckOwner extends ModelCheckerTemplateForward<PayordemInfo, OwnerInfo> {
	
	public PayordemCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(PayordemInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
