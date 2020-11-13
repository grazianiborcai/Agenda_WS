package br.com.mind5.payment.refundOrderItem.model.checker;

import br.com.mind5.business.orderSearch.info.OrdarchCopier;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.model.checker.OrdarchCheckExistAuth;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class RefemCheckOrdarch extends ModelCheckerTemplateForward<RefemInfo, OrdarchInfo> {
	
	public RefemCheckOrdarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OrdarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrdarchCheckExistAuth(option);
	}
	
	
	
	@Override protected OrdarchInfo toForwardClass(RefemInfo baseRecord) {
		return OrdarchCopier.copyFromRefem(baseRecord);
	}
}
