package br.com.mind5.payment.statusPayOrderItem.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;

public final class PaytusemCheckOwner extends ModelCheckerTemplateForward<PaytusemInfo, OwnerInfo> {
	
	public PaytusemCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(PaytusemInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
