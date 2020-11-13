package br.com.mind5.payment.statusPayOrder.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class PaytusCheckOwner extends ModelCheckerTemplateForward<PaytusInfo, OwnerInfo> {
	
	public PaytusCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(PaytusInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
