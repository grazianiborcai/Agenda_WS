package br.com.mind5.payment.payOrderItem.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;
import br.com.mind5.payment.marketplacePartner.model.checker.MktparCheckExist;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckMktpar extends ModelCheckerTemplateForward<PayordemInfo, MktparInfo> {
	
	public PayordemCheckMktpar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MktparInfo> getCheckerHook(ModelCheckerOption option) {
		return new MktparCheckExist(option);
	}
	
	
	
	@Override protected MktparInfo toForwardClass(PayordemInfo baseRecord) {
		return MktparInfo.copyFrom(baseRecord);
	}
}
