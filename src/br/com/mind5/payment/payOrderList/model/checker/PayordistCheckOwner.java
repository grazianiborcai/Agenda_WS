package br.com.mind5.payment.payOrderList.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

public final class PayordistCheckOwner extends ModelCheckerTemplateForward<PayordistInfo, OwnerInfo> {
	
	public PayordistCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(PayordistInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
