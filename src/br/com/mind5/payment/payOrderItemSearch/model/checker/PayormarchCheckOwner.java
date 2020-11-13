package br.com.mind5.payment.payOrderItemSearch.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class PayormarchCheckOwner extends ModelCheckerTemplateForward<PayormarchInfo, OwnerInfo> {
	
	public PayormarchCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(PayormarchInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
