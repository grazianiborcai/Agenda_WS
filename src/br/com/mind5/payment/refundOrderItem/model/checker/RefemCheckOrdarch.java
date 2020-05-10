package br.com.mind5.payment.refundOrderItem.model.checker;

import br.com.mind5.business.orderSearch.info.OrdarchCopier;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.model.checker.OrdarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class RefemCheckOrdarch extends ModelCheckerTemplateForwardV2<RefemInfo, OrdarchInfo> {
	
	public RefemCheckOrdarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OrdarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrdarchCheckExist(option);
	}
	
	
	
	@Override protected OrdarchInfo toForwardClass(RefemInfo baseRecord) {
		return OrdarchCopier.copyFromRefem(baseRecord);
	}
}
